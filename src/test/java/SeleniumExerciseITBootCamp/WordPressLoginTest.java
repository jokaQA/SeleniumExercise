package SeleniumExerciseForBegginers;
//test log in https://wordpress.com/

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class WordPressLoginTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://wordpress.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement logInButton = driver.findElement(By.linkText("Log In"));
        logInButton.click();

        String validUsername = "jokac1";
        String validPassword = "flasicavode1";
        WebElement usernameField = driver.findElement(By.id("usernameOrEmail"));
        usernameField.clear();
        usernameField.sendKeys(validUsername);

        WebElement continueButton = driver.findElement(By.cssSelector(".button.form-button.is-primary"));
        continueButton.click();


        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys(validPassword);

        continueButton.click();

        wait.until(ExpectedConditions.urlToBe("https://wordpress.com/home/jokac.wordpress.com"));


        WebElement profileButton = driver.findElement(By.cssSelector(".masterbar__item.masterbar__item-me"));
        profileButton.click();


        WebElement profileName = driver.findElement(By.className("profile-gravatar__user-display-name"));
        String profileNameText = profileName.getText();

        Assert.assertEquals(profileNameText, validUsername);

        WebElement logoutButton = driver.findElement(By.className("sidebar__me-signout-text"));
        Assert.assertTrue(logoutButton.isDisplayed());

    }
}