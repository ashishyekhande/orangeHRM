package TestPackage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

@Listeners(Listen.class)
public class orangeHRM extends Baseclass{


	@Test
	public void OrangeCRMTest() throws Exception {
		
		w=openURL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}
	
	//@Test(dataProvider = "id")
	public void test(String user,String pass) {
		
		w=openURL("https://www.saucedemo.com/");
		w.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys(user);
		w.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys(pass);
		w.findElement(By.cssSelector("#login-button")).click();
		
	}
	
	//@Test(dataProvider = "jsondata")
	public void testJson(String data) {
		
		System.out.println(data);
		String[] user = data.split(",");
		w=openURL("https://www.saucedemo.com/");
		w.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys(user[0]);
		w.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys(user[1]);
		w.findElement(By.cssSelector("#login-button")).click();
		
	}
	
	
	
	@DataProvider(name = "id")
	public Object[][] data()
	{
		Object[][] data = {
				{"standard_user","secret_sauce"},
				{"locked_out_user","secret_sauce"},
			
				
		};
		return data;
		
	}
	
	@DataProvider(name = "jsondata")
	public String[] jsondata() throws Exception
	{
		FileReader jsonfile = new FileReader("./jsondata.json");
		JSONParser jsonparse = new JSONParser();
		Object obj = jsonparse.parse(jsonfile);  // java object  
		
		JSONObject jsonobject =(JSONObject) obj;  // converting java obejct to json object
		JSONArray array =	(JSONArray) jsonobject.get("userlogin");
		
		String a[] = new String[array.size()];
		
		for(int i =0;i<array.size();i++)
		{
			JSONObject user = (JSONObject) array.get(i); // taking 1st set and making as jsonobject
			String userame =(String) user.get("user");
			String pass =(String) user.get("pass");
			
			a[i]=userame+","+pass;  // combine user name and password  ex. standard_user,secret_sauce
		}
		return a;
		
		
			
		
		
	}
	
	
	
	
}
 