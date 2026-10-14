static double g(double x, double y) {
    return ((Math.pow(Math.sin(x), 2) + Math.pow(Math.sin(y), 2)))
            / (1 + Math.abs(x * y));
}

void main(){
    Scanner sc = new Scanner(System.in);
    double r, s;

    System.out.print("r = ");
    r = sc.nextDouble();

    System.out.print("s = ");
    s = sc.nextDouble();

    double result = (Math.pow(g(r, s * s + 1), 2) + g(1, r * r + s))
            / (1 + Math.pow(g(1, r * s), 2));

    System.out.println("result: " + result);
}