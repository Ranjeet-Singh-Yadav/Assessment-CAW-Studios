package jsonProject;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadDataFromJSONFile {

    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        try {
        	driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");
            driver.manage().window().maximize();

            Thread.sleep(3000);
            WebElement element = driver.findElement(By.cssSelector("div.centered details summary"));
            element.click();
        

            

            JSONParser jp = new JSONParser();

            FileReader rd = new FileReader(".\\jsonFiles\\employee.json");
            Object obj = jp.parse(rd);
            JSONObject empJson = (JSONObject) obj;

            JSONArray array = (JSONArray) empJson.get("Data");
            Thread.sleep(1000);
            System.out.println(array);
     
            String jsonData = array.toJSONString();

            WebElement jsonInput = driver.findElement(By.id("jsondata"));
            jsonInput.clear();
            jsonInput.sendKeys(jsonData);
            Thread.sleep(2000);
          
            driver.findElement(By.id("refreshtable")).click();
           
        }catch(Exception e) {
        	 e.printStackTrace();
        }
        finally {
        	Thread.sleep(2000);
        	
            driver.quit();
        }
    }


}
