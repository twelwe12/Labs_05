import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static BigInteger karatsuba(BigInteger x, BigInteger y) {
        boolean negative = x.signum() != y.signum();

        BigInteger result = karatsubaPositive(x.abs(), y.abs());

        return negative ? result.negate() : result;
    }

    private static BigInteger karatsubaPositive(BigInteger x, BigInteger y) {
        if (x.signum() == 0 || y.signum() == 0) {
            return BigInteger.ZERO;
        }

        if (Math.min(x.bitLength(), y.bitLength()) <= 32) {
            return x.multiply(y);
        }

        int xWords = (x.bitLength() + 31) / 32;
        int yWords = (y.bitLength() + 31) / 32;

        // N — половина кількості слів коротшого числа, округлена вгору.
        int n = (Math.min(xWords, yWords) + 1) / 2;
        int shift = 32 * n;

        BigInteger mask = BigInteger.ONE.shiftLeft(shift)
                .subtract(BigInteger.ONE);

        // x = x1 * t + x0, y = y1 * t + y0, де t = 2^(32N).
        BigInteger x0 = x.and(mask);
        BigInteger x1 = x.shiftRight(shift);
        BigInteger y0 = y.and(mask);
        BigInteger y1 = y.shiftRight(shift);

        BigInteger d0 = karatsubaPositive(x0, y0);
        BigInteger d1 = karatsubaPositive(x1, y1);
        BigInteger d2 = karatsubaPositive(x0.add(x1), y0.add(y1));

        BigInteger middle = d2.subtract(d0).subtract(d1);

        return d1.shiftLeft(2 * shift)
                .add(middle.shiftLeft(shift))
                .add(d0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("a = ");
        BigInteger a = sc.nextBigInteger();

        System.out.print("b = ");
        BigInteger b = sc.nextBigInteger();

        System.out.print("c = ");
        BigInteger c = sc.nextBigInteger();

        System.out.print("d = ");
        BigInteger d = sc.nextBigInteger();

        BigInteger d0 = karatsuba(a, c);
        BigInteger d1 = karatsuba(b, d);
        BigInteger d2 = karatsuba(a.add(b), c.add(d));

        BigInteger r = d0.subtract(d1);
        BigInteger s = d2.subtract(d0).subtract(d1);

        System.out.println("r = " + r);
        System.out.println("s = " + s);

        sc.close();
    }
}
