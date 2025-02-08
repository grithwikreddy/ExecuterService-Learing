package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Q11 {
    public int amount=0;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public void checkBalance() {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " checking balance: " + amount);
        } finally {
             lock.readLock().unlock();
        }
    }
    public void deposit(int cash) {
        lock.writeLock().lock();
        try {
             System.out.println(Thread.currentThread().getName()+ " depositing " + cash);
            amount+=cash;
            System.out.println(Thread.currentThread().getName()+" new balance: " + amount);
        } finally {
            lock.writeLock().unlock();
        }
    }
    public void question11(){
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(() -> checkBalance());
        executor.submit(() -> checkBalance());
        executor.submit(() -> deposit(500));
        executor.submit(() -> checkBalance());
        executor.submit(() -> checkBalance());
        executor.submit(() -> deposit(500));
        executor.submit(() -> checkBalance());
        executor.shutdown();
    }
}
