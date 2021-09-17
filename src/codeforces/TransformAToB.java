package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * https://codeforces.com/contest/727/problem/A
 */
public class TransformAToB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().trim().split(" ");
        int start = Integer.parseInt(in[0]);
        int target = Integer.parseInt(in[1]);
        List<Integer> al = new ArrayList<>();
        al.add(target);
        while (target > start) {
            if ((target & 1) == 0) { // even
                target >>= 1;
            } else {
                target--;
                if (target % 10 != 0) {
                    System.out.println("NO");
                    return;
                }
                target /= 10;
            }
            al.add(target);
        }

        if (target == start) {
            System.out.println("YES");
            System.out.println(al.size());
            for (int i = al.size() - 1; i >= 0; i--) {
                System.out.print(al.get(i) + " ");
            }
            System.out.println();
        } else {
            System.out.println("NO");
        }
    }
}
