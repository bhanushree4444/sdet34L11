package com.practiceTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class PropertyDataTest {

	public static void main(String[] args) throws SQLException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/CommonData.properties");
		Properties properties = new Properties();
		properties.load(fis);
		String url = properties.getProperty("url");
		System.out.println(url);
	}

}
