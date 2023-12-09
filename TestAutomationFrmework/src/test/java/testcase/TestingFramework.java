package testcase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;

public class TestingFramework extends BaseTest {

	@Test(dataProvider = "testdata")
	public static void CreateCustomer(String Fname, String LName, String PostCode) throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(Loc.getProperty("BankManagerLoginButton"))).click();
		driver.findElement(By.xpath(Loc.getProperty("TopAddCustomerButton"))).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(Loc.getProperty("FirstName"))).sendKeys(Fname);
		Thread.sleep(500);
		driver.findElement(By.xpath(Loc.getProperty("LastName"))).sendKeys(LName);
		Thread.sleep(500);
		driver.findElement(By.xpath(Loc.getProperty("PostCode"))).sendKeys(PostCode);
		Thread.sleep(500);
		driver.findElement(By.xpath(Loc.getProperty("SubmitAddCustomerButton"))).click();
		Thread.sleep(500);
		String expectedKeyword = "Customer added successfully with customer id";
		assert (driver.switchTo().alert().getText()).contains(expectedKeyword);
		Thread.sleep(500);
		driver.switchTo().alert().accept();

	}

	// to provide data instead of hard coding them, easier to write different
	// scenarios for one test case
	@DataProvider(name = "testdata")
	public Object[][] tData() {
		return new Object[][] { { "raghad", "emad", "222" }, };
	}

//	public static void OpenAccount() {
//		driver.findElement(By.xpath(Loc.getProperty("BankManagerLoginButton"))).click();
//		
//		
//	}
	@Test
	public static void SearchCustomer() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(Loc.getProperty("BankManagerLoginButton"))).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(Loc.getProperty("CustomersButton"))).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(Loc.getProperty("SearchCustomerField"))).sendKeys("Hermoine");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	    WebElement table = driver.findElement(By.xpath("//table[@class='table table-bordered table-striped']"));
		//System.out.println(table.getText());
		 assert(driver.findElement(By.xpath(Loc.getProperty("Result"))).getText().contains("Hermoine"));
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	@Test
	public static void DeleteCustomer() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(Loc.getProperty("BankManagerLoginButton"))).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(Loc.getProperty("CustomersButton"))).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(Loc.getProperty("SearchCustomerField"))).sendKeys("Albus");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(Loc.getProperty("DeleteButton"))).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertNotNull(driver.findElement(By.xpath(Loc.getProperty("Result"))).getText().contains("Albus"));
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

//	@Test
//	public static void SortPostCode() {
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.findElement(By.xpath(Loc.getProperty("BankManagerLoginButton"))).click();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.findElement(By.xpath(Loc.getProperty("CustomersButton"))).click();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.findElement(By.xpath(Loc.getProperty("SearchCustomerField"))).click();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.findElement(By.xpath(Loc.getProperty("SearchCustomerField"))).sendKeys("u");
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.findElement(By.xpath(Loc.getProperty("PostCodeColumn"))).click();
////		List<WebElement> rows = driver.findElements(By.xpath(Loc.getProperty("TableResultsReturned")));
////		for( int i=0 ; i<rows.size();i++) {
////			String rowElement= rows.get(i).findElement(By.xpath(Loc.getProperty("Result"))).getText();
////		}
//		boolean flag = false;
//		 List<WebElement> list = driver.findElements(By.xpath(Loc.getProperty("TableResultsReturned")));
//		 int size = list.size();
//		 String[] actual = new String[size]; 
//		 String[] sorted = new String[size];
//		 for (int i = 0; i < size; i++) 
//		 {
//		    actual[i]=sorted[i] = driver.findElement(By.xpath("//a[normalize-space()='Post Code']")).getText();
//		 }
//
//		 //Sorting the array
//		 Arrays.sort(sorted);
//
//		 //Validating the existing with sorted array. shows no message if both are same
//		 for(int i = 0;i<size;i++)
//		 {
//		     if(!actual[i].equals(sorted[i]))
//		     {
//		         System.out.println("The elements the webpage are not sorted");
//		         System.out.println("expected "+sorted[i]+" but actual "+actual[i]+" at row "+i);
//		         flag = true;
//		     }
//		 }
}
// }
