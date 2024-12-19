package TestPackage;

import java.io.File;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

public class Baseclass {
	
	public WebDriver w;
	
	@BeforeMethod
	public void initalize() throws Exception
	{
		//System.setProperty("webdrive.chrome.driver", "./Driver/chromedriver.exe");
		
		
		// This will load property file 
		Properties prop = new Properties();
		FileReader property = new FileReader("./data.property");
		prop.load(property);
		String browserName = prop.getProperty("browserName");
		//System.out.println(browserName);
		
		// this line will check the browser name is coming from terminal if from terminal then user name after ? or else after :
		browserName= System.getProperty("browser")!=null ? System.getProperty("browser"):prop.getProperty("browserName");
		
		if(browserName.contains("chrome"))
		{
		
			ChromeOptions ch = new ChromeOptions();
			ch.addArguments("--incognito");
			if(browserName.contains("headless"))
			{
				ch.addArguments("headless");
			}
			w = new ChromeDriver(ch);
		}
		if(browserName.equalsIgnoreCase("microsoftedge"))
		{
			EdgeOptions ch = new EdgeOptions();
			ch.addArguments("--inprivate");
			w = new EdgeDriver(ch);
		}
		
		if(browserName.equalsIgnoreCase("firefox"))
		{
			FirefoxOptions ch = new FirefoxOptions();
			ch.addArguments("-private");
			ch.addArguments("-private");
			w = new FirefoxDriver(ch);
		}
			
				
		/*DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("firefox");
		w = new RemoteWebDriver(new URL("http://192.168.1.113:4444"),cap);
		*/
		w.manage().window().maximize();
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	public WebDriver openURL(String url)
	{
		w.get(url);
		return w;
	}
	
	public File getScreenshot(WebDriver w,String testname) throws Exception {
		
		
		SimpleDateFormat simple = new SimpleDateFormat("MMM dd HH.mm.ss");
		String currentDateTime =simple.format(Calendar.getInstance().getTime());
			
		Thread.sleep(3000);
		TakesScreenshot sc = (TakesScreenshot)w;
		File src = sc.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/"+testname+" "+currentDateTime+".png");
		Files.copy(src, dest);
		return dest;
	}
	
	public ExtentReports getExtentReportObject() {
		
		ExtentSparkReporter reporter = new ExtentSparkReporter("./Report/orangeHRM.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
	}
	
	
	
	@AfterTest
	public void terminate() {
		w.quit();
		
	}
	
}
