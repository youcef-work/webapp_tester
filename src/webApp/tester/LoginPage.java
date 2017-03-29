package webApp.tester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	final String LOGIN_PAGE = "http://localhost:3000/login";
	final String USERNAME = "steve";
	final String PASSWORD = "steve";
	final String USERNAME_XPATH = "//*[@id='username-input']";
	final String PASSWORD_XPATH = "//*[@id='password-input']";
	final String LOGIN_XPATH = "html/body/my-app/div/login/div/form/div[3]/button[1]";
	final String CANCEL_XPATH = "html/body/my-app/div/login/div/form/div[3]/button[0]";
	final static int MAX_ATTEMPTS = 3;
	static int attempts = 0;
	WebDriver webDriver;
	
	public void login(String browser, String username, String password, boolean isPass){
		switch (browser){
			default:
			case "firefox":
				System.setProperty("webdriver.gecko.driver","geckodriver.exe");		
				webDriver = new FirefoxDriver();
				break;
			case "chrome":
				System.setProperty("webdriver.chrome.driver","chromeDriver.exe");
				webDriver = new ChromeDriver();
				break;
			case "ie":
				System.setProperty("webdriver.ie.driver","IEDriverServer.exe");
				webDriver = new InternetExplorerDriver();						
				break;		
		}
				
		//2. Open login page page
		webDriver.get(LOGIN_PAGE);
		String title = webDriver.getTitle();
		System.out.println("Page title is: " + title);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Thread.sleep() caused the exception" + e.getMessage());
		}
	
		//3. Find Username field, and enter "steve"
		WebElement we;
		new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(USERNAME_XPATH)));
		we = webDriver.findElement(By.xpath(USERNAME_XPATH));		
		System.out.println("WebElement = " + we);
		we.clear();
		we.sendKeys(username);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Thread.sleep() caused the exception" + e.getMessage());
		}
		
		//4. Find Password field, and enter "steve"
		new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(PASSWORD_XPATH)));
		we = webDriver.findElement(By.xpath(PASSWORD_XPATH));
		we.clear();
		we.sendKeys(password);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Thread.sleep() caused the exception" + e.getMessage());
		}
		
		//5. Find button "Login", and click on it
		we = webDriver.findElement(By.xpath(LOGIN_XPATH));
		we.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Thread.sleep() caused the exception" + e.getMessage());
		}

		//6. From login page, check page title is ""
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
