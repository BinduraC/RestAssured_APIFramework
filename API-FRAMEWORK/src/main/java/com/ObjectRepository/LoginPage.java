package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//declaration
	@FindBy(id="usernmae")
	private WebElement usernameEdt;
	
	@FindBy(id="inputPassword")
	private WebElement passwordEdt;
	
	@FindBy(xpath="//button[text()='Sign in']")
	private WebElement submitbtn;

	
	//utilization (create business libraries)
	public WebElement getSubmitbtn() {
		return submitbtn;
	}
	
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public void loginToApp(String userName, String passWord) {
		
		usernameEdt.sendKeys(userName);
		passwordEdt.sendKeys(passWord);
		submitbtn.click();
	}
}
