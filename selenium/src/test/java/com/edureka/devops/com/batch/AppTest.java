package com.edureka.devops.com.batch;

import java.util.concurrent.TimeUnit; 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver; 
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.Assert;


public class AppTest{
	
	@Test (enabled = false)
    public void testTitle(){
		System.setProperty("webdriver.chrome.driver","D:\\Training\\Devops\\demo\\selenium\\chromedriver.exe"); 
		ChromeOptions chromeOptions = new ChromeOptions(); 
		WebDriver driver = new ChromeDriver(chromeOptions); 
		driver.get("http://facebook.com"); 
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); 
		String expectedtitle = "Facebook – log in or sign up";
		String actualtitle = driver.getTitle();
		Assert.assertEquals(expectedtitle, actualtitle);
//		driver.close();

    }
	
	// @Test (dependsOnMethods = {'test1', 'test2'})
	// public void test1{
	// 	System.out.println("methiond 1");
	// }
	
	// @Test
	// public void test2{
	// 	System.out.println("methiond 2");
	// }
	
	// @Test
	// public void test3{
	// 	System.out.println("methiond 3");
	// }
	

	
	
}