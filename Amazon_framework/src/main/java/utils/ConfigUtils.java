package utils;

import java.util.Properties;

public class ConfigUtils {
    private static Properties properties;
    private static ConfigUtils configUtils;

    private ConfigUtils() {
        properties =
                PropertiesUtils.LoadProperties("src/main/resources/data.properties");
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
    public String getEmail() {
        String prop = properties.getProperty("email");
        if (prop != null) return prop;
        else
            throw new RuntimeException("Couldn't email in Property file");
    }

    public String getvideoGamesURL() {
        String prop = properties.getProperty("videoGamesURL");
        if (prop != null) return prop;
        else
            throw new RuntimeException("Couldn't videoGamesURL in Property file");
    }

    public String getfullNameL() {
        String prop = properties.getProperty("fullName");
        if (prop != null) return prop;
        else
            throw new RuntimeException("Couldn't fullName in Property file");
    }
    public String getPassword() {
        String prop = properties.getProperty("password");
        if (prop != null) return prop;
        else
            throw new RuntimeException("Couldn't find password in Property file");
    }
    public String getLandMark() {
        String prop = properties.getProperty("landMark");
        if (prop != null) return prop;
        else
            throw new RuntimeException("Couldn't find land mark in Property file");
    }

    public String getPhone() {
        String prop = properties.getProperty("phone");
        if (prop != null) return prop;
        else
            throw new RuntimeException("Couldn't find phone in Property file");
    }

    public String getStreetName() {
        String prop = properties.getProperty("streetName");
        if (prop != null) return prop;
        else
            throw new RuntimeException("Couldn't find streetName in Property file");
    }

    public String getBuildingName() {
        String prop = properties.getProperty("buildingName");
        if (prop != null) return prop;
        else
            throw new RuntimeException("Couldn't find buildingName in Property file");
    }

    public String getCity() {
        String prop = properties.getProperty("city");
        if (prop != null) return prop;
        else
            throw new RuntimeException("Couldn't find city in Property file");
    }


}
