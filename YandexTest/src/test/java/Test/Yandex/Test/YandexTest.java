package Test.Yandex.Test;

import Test.Yandex.Page.YandexMainPage;
import Test.Yandex.Page.YandexWeaterPage;
import Test.Yandex.SettingPage.ChromSetting;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by VGostev on 03.04.2017.
 */
public class YandexTest extends ChromSetting {
    By weatherMontLocator = By.xpath("//ul/*/a[@class='link forecast-brief__item-description forecast-brief__item-description_link_yes t t_c_12']");
    By paswordLocator = By.xpath("//input[@placeholder='Пароль']");
    By entranceButton = By.xpath("//div/*/button[@class='button button_theme_action button_size_m i-bem button_js_inited']");
    By equalsUserNameLocator = By.xpath("*//div/*/span[@class='user__name i-bem']");
    By inputSearchWeatherLocator = By.cssSelector("#header2input");
    By newCityWeatherLinkLocator = By.xpath("//ul/*/a[@class='link place-list__item-name']");
    By entranceLocator = By.xpath("//button[@title='Войти']");
    By emailLocator = By.xpath("//input[@placeholder='Логин']");
    By yandexMainPageLocator = By.xpath("//div/*/img[@class='image']");
    By myLocationLocator = By.cssSelector("#my-location");
    String textWeaterLocator = ".copyright-tech";
    @Test
    public void TestWeater() {
        YandexMainPage yandexPage = new YandexMainPage((WebDriver) driver);
        YandexWeaterPage yandexWeater = yandexPage.openWeaterPage();

        yandexWeater.regionShouldBe(weaterChekPenza);
        yandexWeater.goToWeaterMoscow(cityMoscow);
        //System.out.println(yandexWeater.getTextSelector(timeLocator));
        yandexWeater.regionShouldBe(weaterCheksMoscow);
        yandexWeater.goToMyLocationWeather();
        yandexWeater.goToCheakWeaterMont();
        yandexWeater.entanceLoginYandex(email, pasword);
        yandexWeater.returnToMainYandexPage();
        //yandexPage.actionMap();
    }

}

