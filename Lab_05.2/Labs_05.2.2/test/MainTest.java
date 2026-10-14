public class MainTest {

    public static void main(String[] args) {
        double x = 1.5;
        int[] terms = {0};

        double actual = Main.S(x, 1e-12, terms);
        double expected = Math.log(x);

        if (Math.abs(expected - actual) > 1e-10) {
            throw new AssertionError("S(x) expected " + expected + ", got " + actual);
        }
        if (terms[0] <= 0) {
            throw new AssertionError("S(x) should calculate at least one term");
        }

        System.out.println("PASS: S(1.5) is close to ln(1.5)");
    }
}
