package thread;

public class SecondThread implements Runnable{
	private int i;
public void run(){
	for (; i < 100; i++) {
		System.out.println(Thread.currentThread().getName()+" "+i);
	}
}
public static void main(String[] args) {
	
	for (int i = 0; i < 10; i++) {
		final int index = i;
		System.out.println(index);
		}
	for (int i = 0; i < 100; i++) {
		System.out.println(Thread.currentThread().getName());
		if (i==20) {
			SecondThread stSecondThread=new SecondThread();
			new Thread(stSecondThread,"线程1").start();
			new Thread(stSecondThread,"线程2").start();
		}
	}
}
}
