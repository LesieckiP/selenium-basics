import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.WriteCommentPageObject;


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

		writeCommentPageObject.inputSignature("Super profi stronka ziomuś");

		writeCommentPageObject.clickSubmitButton();

		writeCommentPageObject.waitForRequestsFinish();

		assertEquals("Last comment is wrong!", comment, writeCommentPageObject.getLastComment());
	}
}
