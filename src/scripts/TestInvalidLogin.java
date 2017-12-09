package scripts;

import org.testng.annotations.Test;
import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;

public class TestInvalidLogin extends BaseTest{
	
	@Test
	public void testLogin() throws InterruptedException {
		LoginPage loginpage = new LoginPage(driver);
		
		int rowCount = Lib.getRowCount(EXCEL_PATH, "InvalidLogin");
		for(int i = 1; i < rowCount; i++) {
			String username = Lib.getCellValue(EXCEL_PATH, "InvalidLogin", i, 0);	
			String password = Lib.getCellValue(EXCEL_PATH, "InvalidLogin", i, 1);
			
			loginpage.setUsername(username);
			loginpage.setPassword(password);
			loginpage.clickLogin();
		}
		
		
		
	}
	

}
