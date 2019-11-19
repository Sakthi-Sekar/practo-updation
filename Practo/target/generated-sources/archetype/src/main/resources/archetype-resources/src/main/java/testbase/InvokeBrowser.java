#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.testbase;

import java.io.IOException;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import ${package}.helpers.ReadPropertiesFile;
import ${package}.reports.LogReports;

public class InvokeBrowser {
	public LogReports log = new LogReports();
	public static WebDriver driver;
	Properties config = new Properties();
	protected ReadPropertiesFile read = new ReadPropertiesFile();

//To invoke the chrome browser by practo URL
	@Test(priority = 1)
	public void setup() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:${symbol_escape}${symbol_escape}Users${symbol_escape}${symbol_escape}sakthi.sekar${symbol_escape}${symbol_escape}eclipse-workspace${symbol_escape}${symbol_escape}${artifactId}${symbol_escape}${symbol_escape}lib${symbol_escape}${symbol_escape}chromedriver.exe");
		driver = new ChromeDriver();
		log.info("Chrome browser invoked...");
		driver.get(read.readPropertiesFile("url"));
		log.info("Application opened...");
		driver.manage().window().maximize();
	}
}