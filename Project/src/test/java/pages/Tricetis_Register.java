package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Tricetis_Register {

	WebDriver driver;
	public Tricetis_Register(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	@FindBy(id="gender-male")
	WebElement gender_male;
	public void gen_male()
	{
		gender_male.click();
	}
	
	@FindBy(id="gender-female")
	WebElement gender_female;
	public void gen_female()
	{
		gender_female.click();
	}

	@FindBy(id="FirstName")
	WebElement f_name;
	public void FirstName(String fname)
	{
		if(f_name.isDisplayed())
		{
			f_name.sendKeys(fname);
		}
		else
		{
			System.out.println("First name field is not displayed");
		}
	}
	
	@FindBy(id="LastName")
	WebElement l_name;
	public void LastName(String lname)
	{
		if(l_name.isDisplayed())
		{
			l_name.sendKeys(lname);
		}
		else
		{
			System.out.println("Last name field is not displayed");
		}
	}
	
	@FindBy(id="Email")
	WebElement mail;
	public void Email(String e_mail)
	{
		if(mail.isDisplayed())
		{
			mail.sendKeys(e_mail);
		}
		else
		{
			System.out.println("Email field is not displayed");
		}
	}
	
	@FindBy(id="Password")
	WebElement pass;
	public void Password(String pwd)
	{
		if(pass.isDisplayed())
		{
			pass.sendKeys(pwd);
		}
		else
		{
			System.out.println("Password field is not displayed");
		}
	}
	
	@FindBy(id="ConfirmPassword")
	WebElement cpass;
	public void ConfirmPassword(String c_pwd)
	{
		if(cpass.isDisplayed())
		{
			cpass.sendKeys(c_pwd);
		}
		else
		{
			System.out.println("ConfirmPassword field is not displayed");
		}
	}
	
	@FindBy(id="register-button")
	WebElement Register;
	public void Register_Btn()
	{
		if(Register.isDisplayed())
		{
			Register.click();
		}
		else
		{
			System.out.println("Register Button field is not displayed");
		}
	}
	
}
