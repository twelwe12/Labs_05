import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int k;
        int n = 15;
        Scanner sc = new Scanner(System.in);

        System.out.print("k = ");
        k = sc.nextInt();

        System.out.println("(iter)           S0 = " + S0(k, n));
        System.out.println("(rec up ++)      S1 = " + S1(k, n, k));
        System.out.println("(rec up --)      S2 = " + S2(k, n, n));
        System.out.println("(rec down ++)    S3 = " + S3(k, n, k, 0));
        System.out.println("(rec down --)    S4 = " + S4(k, n, n, 0));

        sc.close();
    }

    public static double S0(int k, int n) {
        double s = 0;
        for (int i = k; i <= n; i++) {
            s += Math.cos(i) / (1 + Math.pow(Math.sin(i), 2));
        }
        return s;
    }

    public static double S1(int k, int n, int i) {
        if (i > n) {
            return 0;
        }
        return term(i) + S1(k, n, i + 1);
    }

    public static double S2(int k, int n, int i) {
        if (i < k) {
            return 0;
        }
        return term(i) + S2(k, n, i - 1);
    }

    public static double S3(int k, int n, int i, double sum) {
        sum += term(i);
        if (i >= n) {
            return sum;
        }
        return S3(k, n, i + 1, sum);
    }

    public static double S4(int k, int n, int i, double sum) {
        sum += term(i);
        if (i <= k) {
            return sum;
        }
        return S4(k, n, i - 1, sum);
    }

    private static double term(int i) {
        return Math.cos(i) / (1 + Math.pow(Math.sin(i), 2));
    }
}
