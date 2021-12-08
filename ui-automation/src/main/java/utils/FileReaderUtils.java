package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileReaderUtils {
	
	static String propVal;
	final static String filePath = "./src/test/resources/testdata/config.properties";
	static FileInputStream fis = null;

	public static String getPropertyValue(String propertyKey) {
		
		File file = new File(filePath);

		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		propVal = prop.getProperty(propertyKey);	
		return propVal;
		
	}

}
