package pathshala;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * https://codeforces.com/problemset/problem/768/B
 */
public class CodeFor1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().trim().split(" ");
        Long N = Long.parseLong(in[0]);
        long l = Long.parseLong(in[1]);
        long r = Long.parseLong(in[2]);
        List<Integer> list = new ArrayList<>();
        process(N, list);
        System.out.println(list.toString());
    }

    private static void process(Long N, List<Integer> list) {
        if (N < 2) {
            list.add(N.intValue());
            return;
        }
        process(N / 2, list);
        int mod = (int) (N & 1);
        int total = list.get(list.size() - 1);
        list.add(total + mod);
        list.add(total + mod + 1);
    }
}
