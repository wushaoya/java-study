package thread;


/**
 * @Author wushaoya
 * @date 2022-07-07
 * Time: 10:04
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        BeginThread b1 = new BeginThread("Thread1");
        BeginThread b2 = new BeginThread("Thread2");
        b1.start();
        b2.start();
    }
}

class BeginThread extends Thread {
    String name;

    public BeginThread(String name) {
                            this.name = name;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 10) {
            i++;
            System.out.println(this.name + i);
        }
    }
}
