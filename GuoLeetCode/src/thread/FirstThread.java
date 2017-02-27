package thread;

public class FirstThread extends Thread{
//使用继承Thread类的方法创建线程时，多个线程之间无法共享线程类的实例变量
	private int i;
	public void run(){
		for (;i<100; i++) {
			System.out.println(getName()+ " "+ i);
		}
	}
	public static void main(String[] args) {
		for (int i = 0; i<100; i++) {
			System.out.println(Thread.currentThread().getName()+" "+i);
			if (i==0) {
				new FirstThread().start();
				new FirstThread().start();
			}
		}
	}
}
