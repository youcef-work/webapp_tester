package webApp.tester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonSearchPage {
	final String PERSON_SEARCH_PAGE = "http://localhost:3000/person";
	final String FIRST_NAME = "steve";
	final String LAST_NAME  = "steve";
	final String OTHER_NAME = "steve";
	final String FIRST_NAME_XPATH = "//*[@id='firstname-input']";
	final String LAST_NAME_XPATH  = "//*[@id='lastname-input']";
	final String OTHER_NAME_XPATH = "//*[@id='othername-input']";
	final String SEARCH_XPATH = "html/body/my-app/div/login/div/form/div[3]/button[1]";
	final String CANCEL_XPATH = "html/body/my-app/div/login/div/form/div[3]/button[0]";
	WebDriver webDriver;
	
	public void personSearch(String browser, String firstName, String lastName, String other, boolean isPass){
		switch (browser){
			default:
			case "firefox":
				System.setProperty("webdriver.gecko.driver","C:\\Users\\IBM_ADMIN\\workspace_Selenium\\geckodriver.exe");		
				webDriver = new FirefoxDriver();
				break;
			case "chrome":
				System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromeDriver.exe");
				webDriver = new ChromeDriver();
				break;
			case "ie":
				System.setProperty("webdriver.ie.driver","C:\\Program Files\\Internet Explorer\\IEDriverServer.exe");
				webDriver = new InternetExplorerDriver();						
				break;		
		}
				
		//2. Open login page page
		webDriver.get(PERSON_SEARCH_PAGE);
		String title = webDriver.getTitle();
		System.out.println("Page title is: " + title);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Thread.sleep() caused the exception" + e.getMessage());
		}
	
		//3. Find First Name field, and enter "steve"
		WebElement we;
		new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(FIRST_NAME_XPATH)));
		we = webDriver.findElement(By.xpath(FIRST_NAME_XPATH));		
		System.out.println("WebElement = " + we);
		we.clear();
		we.sendKeys(firstName);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Thread.sleep() caused the exception" + e.getMessage());
		}
		
		//4. Find Last Name field, and enter "pickup"
		new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(LAST_NAME_XPATH)));
		we = webDriver.findElement(By.xpath(LAST_NAME_XPATH));
		we.clear();
		we.sendKeys(lastName);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Thread.sleep() caused the exception" + e.getMessage());
		}
		
		//5. Find Other Name field, and enter "pickup"
		new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(OTHER_NAME_XPATH)));
		we = webDriver.findElement(By.xpath(OTHER_NAME_XPATH));
		we.clear();
		we.sendKeys(lastName);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Thread.sleep() caused the exception" + e.getMessage());
		}
		
		//6. Find button "Search", and click on it
		we = webDriver.findElement(By.xpath(SEARCH_XPATH));
		we.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Thread.sleep() caused the exception" + e.getMessage());
		}

		//7. From Person page, check page title is ""
		System.out.println("Web page title: " + webDriver.getTitle());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Thread.sleep() caused the exception" + e.getMessage());
		}

	}

	public void close(){
		//7. Close the page
		System.out.println("Closing Web Browser...");
		webDriver.quit();
	}
}
