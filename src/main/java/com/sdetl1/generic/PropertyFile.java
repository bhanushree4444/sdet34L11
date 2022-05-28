package com.sdetl1.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * this class contains only property filespecific common methods
 * @author Madhu
 *
 */
public class PropertyFile {
	/**
	 * this method used to open the property file
	 */
	static Properties property;
	public static void open_property_file(String filePath) throws IOException   {
	FileInputStream fis=new FileInputStream(filePath);
	property=new Properties();
	property.load(fis);
}
/**
 * this method used to get the data from property file
 * @param key
 * @return
 * @throws IOException
 */
	public static String get_data_propertyfile(String key) throws IOException
	
	{
	String value = property.getProperty(key);	
	return value;
	}
}

