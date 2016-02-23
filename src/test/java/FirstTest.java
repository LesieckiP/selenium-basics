import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.GetProperties;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class FirstTest {


	final private String BASE_URL = "https://podstawyselenium.wordpress.com/";
	final private String PAGE_TITLE = "Maven, Selenium, Java";


	private String user = GetProperties.getProperty("user");
	private String pwd = GetProperties.getProperty("pass");


	static WebDriver driver;

	@BeforeClass
		public static void initialize(){

		driver = new FirefoxDriver();
		driver.manage().window().maximize();

	}

	@Test
	public void getPageAndCheckTitle(){
		driver.get(BASE_URL);

		assertEquals("Invalid page title", PAGE_TITLE, driver.getTitle());

	}

	@Test
	public void loginAsAdminTest(){
		driver.navigate().to(BASE_URL + "/wp-admin");

		WebElement loginInputField = driver.findElement(By.cssSelector("#user_login"));
		loginInputField.sendKeys(user);

		WebElement passwordInputField = driver.findElement(By.cssSelector("#user_pass"));
		passwordInputField.sendKeys(pwd);

		driver.findElement(By.cssSelector("#wp-submit")).click();
		assertTrue("Panel administracyjny nie został wyświetlony", driver.findElement(By.cssSelector("#wpbody-content")).isDisplayed());
	}

	@AfterClass
	public static void quitDriver(){
		driver.quit();
	}




}
