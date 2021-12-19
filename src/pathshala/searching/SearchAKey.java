package pathshala.searching;

/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class SearchAKey {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        String[] in = br.readLine().trim().split(" ");
        int T = Integer.parseInt(br.readLine().trim());
        int low = 0;
        int high = N - 1;
        long prevKey = -1;
        int prevIndex = -1;
        for (int t = 0; t < T; t++) {
            long key = Long.parseLong(br.readLine().trim());

            if (prevIndex > -1) {
                if (key < prevKey) {
                    high = prevIndex - 1;
                } else {
                    low = prevIndex + 1;
                }
            } else {
                high = N - 1;
                low = 0;
            }

            int index = bsearch(in, key, low, high);
            System.out.println(index);
            prevIndex = index;
            prevKey = key;
        }
    }

    private static int bsearch(String[] in, long key, int low, int high) {
        if (high < low) return -1;
        int mid = (high - low) / 2 + low;
        long currentval = Long.parseLong(in[mid]);
        if (currentval == key) return mid;
        else if (currentval > key) return bsearch(in, key, low, mid - 1);
        else return bsearch(in, key, mid + 1, high);
    }
}