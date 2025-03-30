package MultiThreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 5000;

    private final Lock lock = new ReentrantLock();

    //fair locks
//    private final Lock lock = new ReentrantLock(true); //to provide the locks in the order of requested time

//    public synchronized void withdraw(int amount){
//        System.out.println(Thread.currentThread().getName() + " attempting to withdraw" + amount);
//        if(balance >= amount){
//            System.out.println(Thread.currentThread().getName() + " proceeding with withdraw" + amount);
//            try{
//                Thread.sleep(3000);
//            }catch (InterruptedException e){
//
//            }
//            balance -= amount;
//            System.out.println(Thread.currentThread().getName() + " success withdraw" + balance);
//        }else {
//            System.out.println(Thread.currentThread().getName() + " insufficient balance" + balance);
//        }
//    }

    public void withdraw(int amount){
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw" + amount);
        try {
            if(lock.tryLock(2000, TimeUnit.MILLISECONDS)){
                if(balance >= amount){
                    try {
                        System.out.println(Thread.currentThread().getName() + " proceeding with withdraw" + amount);
                        Thread.sleep(3000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " success withdraw" + balance);
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }finally {
                        lock.unlock();
                    }
                }else {
                    System.out.println(Thread.currentThread().getName() + " insufficient balance" + balance);
                    lock.unlock();
                }
            }else{
                System.out.println(Thread.currentThread().getName() + " didnt got the lock");
            }
        }catch (Exception e){
            //good practice to interrupt so that we store the state and process later
            Thread.currentThread().interrupt();
        }
        if(Thread.currentThread().isInterrupted()){
            //do some logic on interruption
            System.out.println(Thread.currentThread().getName() + " got interrupted");
        }
    }
}
