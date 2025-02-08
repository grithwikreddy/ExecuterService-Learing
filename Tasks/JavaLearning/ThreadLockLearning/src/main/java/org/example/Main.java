package org.example;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        //Q1.Write a Java program that creates two threads to find and print even and odd numbers from 1 to 20.
        Q1 q1=new Q1();
       // q1.question1();
        //Q2.Write a Java program that sorts an array of integers using multiple threads.
        Q2 q2=new Q2();
        //q2.question2();
        //Q3.Write a Java program that performs matrix multiplication using multiple threads.
        Q3 q3=new Q3();
        //q3.question3();
        //Q4.Write a Java program that calculates the sum of all prime numbers up to a given limit using multiple threads.
        Q4 q4=new Q4();
        //q4.question4();
        //Q5.Write a Java program that creates a bank account with concurrent deposits and withdrawals using threads.
        Q5 q5=new Q5();
        //q5.question5();
        //Q6.perform deadlock using Syncronization
        Q6 q6=new Q6();
        //q6.question6();
        //Q7.yeild example
        Q7 q7=new Q7();
        //q7.question7();
        //Q8.Producer and Consumer Problem
        Q8 q8=new Q8();
        //q8.question8();
        //Q9.ReentrantLock Learning
        Q9 q9=new Q9();
        //q9.question9();
        //Q10.Bank using Reentrantlock
        Q10 q10=new Q10();
        //q10.question10();
        //Q11. Read and Write Reentrantlock Learing
        Q11 q11=new Q11();
        q11.question11();
    }
}