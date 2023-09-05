package tests;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import pages.ItemsPage;
import pages.LoginPage;
import utils.BrowserUtils;
import utils.Driver;
import utils.TestDataReader;

public class ItemsManagement_steps {
	
	BrowserUtils utils = new BrowserUtils();
	LoginPage loginpage = new LoginPage();
	DashboardPage dash_page = new DashboardPage();
	ItemsPage item_page = new ItemsPage();
	
	static String itemName;
	
	@Given("As an entity user, I am logged in")
	public void as_an_entity_user_i_am_logged_in() {
	   Driver.getDriver().get(TestDataReader.getProperty("appurl"));
	   Driver.getDriver().get(TestDataReader.getProperty("appurl"));
	   Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	   Driver.getDriver().manage().window().maximize();
	   utils.waitForElementToBeVisible(loginpage.login_page_email_box);
	   
	   utils.sendkeysWithActionsClass(loginpage.login_page_email_box, TestDataReader.getProperty("email"));
	   utils.sendkeysWithActionsClass(loginpage.login_page_password_box, TestDataReader.getProperty("password"));
	   loginpage.login_page_login_btn.click();
	   
	   utils.waitForElementToBeVisible(dash_page.loggedInSuccess_message);
	   Assert.assertTrue(dash_page.loggedInSuccess_message.isDisplayed());
	}
	
	@Given("I navigate to Items tab")
	public void i_navigate_to_items_tab() {
	   dash_page.items_tab.click();
	   utils.waitForElementToBeVisible(item_page.items_page_item_headerText);
	   Assert.assertTrue(item_page.items_page_item_headerText.isDisplayed());
	}
	
	@When("I click on the Add Item button")
	public void i_click_on_the_add_item_button() {
	    item_page.items_page_addItem_btn.click();
	}
	
	@When("I should be on item input page")
	public void i_should_be_on_item_input_page() {
		utils.waitForElementToBeVisible(item_page.items_Input_page_newItem_text);
	    Assert.assertTrue(item_page.items_Input_page_newItem_text.isDisplayed());
	}
	
	@When("I provide item information name {string}, price {string}, unit {string}, and description {string}")
	public void i_provide_item_information_name_price_unit_and_description(String name, String price, String unit, String description) {
	   itemName = name;
		item_page.items_input_page_name_box.sendKeys(itemName);
	   item_page.items_input_page_price_box.sendKeys(price);
	   item_page.items_input_page_unit_dropdown.click();
	   utils.waitForElementToBeVisible(item_page.items_input_page_unit_pc_option);
	   item_page.items_input_page_unit_pc_option.click();
	   
	   item_page.items_input_page_description.sendKeys(description);
	}
	
	@When("I click Save Item button")
	public void i_click_save_item_button() {
	   item_page.items_page_saveItem_btn.click();
	}
	
	@Then("The Item is added to the Item list table")
	public void the_item_is_added_to_the_item_list_table() {
		utils.waitForElementToBeVisible(item_page.items_page_item_headerText);
		Assert.assertTrue(item_page.items_page_item_headerText.isDisplayed());
		item_page.items_page_filter_btn.click();
		utils.waitForElementToBeVisible(item_page.items_page_filter_name_box);
		item_page.items_page_filter_name_box.sendKeys(itemName);
		utils.waitUntilElementVisibleWithLocator(By.xpath("//a[contains(text(), '" + itemName +"')]"));
		Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//a[contains(text(), '" + itemName +"')]")).isDisplayed());
		
	}
	@Then("I delete the item")
	public void i_delete_the_item() throws InterruptedException {
		Thread.sleep(2000);
		utils.waitForElementToBeVisible(item_page.items_page_3dot_menu);
		item_page.items_page_3dot_menu.click();
		utils.waitForElementToBeVisible(item_page.items_page_3dot_delete_option);
		item_page.items_page_3dot_delete_option.click();
		utils.waitForElementToBeVisible(item_page.items_Input_delete_youSure_text);
		Assert.assertTrue(item_page.items_Input_delete_youSure_text.isDisplayed());
		item_page.items_page_delete_ok_btn.click();
		utils.waitForElementToBeVisible(item_page.items_Input_noResultFound_text);
		Assert.assertTrue(item_page.items_Input_noResultFound_text.isDisplayed());
		Driver.quitDriver();
	}

}
