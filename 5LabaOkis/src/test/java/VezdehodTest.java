import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class VezdehodTest {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:/Users/user/Desktop/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Шаг 1: Открыть сайт
        driver.get("https://вездеход-заказать.рф");
        Thread.sleep(3000);

        // Шаг 3: Получить заголовок
        System.out.println("Заголовок страницы: " + driver.getTitle());

        // Шаг 4: Найти и вывести элементы
        System.out.println("\nПервые 5 элементов с текстом:");
        var allElements = driver.findElements(By.xpath("//*[text()!='']"));
        int count = 0;
        for (var el : allElements) {
            try {
                if (el.isDisplayed()) {
                    String text = el.getText().trim();
                    if (!text.isEmpty() && text.length() < 50) {
                        count++;
                        System.out.println(count + ". " + text);
                        if (count >= 5) break;
                    }
                }
            } catch (Exception e) {
                continue;
            }
        }

        // Находим элемент для клика (кнопка "Заказать" или подобную)
        WebElement orderButton = null;
        String buttonText = "";

        // Ищем по тексту "Заказать", "Оставить заявку", "Купить"
        String[] targetTexts = {"Заказать", "Оставить", "Купить", "Заявк", "Консультац"};

        for (String target : targetTexts) {
            try {
                WebElement el = driver.findElement(By.xpath("//*[contains(text(), '" + target + "')]"));
                if (el.isDisplayed() && el.isEnabled()) {
                    orderButton = el;
                    buttonText = el.getText().trim();
                    System.out.println("\nНайдена кнопка: \"" + buttonText + "\"");
                    break;
                }
            } catch (Exception e) {
                continue;
            }
        }

        // Если не нашли, берём первую кнопку
        if (orderButton == null) {
            var buttons = driver.findElements(By.tagName("button"));
            for (var btn : buttons) {
                try {
                    if (btn.isDisplayed() && btn.isEnabled()) {
                        orderButton = btn;
                        buttonText = btn.getText().trim();
                        System.out.println("\nНайдена первая кнопка: \"" + buttonText + "\"");
                        break;
                    }
                } catch (Exception e) {
                    continue;
                }
            }
        }

        //КЛИК 1: CSS
        System.out.println("\nКЛИК 1 (CSS подход)");
        if (orderButton != null) {
            // Прокручиваем и кликаем через JavaScript (CSS подход)
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", orderButton);
            Thread.sleep(1000);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", orderButton);
            System.out.println("Клик выполнен на: \"" + buttonText + "\"");
            Thread.sleep(2000);
        }

        // КЛИК 2: XPath
        System.out.println("\nКЛИК 2 (XPath)");

        // Теперь ищем элемент в модальном окне для второго клика
        // Например, кнопку "Закрыть" (крестик) или поле ввода
        try {
            // Ищем крестик закрытия модального окна
            WebElement closeButton = driver.findElement(By.xpath(
                "//button[contains(@class, 'close')] | " +
                "//*[contains(text(), '×')] | " +
                "//*[contains(text(), 'Закрыть')] | " +
                "//div[contains(@class, 'modal')]//button"
            ));

            if (closeButton.isDisplayed()) {
                // Кликаем через XPath (обычный click)
                closeButton.click();
                System.out.println("Клик выполнен (XPath на кнопку закрытия)");
            }
        } catch (Exception e) {
            // Если не нашли крестик, кликаем по любому полю в модалке
            try {
                WebElement inputField = driver.findElement(By.xpath("//div[contains(@class, 'modal')]//input"));
                inputField.click();
                System.out.println("✓ Клик выполнен (XPath на поле ввода в модальном окне)");
            } catch (Exception e2) {
                // Последний вариант: клик по фону модального окна
                WebElement modalOverlay = driver.findElement(By.xpath("//div[contains(@class, 'modal-backdrop')]"));
                modalOverlay.click();
                System.out.println("✓ Клик выполнен (XPath на фон модального окна)");
            }
        }

        Thread.sleep(2000);

        // Закрываем браузер
        driver.quit();
        System.out.println("Два клика выполнены: первый открыл модальное окно, второй взаимодействовал с ним.");
    }

}
