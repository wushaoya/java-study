package leetcode;

/**
 * 给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。
 * 请你找到这个数组里第 k 个缺失的正整数。
 *
 * @Author wushaoya
 * @date 2023-07-17
 * Time: 14:58
 */
public class Question1539 {

    public static void main(String[] args) {
        findKthPositive(new int[]{2,3,4,7,11}, 5);
    }

    public static int findKthPositive(int[] arr, int k) {
        int i = 0, num = 0, index = 0;
        while (num < k) {
            index++;
            if (index == arr[i]) {
                if(i < arr.length - 1) {
                    i++;
                }
            } else {
                num ++;
            }
        }
        return index;
    }
}
