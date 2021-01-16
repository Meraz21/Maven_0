package com.mco.utill;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mco.base.TestBase;

public class TestUtill extends TestBase{
	//Wait Functions
	public static long PAGE_LOAD_TIME_OUT = 20;
	public static long IMPLECITELY_WAIT_TIME = 20;

	//DataProvider Functions
	public static String TESTDATA_SHEET_PATH ="/Users/khosruzzaman/Downloads/MultiCartOnline/src/main/java/com/mco/testData/"
			+ "MultiCartTestData.xlsx"; 
	static Workbook book;
	static Sheet sheet ;
	public static FileInputStream file;
	
	
	public static Object[][] getTestData(String sheetName) {
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try  {
			book = WorkbookFactory.create(file);
			}catch (IOException e ) {
				e.printStackTrace();
			}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		System.out.println(sheet.getLastRowNum()+"======="+sheet.getRow(1).getLastCellNum());
		
		for(int i =0; i< sheet.getLastRowNum(); i++) {
			for(int k = 0; k<sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k]= sheet.getRow(i+1).getCell(0).toString();
				System.out.println(data[i][k]+" ");
			}
		}
		return data;
	}
	public static void takeScreenshotAtEndOfTest() throws IOException{
		File scrfile =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrfile, new File(currentDir + "/Screenshots/"+ System.currentTimeMillis()+".png"));
	}
	public static void expWait(String locators) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locators)));
	}
	public static String selectClasses(WebElement valu) {
		Select select = new Select(valu);
		return null;
		
	}
	
	
}

/*
// Waiting 30 seconds for an element to be present on the page, checking
// for its presence once every 5 seconds.
Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
    .withTimeout(30, SECONDS)
    .pollingEvery(5, SECONDS)
    .ignoring(NoSuchElementException.class);

WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
  public WebElement apply(WebDriver driver) {
    return driver.findElement(By.id("foo"));
  }
});*/













