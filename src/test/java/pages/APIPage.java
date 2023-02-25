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

    public List<String> getAPIDocsLinks() {

        List<WebElement> list = getDriver().
                findElements(By.xpath("//div[@class='container']//a[text()='API doc']"));
        List<String> strings = new ArrayList<>();
        for (WebElement element : list){
            strings.add(element.getAttribute("href"));
            getWait().until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            strings.add(getDriver().getTitle());
            getDriver().navigate().back();

        } System.out.println(strings);
        return strings;
    }
    /*public List<String> clickAPIDocsLinks(List<String> linksElements){
        List<String> titlePages = new ArrayList<>();
        for (WebElement element : linksElements){
            element.click();
            titlePages.add(getDriver().getTitle());
            getDriver().navigate().back();
        }return titlePages;
    }*/



}



