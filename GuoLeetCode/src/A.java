import java.lang.reflect.Method;


public class A {
	int b=2;
public  class B{
public B() {
	int b=3;
	int c=A.this.b;
	// TODO Auto-generated constructor stub
}
}
public static class C{
	int a;
	
}
public static void main(String[] args) {
	A a= new A();
	B b= a.new B();
}
}
