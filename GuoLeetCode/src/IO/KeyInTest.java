package IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KeyInTest {
public static void main(String[] args) {
	InputStreamReader reader=new InputStreamReader(System.in);
	BufferedReader bReader=new BufferedReader(reader);
	String lineString=null;
	try {
		while ((lineString=bReader.readLine())!=null) {
			if (lineString.equals("exit")) {
				System.exit(1);
			}
			System.out.println("输入内容为："+ lineString);
			
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
