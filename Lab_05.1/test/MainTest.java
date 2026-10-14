public class MainTest {

    private static void checkNear(String name, double expected, double actual) {
        if (Math.abs(expected - actual) > 1e-12) {
            throw new AssertionError(name + ": expected " + expected + ", got " + actual);
        }
        System.out.println("PASS: " + name);
    }

    public static void main(String[] args) {
        checkNear("g(0, 0)", 0.0, Main.g(0, 0));
        checkNear("g(pi/2, 0)", 1.0, Main.g(Math.PI / 2, 0));
    }
}
