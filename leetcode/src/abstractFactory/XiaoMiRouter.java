package abstractFactory;

/**
 * @Author wushaoya
 * @date 2022-07-20
 * Time: 9:44
 */
public class XiaoMiRouter implements RouterProduct {
    @Override
    public void start() {
        System.out.println("小米路由器开机");
    }

    @Override
    public void shutdown() {
        System.out.println("小米路由器开机");
    }
}
