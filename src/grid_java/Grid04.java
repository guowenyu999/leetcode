package grid_java;

import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Grid04 {
	private static WebDriver driver;
	private static DesiredCapabilities br;

	public static void runBaiduTest(WebDriver driver) {
		driver.get("https://www.baidu.com");
		driver.findElement(By.id("kw")).sendKeys("selenium");
		driver.findElement(By.id("su")).click();
//		driver.quit();
	}

	public static void main(String[] args) throws Exception {
		HashMap<String, String> config = new HashMap<String, String>();
		config.put("chrome", "http://127.0.0.1:4444/wd/hub");
		config.put("ff", "http://127.0.0.1:5555/wd/hub");
//		config.put("chrome", "http://127.0.0.1:6666/wd/hub");
		// 采用 Iterator 遍历 HashMap
		Iterator<String> it = config.keySet().iterator();
		while (it.hasNext()) {
			// 获得字典的 key(浏览器)
			String browser = (String) it.next();
			System.out.println(browser);
			// 获得字典的 value(节点)
			String nodeip = config.get(browser);
			System.out.println(nodeip);
			if (browser.equals("ie"))
				br = DesiredCapabilities.internetExplorer();
			else if (browser.equals("ff"))
				br = DesiredCapabilities.firefox();
			else if (browser.equals("chrome"))
				br = DesiredCapabilities.chrome();
			else
				System.out.println("browser 参数有误，只能为 ie、 ff、chrome");
			driver = new RemoteWebDriver(new URL(nodeip), br);
			runBaiduTest(driver);
		}
	}
}