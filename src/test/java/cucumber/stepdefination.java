package cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import TestPackage.Baseclass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class stepdefination extends Baseclass {

	public WebDriver w ;
	
	@Given("open orangeHRM site")
	public void open_orangeHRM_site() throws Exception
	{
		initalize();
		w=openURL("https://www.saucedemo.com/");
		
	}
	
	@When("^login with (.+) and (.+)$")
	public void login(String user ,String pass)
	{
		w.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys(user);
		w.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys(pass);
		w.findElement(By.cssSelector("#login-button")).click();
		w.quit();
	}
	
}
