package testgrid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.lang.InterruptedException;
import java.util.Arrays;
import java.lang.Math;
import java.util.Map;
import java.util.regex.Pattern;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.List;

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





public class qqqq {
	public WebDriver driver;
	public String URL, Node;
	protected ThreadLocal<RemoteWebDriver> threadDriver = null;
//	String browser = "firefox";
	@Parameters({"browser","pr","Nodeurl"})
	
	
	

	@Test
	public void testLogin() throws Exception {
	String baseUrl = "http://idupesh.com";
	driver.get(baseUrl + "/");
	List<WebElement> elems = driver.findElements(By.xpath("//ul[@id='dj-megamenu145']/li"));
	WebElement webEle = null;
	System.out.println("Cicle for idupesh.com menu started with "+elems.size()+" elements");
	for (int i=1; i<=elems.size(); i++){
	driver.switchTo().defaultContent();
	webEle=driver.findElement(By.xpath("//ul[@id='dj-megamenu145']/li["+i+"]"));
	webEle.click();
	driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
	System.out.println("!--------------------------------------------------------!");
	//System.out.println(driver.findElement(By.xpath("//ul[@id='dj-megamenu145']/li["+i+"]")).getText());
	System.out.println("Clicked menu "+i+" "+driver.findElement(By.xpath("//ul[@id='dj-megamenu145']/li["+i+"]/a")).getText());
	
	List<WebElement> elFrame = driver.findElements(By.tagName("iframe"));
	            //for (WebElement elFramename : elFrame)
               // System.out.println("frameid: " + elFramename.getAttribute("title"));  
			
	if (elFrame.size()!=0){
			System.out.println("Count of Frames on page "+elFrame.size());
			for (int n=0; n<elFrame.size(); n++){
				int s=n+1;
				System.out.println("Current number of video frame is "+s);
				WebDriverWait waitPagination = new WebDriverWait(driver, 5);
				//waitPagination.ignoring(NoSuchElementException.class);
				//waitPagination.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='nspPagination']")));
				//driver.findElement(By.xpath("//ul[@class='nspPagination']/li["+s+"]/a")).click();
					System.out.println("Searching for nspPagination buttons on the page ");
				if (driver.findElements(By.xpath("//ul[@class='nspPagination']")).size()!=0){
					driver.findElement(By.xpath("//ul[@class='nspPagination']/li["+s+"]/a")).click();
					System.out.println("Found nspPagination and clicked " +s);
					}					
				else{
					System.out.println("Not found nspPagination on the page ");
					}
				driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
				driver.switchTo().frame(n);
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
							System.out.println("NoSuchElementException " +n);
						}
				
				driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
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

	
	
	@Test
	public void calculatepercent() throws InterruptedException {
		
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