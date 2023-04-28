package Marathon_Salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import defaultpackage.BaseClass;

public class TestCase02 extends BaseClassMarathon {
	
	
	@BeforeTest
	public void readData() {
		
		filename = "TestCase2Data";
	}
	
	@Test(dataProvider="fetchData")
	public  void runTestCase02(String oppName, String amount) throws InterruptedException {
		// TODO Auto-generated method stub
				
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(3000);
	
		WebElement findElement2 = driver.findElement(By.xpath("//a[@aria-label='View All Key Deals']"));
		driver.executeScript("arguments[0].click();", findElement2);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@title='New']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@part='input'])[3]")).sendKeys(oppName);
		
		driver.findElement(By.xpath("(//button[@data-value='--None--'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='New Customer']")).click();
		Thread.sleep(3000);
		Actions abt=new Actions(driver);
		WebElement scroll2 = driver.findElement(By.xpath("//label[text()='Order Number']/following::input"));
		abt.scrollToElement(scroll2).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox__input slds-input_faux')])[3]")).click();
		Thread.sleep(3000);
	     driver.findElement(By.xpath("//span[text()='Partner Referral']")).click();
	    Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@class='slds-input'])[2]")).sendKeys(amount);
		Thread.sleep(3000);
	
		driver.findElement(By.xpath("(//input[@class='slds-input'])[3]")).sendKeys("29/4/2023");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(@class,'slds-combobox__input slds-input_faux')]")).click();
		
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Search Campaigns...']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@title='REST API']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
		Thread.sleep(3000);
		
		
		Thread.sleep(3000);
		
		WebElement findElement=driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-button_neutral')]"));
		findElement.click();
		Thread.sleep(2000);
		
		String OptTitle = driver.findElement(By.xpath("(//span[@class='slds-text-body--regular slds-text-color--default slds-truncate slds-show'])[4]")).getAttribute("title");
		System.out.println(OptTitle);
		
		
		if(OptTitle.contains("Salesforce Automation By Venky"))
		{
			System.out.println("Oppurtunity Name is Verified Successfully and it was presented");
		}
		else
		{
			System.out.println("Oppurtunity Name is Verified Successfully and it was not presented");

		}
		
	}

}
