package data;

public class OutOfRangeSampleSize extends Exception{
    OutOfRangeSampleSize(String message){
        super(message);
    }

    public String toString(){
        return "Sample size out of range";
    }

    public static void wrongRange(int k, int distinctValue) throws OutOfRangeSampleSize {
        if (k <= 0 || k > distinctValue) {
            throw new OutOfRangeSampleSize("k is out of range");
        }
    }
}
