package com.mco.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mco.base.TestBase;

public class LoginPage extends TestBase {

	// public static WebDriver driver;

	// PAGE FACTORY OBJECT REPOSITORY'S
	@FindBy(xpath = "//button[@id='dLabellogin']")
	WebElement login_Source_Button;

	@FindBy(xpath = "//input[@id='username']")
	WebElement user_name;

	@FindBy(xpath = "//input[@id='password']")
	WebElement pass_word;

	@FindBy(xpath = "//button[@id='jqLogin']")
	WebElement login_Button;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='dLabel']/span")
	WebElement current_User_Name;

	@FindBy(xpath = "//img[@class='img-responsive']")
	WebElement login_Image;

	// Initializing the page objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validatePageTitle() {
		String titles = driver.getTitle();
		System.out.println("Titles of the page is : " + titles);
		return titles;
	}

	public boolean validateLoginLogoImage() {
		return login_Image.isDisplayed();
	}

	public HomePage login(String un, String pas) {
	login_Source_Button.click();
		user_name.sendKeys(un);
		pass_word.sendKeys(pas);
		login_Button.click();
		return new HomePage();

	}

	public String validatCurentUserName() {
		String curent_Name = current_User_Name.getText();
		System.err.println("\nCurent User Name is : " + curent_Name);
		//TestUtill.expWait(curent_Name);
		return curent_Name;
	}
}
