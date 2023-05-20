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
		// TreeSet di suppporto
		TreeSet<Example> tempData = new TreeSet<Example>();
		// creiamo le 14 liste (14 righe di data)
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

		// prima colonna 
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

		// seconda colonna 
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

		// quinta colonna, abbiamo le liste complete (la matrice completa)
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

		// attributeSet ora è una lista e va inizializzata come tale 
		TreeSet<String> outlookvls = new TreeSet<String>();
		outlookvls.add("overcast");
		outlookvls.add("rain");
		outlookvls.add("sunny");
		DiscreteAttribute OutlookValues = new DiscreteAttribute("OutlookkValues", 0, outlookvls);

		TreeSet<String> temperaturesvls = new TreeSet<String>();
		temperaturesvls.add("hot");
		temperaturesvls.add("mild");
		temperaturesvls.add("cold");
		DiscreteAttribute TemperaturesValues = new DiscreteAttribute("TemperaturesValues", 1, temperaturesvls);


		TreeSet<String> humidityvls = new TreeSet<String>();
		humidityvls.add("high");
		humidityvls.add("normal");
		DiscreteAttribute HumidityValues = new DiscreteAttribute("HumidityValues", 2, humidityvls);


		TreeSet<String> windvls = new TreeSet<String>();
		windvls.add("weak");
		windvls.add("strong");
		DiscreteAttribute WindValues = new DiscreteAttribute("OutlookkValues", 3, windvls);


		TreeSet<String> playtennisvls = new TreeSet<String>();
		playtennisvls.add("yes");
		playtennisvls.add("no");
		DiscreteAttribute PlayTennisValues = new DiscreteAttribute("PlayTennisValues", 4, playtennisvls);

		attributeSet.add(0, OutlookValues);
		attributeSet.add(1, TemperaturesValues);
		attributeSet.add(2, HumidityValues);
		attributeSet.add(3, WindValues);
		attributeSet.add(4, PlayTennisValues);

	}
	
	public int getNumberOfExamples() {
		return numberOfExamples;
	}

	public int getNumberOfAttributes() {
		return attributeSet.size();
	}
	
	public Object getAttributeValue(int exampleIndex, int attributeIndex) {
		return data.get(attributeIndex).get(attributeIndex);
	}
	
	public Attribute getAttribute(int index) {
		return attributeSet.get(index);
	}
	
	
	public String toString() {
		String table = new String();
		for (int i = 0; i<attributeSet.size(); i++){
			table = table + attributeSet.get(i).toString() + ", ";
		}
		table = table + "\n";
		for (int i = 0; i<numberOfExamples; i++){
			table = table + (i+1) + ": ";
			for (int j = 0; j<attributeSet.size(); j++){
				table = table + data.get(i).get(j).toString() + ",\t";
			}
			table = table + "\n";
		}
		return table;
	}

	/*public Tuple getItemSet(int index) {

		Tuple tuple = new Tuple(attributeSet.size());
		for (int i = 0; i<attributeSet.size(); i++) {
			tuple.add(new DiscreteItem((DiscreteAttribute)attributeSet.get(index), (String)data.get(index).get(i)), i);
		}
		return tuple;
	} */
	public Example getItemSet (int index) {
		return data.get(index);
	}

	public int [] sampling(int k) throws OutOfRangeSampleSize{
		if (k<0) {
			throw new OutOfRangeSampleSize("Il numero di elementi del campione deve essere maggiore di 0");
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
		for (int j = 0; j<attributeSet.size(); j++) {
			if (data.get(i).get(j)!= data.get(k).get(j)) {
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

	class Example implements Comparable<Example> {

		private List<Object> example = new ArrayList<Object>();

		public void add(Object o) {

			example.add(o);
		}

		public Object get(int i) {
			return example.get(i);
		}

		public int compareTo(Example ex) {

			int x = 0;
			for (int i = 0; i<example.size(); i++) {
					if (example.get(i).equals(ex.get(i))) {
						x = 0;
					} else if(example.get(i) instanceof String) {
						String o = (String) example.get(i);
						String p = (String) ex.get(i);
						x = o.compareTo(p);
					} else if(example.get(i) instanceof Double) {
						Double o = (Double) example.get(i);
						Double p = (Double) example.get(i);
						x = o.compareTo(p);
					}
			}
			return x;
		} 

		public String toString() {

			String str = new String();

			for (Object o: example) {
				str = " | " + o;
			}

			return str;
		}

	}

}