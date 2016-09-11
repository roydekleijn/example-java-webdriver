package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

public class AuthenticationPage extends LoadableComponent<AuthenticationPage> {
	private final WebDriver driver;

	@FindBy(css = "input#email")
	private WebElement emailTextfield;

	@FindBy(css = "input#passwd")
	private WebElement passwordTextfield;

	@FindBy(css = "input#email_create")
	private WebElement emailCreatTextfield;

	@FindBy(css = "button#SubmitLogin")
	private WebElement loginButton;

	@FindBy(css = "button#SubmitCreate")
	private WebElement createNewButton;

	@FindBy(css = ".alert-danger")
	private WebElement alert;

	public AuthenticationPage(final WebDriver driver) {
		this.driver = driver;

		// This call sets the WebElement fields.
		PageFactory.initElements(driver, this);
	}

	@Override
	protected void load() {
		// Open the page
		driver.get("http://rdekleijn.nl/demo/login");
	}

	@Override
	protected void isLoaded() throws Error {
		// verify if the correct page is open
		Assert.assertTrue(driver.getTitle().startsWith("Login"));
	}

	public MyAccountPage loginWith(final String email, final String password) {
		emailTextfield.sendKeys(email);
		passwordTextfield.sendKeys(password);
		loginButton.click();
		return new MyAccountPage(driver);
	}

	public boolean isAlertPresent() {
		return alert.isDisplayed();
	}

	public AccountCreationPage createNewAccount(final String email) {
		emailCreatTextfield.sendKeys(email);
		createNewButton.click();
		return new AccountCreationPage(driver);
	}

}
