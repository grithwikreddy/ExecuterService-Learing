package org.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Q9 {
    final Lock lock = new ReentrantLock();

    public void re() {
        //synchronized (this) {
        lock.lock();
       try {
            System.out.println("locked Q9 at re");
            ve();
            System.out.println("unlocked Q9 at re");
        }
       finally {
         //  lock.unlock();
       }
            //
      //  }
    }

    public void ve() {
        //synchronized (this) {  //
        lock.lock();
        try{
            System.out.println("locked and unlocked Q9 at ve");
        }
        finally {
            lock.unlock();
            lock.unlock();
        }
            //
       // }
    }
//    public synchronized void re(){
//        System.out.println("re called");
//        ve();
//    }
//    public synchronized void ve(){
//        System.out.println("ve called");
//        //re();
//    }

    public void question9() {
        for(int r=0;r<10;r++){
            re();
        }
    }
}
