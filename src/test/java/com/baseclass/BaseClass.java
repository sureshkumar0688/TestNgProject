package com.baseclass;
import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.logging.FileHandler;

import javax.swing.text.Position;

import org.apache.commons.io.FileUtils;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
// Base Class....Reusable methods

public class BaseClass {

	static WebDriver driver;
	static WebElement findElement;
	
	//1 browser configuration

	public static void browserLaunch(String browserName) {
		switch (browserName) {

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}
	
	// 2 launchURL

	public static void launchUrl(String url) {

		driver.get(url);
	}
	
	// 3 driver.findElement

	public static WebElement locator(String attributeName, String attributeValue) {

		if (attributeName.equalsIgnoreCase("id")) {
			WebElement findElement = driver.findElement(By.id(attributeValue));
			return findElement;
		}
		else if(attributeName.equalsIgnoreCase("name")) {
			WebElement findElement = driver.findElement(By.name(attributeValue));
			return findElement;
		}
		
		else if (attributeName.equalsIgnoreCase("xpath")) {
			WebElement findElement = driver.findElement(By.xpath(attributeValue));
			return findElement;
		}
		
		else if (attributeName.equalsIgnoreCase("cssSelector")) {
			WebElement findElement = driver.findElement(By.cssSelector(attributeValue));
			return findElement;
    
		}else {
			System.out.println("None");
			return null;
			
		}
	}
	// 4- findElements
		public static  List<WebElement> tagName (String tagName) {
			List<WebElement> findElements = driver.findElements(By.tagName(tagName));
			return findElements;
		}

	
	// 5- send keys
	public static  void sendKeys (WebElement ref,String text) {
		ref.sendKeys(text);

	}
	// 6-  click
	public static  void elementClick(WebElement findElement) {
		findElement.click();
	
	}
	
	// 7-  close
	public static void close () {
		 driver.close();
		
	}
	// 8- quite
	public static void quit() {
		driver.quit();
	}
	
	// 9- getTitle
	public static void getTitle() {
		String title = driver.getTitle();
		System.out.println("WebPage Title is :" + title);
	}
	
	// 10- get current URL
	public static void getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Web Page Current URL is :" + currentUrl);
	}
	
	// 11- getText
	public static void getText(WebElement ref) {
		String text = ref.getText();
		System.out.println(text);
		
	}
	// 12- to resize the window dimension
	public static void windowSize(int x,int y) {
		 Dimension d = new Dimension(x,y);
		driver.manage().window().setSize(d);
	}
	
	// 13- to resize the window position
	public static void windowposition(int x,int y) {
			 Point p = new Point(x,y);
			driver.manage().window().setPosition(p);
		}
		
	// 14- getAttribute
	public static void getAttribute (WebElement ref , String att) {
		  String attribute = ref.getAttribute(att);
		  System.out.println("Attribute" +att+ "is" +attribute);
	}
	// 15- mouse over Actions 
	
	public static void actions (String operation , WebElement target) {
		
		Actions a = new Actions (driver);
		
		switch (operation) {
		
		case "click":
			a.click(target).perform();
			break;
			
		case "contextClick":
			a.contextClick(target).perform();
			break;
			
		case "doubleClick":
			a.doubleClick(target).perform();
			break;
			
		case "moveToElement":
			a.moveToElement(target).perform();
			break;
		}
	}
		
	// 16- Actions drag and drop 
		
		public static void dragAndDrop (WebElement source , WebElement target) {
			
			Actions a = new Actions(driver);
			a.dragAndDrop(source, target).perform();
		}
		
	// 17- Actions click And Hold and release 
		
		public static void clickHoldAndRelease(WebElement source , WebElement target) {
			
			Actions a = new Actions(driver);
			a.clickAndHold(source).release(target).perform();
		}
		
	// 18- Actions Copy and Paste
		public static void copyAndPaste (WebElement tocopy , WebElement topaste) {
			
			Actions a = new Actions(driver);
			a.moveToElement(tocopy).perform();
			a.keyDown(Keys.CONTROL).perform();
			a.sendKeys("a").perform();
			a.sendKeys("c").perform();
			a.keyUp(Keys.CONTROL).perform();
			a.moveToElement(topaste).perform();
			a.keyDown(Keys.CONTROL).perform();
			a.sendKeys("v").perform();
		}
		
	// 19- Actions Cut  and Paste
		public static void cutAndPaste (WebElement tocut , WebElement topaste) {
			
			Actions a = new Actions(driver);
			a.moveToElement(tocut).perform();
			a.keyDown(Keys.CONTROL).perform();
			a.sendKeys("x").perform();
			a.keyUp(Keys.CONTROL).perform();
			a.moveToElement(topaste).perform();
			a.keyDown(Keys.CONTROL).perform();
			a.sendKeys("v").perform();
		}
		
	// 20- Actions send keys
		public static void sendKeys (CharSequence  sendkeys) {
			
			Actions a = new Actions(driver);
			a.sendKeys(sendkeys).perform();
		}
		
	// 21- Actions key down
		public static void actionsKeyDown (CharSequence  keydown) {
					
			Actions a = new Actions(driver);
			a.keyDown(keydown).perform();
		}
	// 22- Actions key Up
		public static void actionsKeyUp (CharSequence  keydown) {
					
			Actions a = new Actions(driver);
			a.keyDown(keydown).perform();
		}
		
	// 23- Actions keyBoard SHIFT KEY Function used to change upper case and lower case
		public static void actionsShiftKey (WebElement ref, String text) {
			
		Actions a = new Actions (driver);
		a.keyDown(Keys.SHIFT).perform();
		ref.sendKeys(text);
		a.keyUp(Keys.SHIFT).perform();
		
		}
		
	// 24- Actions keyboard TAB KEY Function its works on move to next tab
		public static void actionsTabKey () {
			
		Actions a = new Actions (driver);
		a.keyDown(Keys.TAB).perform();
		}
		
	// 25- Actions keyboard TAB KEY Function its works on move to next tab
		public static void actionsEnterKey () {
			
		Actions a = new Actions (driver);
		a.keyDown(Keys.ENTER).perform();
		}
		
	// 26- Robot 
		public static void robotClass (String method, int keycode) throws AWTException {
			Robot r = new Robot();
			if (method.equals("keyPress")) {
				r.keyPress(keycode);
			}else if (method.equals("keyRelease")) {
				r.keyRelease(keycode);
			}
			
		}
		
	// 27- Navigate back & forward & Refresh
		public static void navigate (String method) {
			
			if (method.equals("back")) {
				driver.navigate().back();	
			}
			else if (method.equals("forward")) {
				driver.navigate().forward();
			}
			else if (method.equals("refresh")) {
				driver.navigate().refresh();
			}
		}
		
	// 28- Navigate to URL
		public static void navigateToUrl (String Url) {
			driver.navigate().to(Url);
		}
		
	// 29- Javascript Executor js Scroll Down
		
		public static void jsScrollDown (WebElement ref) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0], scrollIntoView(true)",ref);	
		}
		
	// 30- Javascript Executor js Scroll Up
		
		public static void jsScrollUp (WebElement ref) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0]. scrollIntoView(false)",ref);	
			
		}
		
	// 31- Javascript passing text
		
		public static void jsPassingText(WebElement ref  ,String text) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].setAttribute ('value','"+text+"')",ref);
		}
		
	// 32- Javascript click
		
		public static void jsClick(WebElement ref) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0]. click()",ref);	
		}
		
	// 33-  Highlighting the webElement using javascript
		
		public static void jsHeghlighting (WebElement ref) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].setAttribute ('style','backGround:green;border:solid 2px red')",ref);	
			
		}
		
	// 34- Alert
		
		public static Alert alert () {
		Alert alert = driver.switchTo().alert();
			return alert;	
		}
		
	// 35- Select
		
		public static void singleSelect (WebElement ref , String selectType , int index , String value) {
			
			Select s = new Select (ref);
			switch (selectType) {
			
			case "selectByIndex":
			   s.selectByIndex(index);
			   break;
			
			
			case "selectByValue":
				s.selectByValue(value);
				break;
				
			case "selectByVisibleText":
				s.selectByVisibleText(value);
				break;
		}
		}
		
	// 36- isMultiple 
		
		public static void isMultiple (WebElement ref) {
			
			Select s = new Select (ref);
			boolean multiple = s.isMultiple();
			System.out.println(multiple);
			
		}
		
	// 37- select FirstSelectedOption
		
		public static String selectFirstSelectedOption (WebElement ref) {
			Select s = new Select (ref);
			WebElement firstSelectedOption = s.getFirstSelectedOption();
			String selectFirstSelectedOption = firstSelectedOption.getText();
			return selectFirstSelectedOption;
			
		}
		
	// 38- select AllSelectedOption
		
		public static List<WebElement> selectAllSelectedOption (WebElement ref) {
			Select s = new Select (ref);
			List<WebElement> selectAllSelectedOption = s.getAllSelectedOptions();
			return selectAllSelectedOption;
			
		}
	// 39- slect AllOption
		
		public static List<WebElement> selectAllOption (WebElement ref) {
			Select s = new Select (ref);
			List<WebElement> alloptions = s.getOptions();
			return alloptions;
			
		}
		
	// 40- select deselectAll
		
		public static void selectDeselectAll (WebElement ref) {
			Select s = new Select (ref);
			s.deselectAll();
			
		}
		
	// 41- select deselectBy Index
		
		public static void selectDeselectByIndex (WebElement ref , String selectType , int index , String value) {
		
			Select s = new Select (ref);
			switch (selectType) {
			
			case "selectByIndex":
			   s.deselectByIndex(index);
			   break;
			
			
			case "selectByValue":
				s.deselectByValue(value);
				break;
				
			case "selectByVisibleText":
				s.deselectByVisibleText(value);
				break;
		}
		}
		
	// 42- windowsHandle
		
		public static String windowsHandle() {
			String windowHandle = driver.getWindowHandle();
			return windowHandle;
			
		}
		
	// 43- windowsHandles
		
		public static Set<String>  windowsHandles() {
			Set<String> windowHandles = driver.getWindowHandles();
			return windowHandles;
		}
		
	// 44- Screenshot
		
		public static void screenShot (String location) throws IOException {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File screenshotAs= ts.getScreenshotAs(OutputType.FILE);
			File f = new File (location);
			FileUtils.copyFile(screenshotAs, f);
//			FileHandler.copy(screenshotAs, f);
		}
		
	// 45- screenshot need to check 
		
		public static void screenShotElement (WebElement ref ,String location) throws IOException {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File screenshotAs= ts.getScreenshotAs(OutputType.FILE);
			File f = new File (location);
			FileUtils.copyFile(screenshotAs, f);
		}
		
	// 46- Frames index based
		
		public static void framesIndex(int index) {
			driver.switchTo().frame(index);
		}
		
	// 47- Frames id or Name
		
		public static void framesIdOrName (String value) {
			driver.switchTo().frame(value);
			
		}
		
	// 48- Frames webElement
		
		public static void framesWebElement (WebElement ref) {
			driver.switchTo().frame(ref);
		}
		
	// 49 waits ExplicitWait
		public static void waitsExplicitWait(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		until.click();
		}
		
	// 50 Wait
		
		public static void waits_FluentWait(final String xpath) {
		Wait <WebDriver> wait = new
		FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
		.pollingEvery(Duration.ofSeconds(5)).ignoring(Exception.class);
		WebElement until = (WebElement) wait.until(new Function<WebDriver, 
		WebElement>(){
			
		@Override
		public WebElement apply(WebDriver t) {
		return driver.findElement(By.xpath(xpath));
		}});
		until.click();
		}
		
	// 51 Webtable - headings
		
		public static List<String> webtable_Headings(WebElement table) {
		List<WebElement> tHeadings = table.findElements(By.tagName("th"));
		LinkedList li = new LinkedList<String>();
		
		for(int i=0; i < tHeadings.size(); i++) {
		WebElement heading = tHeadings.get(i);
		
		String text = heading.getText();
		// System.out.println(text);
		li.add(text);
		}
		return li;
		}
		
	// 52 Webtable - datas
		
		public static List<String> webtable_Datas(WebElement table) {
		List<WebElement> tRow = table.findElements(By.tagName("td"));
		LinkedList li = new LinkedList<String>();
		
		for(int i=0;i<tRow.size();i++) {
		WebElement row = tRow.get(i);
		String text = row.getText();
		// System.out.println(text);
		li.add(text);
		}
		return li;
		}
		
	// 53 Excel_getRowCount
		
		public static int getRowCount (String path, String sheetName) throws IOException 	{
		FileInputStream fi=new FileInputStream(path);
		XSSFWorkbook workbook= new XSSFWorkbook(fi);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		int rowcount = sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowcount;
		}
		
	// 54 Excel_getCellCount
		
		public static int getCellCount (String path, String sheetName, int rownum) 	throws IOException{
		FileInputStream fi=new FileInputStream(path);
		XSSFWorkbook workbook= new XSSFWorkbook(fi);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		Row row=sheet.getRow(rownum);
		int cellcount = row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellcount;
		}
		
		
	// 55 Excel_getCellData
		
		public static String getCellData (String path, String sheetName, int rownum, 
		int colnum) throws IOException 
		{
		FileInputStream fi=new FileInputStream(path);
		XSSFWorkbook workbook= new XSSFWorkbook(fi);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		Row row=sheet.getRow(rownum);
		Cell cell=row.getCell(colnum);
		DataFormatter formatter = new DataFormatter();
		String data;
		
		try {
		data = formatter.formatCellValue(cell);
		}
		
		catch (Exception e) {
		data="";
		}
		
		workbook.close();
		fi.close();
		return data;
		}
		
		
	// 56 Excel_setCellData
		
		public static void setCellData (String path, String sheetName, int rownum, int colnum, String data) throws IOException {
		File xlfile=new File (path);
		if(!xlfile.exists())
		{
		XSSFWorkbook workbook=new XSSFWorkbook();
		FileOutputStream fo=new FileOutputStream(path);
		workbook.write(fo);
		}
		FileInputStream fi=new FileInputStream(path);
		XSSFWorkbook workbook=new XSSFWorkbook(fi);
		if(workbook.getSheetIndex(sheetName)==-1) // if sheet not exists then 
	//	create 1
		 workbook.createSheet(sheetName);
		XSSFSheet sheet=workbook.getSheet(sheetName);
		if(sheet.getRow(rownum)==null) // if row not exists then create 1
		sheet.createRow(rownum);
		Row row=sheet.getRow(rownum);
		Cell cell=row.createCell(colnum);
		cell.setCellValue(data);
		FileOutputStream fo=new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
		
		}
       
	// 57 Excel_fillGreenColor
		
		public static void fillGreenColor (String path, String sheetName, int rownum, 
		int colnum) throws IOException
		{
		FileInputStream fi=new FileInputStream(path);
		XSSFWorkbook workbook=new XSSFWorkbook(fi);
		XSSFSheet sheet=workbook.getSheet(sheetName);
	    Row row=sheet.getRow(rownum);
	    Cell cell=row.getCell(colnum);
		XSSFCellStyle createCellStyle = workbook.createCellStyle();
		createCellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		createCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(createCellStyle);
		FileOutputStream fo=new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
		
}
	// 58 Excel_fillRedColor
		
		public static void fillRedColor (String path, String sheetName, int rownum, 
		                                                  int colnum) throws IOException {
		FileInputStream fi=new FileInputStream(path);
		XSSFWorkbook workbook=new XSSFWorkbook(fi);
		XSSFSheet sheet=workbook.getSheet(sheetName);
		
		Row row=sheet.getRow(rownum);
		Cell cell=row.getCell(colnum);
		
		XSSFCellStyle createCellStyle = workbook.createCellStyle();
		createCellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
		createCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(createCellStyle);
		
		FileOutputStream fo=new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
		
		
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

