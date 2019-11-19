package com.atmecs.practo.testbase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.practo.constants.ConstantPaths;
import com.atmecs.practo.grid.BaseGrid;
import com.atmecs.practo.helpers.ReadPropertiesFile;
import com.atmecs.practo.reports.LogReports;





public class TestBase {

	public WebDriver driver;
	public LogReports log = new LogReports();
	public ReadPropertiesFile read = new ReadPropertiesFile();
	String url;
	public String Xpath;

	@SuppressWarnings("deprecation")
	@Parameters("browsername")
	@Test
	public void invokeBrowser(String base) throws IOException {
		String modeofrunning = "grid";
		url = read.readPropertiesFile("Url", ConstantPaths.CONFIG_FILE);
		if(modeofrunning.equalsIgnoreCase("grid"))
		{
		driver=	BaseGrid.getDriver(base);
		}
		else {
			
		
// String base = Readproperties.readPropertiesFile("Browser", ConstantPaths.CONFIG_FILE);
		
		if (base.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ConstantPaths.CHROME_FILE);
			driver = new ChromeDriver();
			log.info("Chrome browser launched...");

		} else if (base.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ConstantPaths.FIREFOX_FILE);
			driver = new FirefoxDriver();
			log.info("Firefox browser launched...");

		} else if (base.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", ConstantPaths.IE_FILE);
			DesiredCapabilities ieCaps = DesiredCapabilities.internetExplorer();
			ieCaps.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "");
			driver = new InternetExplorerDriver(ieCaps);
			log.info("IE browser started...");
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.MINUTES);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		log.info("Application is open...");
	}
	}
	@AfterSuite
	public void closeBrowser() {
		//driver.quit();
	}

}
