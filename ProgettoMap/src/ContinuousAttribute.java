class ContinuousAttribute extends Attribute {
    double max;
    double min;

    ContinuousAttribute(String name, int index, double min, double max) {
        super(name, index);
        this.min = min;
        this.max = max;
    }

    double getScaledValue(double v) {
        double vScld = (v-min)/(max-min);
        return vScld;
    }
}
