package juc;

import java.util.Arrays;
import java.util.List;

/**
 * @Author wushaoya
 * @date 2022-09-23
 * Time: 17:08
 */
public class StreamTest {
    public static void main(String[] args) {
        User u1 = new User(1, "a", 10);
        User u2 = new User(2, "b", 11);
        User u3 = new User(3, "c", 12);
        User u4 = new User(4, "d", 13);
        User u5 = new User(5, "e", 14);
        User u6 = new User(6, "f", 15);

        List<User> list = Arrays.asList(u1, u2, u3, u4, u5, u6);
        list.stream().filter(u -> {
            return u.getId() % 2 == 0;
        }).filter(u -> {
            return u.getAge() > 23;
        }).map(u -> {
            return u.getName().toUpperCase();
        }).sorted((uu1, uu2) -> {
            return uu2.compareTo(uu1);
        }).limit(1).forEach(System.out::println);
    }
}


