package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.home.HomeUsersSignInPage;

public class HomeSignInTest extends BaseTest {
    @Test //регистрация с вводом данных
    public void testSignInMenuOpensSignInToYourAccountForm(){
        openBaseURL()
                .clickSignInTopMenu()
                .clickClearInputEmail()
                .clickClearInputPassword()
                .clickSubmitButton();
    }
    @Test // выход из аккаунта
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

    @Test // авторизация с неправильным Email или паролем
    public void testLogInWithInvalidPassword() {
        final String expectedNoticeMessage = "Invalid Email or password.";
        final String expectedSignInMenuText = "Sign In";
        final String userPassword = "Tester11#";

        final String oldSignInMenuText = openBaseURL()
                .clickSignInMenu()
                .getSignInText();

        HomeUsersSignInPage homeUsersSignInPage = new HomeUsersSignInPage(getDriver());

        homeUsersSignInPage
                .clickClearInputRegularUserEmail()
                .clickClearInputRegularUserPassword(userPassword)
                .clickSubmitButton();

        String actualNoticeMessage = homeUsersSignInPage.getNotification();
        String actualSignInMenuText = homeUsersSignInPage.getSignInText();

        Assert.assertEquals(actualNoticeMessage, expectedNoticeMessage);
        Assert.assertEquals(actualSignInMenuText, oldSignInMenuText);
        Assert.assertEquals(actualSignInMenuText, expectedSignInMenuText);
    }

}
