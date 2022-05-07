package AutomationScript;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.io.Files;


public class AutomateCopWellness1 extends BaseUI {

	public void copwell() {
		driver.findElement(By.xpath("//a[@event='Nav Provider Marketing:Interacted:Plus Corporate']")).click();
	}

	// entering the details in the forms
	public void enterdetails() throws IOException {

		FileInputStream fi = new FileInputStream(
				System.getProperty("user.dir") + "\\testdata\\testdata hackathon.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheetAt(1);// sheet (1)
		XSSFRow wr = ws.getRow(1);
		XSSFCell wc = wr.getCell(0);
		XSSFCell wc1 = wr.getCell(1);
		XSSFCell wc2 = wr.getCell(2);
		XSSFCell wc3 = wr.getCell(3);
		String data1 = wc.getStringCellValue();
		String data2 = wc1.getStringCellValue();
		String data3 = wc2.getStringCellValue();
		String data4 = wc3.getStringCellValue();

		driver.findElement(By.xpath("//input[@id='name' and @placeholder='Name']")).sendKeys(data1);
		driver.findElement(By.xpath("//input[@id='organizationName']")).sendKeys(data2);
		driver.findElement(By.xpath("//input[@id='officialEmailId']")).sendKeys(data3);
		driver.findElement(By.xpath("//input[@id='contactNumber']")).sendKeys(data4);
		Select org_size = new Select(driver.findElement(By.xpath("//select[@id='organizationSize']")));
        org_size.selectByVisibleText("1001-5000");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		 
		 
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}
	}
	public void Schedule_a_demo() throws IOException {
		WebElement Password = driver.findElement(By.xpath("//button[@type='submit']"));
		boolean result = Password.isEnabled();
		Assert.assertEquals(false,result);
		System.out.println("*************************CHECKING WITH INVALID DETAILS*********************");
		System.out.println("****************************************************************");
	
		if(result==false)
	    {
			System.out.println("Element is disabled – Assert failed");
		}
		else 
		{
			System.out.println("Element is enabled – Assert passed");
		}
		
	}

		//taking the screenShot
		public void screenshoot() throws IOException
		{ 
			   //ScreenShot:
			   TakesScreenshot capture = (TakesScreenshot) driver;
			   File srcFile = capture.getScreenshotAs(OutputType.FILE);
			   File destFile = new File("D:\\eclipse\\Findinghospitals\\screenshot\\Screen.png");
			   Files.copy(srcFile, destFile);
			   
	}

}