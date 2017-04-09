package Test.Yandex;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

/**
 * Created by VGostev on 03.04.2017.
 */
public class YandexWeaterTest extends ChromSetting {

    @Test
    public void TestWeater() {
        YandexPage yandexPage = new YandexPage((WebDriver) driver);

        yandexPage.weatherYandex();
        yandexPage.equalsWeater(weaterEqualsPenza);
        yandexPage.weaterSearcMoscow(cityMoscow);
        System.out.println(yandexPage.getTextSelector(timeLocator));
        yandexPage.equalsWeater(weaterEqualsMoscow);
        yandexPage.returnMyLocationWeather();
        yandexPage.cheakWeaterMont();
        yandexPage.entanceLoginYandex(emailLogin, paswordLogin);
        yandexPage.returnMainYandexPage();
        yandexPage.actionMap();
    }

}

