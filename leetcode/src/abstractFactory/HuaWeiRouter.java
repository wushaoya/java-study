package abstractFactory;

/**
 * @Author wushaoya
 * @date 2022-07-20
 * Time: 9:45
 */
public class HuaWeiRouter implements RouterProduct{
    @Override
    public void start() {
        System.out.println("华为路由器开机");
    }

    @Override
    public void shutdown() {
        System.out.println("华为路由器关机");
    }
}
