package testgrid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.lang.InterruptedException;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.Map;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.Proxy.ProxyType;

public class TestGridClass {
	public WebDriver driver;
	public String URL, Node;
	protected ThreadLocal<RemoteWebDriver> threadDriver = null;
//	String browser = "firefox";
	@Parameters({"browser","pr","Nodeurl"})
		
	@BeforeTest
	public void launchbrowser(String browser,String pr, String Nodeurl) throws MalformedURLException {
		//String URL = "http://www.calculator.net";

		if (browser.equalsIgnoreCase("firefox")) {
			System.out.println(" Executing on FireFox in VM");
			String Node = "http://192.168.137.129:4444/wd/hub";
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			cap.setCapability("marionette", false);
			driver = new RemoteWebDriver(new URL(Node), cap);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} else if (browser.equalsIgnoreCase("chrome")) {
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
		else {
			throw new IllegalArgumentException("The Browser Type is Undefined");
		}
	}

	@Test
	public void calculatepercent() throws InterruptedException {
		

		
		driver.get("https://www.youtube.com/watch?v=yKeXgQ5yDAM");
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		Thread.sleep(120000);
		
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
		
		driver.get("https://www.idupesh.com/");
  		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		Thread.sleep(60000);
		
		driver.get("https://www.idupesh.com/articles/6-v8-supercars-newcastle-500.html");
  		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		Thread.sleep(60000);
		
		driver.get("https://www.idupesh.com/articles/7-looking-up-into-a-tree-at-tokyo-s-shinjuku-gyoen-park.html");
  		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		Thread.sleep(60000);
		
		driver.get("https://www.idupesh.com/articles/8-jamie-whincup-is-the-2017-supercars-champion-after-a-controversial-final-race-that-saw-scott-mclaughlin-lose-the-title-through-a-post-race-penalty-click-for-full-results.html");
  		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		Thread.sleep(60000);
		
		
		

		

		}
	@AfterTest
	public void closeBrowser() {
		 driver.quit();
	}
}