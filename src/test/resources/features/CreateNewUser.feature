@tag
Feature: Administrator - Check the flow of Create New User

  @sanity
  Scenario: Verify the flow of Create New User
    Given login by the Username and Password
    When click the UserMenu
    Then Click on The Create Button
    Then Enter data to all fields
    Then Click on create button
    Then click on OK button
    And SignOut
    
    
    