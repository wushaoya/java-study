package abstractFactory;

/**
 * @Author wushaoya
 * @date 2022-07-20
 * Time: 9:44
 */
public class XiaoMiPhone implements PhoneProduct{
    @Override
    public void start() {
        System.out.println("小米手机开机");
    }

    @Override
    public void shutdown() {
        System.out.println("小米手机开机");
    }
}
