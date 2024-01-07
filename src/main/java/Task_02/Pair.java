package Task_02;

public class Pair {

    Double first;
    Double second;


    public Pair(Double first, Double second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}