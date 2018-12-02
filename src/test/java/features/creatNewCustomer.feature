@account
Feature: Customer
  As a PO
  I want to register a new account
  And I want to login to application
  And I want to creat a new customer
  So that I can verify whether register, login and creat new customer functions work well

  @register
  Scenario: Register a new account
    When I get Login Page URL
    When I click here link
    And I input to email textbox with a random email address
    And I click to Submit button at Register page
    Then I get UserID information
    And I get Password information
    When I open Login page again

  @login
  Scenario: Login to application
    Given I input to Username textbox
    And I input to Password textbox
    And I click to Login button at Login page
    Then Verify Home page displayed with message "Welcome To Manager's Page of Guru99 Bank"

  @creat_a_new_customer
  Scenario Outline: Creat a new customer
    Given I open New Customer page
    When Input to New Customer form with data
      | Name   | Gender | DateOfBirth   | Address   | City   | State   | Pin   | Phone   | Email   | Password   |
      | <Name> | f      | <DateOfBirth> | <Address> | <City> | <State> | <Pin> | <Phone> | <Email> | <Password> |
    And I click Submit button in New Customer page
    Then I verify whether new customer is created successfully

    Examples: New Customer information
      | Name      | DateOfBirth | Address    | City   | State       | Pin    | Phone       | Email              | Password | Message                             |
      | Auto Test | 1988-06-08  | Manor Road | Witney | Oxfordshire | 123456 | 09876543218 | autotest@gmail.com |   123123 | Customer Registered Successfully!!! |
