package abstractFactory;

/**
 * @Author wushaoya
 * @date 2022-07-20
 * Time: 9:42
 */
public interface RouterProduct {
    /**
     * 开机
     */
    void start();

    /**
     * 关机
     */
    void shutdown();
}
