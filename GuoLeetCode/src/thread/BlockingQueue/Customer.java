package thread.BlockingQueue;

import java.util.concurrent.BlockingQueue;

public class Customer implements Runnable {
	private final BlockingQueue<Integer> bQueue;
	public Customer(BlockingQueue<Integer> bQueue){
		this.bQueue=bQueue;
	}
@Override
public void run() {
	// TODO Auto-generated method stub
	for (int i = 0; i < 10; i++) {
		try {
			bQueue.take();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("------苹果的数量是："+" "+" "+bQueue.size());
	}
}
}
