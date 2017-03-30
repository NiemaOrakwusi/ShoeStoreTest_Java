/*Selenium WebDriver and JUnit Test verify items within a page is present and email functions are working.*/

package ShoeStore;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;




public class ShoeTest {
		 
	//Initialize the WebDriver
	public static WebDriver drv;
	
	//Start BeforeClass to provide startup of the application
	@BeforeClass
	public static void start(){
		
		//Assigned the WebDriver
		drv = new FirefoxDriver();
		
		//Retrieved the URL
		drv.get("http://shoestore-manheim.rhcloud.com/");
		
		//Put a pause or wait for 60 second
		drv.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	}//end start 
	//Start of First Test
	@Test
	public void CheckItems() {
		
		//Find the Element from the link and click
		drv.findElement(By.linkText("All Shoes")).click();
		
		//Put a pause or wait for 60 second
		drv.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		//Initialized a list and assigned it to a Element
		List<WebElement> test = drv.findElements(By.className("shoe_description"));
		
		
		int Size = 0;
		
		//Created a for loop to Initialize a new WebElement to retrieve multiple elements within the page for this CLassName
		for(WebElement dk : test)
		{
			//if statement to verify elements are present
			if(dk.isDisplayed()) {
				Size++;
				
				//Display the results of the loop
				System.out.println(dk.getText());
			}//end if
		}//end for loop
		
		//Put a pause or wait for 60 second
		drv.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		//Initialized a list and assigned it to a Element
		List<WebElement> tests = drv.findElements(By.className("shoe_price"));
		
		int Sizes = 0;
		
		//Created a for loop to Initialize a new WebElement to retrieve multiple elements within the page for this CLassName
		for(WebElement dkf : tests)
		{
			//if statement to verify elements are present
			if(dkf.isDisplayed()) {
				Sizes++;
				
				//Display the results of the loop
				System.out.println(dkf.getText());
			}//end if
		}//end for
		
		//Put a pause or wait for 60 second
		drv.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		//Initialized a list and assigned it to a Element
		List<WebElement> ImageFile = drv.findElements(By.xpath("//table/tbody/tr[6]/td[1]"));
        
		
		int Sixed = 0;
		//Created a for loop to Initialize a new WebElement to retrieve multiple elements within the page for this CLassName
		for(WebElement dfj : ImageFile){
			
			//if statement to verify elements are present
        	if (dfj == null){
        		Sixed++;
        		//String product;
        		
        		//Display the results is not displayed
        		System.out.println(dfj.isDisplayed());
        		
        	}
        	else
        	{
        		//Display the results is displayed  		
        		System.out.println(dfj.isDisplayed());
        		
        	}//end if/else
		}//end for 
		
		//Put a pause or wait for 60 second
		drv.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		//Close the WebDriver
		drv.close();
		
	}//end CheckItems
	@Test
	public void Email(){
		
		//Retrieved the URL
		drv.get("http://shoestore-manheim.rhcloud.com/");
		
		//Put a pause or wait for 60 second
		drv.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		//Initialized a WebElement and assigned it to a Element
		WebElement emails = drv.findElement(By.id("remind_email_input"));
		
		//Input the email address into the email element
		emails.sendKeys("emailaddress@yahoo.com");
		
		//Locate a Element and Click to send the email
		drv.findElement(By.xpath("//html//body//header//form[1]//div//input[2]")).click();
		
		//Put a pause or wait for 60 second
		drv.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		//Initialized a string and assigned it to a Element to retrieve the text
		String fnd = drv.findElement(By.xpath("//html//body//div[4]//div")).getText();
		
		//Put a pause or wait for 60 second
		drv.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		//Assert to verify the message is present
				
		Assert.assertTrue(fnd.contains("Thanks! We will notify you of our new shoes at this email:"));

		//Initialized a string and assign the message to display at a certain point with substring
		String foe3 = fnd.substring(0,59);
		
		//Initialized a string and assign the message to display at a certain point with indexOf
		String foe4 = fnd.substring(fnd.indexOf(':') + 1).toString();
		
		
		//Print Displayed the message indexof
		System.out.println(foe3 + foe4);
		
		//Assert to verify the message is present with user email
		Assert.assertEquals(fnd, "Thanks! We will notify you of our new shoes at this email:" + foe4);
		
	}//end of Email
		@AfterClass
		public static void CleanUp(){
				
		//Print Displayed of the results of the test.
		System.out.println("Test Successful");
		
		//Close all Webdriver
		drv.close();
		
	}
}


