import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Power {
    public static void main(String[] args) throws IOException {
        System.out.println(myPow(0.999999999, -2147483648));
    }

    public static double myPow(double x, int n) {
        if (n == 0) return 1;
        if (x == 1 || n == 1) return x;
        double res = 0;
        if (n < 0) {
            long p = Math.abs(n * 1L);
            res = helper(x, p);
            return 1 / (res * 1.0F);
        } else {
            return helper(x, n);
        }

    }

    public static double helper(double x, long n) {
        if (n == 1 || n == 0) {
            return x;
        }
        double res = helper(x, n / 2);
        res *= res;
        if ((n & 1) != 0) {
            res *= x;
        }
        return res;
    }
}
