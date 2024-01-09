package Task_04;

import Task_04.pages.LoginPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class UITest {
    private static final String userEmail = "login";
    private static final String userPassword = "password";
    private static final String email = "login@login.ru";
    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeAll
    static void initialization() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }

    @BeforeEach
    void open() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
//        options.addArguments("--headless");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://gb.ru/login");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    void testGBNotEmailLogin() {

        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.authorization(userEmail, userPassword);

        Assertions.assertTrue(loginPage.getTextError());


        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("src/main/resources/screen.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Test
    void testGBWithoutPassword() {

        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.inputNotPassword(email);
        Assertions.assertEquals("", loginPage.checkFieldPassword());


    }

    @AfterAll
    static void close() {
        driver.quit();

    }

}
