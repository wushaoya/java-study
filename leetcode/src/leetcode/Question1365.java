package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给你一个数组nums，对于其中每个元素nums[i]，请你统计数组中比它小的所有数字的数目。
 * 换而言之，对于每个nums[i]你必须计算出有效的j的数量，其中 j 满足j != i 且 nums[j] < nums[i]。
 * 以数组形式返回答案。
 *
 * @Author wushaoya
 * @date 2022-09-27
 * Time: 10:22
 */
public class Question1365 {
    public static int[] smallerNumbersThanCurrent(int[] nums) {

        int[] res = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        // list.stream().sorted();
        Collections.sort(list);
        for (int i = 0; i < nums.length; i++) {
            res[i] = list.indexOf(nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {8, 1, 2, 2, 3};
        long time = System.currentTimeMillis();
        System.out.println(time);
        smallerNumbersThanCurrent(nums);
        System.out.println(System.currentTimeMillis() - time);
    }
}
