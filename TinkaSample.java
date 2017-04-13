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
	
	WebElement searchTextBefore=driver.findElement(By.xpath("//span[@class='tma_text__input_inactive']"));
	searchTextBefore.click();
	Thread.sleep(2000);
	WebElement searchTextAfter=driver.findElement(By.xpath("//span[@class='tma_input__textarea tma_text__input_active']"));
	
	highLightElement1(driver,searchTextAfter);
	
		searchTextAfter.clear();
		searchTextAfter.sendKeys("muttertag");
	//((JavascriptExecutor)driver).executeScript("document.getElementsById('tma_freeTextInput__input')[0].value='muttertag';",searchText); 
	//Thread.sleep(4000);
	
	WebElement searchButton=driver.findElement(By.xpath("//i[@class='tma_input__after tma_icon tma_icon__enter_outline']"));
	
	searchButton.click();
	
	//fetching the url
	
	new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='tma_app']/main/section/div/div[1]/div[2]/div/div[2]/div")));
	
	WebElement videoUrl=driver.findElement(By.xpath("//*[@id='tma_app']/main/section/div/div[1]/div[2]/div/div/div[2]/div/div"));
	
	String url=videoUrl.getAttribute("onclick");
	
	String[]str=url.split(" ");
	
	System.out.println(str);
	
	System.out.println("url is = "+url);
	
	//driver.close();
	
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