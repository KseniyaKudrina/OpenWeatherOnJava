package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PricingPage extends FooterMenuPage {

    @FindBy(xpath = "//section[@id = 'history']//tbody/tr[2]/td[1]/b")
    private WebElement historyBulk;
    @FindBy(xpath = "//section[@id = 'history']//tbody/tr[2]/td[2]/b")
    private WebElement historyForecastBulk;
    @FindBy(xpath = "//section[@id = 'history']//tbody/tr[2]/td[3]")
    private WebElement starter;
    @FindBy(xpath = "//section[@id = 'history']//tbody/tr[2]/td[4]")
    private WebElement medium;
    @FindBy(xpath = "//section[@id = 'history']//tbody/tr[2]/td[5]")
    private WebElement advanced;

    public static String HISTORY_BULK = "History Bulk";
    public static String HISTORY_FORECAST_BULK  = "History Forecast Bulk";
    public static String STARTER = "Starter";
    public static String MEDIUM  = "Medium";
    public static String ADVANCED  = "Advanced";

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
    public Map<String, String> getAtributes(){
        Map<String, String> atributes = new HashMap<>();
        atributes.put(HISTORY_BULK, historyBulk.getText());
        atributes.put(HISTORY_FORECAST_BULK, historyForecastBulk.getText());
        atributes.put(STARTER, starter.getText());
        atributes.put(MEDIUM, medium.getText());
        atributes.put(ADVANCED, advanced.getText());
        return atributes;
    }


}
