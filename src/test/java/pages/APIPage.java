package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

}
