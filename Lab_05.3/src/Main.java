void main(){
    Scanner sc = new Scanner(System.in);
    double t, tp, tk, n, dt, result;

    System.out.print("tp = ");
    tp = sc.nextDouble();

    System.out.print("tk = ");
    tk = sc.nextDouble();

    System.out.print("n = ");
    n = sc.nextDouble();

    dt = (tk - tp) / n;

    System.out.println("+-----------+---------------------+");
    System.out.printf("|%10s |%20s |", "t", "result");
    System.out.println();
    System.out.println("+-----------+---------------------+");

    for (t = tp; t <= tk; t += dt) {

        result = f(1 + 2 * t) + Math.pow(f(1) + 2 * f(2 * t), 2);

        System.out.printf("|%10.4f |%20.10f |", t, result);
        System.out.println();
        System.out.println("+-----------+---------------------+");
    }
}

double f(double x){
    if (Math.abs(x) >= 1){
        return (Math.pow(Math.sin(x), 2) + Math.sin(x * x))
                / (1 + Math.pow(Math.cos(x), 2));
    }

    else {
        int n = 0;
        double a = Math.pow(x, 4 * n + 1) / factorial(4 * n + 1);
        double s = a;
        do{
            n ++;
            double r = Math.pow(x, 4)
                    / ((4.0 * n + 2) * (4.0 * n + 3) * (4.0 * n + 4) * (4.0 * n + 5));
            a *= r;
            s += a;
        } while (n <= 6);
        return s;
    }
}

double factorial(int n) {
    double result = 1.0;

    for (int i = 2; i <= n; i++) {
        result *= i;
    }

    return result;
}
