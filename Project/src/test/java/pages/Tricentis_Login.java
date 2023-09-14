package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Tricentis_Login {

	WebDriver driver;
	public Tricentis_Login(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	@FindBy(xpath="//*[@id='Email']")
	WebElement email;
	
	public void username(String uid)
	{
		email.sendKeys(uid);
	}
	
	@FindBy(id="Password")
	WebElement pass;
	
	public void password(String pwd)
	{
		pass.sendKeys(pwd);
	}
	
	@FindBy(xpath="/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")
	WebElement login;
	
	public void Login()
	{
		login.click();
	}
}
