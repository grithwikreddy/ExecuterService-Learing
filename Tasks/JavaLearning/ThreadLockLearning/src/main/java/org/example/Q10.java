package org.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Q10 {
    int money=0;
    Lock lock=new ReentrantLock(true);
    Condition wait=lock.newCondition();
    Queue<Integer> queue=new LinkedList<>();
    public void withdraw(int cash) throws InterruptedException {
        lock.lock();
        try {
            while (money < cash) {
                System.out.println(Thread.currentThread().getName() + " waithing for deposit");
                queue.add(cash);
                wait.await();
            }
            money-=cash;
            System.out.println("Withdeaw amount " + cash + " successfully new ballance: " + money);
        }
        finally {
            lock.unlock();
        }
    }
    public void deposit(int cash){
        lock.lock();
        try {
            System.out.println("Deposited :"+cash);
            money+=cash;
            while(!queue.isEmpty()){
                int need=queue.peek();
                if(money>=need){
                    wait.signal();
                    queue.poll();
                }
                else{
                    break;
                }
            }
        }
        finally {
            lock.unlock();
        }
    }
    public void question10(){
        ExecutorService e= Executors.newFixedThreadPool(4);
        e.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    withdraw(600);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        e.execute(new Runnable() {
            @Override
            public void run() {
                deposit(400);
            }
        });
        e.execute(new Runnable() {
            @Override
            public void run() {
                deposit(600);
            }
        });

        e.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    withdraw(400);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
