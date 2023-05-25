package data;
import java.util.Iterator;
import java.util.TreeSet;
import utility.ArraySet;

class DiscreteAttribute extends Attribute implements Iterable<String> {

    //private String[] values;
    private TreeSet<String> values; /* TreeSet è una collezione di elementi ordinati e non duplicati, struttura ad albero */
    private Iterator<String> iterator = values.iterator();/* iteratore permette di scorrere gli elementi, aggiungere e rimuovere */

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
     * restituisve quante volte si ripete uno specifico attributo
     */

    public int frequency(Data data, ArraySet idList, String v) {

        int count = 0;
        for (int j = 0; j<idList.getSize(); j++) // scorro l'arrayset
            {
                if (idList.get(j)) { // nelle posizioni j-true 
                    if (data.getAttributeValue(j, getIndex()).equals(v)) { // controllo data in riga j e colonna k se è uguale a v
                        count++;
                    }
                }
            }

        return count; 
    }

}