package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.BaseClass;

public class PomLogin extends BaseClass {
	
//the object repository
	
@FindBy(xpath="/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")
WebElement Username;

@FindBy(xpath="/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")
WebElement Password;

@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
WebElement LoginBtn;


// creating constructor to initiate the above elements
public PomLogin() {
	
	//initializing all the @FindBy annotated elements
	PageFactory.initElements(driver, this); //visibility of driver was changed to protected from suggestions
	
	}

	//creating method to enter text in username
	public void enterUsername(String usernameText) {
		
		//driver.findElement(By.name("username")).sendKeys(usernameText);
		Username.sendKeys(usernameText);
	}
	

	//creating method to enter text in Password
	public void enterPassword(String passwordText) {
			
		//driver.findElement(By.name("password")).sendKeys(passwordText);
		Password.sendKeys(passwordText);
		
	}
	
	//creating method to click login button
	public void clickLoginBtn() {
				
		//driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		LoginBtn.click();
			
	}
	
	//creating method to get the title of the page
	public String verifyPage() {
		
		return driver.getTitle();
	}
	
	
	
	
	
	
}//BaseClass ends here
