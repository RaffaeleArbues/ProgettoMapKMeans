package data;
import utility.ArraySet;

public abstract class Item {

    private Attribute attribute;
    private Object value;

    Item(Attribute attribute, Object value) {
        this.attribute = attribute;
        this.value = value;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public Object getValue() {
        return value;
    }

    public String toString() {
        return value.toString();
    }

    abstract double distance(Object a); // implementazione diversa per ogni tipo di attributo

    /*
     * Modifica value di Item con il valore più ripetuto per un determinato attributo
     */
    public void update (Data data, ArraySet clusteredData) {
        this.value = data.computePrototype(clusteredData, attribute);
    }
}
