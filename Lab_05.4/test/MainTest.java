public class MainTest {

    private static void checkNear(String name, double expected, double actual) {
        if (Math.abs(expected - actual) > 1e-12) {
            throw new AssertionError(name + ": expected " + expected + ", got " + actual);
        }
        System.out.println("PASS: " + name);
    }

    public static void main(String[] args) {
        int k = 1;
        int n = 15;
        double expected = Main.S0(k, n);

        checkNear("recursive increasing return", expected, Main.S1(k, n, k));
        checkNear("recursive decreasing return", expected, Main.S2(k, n, n));
        checkNear("recursive increasing accumulator", expected, Main.S3(k, n, k, 0));
        checkNear("recursive decreasing accumulator", expected, Main.S4(k, n, n, 0));
    }
}
