package jsonProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSONtest {
   WebDriver driver;
   
   void setup() {
	   WebDriverManager.chromedriver().setup();
	   driver = new ChromeDriver();
	   driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	   
 
	   driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");
	   driver.findElement(By.name("Table Data")).click();
	   driver.findElement(By.id("jsondata")).sendKeys("array");
   }
}
