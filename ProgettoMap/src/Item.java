
abstract class Item {

    Attribute attribute;
    Object value;

    Item(Attribute attribute, Object value) {
        this.attribute = attribute;
        this.value = value;
    }

    Attribute getAttribute() {
        return attribute;
    }

    Object getValue() {
        return value;
    }

    public String toString() {
        return value.toString();
    }

    abstract double distance(Object a); // implementazione diversa per ogni tipo di attributo

    void update (Data data, ArraySet clusteredData) {
        this.value = data.computePrototype(clusteredData, attribute);
    }
}
