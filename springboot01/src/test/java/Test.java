import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Author wushaoya
 * @date 2022-07-20
 * Time: 9:52
 */
@SpringBootTest
public class Test {
    @Autowired
    RedisTemplate redisTemplate;
    public static void main(String[] args) {

    }

    @org.junit.jupiter.api.Test
    public void test(){
        redisTemplate.opsForValue().set("wsy","test");
        System.out.println(redisTemplate.opsForValue().get("wsy"));
    }

}
