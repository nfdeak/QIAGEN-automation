@FeatureOne
Feature: Checking the search functionality for flight+hotel+car bundle on http://www.hotwire.com/ website

  Scenario Outline: There is at least one result returned when searching for a bundle
    Given User is on "<website>" landing page
    Then Home page is opened
    When User clicks on bundles button
    And User selects car, hotel and flight options
    And User enters flight "<from>" and "<to>" destination
    And User selects return date "<nDays>" after next day
    And User enters "<departingHour>" for departing hour and "<returningHour>" for returning hour
    And User clicks on search button
    Then User is redirected to results page and we verify if there is at least 1 result
    And Closes browser
    Examples:
      | website                           | from  | to  |  nDays | departingHour | returningHour |
      | https://www.hotwire.com/          | SFO   | LAX |  20    | Evening       | Morning       |