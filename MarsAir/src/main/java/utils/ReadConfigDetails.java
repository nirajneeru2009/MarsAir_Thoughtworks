package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigDetails {
	private Properties properties;
   
    // Method to get the value for a given key
    public String getConfigValue(String key) {
    	Properties properties = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("config.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return properties.getProperty(key, "Key not found");
    }
}
