package product_customer;

public class Box {
 private int apple;
 public Box(int apple) {
	// TODO Auto-generated constructor stub
	this.apple=apple;
}
public int getApple() {
	return apple;
}
public void setApple(int apple) {
	this.apple = apple;
}
public synchronized void drawApple() {
	if (apple==0) {
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		apple--;
		System.err.println("----苹果数量是："+" "+apple);
		notify();
	
}
public synchronized void addApple() {
	if (apple==5) {
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		apple++;
		System.err.println("苹果数量是："+" "+apple);
		notify();
	
}
}
