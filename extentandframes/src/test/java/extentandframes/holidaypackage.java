package extentandframes;


	import java.util.ArrayList;
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.WindowType;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
	import io.github.bonigarcia.wdm.WebDriverManager;
	public class holidaypackage extends util {
		public static String url="https://www.makemytrip.com/";
		WebDriver driver;
		ExtentHtmlReporter htmlReporter;
		ExtentReports extent;
		ExtentTest test;
		@BeforeTest
		public void beforetest() throws InterruptedException
		{
			htmlReporter = new ExtentHtmlReporter("extent.html");
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		@Test
		public void test() throws InterruptedException
		{
			test = extent.createTest("Makemytrip");
			test.pass("you are in MakeMytrip Website");
			Thread.sleep(7000);
			driver.findElement(By.linkText("Holiday Packages")).click();
			test.pass("you clicked Holiday packages");
			driver.findElement(By.xpath("//*[@id='fromCity']")).click();
			driver.findElement(By.xpath("//*[text()='Bangalore']")).click();
			test.pass("you selected Bangalore");
			driver.findElement(By.id("toCity")).click();
			driver.findElement(By.xpath("//*[@class='dest-search-input']")).sendKeys("singapore");
			driver.findElement(By.xpath("//div[text()='Singapore']")).click();
			test.pass("you selected Singapore");
			Thread.sleep(6000);
			driver.findElement(By.xpath("//button[@data-cy='submit']")).click();
			test.pass("you are travelling from Bangalore to Singapore");
			Thread.sleep(9000);
			driver.findElement(By.xpath("//*[@id='departure_date']")).click();
			Thread.sleep(9000);
			driver.findElement(By.xpath("//div[@aria-label='Thu Nov 17 2022']")).click();
			test.pass("you selected 17th NOV");
			Thread.sleep(6000);
			driver.findElement(By.xpath("//*[@class='primaryBtn big fill btn btn-top-nav btn-lg']")).click();
			Thread.sleep(6000);
			WebElement slider=driver.findElement(By.xpath("//*[@class='flexOne makeFlex']/div[3]//div/div//div/div[5]"));
			Thread.sleep(6000);
			Actions ac=new Actions(driver);
			Thread.sleep(6000);
			ac.dragAndDropBy(slider,-170,0).build().perform();
			Thread.sleep(7000);
			util.scrollIntoView(slider, driver);
			test.pass("you are scrolling the page");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@class='Container']/div/div[4]/div/div[2]/div/div/div/div/div")).click();
			test.pass("you are slected a short trip to singapore");
			Thread.sleep(5000);
			System.out.println(driver.getTitle());
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			int s=tabs.size();
			System.out.println(s);
			driver.switchTo().window(tabs.get(1)); //switches to new tab
			Thread.sleep(8000);
			WebElement slider1=driver.findElement(By.xpath("//*[@class='hotel-row-wrapper ']/div/div/div/span"));
			slider1.click();
			util.scrollIntoView(slider1, driver);
			test.pass("you clicked on change hotel");
			Thread.sleep(8000);
			WebElement hotel =driver.findElement(By.xpath("//*[@class='sidePanelBody']/div[2]/div[2]/div[7]/span"));
			hotel.click();
			test.pass("you slected another hotel");
			Thread.sleep(8000);
			driver.findElement(By.xpath("//*[@class='makeFlex column packageUpdate']/div/p")).click();
			test.pass("you are updating package");
			Thread.sleep(8000);
			WebElement pac=driver.findElement(By.xpath("//*[@class='add-activity-container']/div[2]"));
			pac.click();
			util.scrollIntoView(pac, driver);
			test.pass("you are selected add activity");
			Thread.sleep(8000);
			WebElement wc1=driver.findElement(By.xpath("//*[@class='sidePanelBody']/div[2]/div[2]/div[3]/span"));
			wc1.click();
			util.scrollIntoView(wc1, driver);
			test.pass("you are activity to ur package");
			Thread.sleep(8000);
			driver.findElement(By.xpath("//*[@class='makeFlex column packageUpdate']/div/p")).click();
			Thread.sleep(7000);
			driver.findElement(By.xpath("//*[@class='initerary-nav']/li[2]")).click();
			test.pass("you  clicked on flights panel");
			Thread.sleep(8000);
			driver.findElement(By.xpath("//*[@class='initerary-nav']/li[3]")).click();
			test.pass("you clicked on Hotel panel");
			Thread.sleep(8000);
			driver.findElement(By.xpath("//*[@class='initerary-nav']/li[4]")).click();
			test.pass("you clicked on transfers panel");
			Thread.sleep(8000);
			driver.findElement(By.xpath("//*[@class='initerary-nav']/li[5]")).click();
			test.pass("you clicked on acitivity panel");
			Thread.sleep(8000);
			driver.quit();
			extent.flush();
		}
	}


