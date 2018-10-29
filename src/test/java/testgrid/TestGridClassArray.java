package testgrid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.regex.Pattern;
import java.lang.InterruptedException;
import java.lang.Math;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.*;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.Test;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;



public class TestGridClassArray {
	public WebDriver driver;
	public String URL, Node;
	protected ThreadLocal<RemoteWebDriver> threadDriver = null;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
//	String browser = "firefox";
	@Parameters({"browser","pr","Nodeurl"})
		
	@BeforeTest
	public void launchbrowser(String browser,String pr, String Nodeurl) throws MalformedURLException {
		//String URL = "http://www.calculator.net";

		if (browser.equalsIgnoreCase("firefox")) {
			System.out.println(" Executing on FireFox in VM");
			//String Node = "http://192.168.85.129:4444/wd/hub";
			String Node = "http://localhost:4444/wd/hub";
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.ANY);
			cap.setVersion("46.0");
			cap.setCapability("marionette", true);			
			driver = new RemoteWebDriver(new URL(Node), cap);
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} else if (browser.equalsIgnoreCase("local")){
			driver = new ChromeDriver();	
			File file = new File("./chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			String ExpTitle = "Welcome: Mercury Tours";
		}
		else if (browser.equalsIgnoreCase("chrome")) {
			System.out.println(" Executing on CHROME in Lunix");
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.LINUX);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			options.addArguments(Arrays.asList("--window-position=0,0"));	 		
			options.addArguments(Arrays.asList("--window-size=1920,1080"));
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new RemoteWebDriver(new URL(Nodeurl), cap);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} else if (browser.equalsIgnoreCase("vista")) {
			System.out.println(" Executing on CHROME in Vista");
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.VISTA);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			options.addArguments(Arrays.asList("--window-position=0,0"));	 		
			options.addArguments(Arrays.asList("--window-size=1920,1080"));
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new RemoteWebDriver(new URL(Nodeurl), cap);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} else if (browser.equalsIgnoreCase("win10")) {
			System.out.println(" Executing on CHROME in Winows 10");
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WIN10);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			options.addArguments(Arrays.asList("--window-position=0,0"));	 		
			options.addArguments(Arrays.asList("--window-size=1920,1080"));
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new RemoteWebDriver(new URL(Nodeurl), cap);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		//else {
		//	throw new IllegalArgumentException("The Browser Type is Undefined");
		//}
	}
	@Test
	public void idupeshcomVideo() throws Exception {
		String baseUrl = "http://idupesh.com";
		driver.get(baseUrl + "/");
		List<WebElement> elems = driver.findElements(By.xpath("//ul[@id='dj-megamenu145']/li"));
		WebElement webEle = null;
		System.out.println("Cycle for idupesh.com menu started with "+elems.size()+" elements");
		System.out.println("!--------------------------------------------------------!");
		driver.switchTo().defaultContent();
				
	for (int i=2; i<=elems.size(); i++){
		System.out.println(i);
		webEle=driver.findElement(By.xpath("//ul[@id='dj-megamenu145']/li["+i+"]"));
		webEle.click();
		System.out.println("Clicked menu "+i);
		List<WebElement> elFrame = driver.findElements(By.xpath("//*/iframe"));
		System.out.println("Count of Frames on page "+elFrame.size());
		for (int f=0;f<elFrame.size();f++){
			driver.switchTo().frame(f);
			System.out.println("Switched to frame number  "+f);
			//WebDriverWait wait = new WebDriverWait(driver, 60);
			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ytp-large-play-button ytp-button']")));
			
			if 	(isElementPresent(By.xpath("//a[@class='ytp-title-link yt-uix-sessionlink']"))==true){
				System.out.println("Video title "+driver.findElement(By.xpath("//a[@class='ytp-title-link yt-uix-sessionlink']")).getText());
			}	else {
				System.out.println("Title of video not found in selected Frame number " +f);
			}
			
			if 	(isElementPresent(By.xpath("//button[@class='ytp-large-play-button ytp-button']"))==true){
				driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();
				Thread.sleep(10000);
				System.out.println("Video in Frame "+f+" clicked ");
			}	else {
				System.out.println("NoSuchElementException " +f);
			}

					

			//driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
			driver.switchTo().defaultContent();
		}
	}
	}
	private boolean isElementPresent(By by) {  
    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
    try {  
        driver.findElement(by);  
        return true;  
    } catch (NoSuchElementException e) {  
        return false;  
    } finally {  
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
    }  
}
	
	@Test
	public void idupeshcomMenu() throws Exception {
	String baseUrl = "http://idupesh.com";
	driver.get(baseUrl + "/");
	List<WebElement> elems = driver.findElements(By.xpath("//ul[@id='dj-megamenu145']/li"));
	WebElement webEle = null;
	System.out.println("Cycle for idupesh.com menu started with "+elems.size()+" elements");
	for (int i=1; i<=elems.size(); i++){
	driver.switchTo().defaultContent();
	webEle=driver.findElement(By.xpath("//ul[@id='dj-megamenu145']/li["+i+"]"));
	webEle.click();
	//driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
	System.out.println("!--------------------------------------------------------!");
	//System.out.println(driver.findElement(By.xpath("//ul[@id='dj-megamenu145']/li["+i+"]")).getText());
	System.out.println("Clicked menu "+i+" "+driver.findElement(By.xpath("//ul[@id='dj-megamenu145']/li["+i+"]/a")).getText());
	
	List<WebElement> elFrame = driver.findElements(By.tagName("iframe"));
	            //for (WebElement elFramename : elFrame)
               // System.out.println("frameid: " + elFramename.getAttribute("title"));  
			
	if (elFrame.size()!=0){
			System.out.println("Count of Frames on page "+elFrame.size());
			for (int n=0; n<=1; n++){
			//for (int n=0; n<elFrame.size(); n++){
				int s=n+1;
				System.out.println("Current number of video frame is "+s);
				WebDriverWait waitPagination = new WebDriverWait(driver, 5);
				//waitPagination.ignoring(NoSuchElementException.class);
				//waitPagination.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='nspPagination']")));
				//driver.findElement(By.xpath("//ul[@class='nspPagination']/li["+s+"]/a")).click();
					System.out.println("Searching for nspPagination buttons on the page ");
					List<WebElement> Paginations = driver.findElements(By.xpath("//ul[@class='nspPagination']"));
				if (driver.findElements(By.xpath("//ul[@class='nspPagination']")).size()!=0){
					driver.findElement(By.xpath("//ul[@class='nspPagination']/li["+s+"]/a")).click();
					System.out.println("Found nspPagination and clicked ");
					}					
				else{
					System.out.println("Not found nspPagination on the page ");
					}
				driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
				
			for (int f=0; f<=Paginations.size(); f++){
				driver.switchTo().frame(f);
				System.out.println("Switched to frame number  "+n+" text "+driver.findElement(By.xpath("//a[@class='ytp-title-link yt-uix-sessionlink']")).getText());
				WebDriverWait wait = new WebDriverWait(driver, 60);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ytp-large-play-button ytp-button']")));
				//WebElement element=driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']"));
				//Actions actions = new Actions(driver);
				//actions.moveToElement(element).click().perform();
							
					try
						{
							driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();
//							Thread.sleep(2000);
							//driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']")).click();
							//Thread.sleep(2000);
							System.out.println("Video in Frame "+n+" clicked ");
						} 
					catch(NoSuchElementException e)
						{
							e.printStackTrace();
							System.out.println("NoSuchElementException " +f);
						}
				driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
			}
				driver.switchTo().defaultContent();	
				System.out.println("Frame "+n+" switched to defaultContent ");
				//driver.findElement(By.xpath("//ul[@id='dj-megamenu145']/li["+i+"]")).click();
				//driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
				//System.out.println("Menu  "+driver.findElement(By.xpath("//ul[@id='dj-megamenu145']/li["+i+"]")).getText()+" clicked");
			}
			
			
		}
	else {
		System.out.println("No Frames on the page");
	}
	//driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();


	//driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
	//Thread.sleep(60000);
	}
	
	//driver.switch_to_default_content(); //*[@id="nsp-nsp-113"]/div[1]/div[2]/div/div[3]/div/div/iframe
	
	

	driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
	//Thread.sleep(60000);
    //driver.quit();
  }

	
	
	@Test (dependsOnMethods={"idupeshcomMenu"})
	public void idupeshcomLinks() throws InterruptedException {
		
//Sdelal vlogenniy tsikl po adresam kotorue vabirautsya psevdosluchayno in zadannogo macciva.
//Neobhodomo dodelat chtobu adresa zapolnyalu massiv avtovatichesski iz xml.
//takge gelatelno sdelat realnuy generator slechaynogo chislla.

		System.out.println("Start array processing");   
        	String[] urls = {
			"https://www.idupesh.com/",
			"https://www.idupesh.com/10-photos.html",
			"https://www.idupesh.com/16-news.html",
			"https://www.idupesh.com/17-articles.html",
			"https://www.idupesh.com/17-articles/11-the-bad-boss-baby-play-in-the-forest-fun-show-kids-and-childrens.html",
			"https://www.idupesh.com/17-articles/6-v8-supercars-newcastle-500.html",
			"https://www.idupesh.com/17-articles/7-looking-up-into-a-tree-at-tokyo-s-shinjuku-gyoen-park.html",
			"https://www.idupesh.com/17-articles/8-jamie-whincup-is-the-2017-supercars-champion-after-a-controversial-final-race-that-saw-scott-mclaughlin-lose-the-title-through-a-post-race-penalty-click-for-full-results.html",
			"https://www.idupesh.com/18-articles/every-videos.html",
			"https://www.idupesh.com/8-videos.html",
			"https://www.idupesh.com/pisgat-ze-ev-neve-ya-akov-forest.html",
			"https://www.idupesh.com/pisgat-ze-ev-center.html",
			"https://www.idupesh.com/park-yekutiel-adam.html",
			"https://www.idupesh.com/park-in-the-mountains-forest.html",
			};
		for (int j=0;j<100;j++)
		{	
			
			for (int i = 0; i < urls.length; i++) 
			{
				//result = result + mice[i];
				System.out.println(urls[i]);
				int rnd = (int) (Math.random()*urls.length);
					driver.get(urls[rnd]);
					driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
					Thread.sleep(120000);
				
			}
		}	
			   
		
	//	driver.get("https://www.youtube.com/watch?v=yKeXgQ5yDAM");
	//	driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
	//	Thread.sleep(120000);
		
		//driver.get("https://www.youtube.com/watch?v=KPQhbSKx0E8");
		//driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		//Thread.sleep(120000);
		
		//driver.get("https://youtu.be/e0_CiFfa5pM");
  		//driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		//Thread.sleep(60000);
		
		//driver.get("https://youtu.be/OdpR6zyCwGA");
  		//driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		//Thread.sleep(120000);
		
		//driver.get("https://www.youtube.com/watch?v=yKeXgQ5yDAM");
  		//driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		//Thread.sleep(60000);
		
		//driver.get("https://youtu.be/e0_CiFfa5pM");
  		//driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		//Thread.sleep(120000);
		
		//driver.get("https://youtu.be/GBaWeA9cLDU");
  		//driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		//Thread.sleep(60000);
		
		//driver.get("https://www.idupesh.com/");
  		//driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		//Thread.sleep(60000);
		
		//driver.get("https://www.idupesh.com/articles/6-v8-supercars-newcastle-500.html");
  		//driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		//Thread.sleep(60000);
		
		//driver.get("https://www.idupesh.com/articles/7-looking-up-into-a-tree-at-tokyo-s-shinjuku-gyoen-park.html");
  		//driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		//Thread.sleep(60000);
		
		//driver.get("https://www.idupesh.com/articles/8-jamie-whincup-is-the-2017-supercars-champion-after-a-controversial-final-race-that-saw-scott-mclaughlin-lose-the-title-through-a-post-race-penalty-click-for-full-results.html");
  		//driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		//Thread.sleep(60000);

		}
	
	
	@AfterTest
	public void closeBrowser() {
		 driver.quit();
	}
}
