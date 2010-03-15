package org.cspoker.ai.opponentmodels.weka;

import java.io.*;

import org.cspoker.ai.opponentmodels.weka.instances.InstancesBuilder;

import weka.core.Instance;

public class ARFFFile {
	
	private final String nl = InstancesBuilder.nl;	
	private final String folder = "org/cspoker/ai/opponentmodels/weka/models/"; 
	private final String path;
	private final Object player;
	
	private final String preCheckBet = "PreCheckBet.arff";
	private final String postCheckBet = "PostCheckBet.arff";
	private final String preFoldCallRaise = "PreFoldCallRaise.arff";
	private final String postFoldCallRaise = "PostFoldCallRaise.arff";
	private final String showdown = "Showdown.arff";
	
	private Writer preCheckBetFile;
	private Writer postCheckBetFile;	
	private Writer preFoldCallRaiseFile;
	private Writer postFoldCallRaiseFile;
	private Writer showdownFile;
	
	public ARFFFile(Object player, boolean overwrite) throws IOException {
		this.path = (getClass().getProtectionDomain().getCodeSource()
				.getLocation().getPath() + folder).replace("%20", " ");
		this.player = player;
		
		boolean preCheckBetExists = fileExists(preCheckBet, player);
		preCheckBetFile = new BufferedWriter(new FileWriter(path + player
				+ "PreCheckBet.arff", !overwrite));		
		boolean postCheckBetExists = fileExists(postCheckBet, player);
		postCheckBetFile = new BufferedWriter(new FileWriter(path + player
				+ "PostCheckBet.arff", !overwrite));		
		boolean preFoldCallRaiseExists = fileExists(preFoldCallRaise, player);
		preFoldCallRaiseFile = new BufferedWriter(new FileWriter(path + player
				+ "PreFoldCallRaise.arff", !overwrite));		
		boolean postFoldCallRaiseExists = fileExists(postFoldCallRaise, player);
		postFoldCallRaiseFile = new BufferedWriter(new FileWriter(path + player
				+ "PostFoldCallRaise.arff", !overwrite));		
		boolean showdownExists = fileExists(showdown, player);
		showdownFile = new BufferedWriter(new FileWriter(path + player
				+ "Showdown.arff", !overwrite));

		if (overwrite || !preCheckBetExists) {
			preCheckBetFile.write(ARFFPropositionalizer.getPreCheckBetInstance().toString());
			preCheckBetFile.flush();
		}
		if (overwrite || !postCheckBetExists) {
			postCheckBetFile.write(ARFFPropositionalizer.getPostCheckBetInstance().toString());
			postCheckBetFile.flush();
		}
		if (overwrite || !preFoldCallRaiseExists) {
			preFoldCallRaiseFile.write(ARFFPropositionalizer.getPreFoldCallRaiseInstance().toString());
			preFoldCallRaiseFile.flush();
		}	
		if (overwrite || !postFoldCallRaiseExists) {
			postFoldCallRaiseFile.write(ARFFPropositionalizer.getPostFoldCallRaiseInstance().toString());
			postFoldCallRaiseFile.flush();
		}
		if (overwrite || !showdownExists) {
			showdownFile.write(ARFFPropositionalizer.getShowdownInstance().toString());
			showdownFile.flush();
		}
	}

	private double countDataLines(String filename) throws IOException {
	    InputStream is = new BufferedInputStream(new FileInputStream(filename));
	    byte[] c = new byte[1024];
	    int count = 0;
	    int readChars = 0;
	    boolean startReading = false;
	    while ((readChars = is.read(c)) != -1) {
	        for (int i = 0; i < readChars; ++i) {
				if (c[i] == '\n' && startReading)
					++count;
				else if (!startReading && i >= 4 
						&& c[i - 4] == '@' && c[i - 3] == 'd'
						&& c[i - 2] == 'a' && c[i - 1] == 't'
						&& c[i] == 'a')
					startReading = true;
	        }
	    }
		return count + (count > 0 ? -1 : 0);
	}

	private boolean fileExists(String fileName, Object player) throws FileNotFoundException {
		return new File(path + player + fileName).exists();
	}

	public void close() throws IOException {
		preCheckBetFile.close();
		postCheckBetFile.close();
		preFoldCallRaiseFile.close();
		postFoldCallRaiseFile.close();
		showdownFile.close();
	}

	public void writePreCheckBet(Instance instance) {
		try {
			preCheckBetFile.write(instance.toString()+nl);
			preCheckBetFile.flush();
		} catch (IOException e) {
			e.printStackTrace();
			throw new IllegalStateException(e);
		} catch(ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
			throw new IllegalStateException(e);
		}
	}
	
	public double getPreCheckBetCount() {
		try {
			return countDataLines(path + player	+ preCheckBet);
		} catch (IOException e) {
			return 0;
		}
	}

	public void writePostCheckBet(Instance instance) {
		try {
			postCheckBetFile.write(instance.toString()+nl);
			postCheckBetFile.flush();
		} catch (IOException e) {
			e.printStackTrace();
			throw new IllegalStateException(e);
		} catch(ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
			throw new IllegalStateException(e);
		}
	}
	
	public double getPostCheckBetCount() {
		try {
			return countDataLines(path + player + postCheckBet);
		} catch (IOException e) {
			return 0;
		}
	}

	public void writePreFoldCallRaise(Instance instance) {
		try {
			preFoldCallRaiseFile.write(instance.toString()+nl);
			preFoldCallRaiseFile.flush();
		} catch (IOException e) {
			e.printStackTrace();
			throw new IllegalStateException(e);
		} catch(ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
			throw new IllegalStateException(e);
		}
	}
	
	public double getPreFoldCallRaiseCount() {
		try {
			return countDataLines(path + player + preFoldCallRaise);
		} catch (IOException e) {
			return 0;
		}
	}

	public void writePostFoldCallRaise(Instance instance) {
		try {
			postFoldCallRaiseFile.write(instance.toString()+nl);
			postFoldCallRaiseFile.flush();
		} catch (IOException e) {
			e.printStackTrace();
			throw new IllegalStateException(e);
		} catch(ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
			throw new IllegalStateException(e);
		}
	}
	
	public double getPostFoldCallRaiseCount() {
		try {
			return countDataLines(path + player + postFoldCallRaise);
		} catch (IOException e) {
			return 0;
		}
	}

	public void writeShowdown(Instance instance) {
		try {
			showdownFile.write(instance.toString()+nl);
			showdownFile.flush();
		} catch (IOException e) {
			e.printStackTrace();
			throw new IllegalStateException(e);
		} catch(ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
			throw new IllegalStateException(e);
		}
	}
	
	public double getShowdownCount() {
		try {
			return countDataLines(path + player + showdown);
		} catch (IOException e) {
			return 0;
		}
	}
}
