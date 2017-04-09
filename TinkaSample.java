package testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TinkaSample {
	
	@Test
	public static void fetchUrl() throws InterruptedException{
		
		
	//launching the browser
	//System.setProperty("webdriver.gecko.driver", "D:\\BrowserExeFiles\\geckodriver.exe");
	//setting desired capabilities
			//DesiredCapabilities a= DesiredCapabilities.firefox();
			//a.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	WebDriver driver= new FirefoxDriver();
	
	//maximize the window
	driver.manage().window().maximize();
		
	//opening url
	driver.get("https://tinka.iamplus.com/");
	
	//giving implicit time to load the page
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	Thread.sleep(5000);
	WebElement searchText=driver.findElement(By.xpath("//*[@id='tma_freeTextInput__input']/span"));
	/*Actions act=new Actions(driver);
	act.moveToElement(searchText).perform();
	act.click().sendKeys("muttertag").perform();
	//JavascriptExecutor js=(JavascriptExecutor)driver;
	//js.executeScript("document.getElementByXpath('//*[@id='tma_freeTextInput__input']/span').value='muttertag';");
	Thread.sleep(6000);
	//finding search text and applying click action in search button
	//driver.findElement(By.xpath("//*[@id='tma_freeTextInput__input']/span")).sendKeys("muttertag");*/
	//setAttribute(searchText,"value","muttertag");
	highLightElement1(driver,searchText);
	((JavascriptExecutor)driver).executeScript("document.getElementsById('tma_freeTextInput__input')[0].value='muttertag';",searchText); 
	//Thread.sleep(4000);
	
	WebElement searchButton=driver.findElement(By.xpath("//*[@id='tma_app']/main/section/div/div[3]/div/div[2]/i"));
	
	searchButton.click();
	
	//fetching the url
	
	new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='tma_app']/main/section/div/div[1]/div[2]/div/div[2]/div")));
	
	WebElement videoUrl=driver.findElement(By.xpath("//*[@id='tma_app']/main/section/div/div[1]/div[2]/div/div[2]/div"));
	
	String url=videoUrl.getAttribute("href");
	
	System.out.println("url is = "+url);
	
	}
	public static void setAttribute(WebElement element, String attributeName, String value)
	{
	WrapsDriver wrappedElement = (WrapsDriver) element;
	JavascriptExecutor js = (JavascriptExecutor)wrappedElement.getWrappedDriver();
	js.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", element, attributeName, value);
	}
	public static void highLightElement1(WebDriver driver, WebElement element) throws InterruptedException
	{
	JavascriptExecutor js=(JavascriptExecutor)driver; 

	js.executeScript("arguments[0].setAttribute('style','background: yellow; border: solid 5px red')", element); 

	Thread.sleep(5000);
	
	js.executeScript("arguments[0].setAttribute('style','border: solid 2px white')", element); 

	}

}