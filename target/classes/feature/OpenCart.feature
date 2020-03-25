Feature: OpenCartApplication 
  In order to create a webpage
  As a e-commerce vendor
  I want to get access to the portal
  
  Background: these are the steps common for every scenario to be followed
  Given I have browser with opencartpage 
  
 
 Scenario Outline: SearchValidCredential
 When I search for the product with '<product>'
 Then I should get all the search related products
 
 Examples:
 |product|
 |samsung|
 
 Scenario Outline: SearchInValidCredential
 When I search for the product as '<product name>'
 Then I should get message as There is no product that matches the search criteria
 
 Examples:
 |product name|
 |ring|
 |cars|
 
   Scenario: ClickOnAnyProduct
   When I click on any product
   Then I should get all the details of the particular product
   
   Scenario: ComparingTheProducts
   When I click on compare icon
   Then I should get the comparision among the products
   
   Scenario Outline: ClickOnCheckOut
   When I enter '<username>' and '<password>' click on CheckOut
   Then I should navigate to payment page
   
   Examples:
   |username|password|
   |anjanipriya456@gmail.com|anju.555|
   
  
   
   
   
   
   
   
   
   
   
   
   
   
   
   
  