package testgrid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.Map;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestGridClass {
	public WebDriver driver;
	public String URL, Node;
	protected ThreadLocal<RemoteWebDriver> threadDriver = null;
//	String browser = "firefox";
	@Parameters("browser")
	@BeforeTest
	public void launchbrowser(String browser) throws MalformedURLException {
		//String URL = "http://www.calculator.net";

		if (browser.equalsIgnoreCase("firefox")) {
			System.out.println(" Executing on FireFox");
			String Node = "http://192.168.137.129:4444/wd/hub";
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");

			driver = new RemoteWebDriver(new URL(Node), cap);
			// Puts an Implicit wait, Will wait for 10 seconds before throwing
			// exception
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// Launch website
			//driver.navigate().to(URL);
			//driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.out.println(" Executing on CHROME");
	//	ChromeDriverManager.getInstance().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless", "--disable-gpu");
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		//cap.setVersion("62");

			//ChromeDriverManager.getInstance().setup();

			//options.put("binary", "/usr/lib/chromium-browser/chromium-browser");
			//options.put("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");

			//cap.setVersion("62");
			//cap.setPlatform("Ubuntu"); 
			//cap.setCapability("platform", "Ubuntu");
			//cap.setCapability("", "--no-sandbox");
			//cap.setCapabilities("chrome.switches", Arrays.asList("--start-maximized"));
			String Node = "http://192.168.137.129:4444/wd/hub";
			System.setProperty("webdriver.chrome.driver", "/usr/bin/google-chrome");
			driver = new RemoteWebDriver(new URL(Node), cap);
			//driver = new RemoteWebDriver(new URL(Node), options.ToCapabilities());
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// Launch website
			//driver.navigate().to(URL);
			driver.manage().window().maximize();
		}  else {
			throw new IllegalArgumentException("The Browser Type is Undefined");
		}
	}

	@Test
	public void calculatepercent() {
		//driver.navigate().to("https://www.google.com");
		driver.get("https://www.youtube.com/watch?v=KPQhbSKx0E8");
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		
		driver.get("https://youtu.be/e0_CiFfa5pM");
  		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		
	//System.out.println("Launched page https://www.google.com");
	// boolean title = driver.getTitle() == "Google class";
	//System.out.println(driver.getTitle()+" class");

    //if(title)

      //  System.out.println("I am working correctly");

    //else if(!title)

      //  System.out.println("I am braiken!");
	

	}
	@AfterTest
	public void closeBrowser() {
		 driver.quit();
	}
}