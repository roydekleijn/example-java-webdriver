package nl.workshop.structured;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import nl.workshop.AbstractTestBase;
import pages.AuthenticationPage;
import pages.HomePage;
import pages.MyAccountPage;

@Test(groups = { "all" })
public class LoginTest extends AbstractTestBase {

	public void loginSuccess() {
		final MyAccountPage accountPage = new HomePage(driver).get() //
				.clickOnLogin() //
				.loginWith("tester@test.com", "1qazxsw2");
		MatcherAssert.assertThat(accountPage.getWelcomeMessage(),
				Matchers.equalTo("Welcome to your account. Here you can manage all of your personal information and orders."));
	}

	public void loginAccountDoesNotExist() {
		final AuthenticationPage authenticationPage = new HomePage(this.driver).get() //
				.clickOnLogin();
		authenticationPage.loginWith("1234@test.com", "1qazxsw2");
		MatcherAssert.assertThat(authenticationPage.isAlertPresent(), Matchers.equalTo(true));
	}

}
