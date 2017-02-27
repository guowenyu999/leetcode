
public class text {
public int x=0;
public static void delete(text m){
	m.x=1;
}
public static void main(String[] args) {
	text t=new text();
	delete(t);
	System.out.println(t.x);
}
}
