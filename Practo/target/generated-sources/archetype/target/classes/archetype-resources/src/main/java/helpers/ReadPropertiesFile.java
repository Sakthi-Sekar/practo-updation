#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.helpers;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.util.Properties;

import ${package}.constants.ConstantPaths;

public class ReadPropertiesFile {
	FileInputStream input;
	FileInputStream practolocators;
	FileInputStream validate;
	

	public String readPropertiesFile(String elements) {
		Properties prop = new Properties();

		try {
			input = new FileInputStream(ConstantPaths.CONFIG_FILE);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			practolocators = new FileInputStream(ConstantPaths.LOCATORS_FILE);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			prop.load(input);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			prop.load(practolocators);

		} catch (Exception e) {
			e.printStackTrace();
		}
		String data = prop.getProperty(elements);
		return data;
	}

}