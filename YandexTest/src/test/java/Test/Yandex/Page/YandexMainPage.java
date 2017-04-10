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

    public YandexMainPage(WebDriver driver) {
        this.driver = driver;
    }
    By weatherYandexLocator = By.xpath(".//*[@id='wd-_weather']/div/h1/a[1]" );
    By mapYandexLocator = By.xpath("//div/*/a[@href='https://yandex.ru/maps/?utm_source=geoblock_maps_penza']");
    By mapMoveLocator = By.xpath("//div/*/ymaps[@class='ymaps-2-1-48-map']");

    //Метод для перехода на страничку погоды яндекс
    public YandexWeaterPage weatherYandex(){
        driver.findElement(weatherYandexLocator).click();
        return new YandexWeaterPage(driver);
    }

    //Метод для вытаскивания текста из веб элемента
    public void actionMap(){
        WebElement mapYandex = (new WebDriverWait(driver,10))
                .until(ExpectedConditions.presenceOfElementLocated(mapYandexLocator));
        mapYandex.click();
        WebElement mapYandexMove = (new WebDriverWait(driver,10))
                .until(ExpectedConditions.presenceOfElementLocated(mapMoveLocator));
        Actions action = new Actions(driver);
        /*action.clickAndHold(mapYandexMove);
        action.moveToElement(mapYandexMove, 1000, 2000);*/
        action.dragAndDropBy(mapYandexMove, 1000, 2000);
    }

}
