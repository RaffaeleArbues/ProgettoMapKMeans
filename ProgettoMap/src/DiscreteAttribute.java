
class DiscreteAttribute extends Attribute {

    private String[] values;

    DiscreteAttribute(String name, int index, String[] values) {
        super(name, index);
        this.values = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            this.values[i] = values[i];
        }
    }

    public int getNumberOfDistinctValues() {
        return values.length;
    }

    public String getValue(int i) {
        return values[i];
    }

    /*
     * restituisve quante volte si ripete un valore attributo (string v)
     */

    public int frequency(Data data, ArraySet idList, String v) {

        int count = 0;
        for (int j = 0; j<idList.set.length; j++) 
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