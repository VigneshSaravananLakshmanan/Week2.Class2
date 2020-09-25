package week2.Day2;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditPage {
	
	public static void main(String[] args) {
		
		/* Establishing the Web driver */
		WebDriverManager.chromedriver().setup();
		
		/* Launch the Chrome browser */
		
		ChromeDriver driver = new ChromeDriver();
		
		/*  Maximize the window */
		driver.manage().window().maximize();
		
		
		
		/* Launch the URL */
		driver.get("http://leafground.com/pages/Edit.html");
		
		/* Find the textbox using Sibling Xpath */
		driver.findElementByXPath("//label[text()='Enter your email address']/following-sibling::input").sendKeys("vigneshpollachi@gmail.com");
		
		
		/* Append the Text in the text box */
		String textElement = driver.findElementByXPath("(//div[contains(@class,'large')])[2]/input").getText();
		
		/* value to be appended */
		String AppendElement = "Appended";
		
		/* concatenating value */
		AppendElement = textElement + " "+ AppendElement;
		
		
		/* Sending the appended value into the textbox */
		driver.findElementByXPath("(//div[contains(@class,'large')])[2]/input").sendKeys(AppendElement);
		
		driver.findElementByXPath("(//div[contains(@class,'large')])[2]/input").sendKeys(Keys.TAB);
		
		
		/* Get Default text entered */
		
		String DefaultValue = driver.findElementById("(//div[contains(@class,'large')])[3]/input").getText();
		
		System.out.println("The default value available in the text box is "+DefaultValue);
		
		
		
		/* Clear the text -  Grandparent-GrandChild relationship */
		driver.findElementByXPath("//div[@class='example'][4]//input[contains(@value,'Clear')]").clear();
		
       
		
		/* Confirm that the edit field is disabled using Xpath */
		boolean Enabled = driver.findElementByXPath("//label[@for='disabled']/following-sibling::input").isEnabled();
				
		
		if(Enabled == false)
		{
			System.out.println("The field is enabled");
		}
		else
		{
			System.out.println("The field is disabled");
		}
			
		
	}

}
