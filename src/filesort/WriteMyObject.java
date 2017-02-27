package filesort;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

class Teacher implements java.io.Serializable {
//	class Teacher{
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;

	public Teacher(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}

public class WriteMyObject  {

public static void main(String[] args) {
	try {
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("object.txt"));
		Teacher t=new Teacher("lury", 30);
		oos.writeObject(t);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
