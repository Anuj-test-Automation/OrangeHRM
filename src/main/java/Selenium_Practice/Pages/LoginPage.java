package Selenium_Practice.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage
{
    private WebDriver driver;

    //By Locators
    private By usernameInputField = By.xpath("//input[@name='username']");
    private By passwordInputField = By.xpath("//input[@name='password']");
    private By loginButton = By.xpath("//button[@type='submit'][text()=' Login ']");
    private By userProfile = By.xpath("//p[contains(@class, 'oxd-userdropdown-name')]");
    private By logoutLink = By.xpath("//font[contains(text(), 'Log out')]");
    private By forgotPasswordLink = By.xpath("//p[contains(@class, 'login-forgot')]");
    //private By checkForgotPasswordPage = By.xpath("//h6[contains(@class, 'forgot-password-title')]");
    public By checkDashboard = By.xpath("//span[contains(@class,'header-breadcrumb')]");



    //constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername (String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInputField));
        WebElement usernameInput = driver.findElement(usernameInputField);
        usernameInput.sendKeys(username);
    }
    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(passwordInputField);
        passwordInput.sendKeys(password);
    }
    public void clickLoginButton() throws Exception {
        WebElement loginbtn = driver.findElement(loginButton);
        loginbtn.click();
        Thread.sleep(3000);
    }

    public void clickForgotPassword() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(forgotPasswordLink));
        WebElement forgotPwdLink = driver.findElement(forgotPasswordLink);
        forgotPwdLink.click();
    }


    public void clickUserProfile()
    {
        WebElement userProfileHP = driver.findElement(userProfile);
        userProfileHP.click();
    }

    public void clickLogoutLink() {
        WebElement logoutLinkHP = driver.findElement(logoutLink);
        logoutLinkHP.click();
    }

    public void login(String username, String password) throws Exception {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public String getResetPasswordPageURL()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String resetPasswordPageURL = driver.getCurrentUrl();
        return resetPasswordPageURL;
    }
    public boolean checkHomepage () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
        WebElement dashboardHomePage = wait.until(ExpectedConditions.visibilityOfElementLocated(checkDashboard));
        return dashboardHomePage.isDisplayed();
    }

}
