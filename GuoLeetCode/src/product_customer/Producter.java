package product_customer;

public class Producter implements Runnable {
	private Box box;

	public Producter(Box box) {
		// TODO Auto-generated constructor stub
		this.box = box;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			try {
				Thread. sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			box.addApple();
		}

	}
}
