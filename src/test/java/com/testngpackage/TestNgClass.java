package com.testngpackage;

import java.util.Date;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNgClass {
	
	WebDriver driver;
	
	@BeforeClass
	private void test1 () {
		
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/login/");	
	}
	@AfterClass
	private void test2 () {
		driver.close();
	}
	@AfterTest
	private void test3 () {
		System.out.println(" Test 3 ");
	}
	@BeforeMethod
	private void test4 () {
	  Date d = new Date();
	  System.out.println(d);
	}
	@AfterMethod
	private void test5 () {
		Date d = new Date();
		  System.out.println(d);
		
	}
	@Test 
	private void test6 () {
		driver.findElement(By.id("email")).sendKeys("Kumar0688@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("1234567890");
	}
	@Test 
	private void test7 () {
		driver.findElement(By.name("login")).click();
	}
}

	