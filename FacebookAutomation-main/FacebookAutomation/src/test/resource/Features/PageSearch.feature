Feature: Serach specific page
  As an end user, I can enter values in search field 
  so that I can search the facebook pages and I should be able to ineract with the page

  @search @regression
 Scenario: As an end user, I should be able to search the pages as per search querry
    Given I have successfully logged in, into the application
    When I search for the "Fetch Rewards" page
    Then Search result should retun "Fetch Rewards" page

  @search @regression
  Scenario: As an end user, I should be able like the page
    Given I have successfully logged in, into the application
    When I search for the "Fetch Rewards" page
    And I open the "Fetch Rewards" page
    And I Click on the like button
    Then Page with name "Fetch Rewards" shpould be liked
