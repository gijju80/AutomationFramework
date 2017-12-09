package scripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;

public class TestLogin extends BaseTest{
	
	@Test
	public void testLogin() throws InterruptedException {
		LoginPage lgnpg = new LoginPage(driver);
		String un = Lib.getCellValue(EXCEL_PATH, "ValidLogin", 1, 0);
		String pw = Lib.getCellValue(EXCEL_PATH, "ValidLogin", 1, 1);
		String expectedTitle = Lib.getCellValue(EXCEL_PATH, "ValidLogin", 1, 2);
		
		lgnpg.setUsername(un);
		lgnpg.setPassword(pw);
		lgnpg.clickLogin();
		Thread.sleep(10000);
		
		String actualTitle = driver.getTitle();
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(actualTitle, expectedTitle);
		softassert.assertAll();
	}
}