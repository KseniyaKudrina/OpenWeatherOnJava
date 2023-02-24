package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class APIPage extends FooterMenuPage{

    public APIPage(WebDriver driver) {
        super(driver);
    }
    public int getCountWebElementsAPIDocsLinks() {
        List<WebElement> list = getDriver().
                findElements(By.partialLinkText("API doc"));
        List<String> textElements = new ArrayList<>();
        int count = 0;
        for (WebElement element : list) {
            if (element.getText().equals("API doc")) {
                count++;
                textElements.add(element.getText());
            }
        }
        return count;
    }

    /*public List<String> getClickAPIDocsLinks() {

        List<WebElement> list = getDriver().
                findElements(By.xpath("//div[@class='container']//a[text()='API doc']"));
        List<String> titlePages = new ArrayList<>();
        for (int i = 0; i < list.size()-1; i++){
            list.get(i).click();
            titlePages.add(getDriver().getTitle());
            getDriver().navigate().back();
            getWait().until(ExpectedConditions.visibilityOfAllElements(list));

            list = getDriver().
                    findElements(By.xpath("//div[@class='container']//a[text()='API doc']"));

        } System.out.println(titlePages);
        return titlePages;

    }*/



}



