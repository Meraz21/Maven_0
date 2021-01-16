package com.mco.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mco.base.TestBase;
import com.mco.pages.HomePage;
import com.mco.pages.LoginPage;
import com.mco.utill.TestUtill;

public class LoginPageTest extends TestBase {
	
	static LoginPage loginPage;
	static HomePage homePage;
	static TestUtill testUtill;

	public LoginPageTest() {
		super();
	}


	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		loginPage = new LoginPage();
		testUtill = new TestUtill();
		

	}

	@Test(groups = "UI TEST")
	public void loginPageTitleTest() {
		loginPage.validatePageTitle();
		String title = loginPage.validatePageTitle();
		Assert.assertEquals(title, "WildFire Cart", "Title of is 'WildFire Cart' not Available!!");
	}

	@Test(groups = "UI TEST")
	public void loginLogoImageTest() {
		boolean flag = loginPage.validateLoginLogoImage();
		AssertJUnit.assertTrue(flag);
	}

	@Test(priority = 1, groups = "Login Functionality")
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));

	}

	@Test(priority = 2, groups = "Login Functionality")
	public void curentUserNameTest() throws IOException {
		LoginPageTest.loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		loginPage.validatCurentUserName();
		TestUtill.takeScreenshotAtEndOfTest();
		

	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
