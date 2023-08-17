package leetcode;

/**
 * 给定一个排序的整数数组 nums 和一个整数目标值 target ，请在数组中找到 target ，并返回其下标。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * @Author wushaoya
 * @date 2023-08-17
 * Time: 15:44
 */
public class LCR068 {

    public int searchInsert(int[] nums, int target) {
        if (target <= nums[0]) {
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            if (target == nums[i] || (nums[i - 1] < target && target < nums[i])) {
                return i;
            }
        }
        return nums.length;
    }
}
