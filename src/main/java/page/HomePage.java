package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.Base;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class HomePage extends Base {

    private WebDriver driver;
    private String pageUrl ="https://www.hotwire.com/";

    private By carCheckBox = By.cssSelector("*[data-bdd='farefinder-package-bundleoption-car']");
    private By bundelsButton = By.cssSelector("*[data-bdd='farefinder-option-bundles']");
    private By fromInput = By.cssSelector("*[data-bdd='farefinder-package-origin-location-input']");
    private By toInput = By.cssSelector("*[data-bdd='farefinder-package-destination-location-input']");
    private By daysFromDatePicker = By.cssSelector("*[class='day-availability__day']");
    private By endDateInput = By.cssSelector("*[data-bdd='farefinder-package-enddate-input']");
    private By departingHours = By.cssSelector("*[data-bdd='farefinder-package-pickuptime-input']");
    private By returningHours = By.cssSelector("*[data-bdd='farefinder-package-dropofftime-input']");
    private By searchButton = By.cssSelector("*[data-bdd='farefinder-package-search-button']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getSearchButton(){
        return driver.findElement(searchButton);
    }

    public WebElement getDepartingHours(){
        return driver.findElement(departingHours);
    }

    public WebElement getReturningHours(){
        return driver.findElement(returningHours);
    }

    public WebElement getEndDateInput(){
        return driver.findElement(endDateInput);
    }

    public List<WebElement> getDaysFromDatePicker(){
        return driver.findElements(daysFromDatePicker);
    }

    public WebElement getCarCheckBox(){
        return driver.findElement(carCheckBox);
    }

    public WebElement getBundlesButton(){
        return driver.findElement(bundelsButton);
    }

    public WebElement getFromInput(){
        return driver.findElement(fromInput);
    }

    public WebElement getToInput(){
        return driver.findElement(toInput);
    }

    public boolean checkIfHomePageIsOpen() {
        if(driver.getCurrentUrl().equalsIgnoreCase(pageUrl))
            return true;
        else {
            return false;
        }
    }

    public WebElement getDayElementNdaysAfterNextDay(String nDay) {
        waitForElementToBeVisible(daysFromDatePicker);
        List<WebElement> days = getDaysFromDatePicker();
        WebElement nthDay = null;
        for (int i = 0; i < days.size(); i++) {
            if (days.get(i).getText().equals(nDay)) {
                nthDay = days.get(i);
                return nthDay;
            }
        }
        return nthDay;
    }

}
