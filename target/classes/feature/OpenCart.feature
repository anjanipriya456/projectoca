Feature: OpenCartApplication
  In order to create a webpage
  As a e-commerce vendor
  I want to get access to the portal

  Background: These are the steps common for every scenario to be followed
    Given I have browser with opencartpage

  Scenario: SearchValidCredential
    When I search for the product with 'samsung'
    Then I should get all the search related products

  Scenario Outline: SearchInValidCredential
    When User enter search as '<product>'
    Then I should get message as There is no product that matches the search criteria
    
    Examples:
    |product|
    |cars|
    |jewellary|
    |DressesS|

  Scenario: ClickOnAnyProduct
    When I click on any product
    Then I should get all the details of the particular product

  Scenario: ComparingTheProducts
    When I click on compare icon
    Then I should get the comparision among the products

  Scenario: ClickOnCheckOut
    When User enter username and password details from Excel "src/test/resources/excel/anjuExcel.xlsx" with SheetName "Login"
    Then I should navigate to payment page
