import java.util.ArrayList;

class DiscreteAttribute extends Attribute {

    String[] values;

    DiscreteAttribute(String name, int index, String[] values) {
        super(name, index);
        this.values = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            this.values[i] = values[i];
        }
    }

    int getNumberOfDistinctValues() {
        return values.length;
    }

    String getValue(int i) {
        return values[i];
    }

    int frequency(Data data, ArraySet idList, String v) {

        int count = 0;

        for (int i = 0; i<data.getNumberOfAttributes(); i++) 
        {
            for (int j = 0; j<idList.set.length; j++) 
            {
                if (idList.get(j)) {
                    if (data.getAttributeValue(j, i). equals(v)) {
                        count++;
                    }
                }
            }
        }

        return count; 
    }


}