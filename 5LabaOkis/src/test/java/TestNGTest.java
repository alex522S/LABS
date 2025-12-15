//для задания 3
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration; //таймер
//для задания 4:
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;

public class TestNGTest {
    public static void main(String[] args) throws InterruptedException {
        //Задание 3: указываем путь к драйверу
        System.setProperty("webdriver.chrome.driver", "C:/Users/user/Desktop/chromedriver-win64/chromedriver.exe");


        WebDriver driver = new ChromeDriver();
        //Задание 3: создаем неявное ожидание 10 секунд
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Задание 3: открываем тестнг в гугле
        driver.get("https://testng.org/");

        //Задание 3: пауза Thread.sleep для того чтобы увидеть что сайт открылся верно

        Thread.sleep(3000); // 1 секунды


        //Задание 3: Шаг 3 получаем и выводим заголовок
        String pageTitle = driver.getTitle();
        System.out.println("Заголовок страницы: " + pageTitle);

        //Задание 4:
        System.out.println("\nЭлементы оглавления");
        // Находим все ссылки в левом меню. Используем CSS-селектор.
        // Этот селектор ищет все ссылки <a> внутри элемента с id 'toc'  с помощью cssSelector'а
        List<WebElement> tocItems = driver.findElements(By.cssSelector("#toc a")); // WebElement — это "веб-элемент" на странице (кнопка, ссылка, поле ввода).
        /*
        "#toc a" — сам CSS-селектор. Это строка-инструкция:
        #toc — символ # означает "элемент с id="toc"". На сайте testng.org левое меню (Table of Contents) имеет именно такой id: <div id="toc">...</div>.
        Пробел после #toc — означает "внутри". Это ключевой момент.
        a — означает элемент-ссылку (<a> тег).
        Вся фраза #toc a читается так: "Найди все теги <a> (ссылки), которые находятся внутри (на любом уровне вложенности) элемента с id="toc"".
        */

        // Перебираем элементы и выводим текст
        for (WebElement item : tocItems) { //WebElement здесь - тип данных в tocItems перебираем item
            String itemText = item.getText();
            if (!itemText.isBlank()) { // Игнорируем пустые строки
                System.out.println(itemText);
                }
        }
        //Задание 4: Шаг 2 Клик с помощью CSS Selector (по тексту в меню Download)

        // ВЫВОДИМ ВСЕ ССЫЛКИ И ИХ HREF, ЧТОБЫ УВИДЕТЬ ТОЧНОЕ ЗНАЧЕНИЕ
        System.out.println("\n Все ссылки в меню (текст + href)");
        List<WebElement> allLinks = driver.findElements(By.cssSelector("#toc a"));
        for (WebElement link : allLinks) {
            String text = link.getText();
            String href = link.getAttribute("href"); // получаем реальный href
            if (!text.isBlank()) {
                System.out.println("Текст: '" + text + "' -> href: " + href);
            }
        }

        //ищем ссылку по части текста "Download"
        System.out.println("\n=== Поиск ссылки 'Download' ===");
        List<WebElement> downloadLinks = driver.findElements(By.xpath("//div[@id='toc']//a[contains(text(), 'Download')]"));

        if (!downloadLinks.isEmpty()) {
            WebElement downloadLink = downloadLinks.get(0);

            // Клик через JavaScript (гарантированно)
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", downloadLink);
            System.out.println("Клик выполнен (через JS).");
            Thread.sleep(3000);

            // Возвращаемся и кликаем вторым способом
            driver.navigate().back();
            Thread.sleep(2000);

        // Второй клик - другим локатором xpath (по полному тексту)
            WebElement downloadLink2 = driver.findElement(By.xpath("//div[@id='toc']//a[text()='4. Test results']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", downloadLink2);
            System.out.println("Второй клик выполнен (другой XPath).");
            Thread.sleep(3000);

        // Задание 3: шаг 4 закрытие браузера
        driver.quit();
        }
    }
}