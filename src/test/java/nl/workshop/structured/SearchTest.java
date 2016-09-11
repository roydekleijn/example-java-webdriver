package nl.workshop.structured;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import nl.workshop.AbstractTestBase;
import pages.HomePage;
import pages.SearchResultsPage;

@Test
public class SearchTest extends AbstractTestBase {

	public void searchSuccess() {
		final SearchResultsPage searchResultsPage = new HomePage(driver).get() //
				.search("Dress");
		MatcherAssert.assertThat(searchResultsPage.getNumberOfProducts(), Matchers.greaterThan(0));
	}
}
