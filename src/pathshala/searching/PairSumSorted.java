package pathshala.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PairSumSorted {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        String[] in = br.readLine().trim().split(" ");
        int target = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < in.length; i++) {
            int currentVal = Integer.parseInt(in[i]);
            int index = getPosition(in, target - currentVal, i + 1, N - 1);
            System.out.printf("%d %d", ++i, ++index);
            return;
        }

    }
    private static int getPosition(String[] in, int key, int low, int high) {
        if (low > high) return -1;
        int mid = (high - low) / 2 + low;
        int currentVal = Integer.parseInt(in[mid]);
        if (currentVal < key) return getPosition(in, key, mid + 1, high);
        else if (currentVal > key) return getPosition(in, key, low, mid - 1);
        else return mid;
    }
}
