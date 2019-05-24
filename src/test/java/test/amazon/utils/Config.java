package test.amazon.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
	
	private static Properties prop;
	static {
		try {
			prop = new Properties();
			FileInputStream input = new FileInputStream(System.getProperty("user.dir") + "//config.properties");
			prop.load(input);
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Property File Not Found");
		}
	}

	/* Get Value By key */
	public static String getPropertyValue(String key) {
		return prop.getProperty(key);
	}

}