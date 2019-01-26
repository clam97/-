package org.day3;
public class Mysynchronized2
{
     public synchronized void test1()
  {


                    int i = 5;
                      while( i-- > 0)
                     {
                       System.out.println(Thread.currentThread().getName() + " : " + i);
                      try
                        {
                            Thread.sleep(500);
                           }
                        catch (InterruptedException ie)
                         {
                      }
                  }

            }

         public static synchronized void test2()
           {
            int i = 5;
               while( i-- > 0)
               {
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                   try
                  {
                        Thread.sleep(500);
                   }
                   catch (InterruptedException ie)
                    {
                   }
                }
        }

          public static void main(String[] args)
            {
           final Mysynchronized2 myt2 = new Mysynchronized2();
                 Thread test1 = new Thread(  new Runnable() {  public void run() {  myt2.test1();  }  }, "test1"  );
                Thread test2 = new Thread(  new Runnable() {  public void run() { Mysynchronized2.test2();   }  }, "test2"  );
                 test1.start();
                 test2.start();
        //         TestRunnable tr=new TestRunnable();
        //         test3.start();
           }
        }
