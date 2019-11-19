package com.atmecs.practo.dynamic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.atmecs.practo.constants.ConstantPaths;
import com.atmecs.practo.helpers.ReadPropertiesFile;
import com.atmecs.practo.testbase.BaseClass;
import com.atmecs.practo.testscripts.AddToCart;

public class Xmlclass  {
	String browsername;
	String browser;
	Properties config = new Properties();
	public static WebDriver driver;
	protected ReadPropertiesFile read = new ReadPropertiesFile();

	@SuppressWarnings("deprecation")
	@Test
	public void base() throws IOException {
		// driver.get(read.readPropertiesFile("url"));
		browsername = read.readPropertiesFile("browser", ConstantPaths.CONFIG_FILE);

		String[] browser = browsername.split(",");

		XmlSuite xmlsuite = new XmlSuite();
		xmlsuite.setName("suitename");
		xmlsuite.setVerbose(2);
		xmlsuite.setThreadCount(3);
		xmlsuite.setParallel("tests");
		for (String element : browser) {

			XmlTest xmltest = new XmlTest(xmlsuite);
			Map<String, String> parameter = new HashMap<String, String>();
			parameter.put("browsername", element);
			xmltest.setParameters(parameter);
			xmltest.setName("Test validate " + element);

			XmlClass homePage = new XmlClass(AddToCart.class);
// XmlClass productDetail = new XmlClass(.class);
			List<XmlClass> list = new ArrayList<XmlClass>();
			list.add(homePage);
// list.add(productDetail);
			xmltest.setXmlClasses(list);

		}

		TestNG testng = new TestNG();
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(xmlsuite);
		testng.setXmlSuites(suites);

		testng.run();

	}

}
