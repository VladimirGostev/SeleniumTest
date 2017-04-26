package Test.Yandex.Page;

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

    public YandexWeaterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = (new WebDriverWait(driver,10));
    }

    @FindBy(xpath = "/*//*[@class='forecast-brief__item forecast-brief__item_tile']")
    WebElement clickWeatherMontLink;
    @FindBy(xpath = "//button[@class='button button_theme_action button_size_m i-bem button_js_inited']")
    WebElement entranceButtonPopWindows;
    @FindBy(xpath = "//span[@class='user__name i-bem']")
            WebElement currentUserName;
    @FindBy(css = "#header2input")
    WebElement inputSearchCityWeather;
    @FindBy(xpath = "//a[@class='link place-list__item-name'][text()='Москва']")
    WebElement newCityWeatherLink;
    @FindBy(xpath = "//button[@title='Войти']")
    WebElement buttonEntranceMain;
    @FindBy(xpath = "//input[@placeholder='Логин']")
    WebElement inputEmail;
    @FindBy(xpath = "//input[@name='passwd']")
    WebElement inputPasword;
    @FindBy(xpath = "//a[@class='link i-bem']")
    WebElement headYandexMainPage;
    @FindBy(xpath = "//button[@id='my-location']")
    WebElement myLocationBuutton;
    @FindBy(xpath = "//h1[@class='title title_level_1']")
            WebElement currentRegion;
/*    By entranceButtonPopWindows = By.xpath("//button[@class='button button_theme_action button_size_m i-bem button_js_inited']");//кнопка войти на форме popUP
    By currentUserName = By.xpath("//span[@class='user__name i-bem']");
    By inputSearchCityWeather = By.cssSelector("#header2input");
    By newCityWeatherLink = By.xpath("//a[@class='link place-list__item-name'][text()='Москва']");
    By buttonEntranceMain = By.xpath("//button[@title='Войти']");
    By inputEmail = By.xpath("//input[@placeholder='Логин']");
    By inputPasword = By.xpath("//input[@name='passwd']");
    By headYandexMainPage = By.xpath("//a[@class='link i-bem']");
    By myLocationBuutton = By.xpath("//button[@id='my-location']");
    By currentRegion = By.xpath("//h1[@class='title title_level_1']");
    String textWeaterLocator = ".copyright-tech";*/

    public void goToWeaterMoscow(String city){
        wait.until(ExpectedConditions.visibilityOf(inputSearchCityWeather)).sendKeys(city, Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(newCityWeatherLink)).click();
    }
    public String getCurrentRegion(){
        System.out.println(wait.until(ExpectedConditions.visibilityOf(currentRegion)).getText());
        return wait.until(ExpectedConditions.visibilityOf(currentRegion)).getText();
    }
    public YandexWeaterPage regionShouldBe(String region) {
        assertTrue("Eror: region not valid",
                getCurrentRegion().trim().endsWith(region));
        return this;
    }
    public void goToCheakWeaterMont(){
        wait.until(ExpectedConditions.visibilityOf(clickWeatherMontLink)).click();
    }

    public void goToMyLocationWeather(){
        wait.until(ExpectedConditions.visibilityOf(myLocationBuutton)).click();
        System.out.println("Вы перешли на страницу погоды, вашего текущего местоположения");
    }

    public void clickButtonEntrance(){
        wait.until(ExpectedConditions.visibilityOf(buttonEntranceMain)).click();
    }
    public void inputEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(inputEmail)).sendKeys(email);
    }
    public void inputPasword(String psw){
        wait.until(ExpectedConditions.visibilityOf(inputPasword)).sendKeys(psw);
    }
    public void clickLogIn(){
        wait.until(ExpectedConditions.visibilityOf(entranceButtonPopWindows)).click();
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
                (wait.until(ExpectedConditions.visibilityOf(currentUserName)).getText()).endsWith("gostev-test-sel…"));
        System.out.println("User name: " + wait.until(ExpectedConditions.visibilityOf(currentUserName)).getText());
    }
    public YandexMainPage returnToMainYandexPage(){
        wait.until(ExpectedConditions.visibilityOf(headYandexMainPage)).click();
        return new YandexMainPage(driver);
    }
}