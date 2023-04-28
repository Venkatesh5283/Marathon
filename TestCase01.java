package Marathon_Salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import defaultpackage.BaseClass;

public class TestCase01 extends BaseClassMarathon {

	@BeforeTest
	public void readData() {
		
		filename = "TestCase1Data";
	}
	
	@Test(dataProvider="fetchData")
	public  void runTestCase01(String question, String details) throws InterruptedException {
		// TODO Auto-generated method stub

//		1.Launch https://login.salesforce.com/ 
//			2. Log in to Salesforce with your username and password
//			3. Click on the App Launcher (dots)
//			4. Click View All
//			5. Type Content on the Search box
//			6. Click the Content Link
//			7. Click on Chatter Tab
//			8. Verify the Chatter title on the page
//			9. Click the Question tab
//			10. Type a Question with data (coming from Excel)
//			11. Type Details with data (coming from Excel)
//			12. Click Ask
//			13. Confirm the question appears
//			14. Close the browser
		

		
		
		
		
		driver.findElement(By.xpath("//input[@part='input']")).sendKeys("Content");

		driver.findElement(By.xpath("//mark[text()='Content']")).click();

		Thread.sleep(5000);

		driver.findElement(
				By.xpath("//one-app-nav-bar-item-root[@class='navItem slds-context-bar__item slds-shrink-none']"))
				.click();

		driver.findElement(By.xpath("(//span[@class='title'])[3]")).click();
		Thread.sleep(2000);
		String title = driver.getTitle();
		
		if (title.contains("Chatter")) {
			System.out.println("Title is verified and it was in Chatter");
		} else {
			System.out.println("Title is verified and it was not in Chatter");
		}

		driver.findElement(By.xpath("//textarea[@class='cuf-questionTitleField textarea']"))
				.sendKeys(question);

		driver.findElement(By.xpath("//div[@contenteditable='true']")).sendKeys(details);
		driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-button_brand')]")).click();
		String verifydata = driver.findElement(By.xpath("(//span[@class='uiOutputText'])[3]")).getText();

		if (verifydata.contains(question)) {
			System.out.println("Question Appeared");
		} else {
			System.out.println("Question Not Appeared");
		}
		
	}

}
