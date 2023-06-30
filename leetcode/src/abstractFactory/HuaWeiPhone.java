package abstractFactory;

/**
 * @Author wushaoya
 * @date 2022-07-20
 * Time: 9:43
 */
public class HuaWeiPhone implements PhoneProduct{
    @Override
    public void start() {
        System.out.println("华为手机开机");
    }

    @Override
    public void shutdown() {
        System.out.println("华为手机关机");
    }
}
