package SeleniumExerciseITBootCamp;

////Play a song on Youtube

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.Keys.ENTER;

public class PlayYoutubeSong {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.youtube.com/");

        Thread.sleep(3000);

        WebElement youTubeSearchButton= driver.findElement(By.name("search_query"));
        youTubeSearchButton.sendKeys("Dreams Fleetwood Mac");
        youTubeSearchButton.sendKeys(ENTER);

        Thread.sleep(2000);

        WebElement youTubeSong = driver.findElement(By.cssSelector(".style-scope.ytd-video-renderer"));
        youTubeSong.click();

        Thread.sleep(3000);

    }
}
