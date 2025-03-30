package MultiThreading;

class YieldExample extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + i);
            Thread.yield();  // Suggests giving up CPU time
        }
    }

    public static void main(String[] args) {
        YieldExample t1 = new YieldExample();
        YieldExample t2 = new YieldExample();

        //The yield() method in Java allows a thread to pause its execution and give a chance -
        // for other threads of the same or higher priority to run.
        //It does NOT guarantee that another thread will execute immediately.
        //The thread remains in the "Runnable" state, not blocked.
        //The CPU may or may not switch to another thread, depending on the thread scheduler.

        t1.start();
        t2.start();
    }
}