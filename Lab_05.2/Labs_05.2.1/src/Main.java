void main(){
    Scanner sc = new Scanner(System.in);
    double xp, xk, x, dx, eps;
    double[] s = {0};
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

    for (x = xp; x <= xk; x += dx) {
        S(x, eps, n, s);

        System.out.printf("|%5.2f |%20.10f |%20.10f |%5s |%n", x, Math.log(x), s[0], n[0]);
        System.out.println("+------+---------------------+---------------------+------+");
    }
}

void S(double x, double eps, int[] n, double[] s)
{
    n[0] = 0;
    double[] a = {x - 1};
    s[0] = a[0];

    do {
        n[0]++;
        A(x, n[0], a);
        s[0] += a[0];
    } while (Math.abs(a[0]) >= eps);
}

void A(double x, int n, double[] a){
    double R = -((x - 1) * n) / (n + 1.0);
    a[0] *= R;
}