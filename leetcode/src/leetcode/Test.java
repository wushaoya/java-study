package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wushaoya
 * @date 2023-12-04
 * Time: 15:13
 */
public class Test {

    public static boolean getNum(int num) {
        int sum = 0;
        for (int i = 0; i < String.valueOf(num).length(); i++) {
            sum += Integer.parseInt(String.valueOf(num).charAt(i) + "");
        }
        return sum % 4 == 0;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 3999; i++) {
            if(getNum(i)){
                list.add(i);
            }
        }
        System.out.println(list);
        System.out.println(list.size());
    }
}
