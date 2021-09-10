package DS1;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) {
            return false;
        }
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                int index = hm.get(nums[i]);
                int absDiff = Math.abs(index - i);
                if (absDiff <= k) {
                    return true;
                } else {
                    hm.replace(nums[i], i);
                }
            } else {
                hm.put(nums[i], i);
            }
        }
        return false;
    }
}
