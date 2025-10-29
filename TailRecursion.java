
public class TailRecursion {
    public static int pow(int value, int n) {
        if (n == 0) {
            return 1;
        } else {
            return (value * pow(value, n - 1));
        }
    }

    public static int pow2(int n) {
        return pow(2, n);
    }

    public static int sumFactors(int n) {
        return totalFactors(n, 1, 2);
    }

    public static int totalFactors(int n, int i, int x) {
        if (x >= n || n == 1) {
            return i;
        } else if (n % x == 0) {
            return totalFactors(n, i + x, x + 1);
        } else {
            return totalFactors(n, i, x + 1);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(pow2(n));
        System.out.println(sumFactors(n));
    }
}
