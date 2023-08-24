package leetcode;

import java.util.Arrays;

/**
 * 给你一个数字数组 arr 。
 * 如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。
 * 如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。
 *
 * @Author wushaoya
 * @date 2023-08-24
 * Time: 10:45
 */
public class Question1502 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length == 2) {
            return true;
        }
        Arrays.sort(arr);
        int dif = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != dif) {
                return false;
            }
        }
        return true;
    }
}
