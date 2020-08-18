package com.qa.la.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.la.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream FI = new FileInputStream(
					System.getProperty("user.dir")
							+ "/src/main/java/com/qa/la/config/config.properties");
			prop.load(FI);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public WebDriver init() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"src\\main\\resources\\libs\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage()
					.timeouts()
					.pageLoadTimeout(TestUtil.page_Load_TimeOut,
							TimeUnit.SECONDS);
			driver.manage().timeouts()
					.implicitlyWait(TestUtil.implicitwait, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
		}
		return driver;

	}

}
