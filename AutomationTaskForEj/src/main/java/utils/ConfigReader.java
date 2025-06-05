package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

    static {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getBrowser() {
        return properties.getProperty("browser");
    }

    public static String getBaseUrl() {
        return properties.getProperty("baseUrl");
    }

    public static String getApiBaseUrl() {
        return properties.getProperty("apiBaseUrl");
    }

    public static String getValidUsername() {
        return properties.getProperty("validUsername");
    }

    public static String getValidPassword() {
        return properties.getProperty("validPassword");
    }

    public static int getTimeout() {
        return Integer.parseInt(properties.getProperty("timeout"));
    }
}