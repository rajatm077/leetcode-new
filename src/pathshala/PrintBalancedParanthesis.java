package pathshala;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintBalancedParanthesis {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().trim().split(" ");
        int k = Integer.parseInt(in[0]);
        char[] str = new char[2*k];
        print(k, 0, 0, str);
    }

    private static void print(int k, int i, int j, char[] str) {
        if (i + j == 2 * k) {
            System.out.println(str);
            return;
        }
        if (i < k) {
            str[i + j] = '(';
            print(k, i + 1, j, str);
        }
        if (j < i) {
            str[i + j] = ')';
            print(k, i, j + 1, str);
        }
    }
}
