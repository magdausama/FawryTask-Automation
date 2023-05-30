package com.amazon.Utils;

import java.util.Properties;

public class ConfigUtils {
    private static Properties properties;
    private static ConfigUtils configUtils;

    private ConfigUtils() {
        properties =
                PropertiesUtils.LoadProperties("src/main/resources/Data/Data/data.properties");
    }

    public static ConfigUtils getInstance() {
        if (configUtils == null) {
            configUtils = new ConfigUtils();
        }
        return configUtils;
    }
    public String getBaseUrl() {
        String prop = properties.getProperty("baseUrl");
        if (prop != null) return prop;
        else
            throw new RuntimeException("Couldn't find BaseUrl in Property file");
    }
    public String getItemsUrl() {
        String prop = properties.getProperty("itemsUrl");
        if (prop != null) return prop;
        else
            throw new RuntimeException("Couldn't find BaseUrl in Property file");
    }
    public String getPhoneNumber() {
        String prop = properties.getProperty("phoneNumber");
        if (prop != null) return prop;
        else
            throw new RuntimeException("Couldn't find BaseUrl in Property file");
    }
    public String getPassword() {
        String prop = properties.getProperty("password");
        if (prop != null) return prop;
        else
            throw new RuntimeException("Couldn't find BaseUrl in Property file");
    }
}
