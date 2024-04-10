package utils;
import java.lang.reflect.Field;

/**
 * @Author wushaoya
 * @date 2024-04-10
 * Time: 9:57
 */
public class BeanUtils {
    /**
     * 复制S的属性到T的共同属性
     * @param source
     * @param target
     * @return
     * @param <T>
     * @param <S>
     * @throws Exception
     */
    public static <T, S> T copyProperties(S source, T target) throws Exception {
        Class<?> sourceClass = source.getClass();
        Class<?> targetClass = target.getClass();

        Field[] sourceFields = sourceClass.getDeclaredFields();
        for (Field sourceField : sourceFields) {
            String fieldName = sourceField.getName();
            Field targetField = null;
            try {
                targetField = targetClass.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                // 目标对象不存在该属性，忽略
                continue;
            }

            sourceField.setAccessible(true);
            targetField.setAccessible(true);

            Object value = sourceField.get(source);
            targetField.set(target, value);
        }

        return target;
    }

    public static void main(String[] args) throws Exception {
        Source source = new Source();
        source.setName("Tom");
        source.setAge(20);

        Target target = new Target();
        target.setAddress("Beijing");

        copyProperties(source, target);

        System.out.println(target.getName()); // 输出 "Tom"
        System.out.println(target.getAddress()); // 输出 "Beijing"
        source.setName("Jack");
        System.out.println(target.getName()); // 输出 "Tom"
    }
}

class Source {
    private String name;
    private int age;
    // getter and setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


class Target {
    private String name;
    private String address;
    // getter and setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}


