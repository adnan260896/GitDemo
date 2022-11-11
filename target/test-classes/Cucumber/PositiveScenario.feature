
@tag
Feature: Checking out product
  I want to use this template for my feature file

 Background:
   Given Landing on Home Page
  @Regression
  Scenario Outline: Positive Scenario of Checking out product
    Given Enter username <UserName> and pwd <PassWord>
    When Add product <Product> to cart
    And Confirming the added product <Product> and clicking buy now.
    Then Selecting the country <Country> and printing total price in Checkout page
    

 
    Examples: 
      | UserName       | PassWord | Product        | Country |
      |abc123@hello.com|Abc@1234  |ADIDAS ORIGINAL |Germany  |
     