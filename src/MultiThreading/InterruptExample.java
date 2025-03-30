package MultiThreading;

class InterruptExample extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("Thread is running...");
            Thread.sleep(5000);  // Thread goes into sleep
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted!" + e);
        }
    }

    public static void main(String[] args) {
        InterruptExample t = new InterruptExample();
        t.start();
        t.interrupt(); // Interrupt the sleeping thread
    }
}