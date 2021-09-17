import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.hackerrank.com/challenges/recursive-digit-sum/problem
 */
public class RecursiveDigitSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().trim().split(" ");
        char[] digits = in[0].toCharArray();
        long sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum += Character.getNumericValue(digits[i]);
        }
        int k = Integer.parseInt(in[1]);
        long reducedSum = reducer(sum);
        reducedSum = reducer(reducedSum * k);
        System.out.println(reducedSum);
    }

    private static long reducer(long sum) {
        if (sum < 10) return sum;
        else {
            return reducer(sumOfDigits(sum));
        }
    }

    private static long sumOfDigits(long number) {
        long sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

}
