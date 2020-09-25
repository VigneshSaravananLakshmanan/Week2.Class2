package week2.Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Images {

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
		
		/* halt for 2 seconds */
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		/* click on Home page button */
		driver.findElementByXPath("//button[contains(@onclick,'window')]").click();
		
		/* Click on Image button */
		driver.findElementByXPath("//img[@alt='Images']").click();
		
		/* halt for 2 seconds */
		Thread.sleep(2000);
		
		 System.out.println("On clicking the Image link, the page gets landed into "+""+ driver.getTitle());
		 
		 
		 
		 /* click on Image to go home */
		 driver.findElementByXPath("//img[contains(@onclick,'window')]").click();
		 
		 System.out.println("The home page "+""+ driver.getTitle()+""+"is navigated");
		 
		 /* Am I broken */
		 
		 /*driver.findElementByXPath("//label[text()='Am I Broken Image?']/following-sibling::img").click();
		 
		 System.out.println("On clicking on Am i broken link, nothing gets executed.");*/
		 
		 
		 /* clicking the image using the double click  key */
		 
		 /* From the home page, click on Image link */
		 driver.findElementByXPath("//img[@src='images/image.png']").click();
		 
		 /* import the class Actions to perform relevant action */
		 
		 Actions mouseclick = new Actions(driver);
		 
		 /* Identify the image that needs to be double clicked */
		 
		 mouseclick.doubleClick(driver.findElementByXPath("//label[@for='position'][text()='Click me using Keyboard or Mouse']/following-sibling::img"));
		 
		 
		 /* halt for 5 seconds */
		 Thread.sleep(5000);
		 
		 String HomeURL = driver.getCurrentUrl();
		 
		 System.out.println("The URL of the landed page is "+""+HomeURL);
		 
		 if(HomeURL.contains("Playground"))
		 
		 {
			 System.out.println("The home page is landed");
			 }
		 else
			 { 
			 System.out.println("Error in landing to home page");
			 };
			 
			 
			 driver.close();
		

	}

}
