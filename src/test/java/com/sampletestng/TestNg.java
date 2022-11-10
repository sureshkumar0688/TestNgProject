package com.sampletestng;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestNg  {
	
	@Parameters({"userName","password"})
	@Test
	private void test1(String s,String s1) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		WebElement textuser = driver.findElement(By.id("username"));
		textuser.sendKeys(s);
		WebElement pass = driver.findElement(By.id("password"));
		pass.sendKeys(s1);
		
		
	
	}
}

