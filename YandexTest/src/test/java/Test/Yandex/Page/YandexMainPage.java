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
    By weatherYandexLocator = By.xpath("//a[@class='home-link home-link_blue_yes']" );

    public YandexWeaterPage openWeaterPage(){
        driver.findElement(weatherYandexLocator).click();
        return new YandexWeaterPage(driver);
    }
}
