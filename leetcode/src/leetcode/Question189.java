package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 * @Author wushaoya
 * @date 2023-08-18
 * Time: 14:44
 */
public class Question189 {
    public void rotate(int[] nums, int k) {
        List<Integer> temp = Arrays.stream(nums).boxed().collect(Collectors.toList());
        for (int i = 0; i < k; i++) {
            temp.add(0, temp.get(temp.size() - 1));
            temp.remove(temp.size() - 1);
        }
        for (int i = 0; i < temp.size(); i++) {
            nums[i] = temp.get(i).intValue();
        }
    }
}
