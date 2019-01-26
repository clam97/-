package org.day3;

public class Mysynchroized1 {

    public void Test1(){
        synchronized (Mysynchroized1.class){
            for (int i = 0; i <50 ; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"+++++"+i);

            }
        }
    }

    public  static synchronized void Test2(){
        for (int i = 0; i <50 ; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"----"+i);

        }
    }

    public static void main(String[] args) {
       Mysynchroized1 My = new Mysynchroized1();
       Thread t1 = new Thread(new Runnable() {
           @Override
           public void run() {
               My.Test1();
           }
       });
       Thread t2 = new Thread(new Runnable() {
           @Override
           public void run() {
               Mysynchroized1.Test2();
           }
       });
       t1.start();
       t2.start();
    }
}
