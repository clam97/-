package org.day3;

public class Mysynchronized implements Runnable{

    @Override
    public void run() {
        synchronized (this){
            for (int i = 0; i <5 ; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"====="+i);
            }

        }

    }






}
class Mysychr {
    public synchronized void test(){
        for (int i = 0; i <4 ; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"----------"+i);

        }
    }

}

class Test{
    public static void main(String[] args) {
//        Mysynchronized t = new Mysynchronized();
//        Thread t1 = new Thread(t);
//        Thread t2 = new Thread(t);
//        t1.start();
//        t2.start();
      Mysychr mysychr = new Mysychr();
      Thread t = new Thread(new Runnable() {
          @Override
          public void run() {
              mysychr.test();
          }
      });
      Thread t1 = new Thread(new Runnable() {
          @Override
          public void run() {
              mysychr.test();
          }
      });
    t.start();
    t1.start();

    }
}