package com.edureka.devops.com.batch;
import java.util.concurrent.TimeUnit; 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver; 
import org.openqa.selenium.chrome.ChromeOptions;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		System.setProperty("webdriver.chrome.driver","D:\\Training\\Devops\\demo\\selenium\\chromedriver.exe"); 
		ChromeOptions chromeOptions = new ChromeOptions(); 
		WebDriver driver = new ChromeDriver(chromeOptions); 
		driver.get("http://facebook.com"); 
		System.out.println(driver.getTitle());
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); 
//		driver.findElement(By.className("v-button")).click(); 
//		driver.findElement(By.id("gwt-uid-5")).sendKeys("Amit");
//		driver.findElement(By.id("gwt-uid-7")).sendKeys("Kumar");
//		driver.findElement(By.id("gwt-uid-9")).sendKeys("987654");
//		driver.findElement(By.id("gwt-uid-11")).sendKeys("devops@edureka.co");
//		driver.findElement(By.id("gwt-uid-13")).sendKeys("7/7/83,");
//		driver.findElement(By.className("v-button-primary")).click(); 
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("Hello Facebook");

//		driver.close();

    }
}
