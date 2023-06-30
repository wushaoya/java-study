package abstractFactory;

/**
 * @Author wushaoya
 * @date 2022-07-20
 * Time: 9:52
 */
public class XiaoMiFactory implements ProductFactory{
    @Override
    public PhoneProduct getPhone() {
        return new XiaoMiPhone();
    }

    @Override
    public RouterProduct getRouter() {
        return new XiaoMiRouter();
    }
}
