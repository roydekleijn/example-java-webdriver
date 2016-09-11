package nl.workshop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractTestBase {
	protected WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		// Create a new instance of the Firefox driver
		System.setProperty("webdriver.gecko.driver", findFileOnPath("geckodriver"));
		final DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		driver = new FirefoxDriver(capabilities);

		// Open the website
		driver.get("http://www.rdekleijn.nl/demo/index.php");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		// Close the browser
		driver.quit();
	}

	private static String findFileOnPath(final String fileName) {
		return AbstractTestBase.class.getClassLoader().getResource(fileName).getPath();
	}
}
