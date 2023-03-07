package pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;

public class HomeSignInPage extends FooterMenuPage {
    private String email = "jka59433@xcoxc.com";
    private String password = "Tester12#";
    @FindBy(id = "user_email")
    private WebElement userEmail;
    @FindBy(id = "user_password")
    private WebElement userPassword;
    @FindBy(name = "commit")
    private WebElement submitButton;

    public HomeSignInPage(WebDriver driver) {
        super(driver);
    }
    public HomeSignInPage clickClearInputEmail(){
        click(userEmail);
        userEmail.clear();
        input(email, userEmail);

        return this;
    }
    public HomeSignInPage clickClearInputPassword(){
        click(userPassword);
        userPassword.clear();
        input(password, userPassword);

        return this;
    }
    public HomePage clickSubmitButton(){
        click(submitButton);

        return new HomePage(getDriver());
    }

}
