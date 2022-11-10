package com.sampletestng;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class AdactineHotel {
	
	WebDriver driver;
	
	@Parameters ({"userName","password"})
	@Test
	public void adactinHotelLogin(String username ,String password) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		WebElement user = driver.findElement(By.id("username"));
		user.sendKeys(username);
		WebElement pass = driver.findElement(By.id("password"));
		pass.sendKeys(password);
		driver.findElement(By.name("login")).click();	
	}
	
	@Parameters ({"Location","Hotels","RoomType"})
	@Test
	public void searchDeatils(String location,String hotels , String roomType) {
		
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		 WebElement locat = driver.findElement(By.xpath("(//select[@class='search_combobox'])[1]"));
		 Select s = new Select(locat);
		 s.selectByVisibleText(location);
		 
		 WebElement hotel = driver.findElement(By.xpath("(//select[@class='search_combobox'])[2]"));
		 Select s1 = new Select(hotel);
		 s1.selectByVisibleText(hotels);
		 
		 WebElement room = driver.findElement(By.xpath("(//select[@class='search_combobox'])[3]"));
		 Select s2 = new Select(room);
		 s2.selectByVisibleText(roomType);

	
	}
	

}
