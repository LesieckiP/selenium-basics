import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.WriteCommentPageObject;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertEquals;

public class CommentTest {

	private String comment = "Test naszego komentarza";

	private WebDriver driver;

	private WriteCommentPageObject writeCommentPageObject;

	@Before
		public void initialize(){
		driver = Driver.get();
		writeCommentPageObject = new WriteCommentPageObject(driver);
		writeCommentPageObject.get();
	}

	@Test
	public void leaveACommentTest(){
		writeCommentPageObject.inputComment(comment);

		writeCommentPageObject.inputEmail("piotrlesiecki@email.pl");

		writeCommentPageObject.inputSignature("To my papryQArze! ;)");

		writeCommentPageObject.clickSubmitButton();

		writeCommentPageObject.waitForRequestsFinish();

		assertEquals("Last comment is wrong!", comment, writeCommentPageObject.getLastComment());
	}
}
