package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.GetProperties;

import java.util.List;

public class WriteCommentPageObject {

	private WebDriver driver;
	private String BASE_URL = GetProperties.getProperty("BASE_URL");
	private String URL_SUFFIX = "/informacje";
	private String PAGE_TITLE = "Maven, Selenium, Java | Power of test automation";


	@FindBy(how = How.CSS, using = "#comment")
	WebElement commentInputField;

	@FindBy(how = How.CSS, using = "#email")
	WebElement emailInputField;

	@FindBy(how = How.CSS, using = "#author")
	WebElement signatureInputField;

	@FindBy(how = How.NAME, using = "submit")
	WebElement submitButton;

	@FindBy(how = How.CSS, using = ".comment-list .comment-body .comment-content")
	List<WebElement> commentsList;

	public WriteCommentPageObject(WebDriver aDriver) {
		driver = aDriver;
	}

	public void get() {
		driver.get(BASE_URL + URL_SUFFIX);
	}

	public void inputComment(String comment){
		commentInputField.sendKeys(comment);
	}

	public void inputEmail(String email){
		commentInputField.sendKeys(email);
	}

	public void inputSignature(String signature){
		commentInputField.sendKeys(signature);
	}

	public void clickSubmitButton(){
		submitButton.click();
	}

	public String getLastComment(){
		return commentsList.get(commentsList.size() - 1).getText();
	}
}
