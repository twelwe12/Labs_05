import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double xp, xk, dx, eps;
        int[] n = {0};

        System.out.print("xp = ");
        xp = sc.nextDouble();

        System.out.print("xk = ");
        xk = sc.nextDouble();

        System.out.print("dx = ");
        dx = sc.nextDouble();

        System.out.print("eps = ");
        eps = sc.nextDouble();

        System.out.println("+------+---------------------+---------------------+------+");
        System.out.printf("|%5s |%20s |%20s |%5s |%n", "x", "ln(x)", "S", "n");
        System.out.println("+------+---------------------+---------------------+------+");

        for (double x = xp; x <= xk; x += dx) {
            double s = S(x, eps, n);

            System.out.printf("|%5.2f |%20.10f |%20.10f |%5d |%n",
                    x, Math.log(x), s, n[0]);
            System.out.println("+------+---------------------+---------------------+------+");
        }

        sc.close();
    }

    public static double S(double x, double eps, int[] n) {
        n[0] = 0;
        double a = x - 1;
        double s = a;

        do {
            n[0]++;
            a = A(x, n[0], a);
            s += a;
        } while (Math.abs(a) >= eps);

        return s;
    }

    public static double A(double x, int n, double a) {
        double r = -((x - 1) * n) / (n + 1.0);
        return a * r;
    }
}
