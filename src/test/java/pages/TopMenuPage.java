package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class TopMenuPage extends BasePage{
    @FindBy(xpath = "//div[@id='desktop-menu']//a[text()='Guide']")
    private WebElement menuGuideTopMenu;
    final By TOP_GUIDE =By.xpath("//div[@id='desktop-menu']//a[text()='Guide']");

    public GuidePage clickGuideMenu(){
        click(menuGuideTopMenu);
        return new GuidePage(getDriver());
    }
    public GuidePage clickByGuideMenu(){
        clickBy(TOP_GUIDE);
        return new GuidePage(getDriver());
    }

    public TopMenuPage(WebDriver driver) {
        super(driver);
    }
}
