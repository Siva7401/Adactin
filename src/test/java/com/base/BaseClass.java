package com.base;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static final String Value = null;
	public static WebDriver driver;

	// 1.to launch Browser
	public static void getDriver(String browserType){
		switch (browserType) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "IE":
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
		
		default:
			break;
		
		
		}
	}

	// 2.to get url
	public WebElement findElementByValue(String name) {
		WebElement findElement = driver.findElement(By.id(name));
		return findElement;
	}

	// 3.to get title
	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	// 4.to get current url
	public String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;

	}

	// 5.to handle single window
	public String windowHandle() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;

	}

	// 6.to get page source
	public String getPageSource() {
		String pageSource = driver.getPageSource();
		return pageSource;

	}

	// 7.to close the current window
	public void closeWindow() {
		driver.close();

	}

	// 8. to close all windows
	public static void closeAllWindow() {
		driver.quit();

	}

	// 9.to type text
	public void sendText(WebElement element, String data) {
		element.sendKeys(data);

	}

	// 10.to click button
	public void clickButton(WebElement element) {
		element.click();

	}

	// 11.to click submit
	public void submit(WebElement element) {
		element.submit();

	}
	// 12.to get the location of the file

	public Point getLocation(WebElement element) {
		Point location = element.getLocation();
		return location;

	}

	// 13. to get attribute
	public String getAttribute(WebElement element, String value) {
		String attribute = element.getAttribute(value);
		return attribute;

	}

	// 14.to get attribute
	public String getAttribute2(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;

	}

	// 15. to check it is enabled
	public boolean isEnabled(WebElement element) {
		boolean enabled = element.isEnabled();
		return enabled;
	}

	// 16.to check it is displayed
	public boolean isDisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;
	}

	// 17.to check it is selected
	public boolean isSelected(WebElement element) {
		boolean selected = element.isSelected();
		return selected;

	}

	// 18.to get the text
	public String getText1(WebElement element) {
		String text = element.getText();
		return text;

	}

	// 19.to get the tagname
	public String toGetTagName(WebElement element) {
		String tagName = element.getTagName();
		return tagName;

	}

	// 20. to maximize the window
	public static void maximize() {
		driver.manage().window().maximize();

	}

	// 21.to set the point of window
	public Point setPoint(int x, int y) {
		Point p = new Point(x, y);
		driver.manage().window().setPosition(new Point(x, y));
		return p;
	}

	// 22.to set the dimension of the window
	public Dimension setDimension(int width, int height) {
		Dimension d = new Dimension(width, height);
		return d;
	}

	// 23.to perform MouseHover action
	public void performMouseHover(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();

	}

	// 24.to perform click action
	public void click(WebElement element) {
		Actions a = new Actions(driver);
		a.click(element).perform();

	}

	// 25.to perform doubleclick
	public void doubleClick(WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();

	}

	// 26.to perform a right click
	public void rightClick(WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick(element).perform();

	}

	// 27. to perform a drag and drop

	public void dragAndDrop(WebElement source, WebElement target) {
		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).perform();

	}

	// 28.to perform key press
	public void keyPress(int keycode) throws AWTException {
		Robot r = new Robot();
		r.keyPress(keycode);

	}

	// 29.to perform key release
	public void keyRelease(int keycode) throws AWTException {
		Robot r = new Robot();
		r.keyRelease(keycode);

	}

	// 30. to pass text using javascript
	public void typeJs(WebElement element, String text) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript("arguments[0].('value','" + text + "')", element);

	}

	// 31.to perform click using javascrpit
	public void Button(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript("arguments[0].click()", element);

	}

	// 32.to take screenshot
	public void takeScreeenshot(String location) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File(location));
	}

	// 33.to perform dropdown operation using visibletext
	public void dropDownByText(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);

	}
	// 34.to perform dropdown operation using attribute

	public void dropDownByValue(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByValue(text);

	}

	// 35.to perform dropdown operation using by index
	public void dropDownByIndex(WebElement element, int s1) {
		Select s = new Select(element);
		s.selectByIndex(s1);
	}

	// 36.to perform dropdown operation using by deselect by visibletext
	public void deselectByVisibleText(WebElement element, String text) {
		Select s = new Select(element);
		s.deselectByVisibleText(text);

	}

	// 37.to perform dropdown operation using by deselect by attribute
	public void deselectByValue(WebElement element, String text) {
		Select s = new Select(element);
		s.deselectByValue(text);

	}

	// 38.to perform dropdown operation using by deselect by index
	public void deselectByIndex(WebElement element, int index) {
		Select s = new Select(element);
		s.deselectByIndex(index);

	}

	// 39.to perform dropdown operation using by deselectAll
	public void deselectByAll(WebElement element) {
		Select s = new Select(element);
		s.deselectAll();

	}

	// 40.to check multiple option in dropdown
	public void isMultiple(WebElement element) {
		Select s = new Select(element);
		s.isMultiple();
	}

	// 41. to navigate to another url
	public void navigateUrl(String url) {
		driver.navigate().to(url);

	}

	// 42.navigate to forward url
	public void navigateForward() {
		driver.navigate().forward();

	}

	// 43.navigate to backward url
	public void navigateBackward() {
		driver.navigate().back();

	}

	// 44.navigate to refresh url
	public void navigateRefresh() {
		driver.navigate().refresh();

	}

	// 45.to stop the temporary execution for a while
	public void sleep(int time) throws InterruptedException {
		Thread.sleep(time);

	}

	// 46.to stop the time being execution till executes
	public static void implicitWaits(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);

	}

	// 47.switch to frame using index
	public void frameIndex(int index) {
		driver.switchTo().frame(index);

	}

	// 48.switch to frame using frameValue
	public void frameValue(String text) {
		driver.switchTo().frame(text);

	}

	// 49.switch to parent frame using frame
	public void frameParent() {
		driver.switchTo().parentFrame();

	}

	// 50.switch to frame using refelement
	public void frameReference(String element) {
		driver.switchTo().frame(element);

	}

	// 51. to findelement using id
	public WebElement findElementById2(String id) {
		WebElement element = driver.findElement(By.id(id));
		return element;

	}

	// 52. to findelement using name
	public WebElement findElementByName(String name) {
		WebElement element = driver.findElement(By.name(name));
		return element;

	}

	// 53. to findelement using className
	public WebElement findElementByclassName(String name) {
		WebElement element = driver.findElement(By.className(name));
		return element;

	}

	// 54. to findelement using tagName
	public WebElement findElementByTagName(String name) {
		WebElement element = driver.findElement(By.tagName(name));
		return element;

	}

	// 55. to findelement using attributeName
	public WebElement xpathValue(String xpathExpression) {
		WebElement element = driver.findElement(By.xpath(xpathExpression));
		return element;

	}

	// 56. switch to alert click ok
	public void simpleAlerts() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	// 57. switch to alert click ok
	public void confrimAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	// 58. to findelements using tagname
	public List<WebElement> findElementsUsingTagName(WebElement element, String tagName) {
		List<WebElement> findElements = driver.findElements(By.tagName(tagName));
		return findElements;
	}

	// 59. to findelement using linkText
	public WebElement findElementByLinkText(String name) {
		WebElement element = driver.findElement(By.linkText(name));
		return element;

	}

	// 60.to findelement using PartialLinkText
	public WebElement findElementByPartialLinkText(String name) {
		WebElement element = driver.findElement(By.partialLinkText(name));
		return element;
	}

	// 61.to findelement using cssSelector
	public WebElement findElementByCssSelector(String name) {
		WebElement element = driver.findElement(By.cssSelector(name));
		return element;
	}

	// 62.to get the size of element
	public org.openqa.selenium.Dimension getSize(WebElement element) {
		org.openqa.selenium.Dimension size = element.getSize();
		// System.out.println(size.width);
		// System.out.println(size.height);
		return size;
	}

	// 63.to clear text
	public void clearText(WebElement element) {
		element.clear();
	}

	// 64.loadUrl
	public static void loadUrl(String url) {
		driver.get(url);

	}

//65.read data from excel
	public String getData(String sheetName, int rowindex, int cellindex) throws IOException {
		String res = null;
		File file = new File("C:\\Users\\DELL\\eclipse-workspace\\NewMaven\\Excel\\HotelBook.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowindex);
		Cell cell = row.getCell(cellindex);
		CellType celltype = cell.getCellType();
		switch (celltype) {
		case STRING:
			res = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date datecellvalue = cell.getDateCellValue();
				SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
				res = dateformat.format(datecellvalue);
			} else {
				double numericCellValue = cell.getNumericCellValue();
				// BigDecimal valueOf = BigDecimal.valueOf(numericCellValue);
				long l = (long) numericCellValue;
				res = String.valueOf(l);
			}
			break;

		default:
			break;
		}
		return res;
	}

	// 66.update value in excel
	public void upateData(String sheetName, int rowindex, int cellindex, String olddata, String newdata)
			throws IOException {
		File file = new File("C:\\Users\\DELL\\eclipse-workspace\\NewMaven\\Excel\\MavenTest.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowindex);
		Cell cell = row.getCell(cellindex);
		CellType celltype = cell.getCellType();
		String value = cell.getStringCellValue();

		if (value.equals(olddata)) {
			cell.setCellValue(newdata);

		}
		FileOutputStream output = new FileOutputStream(file);
		workbook.write(output);

	}

	// 67.insert value in excel
	public void writeData(String sheetName, int rowindex, int cellindex, String data) throws IOException {
		File file = new File("C:\\\\Users\\\\DELL\\\\eclipse-workspace\\\\NewMaven\\\\Excel\\\\HotelBook.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowindex);
		Cell cell = row.createCell(cellindex);
		cell.setCellValue(data);

		FileOutputStream output = new FileOutputStream(file);
		workbook.write(output);

	}

	// 68.get AttributeValue
	public String getAttribute(String string) {
		WebElement att = driver.findElement(By.id(string));
		att.getAttribute(Value);
		return null;
	}

	// 69.getProperty
	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(System.getProperty("user.dir") + "\\config.properties"));
		Object object = properties.get(key);
		String value = (String) object;
		return value;

	}
	
	public void clearText2(WebElement element) {
		element.clear();
	}

}
