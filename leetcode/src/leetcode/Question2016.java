package leetcode;

/**
 * 给你一个下标从0开始的整数数组nums，该数组的大小为n，请你计算nums[j]-nums[i]能求得的最大差值
 * 其中 0 <= i < j < n 且 nums[i] < nums[j] 。
 * 返回 最大差值 。如果不存在满足要求的 i 和 j ，返回 -1 。
 *
 * @Author wushaoya
 * @date 2023-07-14
 * Time: 8:51
 */
public class Question2016 {
    public int maximumDifference(int[] nums) {
        int res = -1, min = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (min < nums[i]) {
                res = Math.max(res, nums[i] - min);
            } else {
                min = nums[i];
            }
        }
        return res;
    }
}
