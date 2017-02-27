package grid_java;

import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Grid02 {
	private static WebDriver driver;
	private static DesiredCapabilities browser;

	public static void runBaiduTest(WebDriver driver) {
		driver.get("https://www.baidu.com");
		driver.findElement(By.id("kw")).sendKeys("selenium");
		driver.findElement(By.id("su")).click();
//		driver.quit();
	}

	public static void main(String[] args) throws Exception {
		String browsers[];
		browsers = new String[3];
		browsers[0] = "ff";
		browsers[1] = "chrome";
		browsers[2] = "chrome";
		for (int i = 0; i < 1; i++) {
			System.out.println(browsers[i]);
			if (browsers[i].equals("ie"))
				browser = DesiredCapabilities.internetExplorer();
			else if (browsers[i].equals("ff"))
				browser = DesiredCapabilities.firefox();
			else if (browsers[i].equals("chrome"))
				browser = DesiredCapabilities.chrome();
			else
				System.out.println("browser ��������ֻ��Ϊ ie�� ff��chrome");
			//��һ��������ʾ��������ַ���ڶ���������ʾԤ��ִ�еĶ���
			driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), browser);
			runBaiduTest(driver);
		}
	}
}