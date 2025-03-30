package MultiThreading;

public class SyncThread extends Thread{
    private Counter counter;

    public SyncThread(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i=0; i<1000; i++){
            counter.incrementCount();
        }
    }
}
