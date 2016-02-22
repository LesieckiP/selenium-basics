import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.GetProperties;

import static junit.framework.TestCase.assertEquals;

public class FirstTest {


	final private String BASE_URL = "http://papryqarz.org";
	final private String PAGE_TITLE = "papryQArz - We test with taste";


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
		System.out.println(user);
	}

	@AfterClass
	public static void quitDriver(){
		driver.quit();
	}




}
