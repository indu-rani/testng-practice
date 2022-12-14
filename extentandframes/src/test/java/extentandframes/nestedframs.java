package extentandframes;

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
public class nestedframs {
	
	public static String url="https://the-internet.herokuapp.com/nested_frames";
	WebDriver driver;
	@BeforeTest
	public void Test() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	@Test
	public void test1() throws InterruptedException, FileNotFoundException
	{
		driver.findElements(By.tagName("frameset")).size();

		driver.switchTo().frame(driver.findElement(By.xpath("//*[@name='frame-top']"))).switchTo().frame(1);

		System.out.println(driver.findElement(By.xpath("//*[@id='content']")).getText());
      // driver.close();
	
		PrintStream ps = new PrintStream(new File("C:\\Users\\Ragha\\Desktop\\ps.txt"));
		 System.setOut(ps);
		 ps.print(driver.findElement(By.xpath("//*[@id='content']")).getText());


		
	
}
}









