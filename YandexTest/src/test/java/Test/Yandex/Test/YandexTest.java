package Test.Yandex.Test;

import Test.Yandex.Page.YandexMainPage;
import Test.Yandex.Page.YandexWeaterPage;
import Test.Yandex.SettingPage.ChromSetting;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by VGostev on 03.04.2017.
 */
public class YandexTest extends ChromSetting {
    @Test
    public void TestWeater() throws InterruptedException {
        YandexMainPage yandexPage = new YandexMainPage(driver);
        YandexWeaterPage yandexWeater = yandexPage.openWeaterPage();

        yandexWeater.regionShouldBe(weaterChekPenza);
        yandexWeater.goToWeaterMoscow(cityMoscow);
        yandexWeater.regionShouldBe(weaterCheksMoscow);
        yandexWeater.goToMyLocationWeather();
        yandexWeater.goToCheakWeaterMont();
        yandexWeater.entanceLoginYandex(email, pasword);
        yandexWeater.returnToMainYandexPage();
    }

}

