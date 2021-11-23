package TestScripts;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;



public class NewTest {
	
  ChromeDriver driver;
  
@SuppressWarnings("deprecation")
@BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Cristian\\git\\repository\\AmazonAutomation\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS );
  
	    
	  System.out.println("Its ok");	
	  
  }
  
  @Test(priority = 0)
  public void verificarTitulo()
  {
	  driver.get("https://www.amazon.com/");
	  String titulo = driver.getTitle();
	  
	  Assert.assertEquals(titulo, "Amazon.com. Gasta menos. Sonríe más.");
  }
  
  @Test(priority = 100)
  public void buscarProducto()
  {
	  String producto = "Apple watch";
	  String categoria = "Electrónicos";
	  
	  WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
	  
	  Select selCategoria = new Select(dropdown);
	  selCategoria.selectByVisibleText(categoria);
	  
	  driver.findElement(By.id("twotabsearchtextbox")).sendKeys(producto);
	  
	  driver.findElement(By.id("nav-search-submit-button")).click();
	  
	  
	  
  }
  
  @AfterClass
  public void cerrar()
  {
	
  }
  

}
