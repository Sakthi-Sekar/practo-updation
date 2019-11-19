#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.testscripts;

import java.io.File;
import java.util.Properties;

import java.io.*;
import java.util.*;
import org.dom4j.*;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.testng.annotations.Test;

import ${package}.constants.ConstantPaths;
import ${package}.helpers.ReadPropertiesFile;
import ${package}.pages.PageActions;
import ${package}.testbase.InvokeBrowser;
import ${package}.utils.ReadXML;

public class AddToCart extends InvokeBrowser {
	String Xpath;
	String cssSelector;
	ReadPropertiesFile read = new ReadPropertiesFile();
	ReadXML xml = new ReadXML();
	Properties prop = new Properties();

// To click on diagnostics and to select city
	public String readXmlFile(String elements) {
		File inputFile = new File(System.getProperty(ConstantPaths.LOCATOR_FILE));
		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read(inputFile);
		} catch (DocumentException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String value = prop.getProperty(elements);
		return value;
	}

	@Test(priority = 2)
	public void clickOnDiagnostics() throws Exception {

		Xpath = read.readPropertiesFile("loc.btn.diagnostics.xpath");
		PageActions.clickOnElement(driver, Xpath);
		log.info("Clicked on Diagnostics...");
	}

	@Test(priority = 3)
	public void selectCity() {
		Node document = null;

		//String city = document.selectSingleNode("//menu/selectanycityorlocality").getText();

		String selectcity = xml.readXmlFile("selectanycityorlocality");
		PageActions.clickOnElement(driver, Xpath);
	}
//		Xpath = read.readPropertiesFile("loc.field.selectanycityorlocality.xpath");
//		PageActions.ClickElement(driver, Xpath);
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//		log.info("Selected city...");
//		Xpath = read.readPropertiesFile("loc.field.searchfortestsandprofiles.xpath");
//		PageActions.ClickElement(driver, Xpath);
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//		log.info("Entered into next field to select test sample...");
}

//To select CBC Test
//		// driver.findElement(By.cssSelector("${symbol_pound}omniSearch")).sendKeys("CBC Test");
//		cssSelector = read.readPropertiesFile("loc.field.cbctest.cssselector");
//		PageActions.cssSendKeys(driver, cssSelector, "CBC Test");
//		// driver.findElement(By.cssSelector("cssSelector")).sendKeys(Keys.ENTER);
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//		log.info("CBC Test sample selected...");
//// Click on Add(CBC Test) to Cart
//		Xpath = read.readPropertiesFile("loc.btn.addtocartclick.xpath");
//		PageActions.clickOnElement(driver, Xpath);
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//		log.info("CBC Test added to cart...");
//
////Remove previous search(CBC Test)
//		Xpath = read.readPropertiesFile("loc.select.removesymbolcbctest.xpath");
//		PageActions.clickOnElement(driver, Xpath);
//		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		log.info("CBC Test search removed from the field...");
//		Thread.sleep(3000);
//		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);;
//// To select Serium Lipase 
//		cssSelector = read.readPropertiesFile("loc.field.selecttestsseriumlipase.cssselector");
//		Thread.sleep(5000);
//		PageActions.cssSendKeys(driver, cssSelector, "Serum Lipase");
//		Thread.sleep(7000);
//		log.info("Serium Lipase sample selected...");
//
////Click on Add (serium Lipase) to Cart
//		Xpath = read.readPropertiesFile("loc.addseriumlipasetocart.xpath");
//		Thread.sleep(3000);
//		// driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//		PageActions.clickOnElement(driver, Xpath);
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//		log.info("Serium Lipase added to cart...");
////To remove the last search(SeriumLipase)
//		Xpath = read.readPropertiesFile("loc.select.removesymbolseriumlipase.xpath");
//		PageActions.clickOnElement(driver, Xpath);
//		log.info("Serium Lipase search removed from the field...");
//// To select T3 T4 TSH test
//		cssSelector = read.readPropertiesFile("loc.select.t3t4tsh.cssselector");
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//		PageActions.cssSendKeys(driver, cssSelector, "T3 T4 TSH");
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//		log.info("T3 T4 TSH sample selected...");
//// Click on Add(T3 T4 TSH) to Cart
//		Xpath = read.readPropertiesFile("loc.btn.addtocartt3t4tsh.xpath");
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//		PageActions.clickOnElement(driver, Xpath);
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//		log.info("T3 T4 TSH added to cart...");
//	}

//Validation after adding test samples
//	@Test(priority = 2)
//	public void validateAfterAdd() throws FileNotFoundException {
//		validata.namesOfSampleEqual(driver);
//		validata.numberOfTestsEqual(driver);
//		validata.individualSamplePriceEqual(driver);
//		validata.pickUpChargeEqual(driver);
//		validata.initialTotalPriceEqual(driver);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	}
