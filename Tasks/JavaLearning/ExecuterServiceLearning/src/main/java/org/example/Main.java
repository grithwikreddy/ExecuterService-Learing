package org.example;
import java.util.*;
import java.lang.*;
import java.util.concurrent.*;

class FutureCallable implements Callable<Integer> {
Integer a;

public  FutureCallable(Integer a){
    this.a=a;
     }
     @Override
     public Integer call() throws  Exception{
    return a;
     }
}

class Main {
    public  static void anyMultipleCall(){
        ExecutorService e = Executors.newFixedThreadPool(2);
        List<FutureCallable> tasks=List.of(new FutureCallable(1),new FutureCallable(2),new FutureCallable(3),new FutureCallable(4));

        try{Integer results=e.invokeAny(tasks);
                System.out.println(results);
        }
        catch (InterruptedException | ExecutionException ee){
            ee.printStackTrace();
        }
        e.shutdown();
    }
    public  static void multipleCall()  {
        ExecutorService e = Executors.newFixedThreadPool(2);
        List<FutureCallable> tasks=List.of(new FutureCallable(1),new FutureCallable(2),new FutureCallable(3),new FutureCallable(4));

        try{List<Future<Integer>> results=e.invokeAll(tasks);
            for (Future<Integer> r : results) {
                System.out.println(r.get());
            }
        }
        catch (InterruptedException | ExecutionException ee){
            ee.printStackTrace();
        }
        e.shutdown();
    }
     public static void futureCall() {
         ExecutorService e = Executors.newFixedThreadPool(2);
         Future<Integer> f1 = e.submit(new FutureCallable(1));
         Future<Integer> f2 = e.submit(new FutureCallable(2));
         Future<Integer> f3 = e.submit(new FutureCallable(3));
         Future<Integer> f4 = e.submit(new FutureCallable(4));
         try
         {
             System.out.println("1. " + f1.get());
             while(!f2.isDone())
             {
                 System.out.println("waiting for task to finish");
                 Thread.sleep(10);
             }
             System.out.println("2. " + f2.get());
             System.out.println("3. " + f3.get());
             System.out.println("4. " + f4.get());

         }
         catch (InterruptedException | ExecutionException ee)
         {
             ee.printStackTrace();
         }
         e.shutdown();
     }
    public static void singleExecutorLearn(){
        ExecutorService e= Executors.newSingleThreadExecutor();
        e.execute(new Runnable() {
                      public void run() {
                          for(int r=0;r<10;r++){
                              System.out.print(r+" ");
                          }
                      }
                  }
        ) ;
        e.execute(new Runnable() {
                      public void run() {
                          for(int r=0;r<10;r++){
                              System.out.print(r+" ");
                          }
                      }
                  }
        ) ;
        for(int r=11;r<20;r++)
            System.out.print(r+ " ");
        e.shutdown();
    }
    public static void fixedpoolThread(){
        ExecutorService e=Executors.newFixedThreadPool(10);
        for(int r=1;r<=10;r++){
            int temp = r;
            e.execute(new Runnable() {
               @Override
               public void run() {
                   for(int e=1;e<=10;e++)
                        System.out.print((temp *10)+e+" ");
               }
           });
        }
        e.shutdown();
    }
    public static void main(String[] args)  {
//        singleExecutorLearn();
 //      fixedpoolThread();
//        futureCall();
//        multipleCall();
    //    anyMultipleCall();
    }
}