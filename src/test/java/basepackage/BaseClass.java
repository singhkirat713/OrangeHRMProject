package basepackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilitypackage.TimeUtils;

public class BaseClass {
	
	 //creating object to access Properties class
	public static Properties propertiesObject = new Properties();
	//creating object for WebDriver class
	public static WebDriver driver; ////visibility of driver was changed to protected from suggestions in PomLogin class
	
	//creating constructor to read properties of config.properties file
	public BaseClass(){
		
		
	//object with URL of the file
	try {
		FileInputStream file = new FileInputStream("C:\\Users\\abhig\\eclipse-workspace\\orangeart\\src\\test\\java\\environmentvariables\\config.properties");
		propertiesObject.load(file);
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			
		catch(IOException a){
			a.printStackTrace();
			
		}
	}//BaseClass constructor ends here
	
	
	//switch box for browser selection
	public static void initiate(){
		switch(propertiesObject.getProperty("browser")) {
		
		case "Firefox": System.setProperty("webdriver.gecko.driver","geckodriver.exe");
						driver = new FirefoxDriver();
						break;
		case "Chrome": System.setProperty("webdriver.chrome.driver","chromedriver.exe");
						driver = new ChromeDriver();
						break;
						
		default: 		break;
		}//switch ends here
		
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TimeUtils.timepage));
	driver.get(propertiesObject.getProperty("url"));
		
	}
	
	public static void captureScreeenShot(String Filename) {
		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(file, new File("C:\\Users\\abhig\\eclipse-workspace\\orangeart\\src\\test\\java\\screenshots\\ScreenshotsFolder"+Filename+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		
	}
	
	
}//BaseClass ends here
