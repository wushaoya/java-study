package leetcode;

/**
 * 给你一个整数数组 nums ，返回数组中最大数和最小数的 最大公约数 。
 * 两个数的 最大公约数 是能够被两个数整除的最大正整数。
 *
 * @Author wushaoya
 * @date 2023-08-23
 * Time: 9:07
 */
public class Question1979 {
    public int findGCD(int[] nums) {
        int min = 1001, max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        if (max == min) {
            return max;
        }
        for (int j = min; j >= 1; j--) {
            if (max % j == 0 && min % j == 0) {
                return j;
            }
        }
        return 1;
    }
}
