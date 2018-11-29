@login
Feature: Login
  As a PO
  I want to login to application
  So that I can verify whether login function works well

  Scenario: Login to system with param
    Given I open application
    When I input Username as "mngr165494"
    And I input Password as "dusades"
    And I click to Login button
    Then I verify if Homepage is displayed as expected with message "Welcome To Manager's Page of Guru99 Bank"
    And I close browser

  Scenario Outline: Login to system with Example Datatable
    Given I open application
    When I input Username as "<Username>"
    And I input Password as "<Password>"
    And I click to Login button
    Then I verify if Homepage is displayed as expected with message "Welcome To Manager's Page of Guru99 Bank"
    And I close browser
    
   Examples: Username and Password Datatable 
      | Username   | Password |
      | mngr165494 | dusades  |
      | mngr163633 | hEjApuz  |
      | mngr164841 | hapEsyr  |
