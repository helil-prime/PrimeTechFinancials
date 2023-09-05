package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class CustomersPage {
public CustomersPage() {
	PageFactory.initElements(Driver.getDriver(), this);
}

@FindBy (xpath = "//h3[text()='Customers']")
public WebElement customer_page_Customers_TextHeader;

@FindBy (xpath = "//button[text()=' New Customer']")
public WebElement customer_page_NewCustomerBTN;


@FindBy (xpath = "//h6[text()='Basic Info']")
public WebElement customer_page_BasicInfo_Form_Label;

@FindBy (xpath = "//h3[text()='New Customer']")
public WebElement customer_page_NewCustomer_TextHeader;

@FindBy (xpath = "(//input[@name='name'])[1]")
public WebElement customer_page_BasicInfo_DisplayName_Field;

@FindBy (xpath = "(//div[@class='relative rounded-md shadow-sm font-base']/input)[2]")
public WebElement customer_page_BasicInfo_PrimaryContactName_Field;

@FindBy (xpath = "(//input[@name='phone'])[1]")
public WebElement customer_page_BasicInfo_Phone_Field;

@FindBy (xpath = "(//div//child::input[@type='text'])[6]")
public WebElement customer_page_BasicInfo_PrimaryCurrency_Field;

@FindBy (xpath = "//input[@name='email']")
public WebElement customer_page_BasicInfo_Email_Field;

@FindBy (xpath = "//input[@type='url']")
public WebElement customer_page_BasicInfo_Website_Field;

@FindBy (xpath = "(//input[@name='name'])[2]")
public WebElement customer_page_BasicInfo_Prefix_Field;

@FindBy (xpath = "//table")
public WebElement customer_page_CustomerTable;

@FindBy (xpath = "//label[text()='No customers yet!']")
public WebElement customer_page_NoCustomersYet_text;

@FindBy (xpath = "//button[@type='submit']")
public WebElement customer_page_NewCustomerSubmit_BTN;

}
