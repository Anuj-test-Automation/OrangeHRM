package Selenium_Practice;

import Selenium_Practice.Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageStepDefinition
{
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown()
    {
        if(driver!=null) {
            driver.quit();
        }
    }
    @Given("I am on the OrangeHRM demo Login page")
    public void i_am_on_the_orange_hrm_demo_login_page() throws Exception {
        loginPage = new LoginPage(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(10000);


        if(driver.getTitle().equals("OrangeHRM"))
        {
            System.out.println("The user is on login page");
        }
    }
    @Given("I have entered valid username and password")
    public void i_have_entered_valid_username_and_password() {
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");


    }
    @When("I click on the login button")
    public void i_click_on_the_login_button() throws Exception {
        loginPage.clickLoginButton();
    }
    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        Assert.assertEquals(loginPage.checkHomepage(),true);

    }

    @Given("I have entered invalid {string} and {string}")
    public void i_have_entered_invalid_and(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);

    }

    @Then("I should see an error message indicating {string}")
    public void i_should_see_an_error_message_indicating(String error_message) {
        Assert.assertEquals(driver.findElement(By.xpath("//p[text()='Invalid credentials']")).isDisplayed(), true);
    }

    @When("I click on the forgot password link")
    public void i_click_on_the_forgot_password_link() {
        loginPage.clickForgotPassword();
    }

    @Then("I should redirected to the password reset page")
    public void RedirectedToThePasswordResetPage() {
        loginPage.getResetPasswordPageURL();
    }
}
