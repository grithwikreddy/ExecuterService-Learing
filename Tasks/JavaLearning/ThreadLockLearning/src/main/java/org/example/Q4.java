package org.example;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Q4 {
    public void question4(){
        Scanner s=new Scanner(System.in);
        System.out.print("Give Input n= ");
        int n=s.nextInt();
        int sum=0;
        int [] pri=new int[n+1];
        Vector<Thread> threads=new Vector<>();
        for(int r=2;r<=(int)Math.sqrt(n);r++){
            int finalR = r;
            Thread thread=new Thread(()->{
                for(int e = finalR + finalR; e<=n; e+= finalR){
                    if(pri[finalR]==1){
                        break;
                    }
                    pri[e]=1;
                }
            });
            threads.add(thread);
            thread.start();
        }
        for(Thread thread:threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        for(int r=2;r<=n;r++){
            if(pri[r]==0) {
                sum += r;
            }
        }
        System.out.println("Sum of prime = "+sum);

    }
}
