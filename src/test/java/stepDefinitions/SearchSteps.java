package stepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import page.ResultPage;
import page.HomePage;
import util.Base;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@RunWith(Cucumber.class)
public class SearchSteps extends Base {

    public ResultPage resultPage;
    public HomePage homePage;

    @Given("User is on {string} landing page")
    public void user_is_on_landing_page(String pageUrl) throws IOException {
        driver = initializeDriver();
        driver.get(pageUrl);
    }

    @Then("Home page is opened")
    public void Home_page_is_opened() {
        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.checkIfHomePageIsOpen());
    }

    @When("User clicks on bundles button")
    public void user_click_bundles_button(){
        homePage.getBundlesButton().click();
    }

    //first two options hotels and flights were already selected by default, we can optionally check those too
    @And("User selects car, hotel and flight options")
    public void user_selects_car_hotel_flight(){
        homePage.getCarCheckBox().click();
    }

    @And("User enters flight {string} and {string} destination")
    public void user_enters_flight_from_to(String from, String to) throws InterruptedException {
        homePage.getFromInput().click();
        homePage.getFromInput().sendKeys(from);
        Thread.sleep(1000);
        homePage.getFromInput().sendKeys(Keys.RETURN);
        homePage.getToInput().sendKeys(to);
        Thread.sleep(1000);
        homePage.getToInput().sendKeys(Keys.RETURN);
    }


    @And("User enters {string} for departing hour and {string} for returning hour")
    public void user_enters_departing_and_returning_hours(String departingHour, String returningHour) {
        Select departinghours = new Select(homePage.getDepartingHours());
        departinghours.selectByVisibleText(departingHour);
        Select returninghours = new Select(homePage.getReturningHours());
        returninghours.selectByVisibleText(returningHour);
    }

    //Note that departing date is already set to next day date, so we don't need to set that, only the return
    @And("User selects return date {string} after next day")
    public void user_select_return_date(String nDaysAfterNextDay){
        homePage.getEndDateInput().click();
        homePage.getDayElementNdaysAfterNextDay(getDateNDaysAfterNextDay(nDaysAfterNextDay)).click();
    }

    @And("User clicks on search button")
    public void user_clicks_search(){
        homePage.getSearchButton().click();
    }

    @Then("User is redirected to results page and we verify if there is at least 1 result")
    public void user_goes_resultpage_and_checks_results() {
        resultPage = new ResultPage(driver);
        waitForElementToBeVisible(resultPage.getHeaderTitle());
        Assert.assertNotEquals(resultPage.getSearchResults().size(),0);
    }

    @And("Closes browser")
    public void close_browser() {
        driver.close();
    }

    public String getDateNDaysAfterNextDay(String nDay){
        Date currentDate = new Date();
        LocalDateTime localDateTimeCurrentDay = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime localDateTimeNextDay = localDateTimeCurrentDay.plusDays(1);
        LocalDateTime localDateTimeNextDayPlus20Days= localDateTimeNextDay.plusDays(Integer.parseInt(nDay));
        return String.valueOf(localDateTimeNextDayPlus20Days.getDayOfMonth());
    }
}
