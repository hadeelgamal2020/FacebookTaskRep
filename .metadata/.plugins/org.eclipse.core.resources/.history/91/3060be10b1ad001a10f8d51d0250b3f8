package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignupPage extends PageObjectsBase{

	public SignupPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="u_0_j")
	WebElement firstNameTxt ; 

	@FindBy(id="u_0_l")
	WebElement surNameTxt; 

	@FindBy(id="u_0_o")
	WebElement emailOrMobileTxt ; 

	@FindBy(id="u_0_r")
	WebElement reEmailOrMobileTxt ;

	@FindBy(id="u_0_v")
	WebElement newPasswordTxt ; 

	@FindBy(id="day")
	WebElement birtdateDayDropDown ;  

	@FindBy(id="month")
	WebElement birtdateMonthDropDown ; 

	@FindBy(id="year")
	WebElement birtdateYearDropDown; 

	@FindBy(xpath="//input[@type='radio'][@name='sex'][@value='1']")
	WebElement femaleRadioButton;

	@FindBy(xpath="//input[@type='radio'][@name='sex'][@value='2']")
	WebElement maleRadioButton;

	@FindBy(id="u_0_11")
	WebElement signupButton; 
	
	@FindBy(partialLinkText="Log In")
	public WebElement loginTxt; 

	public void userSignup(String firstName , String surName , String emailOrMobile , String newpassword) 
	{
		setTextForElement(firstNameTxt, firstName);
		setTextForElement(surNameTxt, surName);
		setTextForElement(emailOrMobileTxt, emailOrMobile);
		setTextForElement(reEmailOrMobileTxt, emailOrMobile);
		setTextForElement(newPasswordTxt, newpassword);
	}


	public void selectBirtdateFromDropdownlist(String day, String month, String year)
	{
		select = new Select(birtdateDayDropDown);
		select.selectByVisibleText(day);
		select = new Select(birtdateMonthDropDown);
		select.selectByVisibleText(month);
		select = new Select(birtdateYearDropDown);
		select.selectByVisibleText(year);
	}

	public void selectGenderForSignup(String gender)
	{
		String genderTobSelected = gender;
		if ( genderTobSelected.equalsIgnoreCase("Male")  ) 
		{
			clickOnButton(maleRadioButton);  
		}
		else if ( genderTobSelected.equalsIgnoreCase("Female")  ) 
		{
			clickOnButton(femaleRadioButton);  
		}
	}


	public void clickOnSignupButton()
	{
		clickOnButton(signupButton);

	}

}
