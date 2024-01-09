package Task_04.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//*[@id='user_email']")
    WebElement userEmailField;
    @FindBy(xpath = "//*[@id='user_password']")
    WebElement passwordField;
    @FindBy(xpath = "//*[@id='new_user']")
    WebElement buttonInput;
    @FindBy(xpath = "//li[@class='parsley-type']")
    WebElement textError;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void typeUserEmail(String userEmail) {
        wait.until(ExpectedConditions.visibilityOf(userEmailField)).sendKeys(userEmail);
    }

    public void typePassword(String userPassword) {
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(userPassword);
    }

    public void clickButtonInput() {
        wait.until(ExpectedConditions.visibilityOf(buttonInput)).click();
    }

    public void authorization(String userEmail, String userPassword) {
        typeUserEmail(userEmail);
        typePassword(userPassword);
        clickButtonInput();
    }

    public boolean getTextError() {
        return wait.until(ExpectedConditions.invisibilityOf(textError));
    }

    public void inputNotPassword(String email) {
        typeUserEmail(email);
        clickButtonInput();
    }

    public String checkFieldPassword() {
        return wait.until(ExpectedConditions.visibilityOf(passwordField)).getText();

    }



}
