package data;

import java.io.Serializable;

class DiscreteItem extends Item implements Serializable{

    DiscreteItem(DiscreteAttribute attribute, String value) {
        super(attribute, value);
    }

    @Override
    public double distance(Object a) {
        
        if (this.getValue().equals(((DiscreteItem) a).getValue())) {
            return 0;
        } else return 1;
        
    }
}
