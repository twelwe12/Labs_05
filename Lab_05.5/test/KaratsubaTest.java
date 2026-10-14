import java.math.BigInteger;

public class KaratsubaTest {

    private static int passed = 0;

    private static void checkEquals(String name, BigInteger expected, BigInteger actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError(
                    name + ": очікувалося " + expected + ", отримано " + actual
            );
        }

        passed++;
        System.out.println("PASS: " + name);
    }

    private static void multipliesLargePositiveNumbers() {
        BigInteger x = new BigInteger("12345678901234567890");
        BigInteger y = new BigInteger("98765432109876543210");
        BigInteger expected = new BigInteger("1219326311370217952237463801111263526900");

        checkEquals("велике додатне множення", expected, Main.karatsuba(x, y));
    }

    private static void handlesNegativeNumbers() {
        BigInteger x = new BigInteger("-12345678901234567890");
        BigInteger y = new BigInteger("98765432109876543210");
        BigInteger expected = new BigInteger("-1219326311370217952237463801111263526900");

        checkEquals("множення з від’ємним операндом", expected, Main.karatsuba(x, y));
    }

    private static void handlesZero() {
        checkEquals("множення на нуль", BigInteger.ZERO,
                Main.karatsuba(BigInteger.ZERO, new BigInteger("12345678901234567890")));
    }

    public static void main(String[] args) {
        multipliesLargePositiveNumbers();
        handlesNegativeNumbers();
        handlesZero();
        System.out.println("Успішно пройдено тестів: " + passed);
    }
}
