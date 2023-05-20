package data;
import java.util.Random;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

import utility.ArraySet;

public class Data {

	private List<Example> data = new ArrayList<Example>();
	private int numberOfExamples;
	private List<Attribute> attributeSet = new LinkedList<Attribute>();

	public Data() {
		//data
		TreeSet<Example> tempData = new TreeSet<Example>();
		Example ex0 = new Example();
		Example ex1 = new Example();
		Example ex2 = new Example();
		Example ex3 = new Example();
		Example ex4 = new Example();
		Example ex5 = new Example();
		Example ex6 = new Example();
		Example ex7 = new Example();
		Example ex8 = new Example();
		Example ex9 = new Example();
		Example ex10 = new Example();
		Example ex11 = new Example();
		Example ex12 = new Example();
		Example ex13 = new Example();

		ex0.add(new String ("sunny"));
		ex1.add(new String ("sunny"));
		ex2.add(new String ("overcast"));
		ex3.add(new String ("rain"));
		ex4.add(new String ("rain"));
		ex5.add(new String ("rain"));
		ex6.add(new String ("overcast"));
		ex7.add(new String ("sunny"));
		ex8.add(new String ("sunny"));
		ex9.add(new String ("rain"));
		ex10.add(new String ("sunny"));
		ex11.add(new String ("overcast"));
		ex12.add(new String ("overcast"));
		ex13.add(new String ("rain"));

		ex0.add(new String ("hot"));
		ex1.add(new String ("hot"));
		ex2.add(new String ("hot"));
		ex3.add(new String ("mild"));
		ex4.add(new String ("cool"));
		ex5.add(new String ("cool"));
		ex6.add(new String ("cool"));
		ex7.add(new String ("mild"));
		ex8.add(new String ("cool"));
		ex9.add(new String ("mild"));
		ex10.add(new String ("mild"));
		ex11.add(new String ("mild"));
		ex12.add(new String ("hot"));
		ex13.add(new String ("mild"));

		ex0.add(new String ("high"));
		ex1.add(new String ("high"));
		ex2.add(new String ("high"));
		ex3.add(new String ("high"));
		ex4.add(new String ("normal"));
		ex5.add(new String ("normal"));
		ex6.add(new String ("normal"));
		ex7.add(new String ("high"));
		ex8.add(new String ("normal"));
		ex9.add(new String ("normal"));
		ex10.add(new String ("normal"));
		ex11.add(new String ("high"));
		ex12.add(new String ("normal"));
		ex13.add(new String ("high"));

		ex0.add(new String ("weak"));
		ex1.add(new String ("strong"));
		ex2.add(new String ("weak"));
		ex3.add(new String ("weak"));
		ex4.add(new String ("weak"));
		ex5.add(new String ("strong"));
		ex6.add(new String ("strong"));
		ex7.add(new String ("weak"));
		ex8.add(new String ("weak"));
		ex9.add(new String ("weak"));
		ex10.add(new String ("strong"));
		ex11.add(new String ("strong"));
		ex12.add(new String ("weak"));
		ex13.add(new String ("strong"));

		ex0.add(new String ("no"));
		ex1.add(new String ("no"));
		ex2.add(new String ("yes"));
		ex3.add(new String ("yes"));
		ex4.add(new String ("yes"));
		ex5.add(new String ("no"));
		ex6.add(new String ("yes"));
		ex7.add(new String ("no"));
		ex8.add(new String ("yes"));
		ex9.add(new String ("yes"));
		ex10.add(new String ("yes"));
		ex11.add(new String ("yes"));
		ex12.add(new String ("yes"));
		ex13.add(new String ("no"));

		numberOfExamples = 14;

		tempData.add(ex0);
		tempData.add(ex1);
		tempData.add(ex2);
		tempData.add(ex3);
		tempData.add(ex4);
		tempData.add(ex5);
		tempData.add(ex6);
		tempData.add(ex7);
		tempData.add(ex8);
		tempData.add(ex9);
		tempData.add(ex10);
		tempData.add(ex11);
		tempData.add(ex12);
		tempData.add(ex13);

		data = new ArrayList<Example>(tempData);
	}
	
	public int getNumberOfExamples() {
		return numberOfExamples;
	}

	public int getNumberOfAttributes() {
		return attributeSet.length;
	}
	
	public Object getAttributeValue(int exampleIndex, int attributeIndex) {
		return data[exampleIndex][attributeIndex];
	}
	
	public Attribute getAttribute(int index) {
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

	public Tuple getItemSet(int index) {

		Tuple tuple = new Tuple(attributeSet.length);
		for (int i = 0; i<attributeSet.length; i++) {
			tuple.add(new DiscreteItem((DiscreteAttribute)attributeSet[i], (String)data[index][i]), i);
		}
		return tuple;
	}

	public int [] sampling(int k) throws OutOfRangeSampleSize{
		if (k<0 || k>distinctTuples) {
			throw new OutOfRangeSampleSize("Il numero di elementi del campione deve essere compreso tra 0 e " + distinctTuples + "");
		}
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
 
	public Object computePrototype(ArraySet idList, Attribute attribute) {
		return  computePrototype(idList, (DiscreteAttribute)attribute);
	}

	/*
	 * valore(attributo) che più frequentemente si ripete utilizzando un vettore freq e la funzione frequency
	 */
	public String computePrototype(ArraySet idList, DiscreteAttribute attribute) {
		
		int freq[] = new int[attribute.getNumberOfDistinctValues()]; // freq di dimensione 5 nel nostro caso
		Arrays.fill(freq, 0);

		for (int i = 0; i<attribute.getNumberOfDistinctValues(); i++) {
			freq[i] = attribute.frequency(this, idList, attribute.getValue(i));
		}

		int max = freq[0];
		int maxIndex = 0;
		for (int i = 1; i<freq.length; i++) {
			if (max < freq[i]) { // e se abbiamo due indici con valori uguali?
				maxIndex = i;
			}
		}

		return attribute.getValue(maxIndex);
	}

	class Example implements Comparable<Example>{
		private List<Object> example = new ArrayList<Object>();

		public void add(Object o){}
		public Object get(int i){return null;}
		public int compareTo(Example ex){return 0;}
		public String toString(){return null;}

	}

}
