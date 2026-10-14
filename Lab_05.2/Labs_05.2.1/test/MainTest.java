public class MainTest {

    public static void main(String[] args) {
        double x = 1.5;
        double eps = 1e-12;
        double[] sum = {0};
        int[] terms = {0};

        Main.S(x, eps, terms, sum);

        double expected = Math.log(x);
        if (Math.abs(expected - sum[0]) > 1e-10) {
            throw new AssertionError("S(x) expected " + expected + ", got " + sum[0]);
        }
        if (terms[0] <= 0) {
            throw new AssertionError("S(x) should calculate at least one term");
        }

        System.out.println("PASS: S(1.5) is close to ln(1.5)");
    }
}
