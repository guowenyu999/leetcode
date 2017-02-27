package Selenium_java;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class RunJavaApplication {
	public static void main(String[] args) {

		// 如果火狐浏览器没有默认安装在C盘，需要制定其路径
		// File file_ie = new File("D:/guo/selenium/IEDriverServer.exe");
		// System.setProperty("webdriver.ie.driver", file_ie.getAbsolutePath());
		// DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		// caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		// caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
		// true);
		// WebDriver my_dr = new InternetExplorerDriver(caps);// 打开ie浏览器
		// WebDriver driver = new InternetExplorerDriver();// 打开ie浏览器

		// System.setProperty("webdriver.gecko.driver", "C:\\Program Files
		// (x86)\\Mozilla Firefox\\firefox.exe");
		//
		// WebDriver driver = new FirefoxDriver();

		// chrome
		// File file_chrome = new File("D:/guo/selenium/chromedriver.exe");
		// System.setProperty("webdriver.chrome.driver",
		// file_chrome.getAbsolutePath());
		// WebDriver driver = new ChromeDriver();

		// firefox
//		WebDriver driver = new FirefoxDriver();
//		System.setProperty("webdriver.firefox.driver", "D:\\guo\\selenium\\geckodriver-v0.9.0-win64\\geckodriver.exe");

//		System.setProperty("webdriver.gecko.driver", "D:/guo/selenium/geckodriver-v0.9.0-win64/geckodriver.exe");
//		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//		capabilities.setCapability("marionette", true);
//		WebDriver driver = new FirefoxDriver(capabilities);
		
		System.setProperty("webdriver.gecko.driver","D:\\guo\\selenium\\geckodriver-v0.14.0-win64\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://www.baidu.com/");

		driver.manage().window().maximize();

		WebElement txtbox = driver.findElement(By.name("wd"));
		txtbox.sendKeys("Glen");

		WebElement btn = driver.findElement(By.id("su"));
		btn.click();

		driver.close();

	}
}
