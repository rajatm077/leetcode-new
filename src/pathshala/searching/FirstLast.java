package pathshala.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FirstLast {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        String[] in = br.readLine().trim().split(" ");
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            long key = Long.parseLong(br.readLine().trim());
            int first = getPosition(in, key, 0, N - 1, true);
            if (first == -1) {
                System.out.println(++first);
                continue;
            }
            int last = getPosition(in, key, first, N - 1, false);
            int freq = last - first + 1;
            System.out.println(freq);
        }

    }

    private static int getPosition(String[] in, long key, int low, int high, boolean first) {
        if (low > high) return -1;
        int mid = (high - low) / 2 + low;
        long currentVal = Long.parseLong(in[mid]);
        if (currentVal < key) return getPosition(in, key, mid + 1, high, first);
        else if (currentVal > key) return getPosition(in, key, low, mid - 1, first);
        else {
            if (mid == 0 || mid == in.length - 1) return mid;
            if (first) {
                long prev = Long.parseLong(in[mid - 1]);
                if (prev != key) return mid;
                else return getPosition(in, key, low, mid - 1, first);
            } else {
                long next = Long.parseLong(in[mid + 1]);
                if (next != key) return mid;
                else return getPosition(in, key, mid + 1, high, first);
            }
        }
    }
}
