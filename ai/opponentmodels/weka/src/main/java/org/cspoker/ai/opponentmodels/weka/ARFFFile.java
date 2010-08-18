package org.cspoker.ai.opponentmodels.weka;

import java.io.*;
import java.util.ArrayList;

import org.cspoker.ai.opponentmodels.weka.instances.InstancesBuilder;

import weka.classifiers.Classifier;
import weka.classifiers.trees.M5P;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

public class ARFFFile {

	private final String nl = InstancesBuilder.nl;
	private final String path;
	private final Object player;
	private final String name;

	private Writer file;
	private long count = 0;
	private WekaOptions config;
	
	private Instances instances;
	private ArrayList<Prediction> predictions;
	private M5P cl = null;

	public ARFFFile(String path, Object player, String name, String attributes,
			WekaOptions config) throws Exception {
		this.path = path;
		this.player = player;
		this.name = name;
		this.config = config;

		// TODO: false => !config.arffOverwrite()
		file = new BufferedWriter(new FileWriter(path + player + name, false));
		file.write(attributes);
		file.flush();
		
		DataSource source = new DataSource(path + player + name);
	    instances = source.getDataSet();
	    // make it clean
	    instances.delete();
	    
	    predictions = new ArrayList<Prediction>();
	}

//	private double countDataLines() {
//		InputStream is;
//		try {
//			is = new BufferedInputStream(new FileInputStream(path + player + name));
//			byte[] c = new byte[1024];
//			int count = 0;
//			int readChars = 0;
//			boolean startReading = false;
//			while ((readChars = is.read(c)) != -1) {
//				for (int i = 0; i < readChars; ++i) {
//					if (c[i] == '\n' && startReading)
//						++count;
//					else if (!startReading && i >= 4 && c[i - 4] == '@'
//							&& c[i - 3] == 'd' && c[i - 2] == 'a'
//							&& c[i - 1] == 't' && c[i] == 'a')
//						startReading = true;
//				}
//			}
//			is.close();
//			return count + (count > 0 ? -1 : 0);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return 0;
//	}
//
//	private boolean fileExists() throws FileNotFoundException {
//		return new File(path + player + name).exists();
//	}

	public void close() throws IOException {
		file.close();
	}

	public void write(Instance instance) {
//		System.out.println("Writing instance " + (count +1) + " in file " + name);
		try {
			count++;
			file.write(instance.toString() + nl);
			file.flush();
			instances.add(instance);
//			if (count != instances.numInstances())
//				System.err.println("PROBLEM");
			adjustWindow();
		} catch (IOException e) {
			throw new IllegalStateException(e);
		} 
	}
	
	public void addPrediction(Prediction p) {
		predictions.add(p);
	}
	
	public double getWindowSize() {
		return instances.numInstances();
	}
	
	public double getAccuracy() {
		if (predictions.isEmpty()) return 0.0;
		double truePositive = 0.0;
		double trueNegative = 0.0;
		double falsePositive = 0.0;
		double falseNegative = 0.0;
		for (int i = 0; i < predictions.size(); i++) {
			Prediction p = predictions.get(i);
			if (p != null) {
				truePositive += p.getTruePositive();
				trueNegative += p.getTrueNegative();
				falsePositive += p.getFalsePositive();
				falseNegative += p.getFalseNegative();
			}
		}
		return (trueNegative + truePositive) / 
				(trueNegative + truePositive + falseNegative + falsePositive);
	}
	
	private double prevAcc = 0.0;
	
	private boolean decreasingAcc(double accuracy) {
		double diffAcc = accuracy - prevAcc;
		prevAcc = accuracy;
		return (diffAcc < -0.01);
	}
	
	private void adjustWindow() {
		if (cl == null) return;
		double windowSize = instances.numInstances();
		double coverage = windowSize / cl.measureNumRules();
		double accuracy = getAccuracy();
		double l;
		if ((coverage < config.getCdLowCoverage()) ||
				(accuracy < config.getCdAccuracy() && decreasingAcc(accuracy)))
			l = Math.round(0.2 *  windowSize);
		else if (coverage > 2 * config.getCdHighCoverage() &&
				accuracy > config.getCdAccuracy())
			l = 2;
		else if (coverage > config.getCdHighCoverage() &&
				accuracy > config.getCdAccuracy())
			l = 1;
		else
			l = 0;
		
		for (int i = 0; i < l; i++) {
			instances.delete(0);
			if (!predictions.isEmpty())
				predictions.remove(0);
		}
		
//		windowSize = windowSize - l;
//		System.out.println(name + ", " + windowSize + ", l: " + l + ", acc: " + accuracy + ", coverage: " + coverage);
	}
	
	public boolean isModelReady() {
		return count > config.getMinimalLearnExamples();
	}
	
	public long getNrExamples() {
		return count;
	}
	
	public String getName() {
		return name;
	}
	
	public Classifier createModel(String fileName, String attribute, String[] rmAttributes) throws Exception {
//		System.out.println("Creating model for " + player + name);
		Instances data;
		if (config.solveConceptDrift())
			data = instances;
		else {
			DataSource source = new DataSource(path + player + name);
		    data = source.getDataSet();
		}
	    if (rmAttributes.length > 0) {
		    String[] optionsDel = new String[2];
			optionsDel[0] = "-R";                                   
			optionsDel[1] = "";
			for (int i = 0; i < rmAttributes.length; i++) 
				optionsDel[1] += (1+data.attribute(rmAttributes[i]).index()) + ",";     
			Remove remove = new Remove();                         
			remove.setOptions(optionsDel);
		    remove.setInputFormat(data);
		    data = Filter.useFilter(data, remove);
	    }
	    // setting class attribute if the data format does not provide this information
	    // E.g., the XRFF format saves the class attribute information as well
	    if (data.classIndex() == -1)
	    	data.setClass(data.attribute(attribute));
	    
	    // train M5P
	    cl = new M5P();
	    cl.setBuildRegressionTree(true);
	    cl.setUnpruned(false);
	    cl.setUseUnsmoothed(false);
	    // further options...
	    cl.buildClassifier(data);
	    
//	    System.out.println("Number of instances: " + data.numInstances());
//	    System.out.println("Number of measures: " + cl.measureNumRules());
//	    System.out.println(cl);
	    
	    // save model + header
	    if (config.modelPersistency())
	    	SerializationHelper.write(path + "../" + player + fileName + ".model", cl);
	    
	    return cl;
	}
}
