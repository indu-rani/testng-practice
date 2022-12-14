package extentandframes;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	import io.github.bonigarcia.wdm.WebDriverManager;
	public class frames {
		public static String url="https://jqueryui.com/droppable/";
		WebDriver driver;
		@BeforeTest
		public void Test() throws InterruptedException
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.get(url);
			driver.manage().window().maximize();
			Thread.sleep(3000);
		}
		@Test()
		public void Test1() throws InterruptedException
		{
			driver.findElements(By.tagName("iframe")).size();
			
			System.out.println(driver.findElements(By.tagName("iframe")).size());
			//driver.switchTo().frame(0);
			
			driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='demo-frame']")));
			
			
			WebElement drag=driver.findElement(By.xpath("//*[@class='ui-widget-content ui-draggable ui-draggable-handle']"));
			WebElement drop=driver.findElement(By.xpath("//*[@class='ui-widget-header ui-droppable']"));
			Actions ac=new Actions(driver);
			Thread.sleep(3000);
			ac.dragAndDrop(drag, drop).build().perform();
			
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			driver.findElement(By.linkText("Accept")).click();
		}
	}


