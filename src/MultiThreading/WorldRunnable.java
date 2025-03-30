package MultiThreading;

public class WorldRunnable implements Runnable{
    @Override
    public void run() {
        for(int i=0; i<100; i++){
            System.out.println("World Runnable");
            System.out.println(Thread.currentThread().getName());
        }
    }
}
