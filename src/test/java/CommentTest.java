import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.WriteCommentPageObject;


import static junit.framework.TestCase.assertEquals;

public class CommentTest {

	private String comment = "Test naszego komentarza";

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
		writeCommentPageObject.inputComment(comment);

		writeCommentPageObject.inputEmail("lesieckip@test.test");

		writeCommentPageObject.inputSignature("Papryqarze to my");

		writeCommentPageObject.clickSubmitButton();

		assertEquals("Last comment is wrong!", comment, writeCommentPageObject.getLastComment());
	}
}
