package KeywordActions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import frameWorkConstants.FrameWorkConstant;

public class keywordActions {

	WebDriver driver;

	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(FrameWorkConstant.implicitWait));
	}

	public void navigate() {
		driver.get(FrameWorkConstant.url);
	}

	public void enterText(String objectName, String text) throws IOException {
		driver.findElement(objectLocator(objectName)).sendKeys(text);
	}

	public By objectLocator(String objectName) throws IOException {
		File file = new File("./src/test/resources/PropertyFile/Locators.properties");
		FileInputStream fis = new FileInputStream(file);

		Properties prop = new Properties();
		prop.load(fis);

		return By.xpath(prop.getProperty(objectName));
	}

	public void click(String objectName) throws IOException {
		driver.findElement(objectLocator(objectName)).click();
	}

	public void closeWindow() {
		driver.close();
	}

}
