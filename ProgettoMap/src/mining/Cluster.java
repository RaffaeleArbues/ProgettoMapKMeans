package mining;
import data.Data;
import data.Tuple;
import utility.ArraySet;

class Cluster {
	
	private Tuple centroid;
	private ArraySet clusteredData; 
	
	/* Cluster(){ ... } */

	Cluster(Tuple centroid) {

		this.centroid = centroid;
		clusteredData = new ArraySet();
		
	} 
		
	public Tuple getCentroid() {
		return centroid;
	}
	
	/*
	 * Aggiorna ogni Item di Tuple centroid con il valore mpiù ripetuto per ogni attribute
	 */
	public void computeCentroid(Data data) {
	 	
		for(int i = 0; i<centroid.getLength(); i++) {
			centroid.get(i).update(data, clusteredData);
		}
		
	}
	/*
	 * return true if the tuple (id) is changing cluster
	 */
	public boolean addData(int id) {
		return clusteredData.add(id);
	}
	
	/*
	 * verifica se una tupla (id) é clusterizzata nell'array corrente
	 */
	public boolean contain(int id) {
		return clusteredData.get(id);
	}
	
	/*
	 * remove the tuple that has changed the cluster
	 */
	public void removeTuple(int id) {
		clusteredData.delete(id);
	}
	
	/* stampa solo la tupla del centroide del cluster */
	public String toString() {

		String str="Centroid = (";
		for(int i = 0; i<centroid.getLength(); i++)
			str += centroid.get(i).getValue(); // aggiunto getValue();
		str += ")";

		return str;
	}
	
	/*stampa la tupla del centroide del cluster e i valori di data del cluster e la distanza di ogni tupla dal centroide e infine la media della distanza */
	public String toString(Data data) {

		String str="Centroid = (";
		for(int i = 0; i<centroid.getLength(); i++)
			str += centroid.get(i).getValue()+ " "; //aggiunto getValue();
		str += ")\nExamples:\n";

		int array[] = clusteredData.toArray();
		for(int i = 0; i<array.length; i++) {
			str += "[";
			for(int j = 0; j<data.getNumberOfAttributes(); j++)
				str += data.getAttributeValue(array[i], j)+" ";
			str += "] dist = "+getCentroid().getDistance(data.getItemSet(array[i])) + "\n";
		}
		str += "AvgDistance = "+getCentroid().avgDistance(data, array) + "\n";
		return str;
	}

}
