//写出下面代码执行的结果（此题需写出分析过程，没有分析过程不得分，分值10分）

class MyThread extends Thread{
	public  void run(){
		try {
			Thread.currentThread().sleep(3000);
		} catch (InterruptedException e) {
		}
		System.out.println("MyThread running");
	}
}



public class ThreadTest3{
	public static void main(String argv[]) {
		MyThread t = new MyThread();
		t.run();//主线程执行了t的run方法。在run中，sleep3秒。 3秒后，打印MyThread running
		t.start();//开启了线程。
		System.out.println("Thread Test");
	  }
}
/*
主线程先执行run时，睡眠3秒，3秒后打印"MyThread running"。

开启另一个线程后，主线程有可能还持有cpu资源，继续打印"Thread Test"，主线程结束。

而开启的另一个线程执行run方法，睡眠3秒，3秒后打印"MyThread running"。


另一情况，主线程开启一个线程时，该线程立刻执行，运行run方法时，睡眠3秒，
在该线程睡眠过程中，cpu会处理主线程。打印"Thread Test"。主线程结束。
然后。另一个线程3秒后，cpu处理该线程打印"MyThread running"。

*/