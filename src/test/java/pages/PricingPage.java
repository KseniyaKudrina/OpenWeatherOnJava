package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class PricingPage extends FooterMenuPage{


    public PricingPage(WebDriver driver) {
        super(driver);
    }
    public List<String> listTableSpecialProducts(){
        List<WebElement> list = getDriver().
                findElements(
                        By.xpath("//section[@id='alerts']/table[@class='table align-buttons-to-bottom']//a[contains(@href,'/api/')]"));
        List <String> textElements = new ArrayList<>();
        for(WebElement element : list){
                textElements.add(element.getText());
            System.out.println(textElements);
            } return textElements;

    }

}
