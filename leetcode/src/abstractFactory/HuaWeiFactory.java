package abstractFactory;

/**
 * @Author wushaoya
 * @date 2022-07-20
 * Time: 9:47
 */
public class HuaWeiFactory implements ProductFactory{
    @Override
    public PhoneProduct getPhone() {
        return new HuaWeiPhone();
    }

    @Override
    public RouterProduct getRouter() {
        return new HuaWeiRouter();
    }
}
