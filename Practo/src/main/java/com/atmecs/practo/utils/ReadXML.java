package com.atmecs.practo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import com.atmecs.practo.constants.ConstantPaths;

public class ReadXML {
	FileInputStream xml;
	Properties prop = new Properties();

	@SuppressWarnings("unused")
	public String readXmlFile(String elements) {
		File inputFile = new File(System.getProperty(ConstantPaths.LOCATOR_FILE));
		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read(inputFile);
		} catch (DocumentException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			xml = new FileInputStream(ConstantPaths.LOCATOR_FILE);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			prop.load(xml);

		} catch (Exception e) {
			e.printStackTrace();
		}
		String value = prop.getProperty(elements);
		return value;
	}
}
