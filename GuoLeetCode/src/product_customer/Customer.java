package product_customer;

public class Customer implements Runnable {
	private Box box;

	public Customer(Box box) {
		// TODO Auto-generated constructor stub
		this.box = box;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			try {
				Thread. sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			box.drawApple();
		}

	}
}
