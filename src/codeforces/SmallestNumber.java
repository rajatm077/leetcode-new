package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://codeforces.com/contest/55/problem/B
 */
public class SmallestNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        String[] op = br.readLine().split(" ");
        long[] numbers = new long[in.length];
        for (int i = 0; i < in.length; i++) {
            numbers[i] = Long.parseLong(in[i]);
        }

        long res = helper(op, numbers, 0);
        System.out.println(res);

    }

    private static long helper(String[] op, long[] numbers, int i) {
        if (i == op.length) {
            long min = Long.MAX_VALUE;
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[j] < 0) continue;
                min = Math.min(min, numbers[j]);
            }
            return min;
        }
        long sol = Long.MAX_VALUE;
        for (int j = 0; j < numbers.length - 1; j++) {
            if (numbers[j] < 0) continue;
            for (int k = j + 1; k < numbers.length; k++) {
                if (numbers[k] < 0 ) continue;
                long res = 0;
                if (op[i].equals("*")) {
                    res = numbers[j] * numbers[k];
                } else {
                    res = numbers[j] + numbers[k];
                }
                long temp1 = numbers[j];
                long temp2 = numbers[k];
                numbers[j] = -1;
                numbers[k] =  res;
                long res2 = helper(op, numbers, i + 1);
                sol = Math.min(sol, res2);
                numbers[j] = temp1;
                numbers[k] = temp2;
            }
        }
        return sol;
    }
}
