package leetcode;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，请计算数组的 中心下标 。
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 *
 * @Author wushaoya
 * @date 2023-09-04
 * Time: 14:12
 */
public class LCR012 {
    public static int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum - nums[0] == 0) {
            return 0;
        }
        int res = -1;
        if (sum - nums[nums.length - 1] == 0) {
            res = nums.length - 1;
        }
        int left = nums[0];
        sum = sum - left;
        for (int i = 1; i < nums.length - 1; i++) {
            if (sum - nums[i] == left) {
                res = i;
                break;
            } else {
                sum = sum - nums[i];
                left = left + nums[i];
            }
        }
        return res;
    }
}
