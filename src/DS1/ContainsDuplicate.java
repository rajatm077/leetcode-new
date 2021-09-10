package DS1;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 1) {
            return false;
        }
        Map<Integer, Integer> hs = new HashMap<>();
        for (Integer i : nums) {
            if (hs.containsKey(i)) {
                return true;
            } else {
                hs.put(i, 1);
            }
        }
        return false;
    }
}
