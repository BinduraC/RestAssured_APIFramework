package com.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class FileUtility {
	
	/**
	 * this method is used to get property value from the .properties file
	 * 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getPropertyValue(String key) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(IConstants.filepath);
		Properties properties = new Properties();
		properties.load(fileInputStream);
		
		String value = properties.getProperty(key);
		return value;	
	}

}
