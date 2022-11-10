package com.blazedemo;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BlazeDemo extends BaseClass {
	
	@Test
	public void blazeDemo () {
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://blazedemo.com/");
		
		HomepagePom hp = new HomepagePom();
		
		WebElement depatureCity = hp.getDepatureCity();
		Select s = new Select(depatureCity);
		s.selectByVisibleText("Boston");
		
		WebElement destinationCity = hp.getDestinationCity();
		Select s1 = new Select(destinationCity);
		s1.selectByIndex(2);
		
		WebElement findFlights = hp.getFindFlights();
		findFlights.click();
		
		
	
	
	}

}
