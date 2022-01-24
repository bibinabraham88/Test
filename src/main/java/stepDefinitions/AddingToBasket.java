package stepDefinitions;

import functionLibrary.CommonFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasketPage;
import pageObjects.CheckOutPage;
import pageObjects.HomePage;
import pageObjects.ProductPage;

public class AddingToBasket extends CommonFunctions {

    HomePage home = new HomePage(driver);
    BasketPage basket = new BasketPage(driver);
    ProductPage product = new ProductPage(driver);
    CheckOutPage checkout = new CheckOutPage(driver);

    @Given("I am on the homepage {string}")
    public void i_am_on_the_homepage(String homepage) {
        home.openHomePage(homepage);
    }
    @When("I click on {string} category from the nav menu")
    public void i_click_on_category_from_the_nav_menu(String category) {
        home.clickOnWinterMenuCategory(category);
    }
    @When("I click on a product {string}")
    public void i_click_on_a_product(String product) {
        home.clickOnProduct(product);
    }
    @When("I select size {string}")
    public void i_select_size_10(String size) {
        product.selectSize(size);
    }
    @When("I click on add to basket")
    public void i_click_on_add_to_basket() {
        product.addProductToBasket();
    }
    @Then("Item in basket shall be same as what was added {string}")
    public void item_in_basket_shall_be_same_as_what_was_added(String productName) {
        product.assertSameProductAdded(productName);
    }
    @When("I click on the basket option on top right")
    public void i_click_on_the_basket_option_on_top_right() {
        home.clickOnBasket();

    }
    @When("I click on Proceed to Checkout")
    public void i_click_on_proceed_to_checkout() {
        basket.proceedToCheckOut();
    }
    @When("I enter my username {string} and password {string}")
    public void i_enter_my_username_and_password(String email, String password) {
        checkout.signInUsingEmailAndPassword(email,password);
    }
    @Then("Then Checkout subtotal should be equal to basket subtotal")
    public void then_checkout_subtotal_should_be_equal_to_basket_subtotal() {
        checkout.assertSubTotalInBasketAndChkOut();
    }
    @When("I scroll down and click on the payment method pay with card")
    public void i_scroll_down_and_click_on_the_payment_method_pay_with_card() throws Exception{
        checkout.scrollToPayments();
        checkout.clickOnPaymentMethod();
    }
}
