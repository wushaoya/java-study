package leetcode;

/**
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和≥target的长度最小的连续子数组[numsl, numsl+1, ..., numsr-1, numsr]并返回其长度。
 * 如果不存在符合条件的子数组，返回 0
 *
 * @Author wushaoya
 * @date 2023-07-13
 * Time: 15:53
 */
public class Offer008 {
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        // 滑动窗口
        while (end < n) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
        // ====== 超出时间限制=========
        /*int tempRes = nums.length + 1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= target) {
                tempRes = i + 1;
                break;
            }
        }
        if (tempRes == nums.length + 1) {
            return 0;
        }
        int res = tempRes;
        for (int i = 0; i < nums.length; i++) {
            int index = tempRes + i - 1;
            if (index > nums.length - 1) {
                index = nums.length - 1;
            }
            for (int j = index; j >= i; j--) {
                int sumTemp = 0;
                for (int k = i; k <= j; k++) {
                    sumTemp += nums[k];
                }
                if (sumTemp >= target) {
                    res = res <= j - i + 1 ? res : j - i + 1;
                }
            }
        }
        return res;*/
    }
}
