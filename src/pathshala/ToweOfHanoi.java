package pathshala;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToweOfHanoi {
    public static void main(String[] args) throws IOException {
        System.out.println(shiftPile(3, 4).toString());
    }
    static List<Integer> shiftPile(int N, int n){
        // code here
        List<List<Integer>> sol = new ArrayList<>();
        toh(N, 1, 3, 2, n, sol);
        return sol.get(n-1);
    }
    public static void toh(int disks, int start, int target, int middle, int maxSteps, List<List<Integer>> sol) {
        if (disks == 1) {
            sol.add(new ArrayList<>(Arrays.asList(start, target)));
            return;
        };
        toh(disks - 1, start, middle, target, maxSteps, sol);
        sol.add(new ArrayList<>(Arrays.asList(start, target)));
        if (sol.size() >= maxSteps) return;
        toh(disks - 1, middle, target, start, maxSteps, sol);
    }
}
