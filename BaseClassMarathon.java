package Marathon_Salesforce;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class BaseClassMarathon {

	public RemoteWebDriver driver;
	public String filename;
	
	@Parameters({"browser", "url", "username", "password"})
	
	@BeforeMethod
	public void preCondition(String browser1, String url, String user1, String pass1) throws InterruptedException
	{
		if(browser1.equalsIgnoreCase("Chrome"))
		{
			ChromeOptions copt = new ChromeOptions();
			copt.addArguments("--disable-Notifications");
			driver = new ChromeDriver(copt);
		}
		else if(browser1.equalsIgnoreCase("Edge"))
		{
			EdgeOptions eopt=new EdgeOptions();
			eopt.addArguments("--diable-Notifications");
			driver=new EdgeDriver(eopt);
		}
		 
		
		 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);

		driver.findElement(By.id("username")).sendKeys(user1);
		driver.findElement(By.id("password")).sendKeys(pass1);
		driver.findElement(By.id("Login")).click();
		Thread.sleep(3000);

		driver.findElement(By.className("slds-icon-waffle")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
	}
	
	
	
	@AfterMethod
	public void postCondition()
	{
		driver.close();
	}
	
	@DataProvider(name="fetchData")
	public String[][] sendData() throws IOException {
		
		String[][] excelDataFetching = ExcelIntegrationMarathon.excelDataFetching(filename);
		return excelDataFetching;
		
	}
}
