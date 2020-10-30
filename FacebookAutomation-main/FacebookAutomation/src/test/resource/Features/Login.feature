Feature: Login to the application
  As an end user, I can login to the application 
  so that I can interact with the application

  @login @regression
  Scenario: As an end user, I should be successfully login to the application
    Given I have launched the application
    When I enter "testfaceboook118@gmail.com" as user name and "Faceboook@111" as password
    And I click on the Log In button
    Then I should be successfully logged into the application
