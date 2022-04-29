import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ria {

    @Test
    public void openSite() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://auto.ria.com/uk/");
        driver.findElement(brand).sendKeys("Chevrolet");
        driver.findElement(By.xpath("//a[@data-value='13']")).click();
        driver.findElement(model).sendKeys("Camaro");
        driver.findElement(By.xpath("//ul[@class='unstyle scrollbar autocomplete-select']//a[@data-value='111']")).click();
        driver.findElement(priceFr).sendKeys("10000");
        driver.findElement(priceTo).sendKeys("20000");
        Thread.sleep(1000);
        driver.findElement(searchButton).click();
        Thread.sleep(3000);
        Assert.assertEquals(site, driver.getCurrentUrl());


    }

    By searchButton = By.xpath("//button[@type='submit']");
    By brand = By.xpath("//input[@id='brandTooltipBrandAutocompleteInput-brand']");
    By model = By.xpath("//input[@id='brandTooltipBrandAutocompleteInput-model']");
    By priceFr = By.xpath("//input[@name='price_ot']");
    By priceTo = By.xpath("//input[@name='price_do']");
    String site = "https://auto.ria.com/uk/search/?categories.main.id=1&price.currency=1&price.USD.gte=10000&price.USD.lte=20000&indexName=auto,order_auto,newauto_search&brand.id[0]=13&model.id[0]=111&size=20";


}