package com.learn.bdd.steps;

import static org.junit.Assert.assertTrue;

import com.learn.bdd.shopping.ApparelShopping;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class ApparelShoppingSteps {
	
	@Given("^the \"(.*)\" is loaded in browser$")
	public void launchApplication(String URL) throws Throwable {
		ApparelShopping.launchApp(URL);
	}

	@When("^the '(.*)' category is selected$")
	public void selectApparelType(String apparelType) throws Throwable {
		ApparelShopping.selectApparelCategory(apparelType);
	}

	@Then("^all available \"(.*)\" should get listed$")
	public void verifySearch(String apparelType) throws Throwable {
		String search = ApparelShopping.verifySearchResult();
		assertTrue(search + " found for " + apparelType, search.contains("There is"));
	}

	@When("^the size is selected as '(\\w+)'$")
	public void the_size_is_selected_as_S(String size) throws Throwable {
		ApparelShopping.selectSize(size);
	}
//
//	@When("^the color is selected as 'Orange'$")
//	public void the_color_is_selected_as_Orange() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@When("^the compositions is selected as 'Cotton'$")
//	public void the_compositions_is_selected_as_Cotton() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@When("^the styles is selected as 'Casual'$")
//	public void the_styles_is_selected_as_Casual() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@When("^I hover over 'Faded Short Sleeve T-shirts'$")
//	public void i_hover_over_Faded_Short_Sleeve_T_shirts() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@When("^I select quick view$")
//	public void i_select_quick_view() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@Then("^the T-shirt detail is loaded$")
//	public void the_T_shirt_detail_is_loaded() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@When("^the quantity is increased to (\\d+)$")
//	public void the_quantity_is_increased_to(int arg1) throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@When("^the T-shirt is added to cart$")
//	public void the_T_shirt_is_added_to_cart() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@Then("^the 'Product successfully added to your shopping cart' message is shown$")
//	public void the_Product_successfully_added_to_your_shopping_cart_message_is_shown() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@Then("^the cart quantity is (\\d+)$")
//	public void the_cart_quantity_is(int arg1) throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@When("^the checkout is done$")
//	public void the_checkout_is_done() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@Then("^my shopping cart is updated with (\\d+) products$")
//	public void my_shopping_cart_is_updated_with_products(int arg1) throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
}
