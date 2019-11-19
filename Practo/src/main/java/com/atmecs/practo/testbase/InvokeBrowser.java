package com.atmecs.practo.testbase;

import java.io.IOException;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.atmecs.practo.constants.ConstantPaths;
import com.atmecs.practo.helpers.ReadPropertiesFile;
import com.atmecs.practo.reports.LogReports;

public class InvokeBrowser {
	public LogReports log = new LogReports();
	public static WebDriver driver;
	Properties config = new Properties();
	protected ReadPropertiesFile read = new ReadPropertiesFile();

//To invoke the chrome browser by practo URL
	@Test(priority = 1)
	public void setup() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sakthi.sekar\\eclipse-workspace\\Practo\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		log.info("Chrome browser invoked...");
		driver.get(read.readPropertiesFile("url", ConstantPaths.CONFIG_FILE));
		log.info("Application opened...");
		driver.manage().window().maximize();
	}
}