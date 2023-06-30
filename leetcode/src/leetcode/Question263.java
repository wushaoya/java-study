package leetcode;

/**
 * 丑数 就是只包含质因数 2、3 和 5 的正整数。
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false
 *
 * @Author wushaoya
 * @date 2022-10-20
 * Time: 10:03
 */
public class Question263 {

    public static boolean isUgly(int n) {
        if (n == 1) {
            return true;
        } else if (n == 0) {
            return false;
        } else if (n % 2 == 0) {
            n = n / 2;
            return isUgly(n);
        } else if (n % 3 == 0) {
            n = n / 3;
            return isUgly(n);
        } else if (n % 5 == 0) {
            n = n / 5;
            return isUgly(n);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        isUgly(14);
    }
}
