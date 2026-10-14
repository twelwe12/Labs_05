import java.util.Scanner;

public class Main {

    public static double g(double x, double y) {
        return (Math.pow(Math.sin(x), 2) + Math.pow(Math.sin(y), 2))
                / (1 + Math.abs(x * y));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("r = ");
        double r = sc.nextDouble();

        System.out.print("s = ");
        double s = sc.nextDouble();

        double result = (Math.pow(g(r, s * s + 1), 2) + g(1, r * r + s))
                / (1 + Math.pow(g(1, r * s), 2));

        System.out.println("result: " + result);
        sc.close();
    }
}
