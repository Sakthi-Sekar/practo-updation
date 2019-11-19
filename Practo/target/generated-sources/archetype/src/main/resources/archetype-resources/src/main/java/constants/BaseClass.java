#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.constants;

import java.io.IOException;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;

import ${package}.helpers.ReadPropertiesFile;
import ${package}.reports.LogReports;

public class BaseClass  {
	
protected static ReadPropertiesFile read = new ReadPropertiesFile();
public  WebDriver driver;
public Properties property;
public static LogReports log = new LogReports();

/**
 * select driver class type
 * 
 * @param browserType
 * @throws IOException
 */	
@Parameters("browser")
	public void openBrowser(String browserType) throws IOException {
	
	switch (browserType) {
	
		case "chrome":
			ChromeOptions optionschrome = new ChromeOptions();
			optionschrome.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", ConstantPaths.CHROME_FILE);
			driver = new ChromeDriver(optionschrome);
			break;
			
		case "firefox":
			System.setProperty("webdriver.gecko.driver",ConstantPaths.FIREFOX_FILE);			
			driver = new FirefoxDriver();
			break;
			
		case "ie":			
			System.setProperty("webdriver.ie.driver", ConstantPaths.IE_FILE);
			driver = new InternetExplorerDriver();
			break;
	
		}
		
		driver.manage().window().maximize();
		driver.get(read.readPropertiesFile("url"));
		
		
	}
}
