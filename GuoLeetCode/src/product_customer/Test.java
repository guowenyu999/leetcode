package product_customer;

public class Test {
public static void main(String[] args) {
	Box box=new Box(0);
	Thread customerThread=new Thread(new Customer(box));
	customerThread.start();
	Thread producterThread=new Thread(new Producter(box));
	producterThread.start();
}
}
