package practiceCucumber;

import org.openqa.selenium.By;

import TestPackage.Baseclass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class stepdefination extends Baseclass {

	
	@Given("site is open")
	public void site_is_open() throws Exception {
		initalize();
		w=openURL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}
	
	@When("^user enter (.+) and (.+)$")
	public void enter_id_pass(String user ,String pass)
	{
		w.findElement(By.cssSelector("input[placeholder*='name']")).sendKeys(user);
		w.findElement(By.cssSelector("input[placeholder*='word']")).sendKeys(pass);
		w.findElement(By.cssSelector("button[type='submit']")).click();
		w.quit();
	}
}
