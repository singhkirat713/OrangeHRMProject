package testlayer;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import basepackage.BaseClass;
import pompackage.PomLogin;
import testdata.ExcelSheet;

public class LoginTestClass extends BaseClass{
	
	//creating the object of PomLogin class to call functions from PomLogin
	//and declaring below to expand scope of object
	PomLogin login;
	
	//creating constructor
	public LoginTestClass() {
		
		
		//calling constructor from parent class using 'super()'
		super();
		
	}//constructor ends here
	
	
	
	@BeforeMethod
	public void initialSetup() {
		
		initiate();
	
		//initiating variable
		login = new PomLogin();
		
	}
	
	
	@Test(priority=1)
	public void titlemethod() {
		
		//calling method to verify page and saving output in variable
		String actualTitle = login.verifyPage();
		
		//import ORG.JUNIT.ASSERT not JUNIT.FRAMEWORK.ASSERT
		//adding hard assertion to confirm page title and then proceed
		Assert.assertEquals(actualTitle,"OrangeHRM");
		
	}
	
	@DataProvider
	public Object[][] Details(){
		
		Object result[][]=ExcelSheet.readData("Sheet1");
		
		return result;
		
	}
	
	
	@Test(priority=2, dataProvider="Details")
	
	public void loginmethod(String name, String pass) {
		//implicit wait added to let the driver pick the element
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		login.enterUsername(name);
		login.enterPassword(pass);
	//	login.clickLoginBtn();
	}
	
	
	
	
	@AfterMethod
	public void closeSetup() {
		//capture screenshot after entering data
		captureScreeenShot("Login");
		driver.close();
		
	}
	
	

}//LoginTestClass ends here
