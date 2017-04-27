package Test.Yandex.SettingPage;

import Test.Yandex.Page.YandexWeaterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by VGostev on 26.04.2017.
 */
public class PageFactorySetting {
    public PageFactorySetting(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@class='forecast-brief__item forecast-brief__item_tile']")
        public WebElement clickWeatherMontLink;
    @FindBy(xpath = "//button[@class='button button_theme_action button_size_m i-bem button_js_inited']")
        public WebElement entranceButtonPopWindows;
    @FindBy(xpath = "//span[@class='user__name i-bem']")
        public WebElement currentUserName;
    @FindBy(css = "#header2input")
        public WebElement inputSearchCityWeather;
    @FindBy(xpath = "//a[@class='link place-list__item-name'][text()='Москва']")
        public WebElement newCityWeatherLink;
    @FindBy(xpath = "//button[@title='Войти']")
        public WebElement buttonEntranceMain;
    @FindBy(xpath = "//input[@placeholder='Логин']")
        public WebElement inputEmail;
    @FindBy(xpath = "//input[@name='passwd']")
        public WebElement inputPasword;
    @FindBy(xpath = "//a[@class='link i-bem']")
        public WebElement headYandexMainPage;
    @FindBy(id = "my-location")
        public WebElement myLocationBuutton;
    @FindBy(xpath = "//h1[@class='title title_level_1']")
        public WebElement currentRegion;
}
