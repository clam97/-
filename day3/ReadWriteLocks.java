package org.day3;


import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLocks {

    public static void main(String[] args) {
        Work work = new Work();
        Worker w1 = new Worker(work,1);
        Worker w2 = new Worker(work,1);
        w1.start();
        w2.start();
    }
}



class Worker extends Thread{
    int flag  ;
    Work work;
    public Worker(Work work,int flag){
        this.work = work;
        this.flag = flag;
    }


    @Override
    public void run() {
        if (flag==1){
            work.ReadLock();
        }
        else {
            work.WriteLock();
        }
    }
}

class Work{

    ReadWriteLock lock = new ReentrantReadWriteLock();
    Lock read = lock.readLock();
    Lock write = lock.writeLock();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void WriteLock(){
         write.lock();
        System.out.println(Thread.currentThread().getId()+"开始进行写操作"+sdf.format(new Date()));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getId()+"写操作结束"+sdf.format(new Date()));
        write.unlock();
    }

    public void ReadLock(){
        read.lock();
        System.out.println(Thread.currentThread().getId()+"读操作开始执行"+sdf.format(new Date()));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getId()+"读操作结束"+sdf.format(new Date()));
        read.unlock();
    }



}