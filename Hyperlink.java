package week2.Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Hyperlink {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		/* Establishing the Web driver */
		WebDriverManager.chromedriver().setup();
		
		/* Launch the Chrome browser */
		
		ChromeDriver driver = new ChromeDriver();
		
		/*  Maximize the window */
		driver.manage().window().maximize();
		
		
		
		/* Launch the URL */
		driver.navigate().to("http://leafground.com/pages/Button.html");
		
		/* wait for the page to load 
		Thread.sleep(2000);*/
		
		/* click on Home page button */
		driver.findElementByXPath("//button[contains(@onclick,'window')]").click();
		
		/* wait for the page to load */
		Thread.sleep(2000);
		
		/* Click on Hyperlink button */
		driver.findElementByXPath("(//a[contains(@class,'wp-categories-link')][contains(@href,'pages')])[2]/following::a[contains(@href,'pages')]").click();
		
		/* halt for the page to load */
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		
		
		/* Click on Go to home page button */
		driver.findElementByXPath("//div[@class='row']//a").click();
		
		/* wait for the page to load */
		Thread.sleep(2000);
		
		
		/* Click on Hyperlink button */
		driver.findElementByXPath("(//a[contains(@class,'wp-categories-link')][contains(@href,'pages')])[2]/following::a[contains(@href,'pages')]").click();
		
		
		/* Find Where am I supposed to go with this link */
		
		driver.findElementByXPath("//a[@link='blue'][@href='Button.html']").click();
		
		/* wait for the page to load */
		Thread.sleep(2000);
		
		String PageURL = driver.getCurrentUrl();
		
		if(PageURL.contains("Button.html"))
		{
			System.out.println("The expected page is landed");
		}
		else
		{
			System.out.println("An incorrect page is navigated");
		}
		
		/* Click on Go to home page button */
		driver.findElementByXPath("//div[@class='row']//button").click();
		
		/* wait for the page to load */
		Thread.sleep(2000);
		
		/* Click on Hyperlink button */
		driver.findElementByXPath("(//a[contains(@class,'wp-categories-link')][contains(@href,'pages')])[2]/following::a[contains(@href,'pages')]").click();
		
		
		/* Make an implicit wait of 2 seconds */
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		
        /* Verify I am broken */
		driver.findElementByXPath("//a[text()='Verify am I broken?']").click();
		
		/* wait for the page to load */
		Thread.sleep(2000);
		
		String PageTitle = driver.getPageSource();
		
		if(PageTitle.contains("error.html"))
		{
			System.out.println("The page is landed into Play with Hyperlinks page");
			
			/* Navigate back to home page */
			driver.navigate().back();
			
		}
		else
		{
			System.out.println("The page has no error");
		}
		
		/* Navigating back to Home page using Preceding Xpath */	
		
		driver.findElementByXPath("//label[@for='position'][contains(text(),'Interact')]/preceding-sibling::a").click();
		
		/* induce wait time of 2 seconds */
		Thread.sleep(2000);
		
		/* click on the hyperlink again using Preceding option */
		driver.findElementByXPath("(//a[contains(@class,'wp-categories')][contains(@href,'pages')])[4]/preceding::img[1]").click();
		
		/* halt for 5 seconds */
		Thread.sleep(5000);
		
		
		/* close the browser */
		driver.close();
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
