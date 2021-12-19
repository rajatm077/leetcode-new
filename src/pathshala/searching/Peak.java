// https://leetcode.com/problems/find-peak-element/

package pathshala.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Peak {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(findPeakElement(new int[] { 1,2,3,2 }));
    }
    public static int findPeakElement(int[] arr) {
        if (arr.length == 1) {
            return 0;
        }
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = ( high - low ) / 2 + low;
            if (mid == 0) {
                if (arr[mid] > arr[mid + 1]) return mid;
                else low = mid + 1;
            } else if (mid == arr.length - 1) {
                if (arr[mid] > arr[mid - 1]) return mid;
                else high = mid - 1;
            } else if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else if (arr[mid] < arr[mid - 1]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
