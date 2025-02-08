package org.example;
class MyThread extends Thread{
    public void run(){
        for(int r=0;r<10;r++){
            System.out.println(Thread.currentThread().getName()+" "+r);
            Thread.yield();
        }
    }
}
public class Q7 {
    public void question7(){
        MyThread thread1=new MyThread();
        MyThread thread2=new MyThread();
        thread2.start();
        thread1.start();

    }
}
