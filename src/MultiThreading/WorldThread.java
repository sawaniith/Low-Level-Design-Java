package MultiThreading;

public class WorldThread extends Thread{
    @Override
    public void run() {
        for(int i=0; i<100; i++){
            System.out.println("World Thread");
            System.out.println(Thread.currentThread().getName());
        }
    }
}
