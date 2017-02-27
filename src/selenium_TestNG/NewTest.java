package selenium_TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class NewTest {
	WebDriver driver;

	@Test
	public void testng001() throws InterruptedException {
		// -----------------------------鎵撳紑IE娴忚鍣�--------------------------------------------------
		System.setProperty("webdriver.gecko.driver", "D:\\guo\\selenium\\geckodriver-v0.14.0-win64\\geckodriver.exe");

		driver = new FirefoxDriver();

		driver.get("http://www.baidu.com/");
		Thread.sleep(1000);
		// 定位到百度的输入框
		driver.findElement(By.id("kw")).sendKeys("G7物流地图");
		Thread.sleep(1000);
		// 点击搜索
		driver.findElement(By.id("su")).click();

		Thread.sleep(1000);
		// 打印页面标题
		System.out.println(driver.getTitle());
		// 验证页面标题是否符合预期
		Assert.assertEquals(driver.getTitle(), "G7物流地图_百度搜索");
		Thread.sleep(5000);

	}

	public void f() {
	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}

	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

}
