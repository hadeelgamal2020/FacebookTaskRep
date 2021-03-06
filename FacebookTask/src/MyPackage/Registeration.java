package MyPackage;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Registeration {

	public WebDriver driver;

	@BeforeMethod
	public void setUp() throws Exception {
		// System Property for Chrome Driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hg250102\\Desktop\\ChromeDriver\\chromedriver.exe");

		// Instantiate a ChromeDriver class.
		driver = new ChromeDriver();

		// Launch Website
		driver.navigate().to("https://www.facebook.com/");

		// Maximize the browser
		driver.manage().window().maximize();
	}

	@Test(dataProvider = "testdata")
	public void userSignup(String firstname, String surname, String mobileno, String password, String selectday,
			String selectmonth, String selectyear, String gender) {
		try {
			// Initialize gender id string
			String genderid = "";

			// Compare excel file data and select the corresponding id
			if (gender.equalsIgnoreCase("female")) {
				genderid = ("u_0_6");
			} else if (gender.equalsIgnoreCase("male")) {
				genderid = ("u_0_7");
			} else
				genderid = ("u_0_8");

			// Select the unique element
			driver.findElement(By.id("u_0_m")).sendKeys(firstname);
			driver.findElement(By.id("u_0_o")).sendKeys(surname);
			driver.findElement(By.id("u_0_r")).sendKeys(mobileno);
			driver.findElement(By.id("u_0_w")).sendKeys(password);

			Select Daydropdown = new Select(driver.findElement(By.id("day")));
			Daydropdown.selectByValue(selectday);

			Select Monthdropdown = new Select(driver.findElement(By.id("month")));
			Monthdropdown.selectByValue(selectmonth);

			Select Yeardropdown = new Select(driver.findElement(By.id("year")));
			Yeardropdown.selectByValue(selectyear);

			driver.findElement(By.id(genderid)).click();

			driver.findElement(By.id("u_0_13")).click();

			driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);

			if (driver.findElements(By.id("code_in_cliff")).size() != 0)

			{
				System.out.println("Login Scenario Test : Passed");
			} else {

				System.out.println("Login Scenario Test : Failed");
			}
		}

		catch (Exception e) {
			e.printStackTrace();

		}

	}

	@AfterMethod
	void ProgramTermination() {
		driver.quit();
	}

	@DataProvider(name = "testdata")
	public Object[][] signupTestData() {
		ReadExcelFile configuration = new ReadExcelFile(
				System.getProperty("user.dir") + "/testdata/Registeration_Testdata.xlsx");
		int rows = configuration.getRowCount(0);
		Object[][] signupdata = new Object[rows][8];

		for (int i = 0; i < rows; i++) {
			signupdata[i][0] = configuration.getData(0, i, 0);
			signupdata[i][1] = configuration.getData(0, i, 1);
			signupdata[i][2] = configuration.getData(0, i, 2);
			signupdata[i][3] = configuration.getData(0, i, 3);
			signupdata[i][4] = configuration.getData(0, i, 4);
			signupdata[i][5] = configuration.getData(0, i, 5);
			signupdata[i][6] = configuration.getData(0, i, 6);
			signupdata[i][7] = configuration.getData(0, i, 7);
		}
		return signupdata;
	}

}
