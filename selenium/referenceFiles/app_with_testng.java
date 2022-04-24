import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit; 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver; 
import org.testng.annotations.Test; 
import org.openqa.selenium.chrome.ChromeOptions; 
public class NewTest {

	@Test
  public void verifyHomepageTitle() {
      
      System.out.println("launching firefox browser"); 
	  System.setProperty("webdriver.chrome.driver","D:\\Training\\Devops\\demo\\selenium\\chromedriver.exe"); 
		ChromeOptions chromeOptions = new ChromeOptions(); 
		chromeOptions.addArguments("--headless");
		WebDriver driver = new ChromeDriver(chromeOptions); 
      driver.get("http://192.168.56.101:8090/addressbook");
      String expectedTitle = "Hello World";
      String actualTitle = driver.getTitle();
      Assert.assertEquals(actualTitle, expectedTitle);
      driver.close();
  }
}