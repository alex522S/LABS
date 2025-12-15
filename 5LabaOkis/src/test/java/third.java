import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class third {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:/Users/user/Desktop/chromedriver-win64/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //

        driver.get("https://www.avito.ru");
        Thread.sleep(1000); //

        System.out.println("1. Заголовок: " + driver.getTitle());

        // 2. Простой элемент - поле ввода в футере (есть всегда)
        WebElement footerInput = driver.findElement(By.cssSelector("input, textarea, [contenteditable='true']"));
        footerInput.click();
        System.out.println("2. Клик 1 (CSS) выполнен");
        Thread.sleep(2000);

        // 3. XPath - клик по body (гарантированно есть)
        driver.findElement(By.xpath("//body")).click();
        System.out.println("3. Клик 2 (XPath) выполнен");
        Thread.sleep(2000);

        // 4.закрываем браузер
        driver.quit();
        System.out.println("4. Готово!");
    }
}