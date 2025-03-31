package MultiThreading;

public class MultiThreadMain {
    public static void main(String[] args) throws InterruptedException{
        //user threads

        //created thread using extend of Thread class
//        WorldThread wt = new WorldThread(); //NEW state
//        wt.start(); //RUNNABLE state
//
//        //other state possible is WAITING/BLOCKED/TIMED_WAITING (waiting for resources or other thread to complete)
//
//
//        //create thread using implement of Runnable class
//        WorldRunnable wr = new WorldRunnable();
//        Thread t1 = new Thread(wr);
//        t1.setPriority(Thread.MAX_PRIORITY);
//        //Thread priority is a suggestion, not a guarantee. The OS and JVM determine actual scheduling.
//        t1.start();
//        t1.join(); //main thread will wait till t1 completes here
//        //TERMINATED (when called t1.join();)
//
//        for(int i=0; i<100; i++){
//            System.out.println("Hello");
//            System.out.println(Thread.currentThread().getName());
//        }

        Counter c = new Counter();
        SyncThread t1 = new SyncThread(c);
        SyncThread t2 = new SyncThread(c);

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        } catch (InterruptedException e) {

        }
        System.out.println(c.getCount());

        BankAccount bankAccount = new BankAccount();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                bankAccount.withdraw(3000);
            }
        };
        Thread t11 = new Thread(runnable, "Thread 1");
        Thread t22 = new Thread(runnable, "Thread 2");
        t11.start();
        t22.start();

        //thread using lambda
        Thread tl1 = new Thread(() -> {
            bankAccount.withdraw(1000);
        }, "Thread 1");
    }
}
