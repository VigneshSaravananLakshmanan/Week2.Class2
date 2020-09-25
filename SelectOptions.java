package week2.Day2;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectOptions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* Establish the WebDriver */
		WebDriverManager.chromedriver().setup();
		
		/* Launch the Chrome browser using the ChromeDriver Class */
		ChromeDriver driver = new ChromeDriver();
		
		/* maximize the Chrome window */
		driver.manage().window().maximize();
		
		/* Enter the URL */
		driver.get("http://leafground.com/pages/Dropdown.html");
		
		
		
		/* Select Training program by index */
		WebElement Index = driver.findElementByXPath("//section[contains(@class,'innerblock')]//select");
		
		  /* To use dropdown utilze the Select class */
		  Select Dd1 = new Select(Index);
		  
		  /* Select the value by Index 
		   ________________________  */
		  
		  /* Consolidating all the elements of the dropdown in a signle List variable */
		  List<WebElement> options = Dd1.getOptions();
		  
		  /* Calculating the index */
		  int size = options.size();
		  
		  /* Selecting the option Selenium using index */
		  Dd1.selectByIndex(1);
		  
		  /* Verifying if Selenium is selected in dropdown */
		  
		  String text = driver.findElementByXPath("//section[contains(@class,'innerblock')]//select").getText();
		  
		  
		  if(text.contains("Selenium"))
		  {
			  System.out.println("The right index value is selected");
			  
		  }
		  else
		  {
			  System.out.println("Incorrect index value is chosen");
		  }
		  
		  
		/* ---------Select Training program using Text ---------*/
		  
		  /* Identify the element */
		  WebElement Trainingpgm = driver.findElementByXPath("(//section[contains(@class,'innerblock')]//select)[2]");
		  
		  /* To use dropdown utilze the Select class */
		  Select Dd2 = new Select(Trainingpgm);
		  
		  Dd2.selectByVisibleText("Selenium");
		  
		  
		  /* ---------Select Training program using Value ---------*/
		  /* Identify the element */
		  WebElement value = driver.findElementByXPath("(//section[contains(@class,'innerblock')]//select)[3]");
		  
		  /* To use dropdown utilze the Select class */
		  Select Dd3 = new Select(value);
		  
		  Dd3.selectByValue("1");
		  
		  
		  /* Get the number of dropdown options */
		  /* Identify the element */
		  WebElement count = driver.findElementByXPath("(//section[contains(@class,'innerblock')]//select)[4]");
		  
		  /* To use dropdown utilze the Select class */
		  Select Dd4 = new Select(count);
		  
		  /* Storing up all the values into a single variable */
		  int var = Dd4.getOptions().size();
		  
		  System.out.println("The options available in this Select dropdown is "+(var-1));
		  
		  
		  /* Selecting the options using Send Keys */
		  
		  /* Identify the element and send the keys */
		  driver.findElementByXPath("(//section[contains(@class,'innerblock')]//select)[5]").sendKeys("Selenium");
		  
		  String SendKeyValue = driver.findElementByXPath("(//section[contains(@class,'innerblock')]//select)[5]").getText();
		  
		  if(SendKeyValue.contains("Selenium"))
		  {
			  System.out.println("The options in the select box can be selected using the SendKeys");
		  }
		  else
		  {
			  System.out.println("The options in the select box cannot be selected using the SendKeys");
		  }
		  
		  
		  
		 /* Select your program */
		  
		  /* identify the element */
		  WebElement SelectUrpgm = driver.findElementByXPath("//option[contains(text(),'programs')]");
		  
		  System.out.println("The web element to chose is identified");
		    
		  
		  /* To use dropdown utilze the Select class */
		  Select Dd5 = new Select(SelectUrpgm);
		  
		 /* collating all the elements into a single variable */
		  List<WebElement> AllElements = Dd5.getOptions();
		  
		  System.out.println("The size of the SelectUrPgm is "+AllElements.size());
		  
		  /* To select all elements of the combo box */
		  
		  for(WebElement multiselect:AllElements)
		  {
			 System.out.println(multiselect.getText());
		  }
		  
		  driver.navigate().back();
		  
		  /* to close the current browser */
		  driver.close();

		 	  
		  
		  
	}

}
