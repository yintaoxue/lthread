package org.fossd.lthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 *
 */
public class SimpleThreadPool 
{
    public static void main( String[] args )
    {
    	// 创建一个可重用固定线程数的线程池
    	ExecutorService pool = Executors.newFixedThreadPool(10);
    	// 创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
    	Thread t1 = new MyThread();
    	Thread t2 = new MyThread();
    	Thread t3 = new MyThread();
    	Thread t4 = new MyThread();
    	Thread t5 = new MyThread();
    	t1.setName("t1");
    	t2.setName("t2");
    	t3.setName("t3");
    	t4.setName("t4");
    	t5.setName("t5");
    	
    	// 将线程放入池中进行执行
    	pool.execute(t1);
    	pool.execute(t2);
    	pool.execute(t3);
    	pool.execute(t4);
    	pool.execute(t5);
    	// 关闭线程池
    	pool.shutdown();

    }
}

class MyThread extends Thread {
    @Override
    public void run() {
	System.out.println(Thread.currentThread().getName() + "正在执行。。。");
    }
}
