package TestCase;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import ExcelLibrary.ExcelLibrary;
import KeywordActions.keywordActions;
import frameWorkConstants.FrameWorkConstant;

public class TC_DWS_Search_001Test {

	@Test
	public void enteringText() throws EncryptedDocumentException, IOException, InterruptedException {
		ExcelLibrary excel = new ExcelLibrary();
		ArrayList<String> data = excel.readFromExcel();

		System.out.println(data);
		
		keywordActions key = new keywordActions();
		for (int i = 0; i < data.size(); i++) {
			String keyword = data.get(i);
			switch (keyword) {
			case "openBrowser":
				key.openBrowser();
				break;
			case "navigate":
				key.navigate();
				break;
			case "enterText":
				key.enterText("SearchTextField", "smartphone");
				break;
			case "click":
				key.click("SearchButton");
				break;
			case "loginLink":
				key.click("loginLink");
				break;
			case "email":
				key.enterText("email", FrameWorkConstant.email);
				break;
			case "password":
				key.enterText("password", FrameWorkConstant.password);
				break;
			case "loginButton":
				key.click("loginButton");
				break;
			case "logoutLink":
				key.click("logoutLink");
				break;
			case "wait":
				Thread.sleep(1000);
				break;
			case "close":
				key.closeWindow();

			}
		}

	}
}
