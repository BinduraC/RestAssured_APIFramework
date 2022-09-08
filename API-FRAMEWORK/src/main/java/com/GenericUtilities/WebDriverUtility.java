package com.GenericUtilities;

import java.io.File;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author Bindura
 *
 */
public class WebDriverUtility {
	/**
	 * this method is used to maximize the browser
	 * 
	 * @param driver
	 */
	public void maximizeTheBrowser(WebDriver driver) {
		driver.manage().window().maximize();

	}
	/**
	 * this method is used to minimize the browser
	 * @param driver
	 */
	public void minimizeTheBrowser(WebDriver driver) {
		driver.manage().window().minimize();

	}

	/**
	 * this method is used to refresh the page
	 * @param driver
	 */
	public void refreshThePage(WebDriver driver) {
		driver.navigate().refresh();
	}
	/**
	 * this method is used to go back to previous page
	 * @param driver
	 */
	public void backToPreviousPage(WebDriver driver) {
		driver.navigate().back();
	}
	/**
	 * this method is used to navigate to nextpage
	 * @param driver
	 */
	public void forwardToNextPage(WebDriver driver) {
		driver.navigate().forward();;
	}
	/**
	 * this method is used to wait untill page details get load
	 * @param driver
	 */
	public void waitTillPageDetailsLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IConstants.implicitlywaitDuration));

	}
	/**
	 * this method is used to wait untill particular element is clicked
	 * @param driver
	 * @param element
	 */
	public void waitTillElementToClick(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IConstants.explicitlywaitDuration));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
	/**
	 * this method is used to wait untill element is visible
	 * @param driver
	 * @param element
	 */
	public void waitTillElementToVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IConstants.explicitlywaitDuration));
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	/**
	 * this method is used to wait untill page loads title
	 * @param driver
	 * @param title
	 */
	public void waitTillPageLoadTitle(WebDriver driver, String title) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IConstants.explicitlywaitDuration));
		wait.until(ExpectedConditions.titleContains(title));

	}
	/**
	 * this method is used to wait untill page loads url
	 * @param driver
	 * @param url
	 */
	public void waitTillPageLoadURL(WebDriver driver, String url) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IConstants.explicitlywaitDuration));
		wait.until(ExpectedConditions.urlContains(url));

	}
	/**
	 * this method is used to ignore NoSuchElementException
	 * @param driver
	 */
	public void ignoreNoSuchElementException(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IConstants.explicitlywaitDuration));
		wait.ignoring(NoSuchElementException.class);
	}
	/**
	 * this method is used to wait for alert popup message
	 * @param driver
	 */
	public void waitForAlertPopupMessage(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IConstants.explicitlywaitDuration));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	/**
	 * this method is used to switch to frame using index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);

	}
	/**
	 * this method is used to switch to frame using ID
	 * @param driver
	 * @param id
	 */
	public void switchToFrameUsingID(WebDriver driver, String id) {
		driver.switchTo().frame(id);

	}
	/**
	 * this method is used to switch to frame based on element
	 * @param driver
	 * @param element
	 */
	public void switchToFrameWithElement(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);

	}
	/**
	 * this method is used to switch to parent frame
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().defaultContent();

	}
	/**
	 * this method is used to mousehover on the element
	 * @param driver
	 * @param element
	 */
	public void mouseHoverOnElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();;

	}
	/**
	 * this method is used to right click on the element
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();;

	}
	/**
	 * this method is used to switch to alert popup window and click on OK
	 * @param driver
	 * @param expectedMessage
	 */
	public void switchToAlertWindowAndAccept(WebDriver driver, String expectedMessage) {
		Alert alert = driver.switchTo().alert();
		if(alert.getText().equals(expectedMessage)) {
			System.out.println("Alert message is verified");
		}else{
			System.out.println("Alert message not verified");
		}
		alert.accept();
	}
	/**
	 * this method is used to switch to alert popup window and click on cancel
	 * @param driver
	 * @param expectedMessage
	 */
	public void switchToAlertWindowAndCancel(WebDriver driver, String expectedMessage) {
		Alert alert = driver.switchTo().alert();
		if(alert.getText().equals(expectedMessage)) {
			System.out.println("Alert message is verified");
		}else{
			System.out.println("Alert message not verified");
		}
		alert.dismiss();
	}
	/**
	 * this method is used to clickon ENTER key
	 * @param driver
	 */
	public void clickOnEnterKey(WebDriver driver) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * this method is used to select value from list based on index
	 * @param element
	 * @param index
	 */
	public void selectDropDownByIndex(WebElement element, int index) {
		Select selectDropDown = new Select(element);
		selectDropDown.selectByIndex(index);
	}
	/**
	 * this method is used to select value from list based on value
	 * @param element
	 * @param value
	 */
	public void selectDropDownByValue(WebElement element, String value) {
		Select selectDropDown = new Select(element);
		selectDropDown.selectByValue(value);
	}
	
	/**
	 * this method is used to select value from list based on visible text
	 * @param element
	 * @param value
	 */
	public void selectDropDownByVisibileText(WebElement element, String value) {
		Select selectDropDown = new Select(element);
		selectDropDown.selectByVisibleText(value);
	}

	/**
	 * Used to scroll the bar to a particular element based on location of the web element
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void scrollBar(WebDriver driver, int x, int y) {

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	/**
	 * this method is used to take screenshot of the web page
	 * @param driver
	 * @param screenShotName
	 */
	public void takesScreenShot(WebDriver driver, String screenShotName) {
		Date d =new Date();
		String currentDate = d.toString().replaceAll(":", "-");

		TakesScreenshot screenShot = (TakesScreenshot)driver;
		File src = screenShot.getScreenshotAs(OutputType.FILE);
		File dest = new File(IConstants.screenShotsPath+currentDate+screenShotName+".png");
		try {
			FileUtils.copyFile(src, dest);
		}catch(Exception e) {
			e.printStackTrace();;
		}
	}
	/**
	 * this method is used to wait and click using custom wait
	 * @param driver
	 */
	public void waitAndClickUsingCustomWait(WebDriver driver) {
		FluentWait wait = new FluentWait(driver);
		wait.ignoring(NoSuchElementException.class);

	}
	/**
	 * this method is used to wait and click WebElement based on polling time and duration
	 * @param element
	 * @param pollingTime
	 * @param duration
	 */
	public void waitAndClick(WebElement element, long pollingTime, int duration) {
		int count=0;
		while(count<duration) {
			try {
				element.click();
				break;
			}catch(Exception e) {
				try {
					Thread.sleep(pollingTime);
				}catch(Exception e2) {
					e2.printStackTrace();
				}
				count++;
			}
		}
	}
	/**
	 * this method is used to switch to window using title
	 * @param driver
	 * @param actualTitle
	 */
	public void switchToWindowUsingTitle(WebDriver driver, String actualTitle) {
		Set<String> windowList = driver.getWindowHandles();
		for(String window : windowList) {
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if(title.contains(actualTitle)) {
				break;
			}
		}
	}
	/**
	 * this method is used to switch to window using url
	 * @param driver
	 * @param actualUrl
	 */
	public void switchToWindowUsingUrl(WebDriver driver, String actualUrl) {
		Set<String> windowList = driver.getWindowHandles();
		Iterator<String> windowiterator = windowList.iterator();
		while(windowiterator.hasNext()) {
			String window = windowiterator.next();
			driver.switchTo().window(window);
			String url = driver.getCurrentUrl();
			if(url.contains(actualUrl)) {
				break;
			}
		}
	}
    /**
     * Used to get next month date
     * @param driver
     * @param eltClickingNextMonButton
     * @param eltTogetCurrentMonthYear
     * @param reqMonth
     * @param reqYear
     */
	public void selectRequiredDate(WebDriver driver,WebElement eltClickingNextMonButton,WebElement eltTogetCurrentMonthYear, String reqMonth, String reqYear) {
		String[] currentmonthYearArr = eltTogetCurrentMonthYear.getText().split(", ");
		String currentMonth=currentmonthYearArr[0];
		String currentYear=currentmonthYearArr[1];

		while(!(reqMonth.equalsIgnoreCase(currentMonth) && reqYear.equals(currentYear))) {
			eltClickingNextMonButton.click();
			currentmonthYearArr = eltTogetCurrentMonthYear.getText().split(", ");	
			currentMonth=currentmonthYearArr[0];
			currentYear=currentmonthYearArr[1];

		}
	}
}

