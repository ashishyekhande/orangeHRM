package TestPackage;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Fileupload extends Baseclass {

	@Test
	public void file() throws Exception {

		w=openURL("https://demoqa.com/upload-download");
		WebElement uplodad = w.findElement(By.xpath("//input[@id='uploadFile']"));
		String path ="C:\\Users\\koush\\Desktop\\test.txt";
		uplodad.sendKeys(path);

		//
		/*StringSelection selection = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		
		Robot r = new Robot();
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		
		r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
		
		*/
	}
}
