public class MainTest {

    private static void checkNear(String name, double expected, double actual) {
        if (Math.abs(expected - actual) > 1e-12) {
            throw new AssertionError(name + ": expected " + expected + ", got " + actual);
        }
        System.out.println("PASS: " + name);
    }

    public static void main(String[] args) {
        checkNear("factorial(5)", 120.0, Main.factorial(5));

        double x = 1.0;
        double expected = (Math.pow(Math.sin(x), 2) + Math.sin(x * x))
                / (1 + Math.pow(Math.cos(x), 2));
        checkNear("f(1)", expected, Main.f(x));
    }
}
