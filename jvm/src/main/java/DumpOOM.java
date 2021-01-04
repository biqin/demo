import java.util.ArrayList;
import java.util.List;

public class DumpOOM {
    public static void main(String[] args) throws InterruptedException {
        List v = new ArrayList();
        for (int i = 0; i < 100; ++i) {
            v.add(new byte[1024*1024]);
        }
        System.out.println("finish");
        Thread.sleep(10000000000L);
    }
}
