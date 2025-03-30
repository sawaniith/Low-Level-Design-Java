package MultiThreading;

public class DaemonThread extends Thread{
    @Override
    public void run() {
        while (true) { // Infinite loop (JVM will kill it when user threads finish)
            System.out.println("Daemon Thread running...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }

    public static void main(String[] args) {
        DaemonThread t = new DaemonThread();
        t.setDaemon(true); // Convert to daemon thread
        t.start();
        System.out.println("Main method ends. JVM will exit soon. and stop the daemon thread");
    }
}
