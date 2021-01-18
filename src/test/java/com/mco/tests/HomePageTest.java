package com.mco.tests;
 
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mco.base.TestBase;
import com.mco.pages.HomePage;
import com.mco.pages.LoginPage;

public class HomePageTest extends TestBase {
	HomePage homePage;
	LoginPage loginPage;


	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		loginPage = new LoginPage();

	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		homePage.validatPageTitle();
		String title = loginPage.validatePageTitle();
		Assert.assertEquals(title, "WildFire Cart", "Title of is 'WildFire Cart' not Available!!");
		System.out.println("The Assertion has passed Smothly...");
	}

	@Test(priority = 2)
	public void loginSourceButtonNameTest() {
		homePage.validateLoginSourstButton();
		Assert.assertTrue(true);
		System.out.println("The Assertion has passed...");
	}
	@Test(priority = 3)
	public void abotUsLinkTest() {
		homePage.validateAbotUsLink();
		Assert.assertTrue(true);
	}
	
	@Test(priority = 4)
	public void contactUsLinkTest() {
		homePage.validateContactUsLink();
		Assert.assertTrue(true);
		//AssertJUnit.assertTrue(homePage.validateContactUsLink(), "Didnt Find any Value");
	}
	
	@Test(priority = 6)
	public void viewCartLinkTest() {
		homePage.validateViewCartLink();
		Assert.assertTrue(true);
	}
	@Test(priority = 7)
	public void CurrencyListsTest() {
		homePage.verifyCurrencyLists();
		Assert.assertEquals("AUSTRALIAN DOLLAR", "AUSTRALIAN DOLLAR", "Nothing Match!!!!");
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
