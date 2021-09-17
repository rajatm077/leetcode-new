import java.util.ArrayList;
import java.util.List;

public class AllSubsets {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3 };
        getAllSubset(arr);
    }

    private static void getAllSubset(int[] arr) {
        List<List<Integer>> sol = new ArrayList<>();
        helper(arr, sol, 0, null);
        for (List<Integer> list: sol) {
            System.out.println(list.toString());
        }
    }

    private static void helper(int[] arr, List<List<Integer>> sol, int crtIndex, List<Integer> set) {
        if (set == null) {
            set = new ArrayList<>();
        }
        if (crtIndex == arr.length) {
            sol.add(set);
            return;
        }
        helper(arr, sol, crtIndex + 1, set);
        ArrayList<Integer> clone = new ArrayList<>(set);
        clone.add(arr[crtIndex]);
        helper(arr, sol, crtIndex + 1, clone);
    }
}
