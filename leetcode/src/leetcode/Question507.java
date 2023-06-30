package leetcode;

/**
 * 对于一个正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
 * 给定一个整数n，如果是完美数，返回 true；否则返回 false。
 *
 * @Author wushaoya
 * @date 2023-04-28
 * Time: 15:10
 */
public class Question507 {

    public static boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }
        int half;
        if (num % 2 == 0) {
            half = num / 2;
        } else {
            half = (num - 1) / 2;
        }
        int sum = 0;
        for (int i = 1; i <= half; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        if (sum == num) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 100000; i++) {
            if (checkPerfectNumber(i)) {
                System.out.print(i + ";");
            }
        }
    }
}
