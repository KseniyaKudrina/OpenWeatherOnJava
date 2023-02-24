package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HomeSignInTest extends BaseTest {
    @Test //регистрация с вводом данных
    public void testSignInMenuOpensSignInToYourAccountForm(){
        openBaseURL()
                .clickSignInTopMenu()
                .clickClearInputEmail()
                .clickClearInputPassword()
                .clickSubmitButton();
    }
    @Test
    public void testSignOut(){
        if(getDriver().findElement(By.id("user-dropdown")).isDisplayed()){
            getDriver().findElement(By.id("user-dropdown")).click();
            getDriver().findElement(By.xpath("//a[@href='/user/sign_out']")).click();

        }
    }
    @Test //сообщение о успешной регистрации
    public void testSignIn(){
        System.out.println(openBaseURL().signIn().getText());
    }
}
