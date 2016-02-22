import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static junit.framework.TestCase.assertEquals;

public class FirstTest {

	WebDriver driver = new FirefoxDriver();

	@Test
	public void firstTest(){
		driver.get("http://papryqarz.org");

		assertEquals("Nieprawidłowy tytuł strony PapryQarz", "papryQArz - We test with taste", driver.getTitle());
	}

}
