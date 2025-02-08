package org.example;

import java.util.Vector;

public class Q3 {
    public void question3(){
        int[][] max1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7,8,9}
        };
        int [][] max2={
                {2,3,4},
                {7,8,9},
                {3,4,5}
        };
        Vector<Thread> threads=new Vector<>();
        int [][] ans={{0,0,0},{0,0,0},{0,0,0}};
        for(int r=0;r<3;r++){
            for(int e=0;e<3;e++){
                int finalR = r;
                int finalE = e;
                Thread thread1=new Thread(()->{
                    ans[finalR][finalE]=(max1[finalR][0]*max2[0][finalE])+(max1[finalR][1]*max2[1][finalE])+(max1[finalR][2]*max2[2][finalE]);
                });
                threads.add(thread1);
                thread1.start();
            }
        }
        for(Thread thread:threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        for(int r=0;r<3;r++){
            for(int e=0;e<3;e++){
                System.out.print(ans[r][e]+" ");
            }
            System.out.println("");
        }
    }
}
