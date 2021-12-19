import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PerfectNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int sqrtN = (int) Math.sqrt(N);
        int[] primes = new int[sqrtN + 4];
        fillPrimeNumbers(primes);
        int sumOfFactors = 1;
        for (int i = 2; i < primes.length; i++) {
            if (primes[i] == 0 && N % i == 0) {
                int div2 = (N / i);
                sumOfFactors = sumOfFactors + i + div2;
                if (div2 < primes.length) {
                    primes[div2] = 1;
                }
            }
        }
        System.out.println(sumOfFactors);
        if (sumOfFactors == N) {
            System.out.println("Perfect");
        } else {
            System.out.println("Not Perfect");
        }
    }

    private static void fillPrimeNumbers(int[] primes) {
        for (int i = 2; i < primes.length; i++) {
            if (primes[i] > 0) continue;
            for (int j = i*2; j < primes.length; j += i) {
                primes[j] = 1;
            }
        }
    }
}
