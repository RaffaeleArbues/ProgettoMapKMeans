package data;
import java.util.Iterator;
import java.util.TreeSet;
import utility.ArraySet;

class DiscreteAttribute extends Attribute implements Iterable<String> {

    //private String[] values;
    private TreeSet<String> values;
    private Iterator<String> iterator = values.iterator();

    DiscreteAttribute(String name, int index, TreeSet<String> v) {

        super(name, index);
        //this.values = new String[values.length];
        this.values = new TreeSet<String>();
        Iterator<String> it = v.iterator();
        while (it.hasNext()) {
            this.values.add(it.next());
        }
        
    }

    public int getNumberOfDistinctValues() {
        return values.size();
    }

    public Iterator<String> iterator(){
        return values.iterator();    
    }

    /*
     * restituisve quante volte si ripete un valore attributo (string v)
     */

    public int frequency(Data data, ArraySet idList, String v) {

        int count = 0;
        for (int j = 0; j<idList.getSize(); j++) 
            {
                if (idList.get(j)) {
                    if (data.getAttributeValue(j, getIndex()).equals(v)) {
                        count++;
                    }
                }
            }

        return count; 
    }




}