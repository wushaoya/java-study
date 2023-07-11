package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给你一个下标从 0 开始的整数数组 nums 。在一步操作中，移除所有满足nums[i - 1] > nums[i] 的 nums[i] ，其中 0 < i < nums.length 。
 * 重复执行步骤，直到 nums 变为 非递减 数组，返回所需执行的操作数。
 *
 * @Author wushaoya
 * @date 2023-07-11
 * Time: 10:48
 */
public class Question2289 {

    public int totalSteps(int[] nums) {
        int ret = 0;
        Deque<int[]> stack = new ArrayDeque<>();
        for (int num : nums) {
            // step表示在第几步删除
            int step = 0;
            // 如果当前元素比栈顶元素大，则可能需要删除（如果左侧有更大的元素则需要删除）。
            // 即使需要删除，也需要在下一轮删除，所以此时需要记录前一个元素在第几步删除，当前元素需要删除的话，加1即可。
            while (stack.size() > 0 && stack.peek()[0] <= num) {
                step = Math.max(step, stack.peek()[1]);
                stack.pop();
            }
            // 如果栈不为空，说明当前元素左侧有更大的值，当前元素需要删除，则更新step
            if (stack.size() != 0) {
                ++step;
            } else { // 如果栈为空，说明当前元素是已扫描元素中的最大值，它不需要被删除，将step置为0。这一步骤不操作也可，反正后续用不到。
                step = 0;
            }
            ret = Math.max(ret, step);
            stack.push(new int[]{num, step});
        }
        return ret;
        //  =======超出时间限制=========
        /*if (nums.length <= 1) {
            return 0;
        }
        int res = 0;
        List<Integer> list = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        return dfs(list, res);*/
    }

    /*
    超出时间限制
     */
    public int dfs(List<Integer> list, int res) {
        List<Integer> temp = new ArrayList<>();
        temp.add(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) >= list.get(i - 1)) {
                temp.add(list.get(i));
            }
        }
        if (temp.size() == list.size()) {
            return res;
        } else {
            res++;
            return dfs(temp, res);
        }
    }
}
