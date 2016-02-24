package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.GetProperties;

import java.util.List;

public class WriteCommentPageObject {

	public WriteCommentPageObject(WebDriver aDriver) {
		driver = aDriver;
	}

	private WebDriver driver;

	private String BASE_URL = GetProperties.getProperty("BASE_URL");
	private String URL_SUFFIX = "/informacje";

	By commentInput = By.cssSelector("#comment");

	By emailInput = By.cssSelector("#email");

	By signatureInput = By.cssSelector("#author");

	By submitButton = By.cssSelector("#comment-submit");

	By commentsList = By.cssSelector("#comments .comment-content p");

	public void get() {
		driver.get(BASE_URL + URL_SUFFIX);
	}

	public void inputComment(String comment){
		driver.findElement(commentInput).sendKeys(comment);
	}

	public void inputEmail(String email){
		driver.findElement(emailInput).sendKeys(email);
	}

	public void inputSignature(String signature){
		driver.findElement(signatureInput).sendKeys(signature);
	}

	public void clickSubmitButton(){
		driver.findElement(submitButton).click();
	}

	public String getLastComment(){
		List<WebElement> comments = driver.findElements(commentsList);
		return comments.get(comments.size() - 1).getText();
	}

	public void waitForRequestsFinish() {

	}
}
