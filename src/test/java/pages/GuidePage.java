package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base_abstract.FooterMenuPage;

import java.util.ArrayList;
import java.util.List;

public class GuidePage extends FooterMenuPage {


    public GuidePage(WebDriver driver) {
        super(driver);
    }
    public int countButtonsLearnMore(){
        List<WebElement> list = getDriver().
                findElements(By.xpath("//div[@class='col-sm-12']//a[@class='ow-btn round btn-orange']"));
        List <String> textElements = new ArrayList<>();
        int count = 0;
        for(WebElement element : list){
            if(element.getText().equals("Learn more")){
                count++;
                textElements.add(element.getText());
            }
    }
        return count;
    }


}
