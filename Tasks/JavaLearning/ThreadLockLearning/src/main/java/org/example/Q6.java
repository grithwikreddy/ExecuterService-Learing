package org.example;
class Data{
    private Integer data;
    public Data(int data){
        this.data=data;
    }
}
public class Q6 {
    public void question6(){
        Data lock1=new Data(1);
        Data lock2=new Data(2);
        Thread thread1=new Thread(()->{
            synchronized (lock1){
                System.out.println("locked lock1 by thread1");
                synchronized (lock2){
                    System.out.println("locked lock2 by theread1");
                }
            }
        });
        Thread thread2=new Thread(()->{
            synchronized (lock2){
                System.out.println("locked lock2 by thread2");
                synchronized (lock1){
                    System.out.println("locked lock1 by theread2");
                }
            }
        });
        thread1.start();
        thread2.start();

    }
}
