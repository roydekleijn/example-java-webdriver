package nl.workshop.structured;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import nl.workshop.AbstractTestBase;
import pages.HomePage;
import pages.SearchResultsPage;

@Test
public class DataDrivenSearchTest extends AbstractTestBase {

	@DataProvider
	public Object[][] data() {
		return new Object[][]{ //
			{ "Dress" }, //
			{ "Sleeves" }, //
			{ "Blouse" }, //
			{ "T-shirt" } //
		};
	}

	@Test(dataProvider = "data")
	public void searchSuccess(String query) {
		final SearchResultsPage searchResultsPage = new HomePage(driver).get() //
				.search(query);
		MatcherAssert.assertThat(searchResultsPage.getNumberOfProducts(), Matchers.greaterThan(0));
	}
}