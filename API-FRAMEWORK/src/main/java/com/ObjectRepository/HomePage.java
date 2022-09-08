package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.WebDriverUtility;



public class HomePage extends WebDriverUtility{

	//initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//declaration 
	@FindBy(xpath="(//a[.='Organizations'])[1]") 
	private WebElement organizationsLink;
	
	@FindAll({@FindBy(xpath="//a[.='Contacts']") ,
	@FindBy(xpath="//a[@href='index.php?module=Contacts&action=index']")})
	private WebElement contactsLink;
	
	@FindBy(xpath="//a[.='Opportunities']")
	private WebElement opportunityLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement moreLink;
	
	@FindBy(linkText="Sales Order")
	private WebElement salesOrderLink;
	
	@FindAll({@FindBy(xpath="//a[text()='Products']"),
	@FindBy(xpath="//a[@href='index.php?module=Products&action=index']")})
	private WebElement productLink;
	
	@FindAll({@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']"),
	@FindBy(xpath="//span[text()=' Administrator']/../..//img[@src='themes/softed/images/user.PNG']")})
	private WebElement administratorLink;
	
	@FindBy(xpath="(//td[@class='tabUnSelected'])[11]")
	private WebElement moreMouseHover;
	
	@FindBy(xpath="//a[.='Sign Out']")
	private WebElement signoutLink;

	//utilization
	
	public void clickOrganizationsLink() {
		organizationsLink.click();
	}

	public void clickContactsLink() {
		contactsLink.click();
	}

	
	public void clickOpportunityLink() {
		opportunityLink.click();
	}
	
	public void clickProductLink() {
		productLink.click();
	}
	

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getAdministratorLink() {
		return administratorLink;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}
	
	public void mouseHoverMoreClickSalesOrder(WebDriver driver) {
		mouseHoverOnElement(driver, moreLink);
		salesOrderLink.click();
	}
	
	public void logOut(WebDriver driver) {
		mouseHoverOnElement(driver, administratorLink);
		signoutLink.click();
	}
	
	
}
