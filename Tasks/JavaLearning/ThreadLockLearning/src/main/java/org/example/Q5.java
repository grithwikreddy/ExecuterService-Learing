package org.example;
class Bank{
    private int amount=0;
    private int required=0;
    public synchronized void withdraw(int cash) throws InterruptedException {
        if(amount<cash){
            required=cash;
            wait();
        }
        if(amount>=cash){
            amount-=cash;
            System.out.println("Widraw successful and new ballance = "+amount);
        }
        else {
            System.out.println("Inssufient funds and current ballance ="+amount);
        }
    }
    public synchronized void deposit(int cash){
        amount+=cash;
        System.out.println("New ballance ="+amount);
        if(amount>=required)
        notify();
    }
}
public class Q5 {
    public void question5() throws InterruptedException{
        Bank b=new Bank();
        Thread t1=new Thread(()->{
            try {
                b.withdraw(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t6=new Thread(()->{b.deposit(800);});
        Thread t2=new Thread(()->{
            try {
                b.withdraw(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t3=new Thread(()->{b.deposit(10000);});
        Thread t4=new Thread(()->{
            try {
                b.withdraw(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t5=new Thread(()->{
            try {
                b.withdraw(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t7=new Thread(()->{
            try {
                b.withdraw(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t6.setPriority(4);
        t3.setPriority(4);
        t7.start();
        t6.start();
        t1.start();
        t2.start();
        t3.start();

        t4.start();
        t5.start();

    }
}
