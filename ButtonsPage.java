package week2.Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonsPage {
	
	public static void main(String[] args) throws InterruptedException {
		
			
			/* Establishing the Web driver */
			WebDriverManager.chromedriver().setup();
			
			/* Launch the Chrome browser */
			
			ChromeDriver driver = new ChromeDriver();
			
			/*  Maximize the window */
			driver.manage().window().maximize();
			
			
			
			/* Launch the URL */
			driver.navigate().to("http://leafground.com/pages/Button.html");
			
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
			
			/* get the Page Title */
			String PageTitle = driver.getTitle();
			
			if(PageTitle.contains("TestLeaf"))
			{
				
				driver.findElementByXPath("//button[contains(@onclick,'window.location')]").click();
				
				/* halt for 2 seconds after the page gets loaded */
				Thread.sleep(2000);
				
				String buttonTitle = driver.getTitle();
				
				if(buttonTitle.contains("Selenium"))
						
						{
					System.out.println("The home page is navigated");
					
					driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
						}
				else
				{
					System.out.println("Error in page navigation");
				}
				
				driver.findElementByXPath("//a[contains(@class,'wp-categories')]/img[@alt='Buttons']").click();
				
				Thread.sleep(2000);
				
				
				/* Find the position of X, Y button using Xpath - sibling locator */
				
				Point location = driver.findElementByXPath("//label[@for='position'][contains(text(),'position')]/following-sibling::button").getLocation();
				
				System.out.println("The horizontal point of the button location is "+location.getX());
				
				System.out.println("The Vertical location point of the button location is "+location.getY());
				
				
				/* Find Button Colour */
				System.out.println(driver.findElementByXPath("(//label[@for='position'][contains(text(),'button')])[2]/following-sibling::button").getCssValue("background-color"));
				
				
				/* Find the height and Width */
				Dimension size = driver.findElementByXPath("(//label[@for='position' and contains(text(),'Find')])[3]/following-sibling::button").getSize();
				
				System.out.println("The height of the button is "+""+size.getHeight());
				System.out.println("The width of the button is "+""+size.getWidth());
				
				/* close the browser */
				driver.close();
				   
			}
			
			
			
			
	}

}
