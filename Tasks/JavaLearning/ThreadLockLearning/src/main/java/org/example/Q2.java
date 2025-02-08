package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import static java.util.Collections.swap;

public class Q2 {

    public int sort(Vector<Integer> v,int l,int r){
        int p=v.get(r);
        int i = l - 1;
        for (int j = l; j <=r-1;j++) {
            if (v.get(j)<p) {
                i++;
                swap(v,i,j);
            }
        }
        swap(v,i+1,r);
        return i + 1;
    }
    public void re(Vector<Integer> v,int l,int r){
        if(l>=r){return;}
        int p=sort(v,l,r);
            Thread thread1 = new Thread(() -> {
                re(v, l, p - 1);
            });
            thread1.start();
            Thread thread2 = new Thread(() -> {
                re(v, p + 1, r);
            });
            thread2.start();
        try {
            thread1.join();
            thread2.join();
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void question2() throws InterruptedException {
        Vector<Integer> v=new Vector<>(Arrays.asList(1,6,2,3,8,9,5,6,9,2,10));
        re(v,0,10);
        for(int r=0;r<11;r++){
            System.out.println(v.get(r));
        }

    }
}
