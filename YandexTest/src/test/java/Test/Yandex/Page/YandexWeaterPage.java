package Test.Yandex.Page;

import Test.Yandex.SettingPage.PageFactorySetting;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;


/**
 * Created by vgostev on 10.04.2017.
 */
public class YandexWeaterPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private PageFactorySetting pFactory;

        public YandexWeaterPage(WebDriver driver) {
        this.driver = driver;
        pFactory = new PageFactorySetting(driver);
        PageFactory.initElements(driver, PageFactorySetting.class);
        wait = (new WebDriverWait(driver,10));
    }

    public void goToWeaterMoscow(String city){
        wait.until(ExpectedConditions.visibilityOf(pFactory.inputSearchCityWeather)).sendKeys(city, Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(pFactory.newCityWeatherLink)).click();
    }
    public String getCurrentRegion(){
        System.out.println(wait.until(ExpectedConditions.visibilityOf(pFactory.currentRegion)).getText());
        return wait.until(ExpectedConditions.visibilityOf(pFactory.currentRegion)).getText();
    }
    public YandexWeaterPage regionShouldBe(String region) {
        assertTrue("Eror: region not valid",
                getCurrentRegion().trim().endsWith(region));
        return this;
    }
    public void goToCheakWeaterMont(){
        wait.until(ExpectedConditions.visibilityOf(pFactory.clickWeatherMontLink)).click();
    }
    public void goToMyLocationWeather() {
        wait.until(ExpectedConditions.visibilityOf(pFactory.myLocationBuutton)).click();
        System.out.println("Вы перешли на страницу погоды, вашего текущего местоположения");
    }
    public void clickButtonEntrance(){
        wait.until(ExpectedConditions.visibilityOf(pFactory.buttonEntranceMain)).click();
    }
    public void inputEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(pFactory.inputEmail)).sendKeys(email);
    }
    public void inputPasword(String psw){
        wait.until(ExpectedConditions.visibilityOf(pFactory.inputPasword)).sendKeys(psw);
    }
    public void clickLogIn(){
        wait.until(ExpectedConditions.visibilityOf(pFactory.entranceButtonPopWindows)).click();
    }
    public void entanceLoginYandex(String email, String pasword) {
        clickButtonEntrance();
        inputEmail(email);
        inputPasword(pasword);
        clickLogIn();
        verificationUserName();
        System.out.println("Вы вошли под своей учетной записью");
    }
    public void verificationUserName(){
        assertTrue("Eror: name user not valid",
                (wait.until(ExpectedConditions.visibilityOf(pFactory.currentUserName)).getText()).endsWith("gostev-test-sel…"));
        System.out.println("User name: " + wait.until(ExpectedConditions.visibilityOf(pFactory.currentUserName)).getText());
    }
    public YandexMainPage returnToMainYandexPage(){
        wait.until(ExpectedConditions.visibilityOf(pFactory.headYandexMainPage)).click();
        return new YandexMainPage(driver);
    }
}