package baseClass;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.Screenshots;

public class Multiplewindow_Methods 
{
	public static WebDriver driver;
    //To select create account 
	public void create_Account(WebDriver driver)
	{
		WebElement  element = driver.findElement(By.cssSelector(" a[title='Create Rediffmail Account']"));
		element.click();
		
		//Taking screenshot of 'CreateAccount' Webpage
		Screenshots screenshot=new Screenshots(driver);
		screenshot.captureScreenShot();
	}

	
	//To validate "Create Rediffmail account" webpage is opened 
	public void validation_1(WebDriver driver)
	{
		String URL = driver.getCurrentUrl();
		if(URL.equals("http://register.rediff.com/register/register.php?FormName=user_details")) 
		{
			System.out.println("Testcase passed: Create Rediffmail account is opened and screenshot is saved");
		} 
		else
		{
			System.out.println("Testcase failed: Create Rediffmail account is not opened");
		}
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	}
	
	

	//To count total no of links in the webpage
	public void print_Links(WebDriver driver)
	{
		List<WebElement> nooflinks = driver.findElements(By.tagName("a"));
		System.out.println("The Total number of links on the webpage are: ");
		System.out.println(nooflinks.size());

		//To print the links in the webpage
		System.out.println("The links on the webpage are: ");
		for(WebElement links:nooflinks)
		{
			System.out.println(links.getText()+links.getAttribute("href"));
		}
	}

	
	public void Terms_and_Conditions(WebDriver driver) throws FileNotFoundException
	{
		//To click on Terms and conditions link
		String Parentwindow = driver.getWindowHandle();
		WebElement element1 = driver.findElement(By.linkText("terms and conditions"));
		element1.click();
		Set<String> popupwindow = driver.getWindowHandles();
		for(String childwindow:popupwindow)
		{
			if(!(childwindow.equalsIgnoreCase(Parentwindow)))
			{
				//To validate child window is displayed
				WebElement cwvalidation = driver.findElement(By.tagName("body"));
				if(cwvalidation.isDisplayed()) {
					System.out.println("Testcase passed: The child window 'Terms and Conditions' is opened and screenshot is saved " );
				}else
				{
					System.out.println("Tesstcase failed: The child window is not opened");
				} 

				//switching to the child window
				driver.switchTo().window(childwindow);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				
				//Taking screenshot after switched to the childwindow
				Screenshots screenshot=new Screenshots(driver);
				screenshot.captureScreenShot();
				// To validate the title of the Childwindow
				String expectedresult = "Terms and Conditions";
				String actualresult = driver.findElement(By.cssSelector(".floatL.bold")).getText();
				if(expectedresult.equals(actualresult))
				{
					System.out.println("Testcase Passed: Title of the page is "+actualresult);
				}
				else 
				{
					System.out.println("Test case is failed");
				}
			}
		}

		//To close the child window
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		driver.close();

		// switching to the parentwindow
		driver.switchTo().window(Parentwindow);
		driver.manage().timeouts().implicitlyWait(80,TimeUnit.SECONDS);	
	}
	

	//To quit the browser
	public void quitbrowser(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.quit();
	}
}


