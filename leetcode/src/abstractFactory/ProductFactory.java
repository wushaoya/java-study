package abstractFactory;

/**
 * @Author wushaoya
 * @date 2022-07-20
 * Time: 9:46
 */
public interface ProductFactory {

    /**
     * 生产手机
     */
    PhoneProduct getPhone();

    /**
     * 生产路由器
     */
    RouterProduct getRouter();
}
