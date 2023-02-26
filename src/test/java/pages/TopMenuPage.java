package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class TopMenuPage extends BasePage{
    @FindBy(xpath = "//div[@id='desktop-menu']//a[text()='Guide']")
    private WebElement menuGuideTopMenu;
    final By TOP_GUIDE =By.xpath("//div[@id='desktop-menu']//a[text()='Guide']");

    @FindBy(xpath = "//li[@class='user-li']//a")
    private WebElement singInTopMenu;
    @FindBy(linkText = "Pricing")
    private WebElement pricingTopMenu;

    @FindBy(xpath = "//div[@id='desktop-menu']//a[text()='Maps']")
    private WebElement mapsTopMenu;
    @FindBy(xpath = "//div[@id='desktop-menu']//li[@class='user-li']/a")
    private WebElement signInTopMenu;

    public TopMenuPage(WebDriver driver) {
        super(driver);
    }
    public GuidePage clickGuideMenu(){
        click(menuGuideTopMenu);
        return new GuidePage(getDriver());
    }
    public GuidePage clickByGuideMenu(){
        clickBy(TOP_GUIDE);
        return new GuidePage(getDriver());
    }
    public HomeSignInPage clickSignInTopMenu(){
        click(singInTopMenu);
        return new HomeSignInPage(getDriver());
    }
    public PricingPage clickByPricingMenu(){
        click(pricingTopMenu);
        return new PricingPage(getDriver());
    }
    public MapsPage clickByMapsMenu(){
        click(mapsTopMenu);
        return new MapsPage(getDriver());
    }
    public HomeUsersSignInPage clickSignInMenu() {
        click(signInTopMenu);

        return new HomeUsersSignInPage(getDriver());
    }

    public HomePage signIn() {
        clickSignInMenu().signInAsRegularUser();

        return new HomePage(getDriver());
    }

    public HomeUsersSignInPage signOut() {
        click(getDriver().findElement(By.id("user-dropdown")));
        click(getDriver().findElement(By.xpath("//a[@href='/users/sign_out']")));

        return new HomeUsersSignInPage(getDriver());
    }



}
