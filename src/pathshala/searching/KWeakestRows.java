package pathshala.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class KWeakestRows {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().trim().split(" ");
        int N = Integer.parseInt(in[0]);
        int M = Integer.parseInt(in[1]);
        String[][] arr = new String[N][M];
        RowRank[] rowRanks = new RowRank[N];
        for (int i = 0; i < N; i++) {
            in = br.readLine().trim().split(" ");
            int index = getPosition(in, 1, 0, in.length - 1);
            rowRanks[i] = new RowRank(index, i);
        }
        Arrays.sort(rowRanks, (r1, r2) -> {
            if (r1.count == r2.count) return r1.index - r2.index;
            else return r1.count - r2.count;
        });
        for (int i = 0; i < rowRanks.length; i++) {
            System.out.printf("%d ", rowRanks[i].index);
        }
    }

    private static int getPosition(String[] in, int key, int low, int high) {
        if (low > high) return -1;
        int mid = (high - low) / 2 + low;
        int currentVal = Integer.parseInt(in[mid]);
        if (currentVal > key) return getPosition(in, key, mid + 1, high);
        else if (currentVal < key) return getPosition(in, key, low, mid - 1);
        else {
            if (mid == in.length - 1) return mid;
            int next = Integer.parseInt(in[mid + 1]);
            if (next != key) return mid;
            else return getPosition(in, 1, mid + 1, high);
        }
    }

    static class RowRank {
        public int count;
        public int index;
        public RowRank(int count, int index) { this.count = count; this.index = index; }
    }
}
