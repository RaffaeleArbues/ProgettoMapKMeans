import java.util.Random;
import java.util.Arrays;

class Data {

	Object [][] data;
	int numberOfExamples;
	Attribute [] attributeSet;

	Data() {
		//data
		data = new Object [14][5];

		data[0][0]=new String ("sunny");
		data[1][0]=new String ("sunny");
		data[2][0]=new String ("overcast");
		data[3][0]=new String ("rain");
		data[4][0]=new String ("rain");
		data[5][0]=new String ("rain");
		data[6][0]=new String ("overcast");
		data[7][0]=new String ("sunny");
		data[8][0]=new String ("sunny");
		data[9][0]=new String ("rain");
		data[10][0]=new String ("sunny");
		data[11][0]=new String ("overcast");
		data[12][0]=new String ("overcast");
		data[13][0]=new String ("rain");
		
		data[0][1]=new String ("hot");
		data[1][1]=new String ("hot");
		data[2][1]=new String ("hot");
		data[3][1]=new String ("mild");
		data[4][1]=new String ("cool");
		data[5][1]=new String ("cool");
		data[6][1]=new String ("cool");
		data[7][1]=new String ("mild");
		data[8][1]=new String ("cool");
		data[9][1]=new String ("mild");
		data[10][1]=new String ("mild");
		data[11][1]=new String ("mild");
		data[12][1]=new String ("hot");
		data[13][1]=new String ("mild");
		
		data[0][2]=new String ("high");
		data[1][2]=new String ("high");
		data[2][2]=new String ("high");
		data[3][2]=new String ("high");
		data[4][2]=new String ("normal");
		data[5][2]=new String ("normal");
		data[6][2]=new String ("normal");
		data[7][2]=new String ("high");
		data[8][2]=new String ("normal");
		data[9][2]=new String ("normal");
		data[10][2]=new String ("normal");
		data[11][2]=new String ("high");
		data[12][2]=new String ("normal");
		data[13][2]=new String ("high");
		
		
		data[0][3]=new String ("weak");
		data[1][3]=new String ("strong");
		data[2][3]=new String ("weak");
		data[3][3]=new String ("weak");
		data[4][3]=new String ("weak");
		data[5][3]=new String ("strong");
		data[6][3]=new String ("strong");
		data[7][3]=new String ("weak");
		data[8][3]=new String ("weak");
		data[9][3]=new String ("weak");
		data[10][3]=new String ("strong");
		data[11][3]=new String ("strong");
		data[12][3]=new String ("weak");
		data[13][3]=new String ("strong");
		

		data[0][4]=new String ("no");
		data[1][4]=new String ("no");
		data[2][4]=new String ("yes");
		data[3][4]=new String ("yes");
		data[4][4]=new String ("yes");
		data[5][4]=new String ("no");
		data[6][4]=new String ("yes");
		data[7][4]=new String ("no");
		data[8][4]=new String ("yes");
		data[9][4]=new String ("yes");
		data[10][4]=new String ("yes");
		data[11][4]=new String ("yes");
		data[12][4]=new String ("yes");
		data[13][4]=new String ("no");

		numberOfExamples = 14;

		attributeSet = new DiscreteAttribute[5];

		// TO DO : avvalorare ciascune elemento di attributeSet con un oggetto della classe DiscreteAttribute che modella il corrispondente attributo (e.g. outlook, temperature,etc)
		// nel seguito si fornisce l'esempio per outlook

		String outLookValues[]=new String[3];
		outLookValues[0]="overcast";
		outLookValues[1]="rain";
		outLookValues[2]="sunny";
		attributeSet[0] = new DiscreteAttribute("Outlook",0, outLookValues);
		
		String TemperaturesValues[]=new String[3];
		TemperaturesValues[0]="hot";
		TemperaturesValues[1]="mild";
		TemperaturesValues[2]="cool";
		attributeSet[1] = new DiscreteAttribute("Temperature", 1, TemperaturesValues);

		String HumidityValues[]=new String[2];
		HumidityValues[0]="high";
		HumidityValues[1]="normal";
		attributeSet[2] = new DiscreteAttribute("Humidity", 2, HumidityValues);

		String WindValues[]=new String[2];
		WindValues[0]="weak";
		WindValues[1]="strong";
		attributeSet[3] = new DiscreteAttribute("Wind",3, WindValues);

		String PlayTennisValues[]=new String[2];
		PlayTennisValues[0]="no";
		PlayTennisValues[1]="yes";
		attributeSet[4] = new DiscreteAttribute("PlayTennis",4, PlayTennisValues);
	}
	
	int getNumberOfExamples() {
		return numberOfExamples;
	}

	int getNumberOfAttributes() {
		return attributeSet.length;
	}
	
	Object getAttributeValue(int exampleIndex, int attributeIndex) {
		return data[exampleIndex][attributeIndex];
	}
	
	Attribute getAttribute(int index) {
		return attributeSet[index];
	}
	
	
	public String toString() {
		String table = new String();
		for (int i = 0; i<attributeSet.length; i++){
			table = table + attributeSet[i].toString() + ", ";
		}
		table = table + "\n";
		for (int i = 0; i<numberOfExamples; i++){
			table = table + (i+1) + ": ";
			for (int j = 0; j<attributeSet.length; j++){
				table = table + data[i][j].toString() + ",\t";
			}
			table = table + "\n";
		}
		return table;
	}

	Tuple getItemSet(int index) {

		Tuple tuple = new Tuple(attributeSet.length);
		for (int i = 0; i<attributeSet.length; i++) {
			tuple.add(new DiscreteItem((DiscreteAttribute)attributeSet[i], (String)data[index][i]), i);
		}
		return tuple;
	}

	int [] sampling(int k) {

		int centroidIndexes[] = new int[k];
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		for (int i = 0; i<k; i++) {
			boolean found = false;
			int c;
			do {
				found = false;
				c = rand.nextInt(numberOfExamples); // numero casuale tra 0 e numberOfExamples-1
				for (int j = 0; j<i; j++) {
					if (compare(centroidIndexes[j], c)) { // se c è già stato scelto come centroide
						found = true;					  // esci dal ciclo e scegli un altro centroide
						break;
					}
				}
			} while (found);
			centroidIndexes[i] = c;
		}
		return centroidIndexes;
	}

	private boolean compare(int i, int k) {

		boolean res = true;
		for (int j = 0; j<attributeSet.length; j++) {
			if (data[i][j] != data[k][j]) {
				res = false;
			}
		}

		return res;

	}
 
	Object computePrototype(ArraySet idList, Attribute attribute) {
		return  computePrototype(idList, (DiscreteAttribute)attribute);
	}

	/*
	 * valore che più frequentemente si ripete per attribute utilizzando idList
	 */
	String computePrototype(ArraySet idList, DiscreteAttribute attribute) {
		
		int freq[] = new int[attribute.getNumberOfDistinctValues()];
		Arrays.fill(freq, 0);

		for (int i = 0; i<attribute.getNumberOfDistinctValues(); i++) {
			freq[i] = attribute.frequency(this, idList, attribute.getValue(i));
		}

		int max = freq[0];
		int maxIndex = 0;
		for (int i = 1; i<freq.length; i++) {
			if (max < freq[i]) {
				maxIndex = i;
			}
		}

		return attribute.getValue(maxIndex);
	}

	public static void main(String args[]) {
		Data trainingSet=new Data();
		System.out.println(trainingSet);
	}

}
