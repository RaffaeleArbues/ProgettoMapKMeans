class DiscreteAttribute extends Attribute{
    String[] values;

    DiscreteAttribute(String name, int index, String[] values){
        super(name, index);
        for (int i=0; i < values.length; i++) {
            this.values[i] = values[i];
        }
    }

    int getNumberOfDistinctValues(){
        return values.length;
    }

    String getValue(int i){
        return values[i];
    }
}