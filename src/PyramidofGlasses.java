import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://codeforces.com/contest/676/problem/B
 */
public class PyramidofGlasses {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().trim().split(" ");
        int height = Integer.parseInt(in[0]); // height of pyramid
        int t = Integer.parseInt(in[1]); // number of seconds
        /**
         * since at level i, the total number of glasses are N(i) = N(i - 1) + 1
         * total glasses at level h will be (h * (h + 1)) / 2
         * sum of natural numbers from 1..n
         */
        int length = (height * (height + 1)) / 2;
        float[] arr = new float[length];

        fill(0, arr,1, t * 1.0F);

        /**
         * counting total filled glasses
         */
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) count++;
        }
        System.out.println(count);
    }

    // using level to find left and right child of current element
    private static void fill(int index, float[] arr, int level, float volume) {
        if (index >= arr.length || volume == 0) return;
        arr[index] += volume;
        if (arr[index] < 1) {
            return;
        }
        volume = arr[index] - 1;
        arr[index] = 1;
        int left = level + index;
        int right = left + 1;
        fill(left, arr, level + 1, volume / 2.0F);
        fill(right, arr, level + 1, volume / 2.0F);
    }
}
