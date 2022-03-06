Feature: As a user, I am able to perform Trade app functions
  I want to add, delete and update trades

  @LogInTradeValid @SmokeTests
  Scenario: As a user, I am able to log in with valid credentials
    Given I am on the Trade App log in page
    When I enter username "Petch" password "SuperPetch123!"
    And I click on Trade login button
    Then I should be on Trade homepage

  @LogInTradeInvalid
  Scenario: As a user, I am not able to log in with invalid credentials
    Given I am on the Trade App log in page
    When I enter username "Petch" password "superpetch123"
    And I click on Trade login button
    Then I should get error message says "Bad credentials"
    And I should still in the log in page

  @LogOutTrade @SmokeTests
  Scenario: As a user, I am able to log out from the application
    Given I am on the Trade App log in page
    When I enter username "Petch" password "SuperPetch123!"
    And I click on Trade login button
    Then I should be on Trade homepage
    And I click on Trade logout button
    Then I shoud be on Trade App log in page

  @AddTradeValid @SmokeTests
  Scenario: As a user, I am able add a trade with valid data
    Given I am on the Trade App log in page
    When I enter username "Petch" password "SuperPetch123!"
    And I click on Trade login button
    Then I should be on Trade homepage
    When I click on Add Trade button
    Then I should be on Save Trade page
    When I select "Buy to Open" and I enter symbol "PETCH" entryDate "03/05/2021" entryPrice "10.0" exitDate "03/07/2021" exitPrice "18"
    And I click Save button
    Then The trade is displayed on the trade table

  @AddTradeInvalid
  Scenario: As a user, I am not able to add trade with invalid data
    Given I am on the Trade App log in page
    When I enter username "Petch" password "SuperPetch123!"
    And I click on Trade login button
    Then I should be on Trade homepage
    When I click on Add Trade button
    Then I should be on Save Trade page
    When I select "Buy to Open" and I enter symbol "" entryDate "03/05/2021" entryPrice "10.0" exitDate "03/07/2021" exitPrice "18"
    And I click Save button
    Then I should get error alert says "Please fill out this field."
    And I should be on Save Trade page

  @SearchTradeValid @SmokeTests
  Scenario: As a user, I am able to search listed trades
    Given I am on the Trade App log in page
    When I enter username "Petch" password "SuperPetch123!"
    And I click on Trade login button
    Then I should be on Trade homepage
    When I enter symbol "PETCH" and date "03/05/2021"
    And I click on Search button
    Then The system should displays the search entered

  @UpdateTradeValid
  Scenario: As a user, I am able to update the existing trade
    Given I am on the Trade App log in page
    When I enter username "Petch" password "SuperPetch123!"
    And I click on Trade login button
    Then I should be on Trade homepage
    When I click on Update
    And I should be on Save Trade page
    When I select "Buy to Open" and I enter symbol "PETCHupdate" entryDate "03/05/2021" entryPrice "10.0" exitDate "03/07/2021" exitPrice "20"
    And I click Save button
    Then The trade is displayed on the trade table with updated values

  @DeleteTrade @SmokeTests
  Scenario: As a user, I am able to delete trade
    Given I am on the Trade App log in page
    When I enter username "Petch" password "SuperPetch123!"
    And I click on Trade login button
    Then I should be on Trade homepage
    When I enter symbol "PETCH" and date "03/05/2021"
    And I click on Search button
    And I click on Delete button
    Then I should get alert says "Are you sure you want to delete this record?"
    And I click on OK
    Then The system should not displays the deleted transaction
