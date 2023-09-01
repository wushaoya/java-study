package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个  无重复元素 的 有序 整数数组 nums 。
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 *
 * @Author wushaoya
 * @date 2023-09-01
 * Time: 9:25
 */
public class Question228 {
    public List<String> summaryRanges(int[] nums) {
        /*List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        if (nums.length == 1) {
            res.add("" + nums[0]);
            return res;
        }
        int min = nums[0];
        int minIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                if (i == nums.length - 1) {
                    res.add(min + "->" + nums[i]);
                }
            } else {
                if (minIndex == i - 1) {
                    res.add("" + min);
                } else {
                    res.add(min + "->" + nums[i - 1]);
                }
                if (i == nums.length - 1) {
                    res.add("" + nums[i]);
                }
                min = nums[i];
                minIndex = i;
            }
        }
        return res;*/

        List<String> ret = new ArrayList<String>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            if (low < high) {
                temp.append("->");
                temp.append(Integer.toString(nums[high]));
            }
            ret.add(temp.toString());
        }
        return ret;
    }
}
