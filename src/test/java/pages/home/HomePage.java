package pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;

public class HomePage extends FooterMenuPage {
    @FindBy(xpath = "//div[@class='panel-body']")
    private WebElement message;

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public String getText(){
       return getText(message);
    }
}
