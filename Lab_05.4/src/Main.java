void main(){
    int k;
    int N = 15;
    Scanner sc = new Scanner(System.in);
    System.out.print("k = ");
    k = sc.nextInt();

    System.out.println("(iter)           S0 = " + S0(k, N));
    System.out.println("(rec up ++)      S1 = " + S1(k, N, k));
    System.out.println("(rec up --)      S2 = " + S2(k, N, N));
    System.out.println("(rec down ++)    S3 = " + S3(k, N, k, 0));
    System.out.println("(rec down --)    S4 = " + S4(k, N, N, 0));
}

double S0(int k, int N)
{
    double s = 0;
    for (int i = k; i <= N; i++)
        s += Math.cos(i) / (1 + Math.pow(Math.sin(i), 2));
    return s;
}

double S1(int k, int N, int i)
{
    if (i > N)
        return 0;
    else
        return Math.cos(i) / (1 + Math.pow(Math.sin(i), 2)) + S1(k, N, i+1);
}
double S2(int k, int N, int i)
{
    if (i < k)
        return 0;
    else
        return Math.cos(i) / (1 + Math.pow(Math.sin(i), 2)) + S2(k, N, i-1);
}
double S3(int k, int N, int i, double t)
{
    t = t + Math.cos(i) / (1 + Math.pow(Math.sin(i), 2));
    if (i >= N)
        return t;
    else
        return S3(k, N, i+1, t);
}
double S4(int k, int N, int i, double t)
{
    t = t + Math.cos(i) / (1 + Math.pow(Math.sin(i), 2));
    if (i <= k)
        return t;
    else
        return S4(k, N, i-1, t);
}