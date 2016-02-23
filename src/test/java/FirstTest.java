import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.WriteCommentPageObject;
import utils.GetProperties;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class FirstTest {


	final private String BASE_URL = "https://podstawyselenium.wordpress.com/";
	final private String PAGE_TITLE = "Maven, Selenium, Java | Power of test automation";


	private String user = GetProperties.getProperty("user");
	private String pwd = GetProperties.getProperty("pass");


	static WebDriver driver;

	private static WriteCommentPageObject writeCommentPageObject;

	@Before
		public static void initialize(){
		driver = Driver.get();
		WriteCommentPageObject writeCommentPageObject = new WriteCommentPageObject(driver);
		writeCommentPageObject.get();
	}

	@Test
	public void leaveACommentTest(){
		String comment = "Drugi test naszego komentarza";

		writeCommentPageObject.inputComment(comment);

		writeCommentPageObject.inputEmail("lesieckip@test.test");

		writeCommentPageObject.inputSignature("Papryqarze to my");

		writeCommentPageObject.clickSubmitButton();

		assertEquals("Last comment is wrong!", comment, writeCommentPageObject.getLastComment());
	}
}
