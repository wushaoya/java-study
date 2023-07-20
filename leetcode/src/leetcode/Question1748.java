package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 。数组中唯一元素是那些只出现 恰好一次 的元素。
 * 请你返回 nums 中唯一元素的和
 *
 * @Author wushaoya
 * @date 2023-07-20
 * Time: 13:54
 */
public class Question1748 {

    public static int sumOfUnique(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue().equals(1)) {
                sum += (int) entry.getKey();
            }
        }
        return sum;
    }
}
