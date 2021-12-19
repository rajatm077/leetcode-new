package pathshala.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RotatedSortedArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine().trim());
        String[] in = "5, 6, 7, 8, 9, 10, 1, 2, 3".trim().split(", ");
        int T = in.length;
        int pivot = getPosition(in, 0, in.length - 1);
        System.out.println("pivot:" + pivot);
        int highVal = Integer.parseInt(in[in.length - 1]);
        int index = -1;
        while (T-- > 0) {
            int key = Integer.valueOf(in[T]);
            if (key <= highVal) {
                index = bsearch(in, key, pivot, in.length - 1);
            } else {
                index = bsearch(in, key, 0, pivot - 1);
            }
            System.out.println("index: " + index + " key: " + key);
        }
    }

    private static int bsearch(String[] in, int key, int low, int high) {
        if (low > high) return -1;
        int mid = (high - low) / 2 + low;
        int currentVal = Integer.parseInt(in[mid]);
        if (currentVal == key) return mid;
        else if (currentVal > key) return bsearch(in, key, low, mid - 1);
        else return bsearch(in, key, mid + 1, high);
     }

    private static int getPosition(String[] arr, int low, int high) {
        if (low == high) return low;
        int mid = (high - low ) / 2 + low;
        int midVal = Integer.parseInt(arr[mid]);
        int highVal = Integer.parseInt(arr[high]);
        if (midVal > highVal) return getPosition(arr, mid + 1, high);
        else {
            if (mid == 0 || midVal < Integer.parseInt(arr[mid - 1])) return mid;
            else return getPosition(arr, low, mid - 1);
        }
    }
}
