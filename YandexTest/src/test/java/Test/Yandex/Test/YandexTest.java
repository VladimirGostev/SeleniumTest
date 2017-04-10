package Test.Yandex.Test;

import Test.Yandex.Page.YandexMainPage;
import Test.Yandex.Page.YandexWeaterPage;
import Test.Yandex.SettingPage.ChromSetting;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

/**
 * Created by VGostev on 03.04.2017.
 */
public class YandexTest extends ChromSetting {

    @Test
    public void TestWeater() {
        YandexMainPage yandexPage = new YandexMainPage((WebDriver) driver);
        YandexWeaterPage yandexWeater = yandexPage.weatherYandex();
        yandexWeater.equalsWeater(weaterEqualsPenza);
        yandexWeater.weaterSearcMoscow(cityMoscow);
        System.out.println(yandexWeater.getTextSelector(timeLocator));
        yandexWeater.equalsWeater(weaterEqualsMoscow);
        yandexWeater.returnMyLocationWeather();
        yandexWeater.cheakWeaterMont();
        yandexWeater.entanceLoginYandex(emailLogin, paswordLogin);
        yandexWeater.returnMainYandexPage();
        yandexPage.actionMap();
    }

}

