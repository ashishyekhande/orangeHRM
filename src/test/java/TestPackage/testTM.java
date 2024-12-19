package TestPackage;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(Listen.class)
public class testTM {

	
	// testing push
	@Test
	public void stringtest()
	{
	String str ="India is India ashish ashish ritu is my country ritu ritu";
	
	String a[]= str.split(" ");
	boolean b[] =  new boolean[a.length];
	{
		for(int i=0;i<a.length;i++)
		{
			int count =1;
			if(b[i]==true) continue;
			String mystring = str.split(" ")[i];
			for(int j =i+1;j<a.length;j++)
			{
				if(mystring.equalsIgnoreCase(a[j]))
				{
					count++;
					b[j]=true;
				}
				
			}
			System.out.println("occrance "+mystring +"==> "+count);
		}
	}
	
	}
}
