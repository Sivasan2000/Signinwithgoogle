package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetup extends ReadPropertiesFile {
	public static WebDriver driver;


	public static WebDriver invokeBrowser()
	{
		String userChoice=AccessPropertiesFile.getBrowserProperty();
		switch(userChoice)
		{
		case "Firefox":
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\2072844\\eclipse-workspace\\MultipleWindow_Miniproject\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "Edge":
			System.setProperty("webdriver.edge.driver", "C:\\Users\\2072844\\eclipse-workspace\\MultipleWindow_Miniproject\\Driver\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		}
		return driver;


	}
	public static WebDriver getURL()
	{
		String url=AccessPropertiesFile.getUrlProp();
		driver.get(url);
		driver.manage().window().maximize();
		return driver;


	}

}
