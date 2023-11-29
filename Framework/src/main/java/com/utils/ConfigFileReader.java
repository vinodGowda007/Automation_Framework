package com.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	public static Properties prop;
	private final String propertyFilePath = "C:\\Users\\Administrator\\eclipse-workspace\\Framework\\config\\properties\\config.properties";

	public ConfigFileReader() {
		BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			prop = new Properties();

			try {
				prop.load(reader);
				reader.close();
			} catch (IOException e) {

				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
			throw new RuntimeException("config.properties file not found at " + propertyFilePath);
		}

	}

	public static String readDataFromPropertyFile(String key) {
		String value = prop.getProperty(key);

		if (value != null) {
			return value;
		}
		else
		{
			throw new RuntimeException(key + " is not specified in the config.properties.");
		}

	}

}
