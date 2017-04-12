package Test.Yandex.Page;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by VGostev on 03.04.2017.
 */
public class YandexMainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public YandexMainPage(WebDriver driver) {
        this.driver = driver;
        wait = (new WebDriverWait(driver,10));
    }
    By weatherYandexLocator = By.xpath(".//*[@id='wd-_weather']/div/h1/a[1]" );
    By mapYandexLocator = By.xpath("//div/*/a[@href='https://yandex.ru/maps/?utm_source=geoblock_maps_penza']");
    By mapMoveLocator = By.xpath("//div/*/ymaps[@class='ymaps-2-1-48-map']");


    public YandexWeaterPage openWeaterPage(){
        driver.findElement(weatherYandexLocator).click();
        return new YandexWeaterPage(driver);
    }
    public void actionMap(){
        Actions action = new Actions(driver);
        action.dragAndDrop(driver.findElement(By.xpath(".//*[@id='wd-_weather']/div/h1/a[1]")),driver.findElement(By.id("id=text"))).sendKeys(Keys.ENTER);
    }

}
