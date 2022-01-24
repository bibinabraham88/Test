Feature: Verify adding product to basket
  As a user
  I shall be able to add a product to the basket

  @basket
  Scenario: Verify adding a random product to basket, view the basket and navigate to payments page
    Given I am on the homepage "http://www.prettylittlething.com"
    When I click on "winter" category from the nav menu
    When I click on a product "Black Hooded Puffer Jacket"
    When I select size "10"
    When I click on add to basket
    Then Item in basket shall be same as what was added "Black Hooded Puffer Jacket"
    When I click on the basket option on top right
    When I click on Proceed to Checkout
    When I enter my username "project.task@yahoo.com" and password "Project@123"
    Then Then Checkout subtotal should be equal to basket subtotal
    When I scroll down and click on the payment method pay with card