package com.edureka.devops.hello;
import java.util.concurrent.TimeUnit; 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver; 
import org.openqa.selenium.chrome.ChromeOptions;
//import org.testng.annotations.Test; 
//import org.testng.Assert; 

public class App 
{
//	@Test 
	public static void main(String[] args) { 
		System.setProperty("webdriver.chrome.driver","D:\\Training\\Devops\\demo\\selenium\\chromedriver.exe"); 
		ChromeOptions chromeOptions = new ChromeOptions(); 
		chromeOptions.addArguments("--headless");
		WebDriver driver = new ChromeDriver(chromeOptions); 
		driver.get("http://192.168.56.101:8090/addressbook"); 
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); 
        //driver.close();
		System.out.println(driver.getTitle());
        // driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("Hello Facebook");


		//Thread.sleep(5000); driver.quit(); 
	}
}


//driver.findElement(By.className("v-button")).click(); 
//driver.findElement(By.id("gwt-uid-5")).sendKeys("Edureka"); 
//driver.findElement(By.id("gwt-uid-7")).sendKeys("DevOps"); 
//driver.findElement(By.id("gwt-uid-9")).sendKeys("9834562709"); 
//driver.findElement(By.id("gwt-uid-11")).sendKeys("Devops@edureka.co"); 
//driver.findElement(By.id("gwt-uid-13")).sendKeys("3/3/21,"); 
//driver.findElement(By.className("v-button-primary")).click(); 
