package testcases;


import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.ConfirmPage;
import pageobjects.HomePage;
import pageobjects.SignupPage;
import testdata.ExcelReader;

public class SignupTestCases extends TestCasesBase {

	SignupPage signupPageObjects;
	ConfirmPage confirmPageObject;
	HomePage homePageObject;
	
	@DataProvider(name="ExcelData")
	public Object[][] userRegisterData() throws IOException
	{
	// get data from Excel Reader class 
		ExcelReader ER = new ExcelReader();
		return ER.getExcelData();
	}
	//Data driven from Excel sheet 	
	@Test(priority=1,alwaysRun=true,dataProvider="ExcelData")
	public void UserCanRegisterSuccssfully(String firstname , String lastname , String email , 
			String password, String day, String month, String year, String gender) throws Exception 
	{
		signupPageObjects = new SignupPage(driver);
		signupPageObjects.userSignup(firstname, lastname, email, password);
		signupPageObjects.selectBirtdateFromDropdownlist(day,month,year);
		signupPageObjects.selectGenderForSignup(gender);
		signupPageObjects.clickOnSignupButton(); 
		confirmPageObject = new ConfirmPage(driver);
		// assertion that user navigate to confirm screen after click on signup button 
		Assert.assertTrue(confirmPageObject.confirmEmailTitle.getText().contains("Confirm your email address"));
		System.out.println(confirmPageObject.confirmEmailTitle.getText());
		confirmPageObject.clickOnLogoutMenu();
		confirmPageObject.clickOnLogoutButton();
	}

}
