package thread.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test {
public static void main(String[] args) {
	BlockingQueue<Integer> bQueue=new ArrayBlockingQueue<Integer>(5);
	new Thread(new Customer(bQueue)).start();
	new Thread(new Producter(bQueue)).start();
}
}
