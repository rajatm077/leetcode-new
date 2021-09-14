package DS1;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSumII {
    public static void main(String[] args) {
        TwoSumII twoSumII = new TwoSumII();
        int[] sol = twoSumII.twoSum(new int[] { 2,7,11,15 }, 9);
        System.out.println(Arrays.toString(sol));
    }
    public int[] twoSum(int[] numbers, int target) {
        int[] sol = new int[2];
        for (int i = 0; i < numbers.length / 2 + 1; i++) {
            int index = binarySearch(numbers, i + 1, numbers.length - 1, target - numbers[i]);
            if (index == i || index < 0) continue;
            else {
                sol[0] = i;
                sol[1] = index;
                return sol;
            }
        }
        return sol;
    }
    public int binarySearch(int[] arr, int left, int right, int key) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) return mid;
            else if (arr[mid] > key) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
}
