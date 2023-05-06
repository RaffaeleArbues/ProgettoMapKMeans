public class ClusterSet{
    Cluster[] C;
    int i = 0;

    ClusterSet(int k){
        C = new Cluster[k];
    }

    void add(Cluster clust){
        C[i] = clust; 
    }

    Cluster get(int i){
        return C[i];
    }

    // Inserisce gli indici dei centroidi dentro l'array centroidIndexes e crea i cluster in base a quello.
    void inizializeCentroids(Data data){
        int[] centroidIndexes = data.sampling(C.length);
        for(int i = 0; i<centroidIndexes.length; i++){
            Tuple centroidI = data.getItemSet(centroidIndexes[i]);
            add(new Cluster(centroidI));
        }
    }

    Cluster nearestCluster(Tuple tuple){
        Cluster nearest = C[0];
        for(int i = 1; i<C.length; i++){
            if(tuple.getDistance(nearest.getCentroid()) > tuple.getDistance(C[i].getCentroid()))
                nearest = C[i];
        }
        return nearest;
    }

    Cluster currentCluster(int id){
        for(int i = 0; i<C.length; i++){
            if(C[i].contain(id))
                return C[i];
        }
        return null;
    }

    void updateCentroids(Data data){
        for(int i = 0; i<C.length; i++){
            C[i].computeCentroid(data);
        }
    }

    public String toString(){
        String str = "";
        for(int i = 0; i<C.length; i++){
            if(C[i] != null){
                str += "Cluster "+i+": "+C[i]+"\n";
            }
        }
        return str;
    }

    public String toString(Data data){
        String str = "";
        for(int i = 0; i<C.length; i++){
            if(C[i] != null){
                str += "Cluster "+i+": "+C[i].toString(data)+"\n";
            }
        }
        return str;
    }
}
