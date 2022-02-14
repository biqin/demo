import java.util.LinkedList;
import java.util.List;

public class HoldCPUMain {
    public static class HoldCPUTask implements Runnable {
        @Override
        public void run() {
            while (true) {
                test();
            }
        }

        private void test() {
            double a = Math.random() * Math.random();
        }
    }

    public static class LazyTask implements Runnable {
        @Override
        public void run() {
            while(true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void qq() {
            double a = Math.random() * Math.random();
        }
    }

    public static void main(String[] args) {
        List<String> aa = new LinkedList<>();
        aa.add("aa");
        aa.add("bb");
        aa.add(1, "cc");
        System.out.println(aa.get(1));
        System.out.println(aa.get(2));
        aa.stream().forEach(a-> System.out.println(a));
        aa.remove(1);
        System.out.println(aa.get(1));
        System.out.println("ccc");
        System.out.println("qq");

        System.out.println("cccc");
        System.out.println("eft");


        new Thread(new HoldCPUTask()).start();
        new Thread(new LazyTask()).start();
        new Thread(new LazyTask()).start();
        new Thread(new LazyTask()).start();

    }
}
