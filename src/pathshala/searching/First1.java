package pathshala.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class First1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        String[] in = br.readLine().trim().split(" ");
        int index = getPosition(in, 1, 0, N - 1);
        System.out.println(index);
    }

    private static int getPosition(String[] in, int key, int low, int high) {
        if (low > high) return -1;
        int mid = (high - low) / 2 + low;
        int currentVal = Integer.parseInt(in[mid]);
        if (currentVal < key) return getPosition(in, key, mid + 1, high);
        else if (currentVal > key) return getPosition(in, key, low, mid - 1);
        else {
            if (mid == 0 || mid == in.length - 1) return mid + 1;
            long prev = Long.parseLong(in[mid - 1]);
            if (prev != key) return mid + 1;
            else return getPosition(in, key, low, mid - 1);
        }
    }
}
