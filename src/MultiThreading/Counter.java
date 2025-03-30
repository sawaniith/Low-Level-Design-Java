package MultiThreading;

public class Counter {
    private int count = 0;

//    public synchronized void incrementCount(){
//        count++;
//    }

    public void incrementCount(){
        synchronized (this){
            count++;
        }
    }

    public int getCount(){
        return count;
    }
}
