package IO;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PushbackReader;

public class PushbackTest {
	public static void main(String[] args) {
		try {
			
//			InputStream in = PushbackTest.class.getResourceAsStream("a.txt");
//			FileReader reader=new FileReader("a.txt");
			System.out.println(PushbackTest.class.getResource("/IO/a.txt").getPath());
			PushbackReader prPushbackReader = new PushbackReader(new FileReader(PushbackTest.class.getResource("a.txt").getPath()), 64);

			char[] buf = new char[32];
			String lastContent = "";
			int hasRead = 0;
			while ((hasRead = prPushbackReader.read(buf))>0){
				String content=new String(buf,0,hasRead);
				int targetIndex=0;
				if ((targetIndex=(lastContent+content).indexOf("new PushbackReader"))>0) {
					prPushbackReader.unread((lastContent+content).toCharArray());
					if (targetIndex>32) {
						buf=new char[targetIndex];
					}
					prPushbackReader.read(buf,0,targetIndex);
					System.out.println(new String(buf,0,targetIndex));
					System.exit(0);
				}else {
					System.out.println(lastContent);
					lastContent=content;
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
