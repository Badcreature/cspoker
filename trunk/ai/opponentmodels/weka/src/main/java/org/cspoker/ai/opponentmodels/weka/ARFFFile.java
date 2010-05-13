package org.cspoker.ai.opponentmodels.weka;

import java.io.*;

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
	private double count;

	private boolean modelReady;

	public ARFFFile(String path, Object player, String name, String attributes,
			boolean overwrite) throws IOException {
		this.path = path;
		this.player = player;
		this.name = name;

		boolean fileExists = fileExists();
		file = new BufferedWriter(new FileWriter(path + player + name, !overwrite));

		if (overwrite || !fileExists) {
			file.write(attributes);
			file.flush();
		}

		count = countDataLines();
		if (count >= WekaOptions.getModelCreationTreshold())
			modelReady = true;
	}

	private double countDataLines() throws IOException {
		InputStream is = new BufferedInputStream(new FileInputStream(path + player + name));
		byte[] c = new byte[1024];
		int count = 0;
		int readChars = 0;
		boolean startReading = false;
		while ((readChars = is.read(c)) != -1) {
			for (int i = 0; i < readChars; ++i) {
				if (c[i] == '\n' && startReading)
					++count;
				else if (!startReading && i >= 4 && c[i - 4] == '@'
						&& c[i - 3] == 'd' && c[i - 2] == 'a'
						&& c[i - 1] == 't' && c[i] == 'a')
					startReading = true;
			}
		}
		is.close();
		return count + (count > 0 ? -1 : 0);
	}

	private boolean fileExists() throws FileNotFoundException {
		return new File(path + player + name).exists();
	}

	public void close() throws IOException {
		file.close();
	}

	public void write(Instance instance) {
		try {
			file.write(instance.toString() + nl);
			file.flush();
			count++;
			if (count >= WekaOptions.getModelCreationTreshold())
				modelReady = true;
		} catch (IOException e) {
			e.printStackTrace();
			throw new IllegalStateException(e);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			throw new IllegalStateException(e);
		}
	}

	public boolean isModelReady() {
		return modelReady;
	}
	
	public Classifier createModel(String fileName, String attribute, String[] rmAttributes) throws Exception {
		if (!modelReady)  throw new IllegalStateException("Model didn't reach threshold for creation!");
		
		DataSource source = new DataSource(path + player + name);
	    Instances data = source.getDataSet();
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
	    M5P cl = new M5P();
	    cl.setBuildRegressionTree(true);
	    cl.setUnpruned(false);
	    cl.setUseUnsmoothed(false);
	    // further options...
	    cl.buildClassifier(data);
	    
	    // save model + header
	    if (WekaOptions.isModelPersistency())
	    	SerializationHelper.write(path + "../" + player + fileName + ".model", cl);
	    
	    return cl;
	}
}
