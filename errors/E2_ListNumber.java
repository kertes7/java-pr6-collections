import java.util.List;

public class E2_ListNumber {

    static double total(List<Number> list) {
        double sum = 0;
        for (Number n : list) sum += n.doubleValue();
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> ints = List.of(1, 2, 3);
        total(ints);                    // List<Integer> не є List<Number>
    }
}
