import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import utils.GetProperties;

import javax.swing.text.html.CSS;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class FirstTest {


	final private String BASE_URL = "https://podstawyselenium.wordpress.com/";
	final private String PAGE_TITLE = "Maven, Selenium, Java | Power of test automation";


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

	@Test
	public void leaveACommentTest(){
		String comment = "Drugi test naszego komentarza";
		driver.navigate().to(BASE_URL + "/informacje");

		driver.findElement(By.cssSelector("#comment")).sendKeys(comment);

		driver.findElement(By.cssSelector("#email")).sendKeys("piotr.lesiecki@test.test");

		driver.findElement(By.cssSelector("#author")).sendKeys("Piotr Lesiecki");

		driver.findElement(By.name("submit")).click();

		List<WebElement> commentsList = driver.findElements(By.cssSelector(".comment-list .comment-body .comment-content"));

		assertEquals("Incorrect comment", comment, commentsList.get(commentsList.size() - 1).getText());

	}

	@AfterClass
	public static void quitDriver(){
		driver.quit();
	}




}
