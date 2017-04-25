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
        wait = (new WebDriverWait(driver,10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/*//*[@class='forecast-brief__item forecast-brief__item_tile']")
            By clickWeatherMontLink;
    @FindBy(xpath = "//button[@class='button button_theme_action button_size_m i-bem button_js_inited']")
            By entranceButtonPopWindows;
    @FindBy(xpath = "//span[@class='user__name i-bem']")
            By currentUserName;
    @FindBy(css = "#header2input")
            By inputSearchCityWeather;
    @FindBy(xpath = "//a[@class='link place-list__item-name'][text()='Москва']")
            By newCityWeatherLink;
    @FindBy(xpath = "//button[@title='Войти']")
            By buttonEntranceMain;
    @FindBy(xpath = "//input[@placeholder='Логин']")
            By inputEmail;
    @FindBy(xpath = "//input[@name='passwd']")
            By inputPasword;
    @FindBy(xpath = "//a[@class='link i-bem']")
            By headYandexMainPage;
    @FindBy(xpath = "//button[@id='my-location']")
            By myLocationBuutton;
    @FindBy(xpath = "//h1[@class='title title_level_1']")
            WebElement currentRegion;
    //By entranceButtonPopWindows = By.xpath("//button[@class='button button_theme_action button_size_m i-bem button_js_inited']");//кнопка войти на форме popUP
    //By currentUserName = By.xpath("//span[@class='user__name i-bem']");
    //By inputSearchCityWeather = By.cssSelector("#header2input");
    //By newCityWeatherLink = By.xpath("//a[@class='link place-list__item-name'][text()='Москва']");
    //By buttonEntranceMain = By.xpath("//button[@title='Войти']");
    //By inputEmail = By.xpath("//input[@placeholder='Логин']");
    //By inputPasword = By.xpath("//input[@name='passwd']");
    //By headYandexMainPage = By.xpath("//a[@class='link i-bem']");
    //By myLocationBuutton = By.xpath("//button[@id='my-location']");
    //By currentRegion = By.xpath("//h1[@class='title title_level_1']");
    String textWeaterLocator = ".copyright-tech";

    public void goToWeaterMoscow(String city){
        wait.until(ExpectedConditions.presenceOfElementLocated(inputSearchCityWeather)).sendKeys(city, Keys.ENTER);
        wait.until(ExpectedConditions.presenceOfElementLocated(newCityWeatherLink)).click();
    }
    public String getCurrentRegion(){
        //System.out.println(wait.until(ExpectedConditions.presenceOfElementLocated(currentRegion)).getText());
        System.out.println(currentRegion.getText());
        //return wait.until(ExpectedConditions.presenceOfElementLocated(currentRegion)).getText();
        return currentRegion.getText();
    }
    public YandexWeaterPage regionShouldBe(String region) {
        assertTrue("Eror: region not valid",getCurrentRegion().trim().endsWith(region));
        return this;
    }
    public void goToCheakWeaterMont(){
        wait.until(ExpectedConditions.presenceOfElementLocated(clickWeatherMontLink)).click();
        //clickWeatherMontLink.click();
    }

    public void goToMyLocationWeather(){
        wait.until(ExpectedConditions.presenceOfElementLocated(myLocationBuutton)).click();
        System.out.println("Вы перешли на страницу погоды, вашего текущего местоположения");
    }

    public void clickButtonEntrance(){
        wait.until(ExpectedConditions.presenceOfElementLocated(buttonEntranceMain)).click();
    }
    public void inputEmail(String email) {
        wait.until(ExpectedConditions.presenceOfElementLocated(inputEmail)).sendKeys(email);
    }
    public void inputPasword(String psw){
        wait.until(ExpectedConditions.presenceOfElementLocated(inputPasword)).sendKeys(psw);
    }
    public void clickLogIn(){
        wait.until(ExpectedConditions.presenceOfElementLocated(entranceButtonPopWindows)).click();
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
        Assert.assertEquals("Eror user name", driver.findElement(currentUserName).getText(),"gostev-test-sel…");
        System.out.println("User name: " + driver.findElement(currentUserName).getText());
    }
    public YandexMainPage returnToMainYandexPage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(headYandexMainPage)).click();
        return new YandexMainPage(driver);
    }
}