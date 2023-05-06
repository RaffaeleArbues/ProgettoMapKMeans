public class Tuple {
    
    Item[] tuple;

    Tuple(int size) {
        tuple = new Item[size];
    }

    int getLength() {
        return tuple.length;
    }

    Item get(int i) {
        return tuple[i];
    }

    void add(Item c, int i) {
        tuple[i] = c;
    }

    double getDistance(Tuple obj) {

        double distance = 0.0;
        for (int i = 0; i<this.tuple.length; i++) {
            distance+= this.tuple[i].distance(obj.get(i));
        }

        return distance;
    }

    double avgDistance(Data data, int clusteredData[]) {

        double avg, sum = 0.0;
        
        avg = sum / clusteredData.length;
        return avg;
    }


}
