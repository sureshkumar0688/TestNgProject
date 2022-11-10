package com.blazedemo;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


public class HomepagePom {
	
	WebDriver driver = new ChromeDriver();
		
	public HomepagePom() {
	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="fromPort")
	private WebElement depatureCity;
	@FindAll({@FindBy(name="toPort"), @FindBy(xpath = "(//select[@class='form-inline'])[2]")})
	private WebElement destinationCity;
	@FindBy(xpath = "//input[@value='Find Flights']")
	private WebElement findFlights;

	public WebElement getDepatureCity() {
		return depatureCity;
	}

	public WebElement getDestinationCity() {
		return destinationCity;
	}

	public WebElement getFindFlights() {
		return findFlights;
	}

}
