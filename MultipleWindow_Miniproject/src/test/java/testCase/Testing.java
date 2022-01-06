package testCase;

import java.io.FileOutputStream;
import java.io.PrintStream;

import org.openqa.selenium.WebDriver;
import utilities.DriverSetup;
import baseClass.Multiplewindow_Methods;


public class Testing {
	public static WebDriver driver;
	public static void main(String[] args) throws Exception{

		driver = DriverSetup.invokeBrowser();

		driver =DriverSetup.getURL();

		System.out.println("Console outputs are redirected to output.txt in Output folder");
		System.setOut(new PrintStream(new FileOutputStream("Output/output.txt")));

		Multiplewindow_Methods mw = new Multiplewindow_Methods();
		mw.create_Account(driver);
		mw.validation_1(driver);
		mw.print_Links(driver);
		mw.Terms_and_Conditions(driver);
		mw.quitbrowser(driver);
	}

}
