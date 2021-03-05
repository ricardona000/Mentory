package functional;

import java.util.stream.IntStream;

public class FP07Threads {

    public static void main(String[] args) {
        /*Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10000; i++) {
                    System.out.println(Thread.currentThread().getId() + ": " + i);
                }
            }
        };
        Thread thread1 = new Thread(runnable);
        thread1.start();
        Thread thread2 = new Thread(runnable);
        thread2.start();
        Thread thread3 = new Thread(runnable);
        thread3.start();*/

        //Functional Approach
        Runnable runnableF = () -> {
            IntStream.range(0, 10000).forEach(i -> System.out.println(Thread.currentThread().getId() + ": " + i));
        };
        Thread threadF1 = new Thread(runnableF);
        threadF1.start();
        Thread threadF2 = new Thread(runnableF);
        threadF2.start();
    }

}
