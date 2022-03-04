Feature: As a user, I am able to perform Trade app functions
  I want to add, delete and update trades

  @AddTradeValid
  Scenario: As a user, I am able to add a trade with valid data
    Given I am on the Trade App log in page
    When I enter username "Petch" password "SuperPetch123!"
    And I click on Trade login button
    Then I should be on Trade homepage
    When I click on Add Trade button
    Then I should be on Save Trade page
    When I enter the following data
      | Buy to Open | PetchStock | 03/02/2022 | 10.0 | 03/02/2022 | 18.0 |
    And I click Save button
    Then The trade is displayed on the trade table
    And The trade data resides in data base correctly

  @AddTradeInvalid
  Scenario: As a user, I am not able to add a trade with invalid data
    Given I am on the Trade App log in page
    When I enter username "Petch" password "SuperPetch123!"
    And I click on Trade login button
    Then I should be on Trade homepage
    When I click on Add Trade button
    Then I should be on Save Trade page
    When I enter the following data
      | Buy to Open | 
