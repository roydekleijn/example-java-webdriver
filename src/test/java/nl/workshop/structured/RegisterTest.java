package nl.workshop.structured;

import java.util.Random;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import nl.workshop.AbstractTestBase;
import pages.HomePage;
import pages.MyAccountPage;
import types.Title;

@Test(groups = { "register" })
public class RegisterTest extends AbstractTestBase {

	public void registerNewAccount() {
		final String rand = Integer.toString(new Random().nextInt());

		final MyAccountPage accountPage = new HomePage(driver).get() //
				.clickOnLogin() //
				.createNewAccount(rand + "tetser@test.com") //
				.setTitle(Title.MR) //
				.setFirstname("T") //
				.setLastname("Tester") //
				.setPassword("1qazxsw2") //
				.setDob("12", "1", "1986")//
				.clickOnRegister();
		MatcherAssert.assertThat(accountPage.getWelcomeMessage(), Matchers.equalTo("Your account has been created."));
	}

}
