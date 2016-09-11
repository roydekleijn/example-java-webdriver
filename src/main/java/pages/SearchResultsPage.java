package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class SearchResultsPage extends LoadableComponent<SearchResultsPage> {

	@FindBy(css = "p.alert-warning")
	private WebElement message;

	@FindBy(css = "ul.product_list .product-name")
	private List<WebElement> productNames;

	public SearchResultsPage(final WebDriver driver) {
		// This call initialize the WebElement fields.
		PageFactory.initElements(driver, this);
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub

	}

	public String getMessage() {
		return message.getText();
	}

	public int getNumberOfProducts() {
		return productNames.size();
	}

}
