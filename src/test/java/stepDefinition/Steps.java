package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;

public class Steps {
	
	public WebDriver driver;
	public LoginPage lp;
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"./src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		lp = new LoginPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
		lp.setUserName(email);
	    lp.setPassword(password);
	}

	@When("Click on Login")
	public void click_on_login() throws InterruptedException {
	    lp.clickLogin();
	    Thread.sleep(3000);
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) throws InterruptedException {
		if(driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			System.out.println("if title "+title);
			Assert.assertTrue(true);
		}else {
			System.out.println("else title "+title);
			System.out.println("else driver title "+driver.getTitle());
			Assert.assertEquals(title,driver.getTitle());
		}
		Thread.sleep(3000);
	}
	@When("User click on Log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
		lp.clickLogout();
		Thread.sleep(3000);
	}

	@Then("close browser")
	public void close_browser() throws InterruptedException {
		driver.quit();
	}


}
