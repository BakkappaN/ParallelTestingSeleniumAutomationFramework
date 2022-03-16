package com.testautomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class PropertiesFileReader {

	public static String getPropertyValue(String key) throws Exception {
		Properties properties = null;
		try {
			Object[] fileNames = getAllPropertiesFiles();
			properties = new Properties();

			for (Object propertyFile : fileNames) {
				properties.load(new FileInputStream(propertyFile.toString()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		key = properties.getProperty(key);
		return key;
	}

	private static Object[] getAllPropertiesFiles() {
		String environment = new TestDataHandler().getEnvironment();
		String dirPath = "./src/test/resources/properties/" + environment + "/";
		File directory = new File(dirPath);
		File[] listOfFiles = directory.listFiles();
		List list = new ArrayList();
		for (File file : listOfFiles) {
			if (file.isFile()) {
				list.add(dirPath.replace('\\', '/') + file.getName());
			}
		}
		return list.toArray();
	}

	public Properties getPropertyForConfig() throws Exception {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("./src/test/resources/Configurations.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return properties;
	}

}