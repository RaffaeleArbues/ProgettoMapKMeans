class DiscreteItem extends Item {

    DiscreteItem(DiscreteAttribute attribute, String value) {
        super(attribute, value);
    }

    @Override
    public double distance(Object a) {
        
        if (getValue().equals(a)) {
            return 0;
        } else return 1;
        
    }
}
