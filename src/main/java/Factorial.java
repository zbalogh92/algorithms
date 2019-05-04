import static java.util.stream.IntStream.rangeClosed;

public class Factorial {

    public int calculateFactorialWithStream(int n) {
        return rangeClosed(1, n).reduce(1, (x, y) -> x * y);
    }

    private int calculateFactorialRecursively(int n) {
        if (n == 1) {
            return 1;
        }

        return n * calculateFactorialRecursively(n - 1);
    }

    private int calculateFactorialIteratively(int n) {
        int value = 1;

        for (int i = n; i > 1; i--) {
            value *= i;
        }

        return value;
    }

}
