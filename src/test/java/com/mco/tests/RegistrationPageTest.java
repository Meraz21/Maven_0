package com.mco.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mco.base.TestBase;
import com.mco.pages.HomePage;
import com.mco.pages.LoginPage;
import com.mco.pages.RegistrationPage;
import com.mco.utill.TestUtill;

public class RegistrationPageTest extends TestBase {
	HomePage homePage;
	LoginPage loginPage;
	TestUtill testUtill;
	RegistrationPage registrationPage;
	static String sheetName="Reg1";

	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		loginPage = new LoginPage();
		testUtill = new TestUtill();
		registrationPage = new RegistrationPage();

	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		homePage.validatPageTitle();
		String title = loginPage.validatePageTitle();
		Assert.assertEquals(title, "WildFire Cart", "Title of is 'WildFire Cart' not Available!!");
	}

	@DataProvider
	public Object[][] getMCOTestData() {
		Object [][]data  = TestUtill.getTestData(sheetName);
		return data;
	}
	@Test(priority=2,dataProvider="getMCOTestData")
	public void newUserRegistrationTest(String email,String userName, String password, 
		String confirmPassword, String firstName, String lastName, String address) throws IOException {
		registrationPage.validateNewUserRegistration(email, userName, password, confirmPassword, firstName, lastName, address);
		loginPage.validatCurentUserName();
		//registrationPage.validatCurentUserName();
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
