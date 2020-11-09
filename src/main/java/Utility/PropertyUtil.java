package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {
    public static String fileName = System.getProperty("user.dir") + "/testData/locator.properties";
    public static Properties OR = null;

    public static String getLocator(String locatorName) throws IOException {
        FileInputStream fis = null;
            if (OR==null){
            fis = new FileInputStream(fileName);
            OR = new Properties();
            OR.load(fis);
        }
            String locatorValue=OR.getProperty(locatorName);
            return locatorValue;
    }
}
