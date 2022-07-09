package DemoQaTesting;

import org.openqa.selenium.edge.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxTest
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.edgedriver().setup();
		WebDriver dri = new EdgeDriver();
		dri.get("https://demoqa.com/checkbox");
		WebElement chkbox = dri.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/ol[1]/li[1]/span[1]/label[1]/span[1]"));
		if(chkbox.isSelected())
			System.out.println("Checkbox is selected");
		else
			chkbox.click();
		System.out.println("Program complete");
		System.out.println("This is a mice code change to check git");
		int a = 10,b=34;
		int c = a+b;
		System.out.println("Result c " + c);
		Thread.sleep(1000);
		dri.close();
	}

}
