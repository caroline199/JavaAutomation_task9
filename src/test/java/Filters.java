import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.log4j.Logger;

public class Filters {

    private static final String url = "https://onliner.by";
    private static final Logger logger = Logger.getLogger(Filters.class);

    @Test
    public void testSearchBabyliss() {
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver_mac64/chromedriver");

        ChromeDriver driver = new ChromeDriver();
        driver.get(url);
        driver.findElement(By.xpath("//span[text()='Фены']")).click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500)");
        driver.findElement(By.xpath("//input[@value='babyliss']/following-sibling::span")).click();

        if (driver.findElement(By.xpath("//input[@value='babyliss']")).isSelected()) {
            System.out.println("Still selected");
        }
        driver.quit();
        logger.info("Second test is finished.");
    }

    @Test
    public void testSearchSeveral() {
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver_mac64/chromedriver");

        ChromeDriver driver = new ChromeDriver();
        driver.get(url);
        driver.findElement(By.xpath("//span[text()='Фены']")).click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 250)");
        driver.findElement(By.xpath("//div[@class='schema-filter-control schema-filter-control_more']")).click();
        driver.findElement(By.xpath("//input[@value='polaris']/following-sibling::span")).click();
        driver.findElement(By.xpath("//input[@value='holt']/following-sibling::span")).click();
        driver.findElement(By.xpath("//input[@value='braun']/following-sibling::span")).click();

        if (
                driver.findElement(By.xpath("//input[@value='polaris']")).isSelected()
                        && driver.findElement(By.xpath("//input[@value='holt']")).isSelected()
                        && driver.findElement(By.xpath("//input[@value='braun']")).isSelected()
        ) {
            System.out.println("Still selected");
        }
        driver.quit();
        logger.info("First test is finished.");
    }
}
