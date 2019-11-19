package com.atmecs.practo.testscripts;

import java.io.File;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.*;
import java.util.*;
import org.dom4j.*;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.atmecs.practo.constants.ConstantPaths;
import com.atmecs.practo.helpers.ReadPropertiesFile;
import com.atmecs.practo.pages.PageActions;
import com.atmecs.practo.testbase.InvokeBrowser;
import com.atmecs.practo.utils.ReadXML;
import com.atmecs.practo.utils.ValidatePracto;

public class AddToCart extends InvokeBrowser {
	String Xpath;
	String cssSelector;
	ReadPropertiesFile read = new ReadPropertiesFile();
	ReadXML xml = new ReadXML();
	Properties prop = new Properties();
	ValidatePracto validata=new ValidatePracto();

// To click on diagnostics and to select city
//	public String readXmlFile(String elements) {
//		File inputFile = new File(System.getProperty(ConstantPaths.LOCATORS_FILE));
//		SAXReader saxReader = new SAXReader();
//		try {
//			Document document = saxReader.read(inputFile);
//		} catch (DocumentException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//		String value = prop.getProperty(elements);
//		return value;
//	}

	@Test(priority = 2)
	public void clickOnDiagnostics() throws Exception {

		Xpath = read.readPropertiesFile("loc.btn.diagnostics.xpath", Xpath);
		PageActions.clickOnElement(driver, Xpath);
		log.info("Clicked on Diagnostics...");
	}

	@Test(priority = 3)
	public void selectCity() {
		//Node document = null;

		//String city = document.selectSingleNode("//menu/selectanycityorlocality").getText();

		String selectcity = xml.readXmlFile("selectanycityorlocality");
		PageActions.clickOnElement(driver, Xpath);
	
	Xpath = read.readPropertiesFile("loc.field.selectanycityorlocality.xpath", selectcity);
		PageActions.ClickElement(driver, Xpath);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		log.info("Selected city...");
		Xpath = read.readPropertiesFile("loc.field.searchfortestsandprofiles.xpath", selectcity);
	PageActions.ClickElement(driver, Xpath);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		log.info("Entered into next field to select test sample...");


//To select CBC Test
		 driver.findElement(By.cssSelector("#omniSearch")).sendKeys("CBC Test");
		cssSelector = read.readPropertiesFile("loc.field.cbctest.cssselector", selectcity);
		PageActions.cssSendKeys(driver, cssSelector, "CBC Test");
		driver.findElement(By.cssSelector("cssSelector")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	log.info("CBC Test sample selected...");
// Click on Add(CBC Test) to Cart
		Xpath = read.readPropertiesFile("loc.btn.addtocartclick.xpath", selectcity);
	PageActions.clickOnElement(driver, Xpath);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		log.info("CBC Test added to cart...");

//Remove previous search(CBC Test)
		Xpath = read.readPropertiesFile("loc.select.removesymbolcbctest.xpath", selectcity);
		PageActions.clickOnElement(driver, Xpath);
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		log.info("CBC Test search removed from the field...");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);;
// To select Serium Lipase 
		cssSelector = read.readPropertiesFile("loc.field.selecttestsseriumlipase.cssselector", selectcity);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		PageActions.cssSendKeys(driver, cssSelector, "Serum Lipase");
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		log.info("Serium Lipase sample selected...");

//Click on Add (serium Lipase) to Cart
	Xpath = read.readPropertiesFile("loc.addseriumlipasetocart.xpath", selectcity);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		PageActions.clickOnElement(driver, Xpath);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		log.info("Serium Lipase added to cart...");
//To remove the last search(SeriumLipase)
		Xpath = read.readPropertiesFile("loc.select.removesymbolseriumlipase.xpath", selectcity);
		PageActions.clickOnElement(driver, Xpath);
		log.info("Serium Lipase search removed from the field...");
// To select T3 T4 TSH test
		cssSelector = read.readPropertiesFile("loc.select.t3t4tsh.cssselector", selectcity);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		PageActions.cssSendKeys(driver, cssSelector, "T3 T4 TSH");
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		log.info("T3 T4 TSH sample selected...");
// Click on Add(T3 T4 TSH) to Cart
		Xpath = read.readPropertiesFile("loc.btn.addtocartt3t4tsh.xpath", selectcity);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		PageActions.clickOnElement(driver, Xpath);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		log.info("T3 T4 TSH added to cart...");
	}

//Validation after adding test samples
	@Test(priority = 2)
	public void validateAfterAdd() throws FileNotFoundException {
		validata.namesOfSampleEqual(driver);
		validata.numberOfTestsEqual(driver);
		validata.individualSamplePriceEqual(driver);
		validata.pickUpChargeEqual(driver);
	validata.initialTotalPriceEqual(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
