package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import util.Base;

import java.util.List;

public class ResultPage extends Base {

    private WebDriver driver;

    private By searchResults = By.tagName("article");
    private By headerTitle = By.id("hotelResultTitle");

    public ResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getSearchResults(){
        return driver.findElements(searchResults);
    }

    public WebElement getHeaderTitle(){
        return driver.findElement(headerTitle);
    }




}
