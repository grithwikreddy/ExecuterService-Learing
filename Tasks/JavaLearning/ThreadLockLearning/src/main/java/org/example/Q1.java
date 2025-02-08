package org.example;

public class Q1 {
    public void question1(){
        Integer c=new Integer(10);
        Thread m=new Thread(()->{
            synchronized (c){
                for(int r=1;r<=20;r+=2){
                    System.out.println(r+ " = "+Thread.currentThread().getName());
                }
            }
        });
        Thread n=new Thread(()->{
            for(int r=0;r<=20;r+=2){
                System.out.println(r+ " = "+Thread.currentThread().getName());
            }
        });
        m.start();
        n.start();
    }
}
