package org.dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderTestNg {
	
	@Test(dataProvider="getData")
	private void sample(String s) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/?ie=UTF8&tag=googinprimeexpt5-21&ascsubtag=_k_CjwKCAjwvNaYBhA3EiwACgndgkpIon3AS3Wktb-VDxwq2bRs6-2aZnBTRF1L1TtciDSqZFE0j9EDihoCJ0EQAvD_BwE_k_&gclid=CjwKCAjwvNaYBhA3EiwACgndgkpIon3AS3Wktb-VDxwq2bRs6-2aZnBTRF1L1TtciDSqZFE0j9EDihoCJ0EQAvD_BwE");
		WebElement search = driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
		search.sendKeys(s);
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
	}
	
	 @DataProvider
	public Object[][] getData()  {
		
		Object [][] data = new Object[5][1];
		data[0][0] = "mobile";
		
		data[1][0] = "laptop";
		
		data[2][0] = "Books";
		
		data[3][0] = "123456";
		
		data[4][0] = "mens dress";
			
		return data;
	
		
	}

}
