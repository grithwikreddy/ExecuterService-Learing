package org.example;

import java.util.LinkedList;
import java.util.Queue;


public class Q8 {
    Queue<Integer> q=new LinkedList<>();
    public synchronized void consume() throws InterruptedException {
        if(q.size()==0){
            wait();
        }
        System.out.println(q.poll()+" Consumed");
        notify();
    }
    public synchronized void produce(int a) throws InterruptedException {
        if(q.size()>1){
            wait();
        }
        System.out.println(a+" Produced");
        q.offer(a);
        notify();
    }
    public void question8(){
        Thread t1=new Thread(){
          @Override
          public void run(){
              try {
                  produce(1);
              } catch (InterruptedException e) {
                  throw new RuntimeException(e);
              }
          }
        };
        Thread t2=new Thread(){
            @Override
            public void run(){
                try {
                    consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread t3=new Thread(){
            @Override
            public void run(){
                try {
                    consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread t4=new Thread(){
            @Override
            public void run(){
                try {
                    produce(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread t5=new Thread(){
            @Override
            public void run(){
                try {
                    produce(3);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread t6=new Thread(){
            @Override
            public void run(){
                try {
                    consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }


}
