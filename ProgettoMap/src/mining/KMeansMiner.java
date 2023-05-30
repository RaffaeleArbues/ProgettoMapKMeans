package mining;
import data.Data;
import data.OutOfRangeSampleSize;

public class KMeansMiner {

    private ClusterSet C;

    public KMeansMiner(int k) {
        C = new ClusterSet(k);
    }
    /*
    public KmeansMiner(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
        return null;
    }
    */

    public ClusterSet getC() {
        return C;
    }

    public int kmeans(Data data) throws OutOfRangeSampleSize {

        int numberOfIterations = 0;
        // STEP 1
        C.inizializeCentroids(data);
        boolean changedCluster=false;
        do {
        numberOfIterations++;
        // STEP 2
        changedCluster=false;
        for(int i=0; i<data.getNumberOfExamples(); i++) {
            // stabilisco il claster più vicino passando ogni tupla di data ad ogni iterata
            Cluster nearestCluster = C.nearestCluster(data.getItemSet(i)); 
            Cluster oldCluster = C.currentCluster(i); //cluster che contiene la tupa id = 0
            boolean currentChange = nearestCluster.addData(i);
            if(currentChange)
                changedCluster=true;
            // rimuovo la tupla dal vecchio cluster
            if(currentChange && oldCluster!=null)
            // il nodo va rimosso dal suo vecchio cluster
                oldCluster.removeTuple(i);
            }
        // STEP 3
        C.updateCentroids(data);
        } while(changedCluster);


        return numberOfIterations;
    }

}