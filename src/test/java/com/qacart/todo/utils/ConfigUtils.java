package com.qacart.todo.utils;

import lombok.Getter;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtils {

    @Getter
    private static final ConfigUtils instance = new ConfigUtils();
    private Properties properties;

    private ConfigUtils() {
        properties = readProp();
    }

    private Properties readProp() {
        InputStream is;
        try {
            String env = System.getProperty("env", "PRODUCTION");
            switch (env) {
                case "PRODUCTION" -> is = new FileInputStream("src/test/resources/env/production.properties");
                case "LOCAL" -> is = new FileInputStream("src/test/resources/env/local.properties");
                case "QA" -> is = new FileInputStream("src/test/resources/env/qa.properties");
                case "CERT" -> is = new FileInputStream("src/test/resources/env/cert.properties");
                default -> throw new RuntimeException("Environment is not supported!");
            }
            properties = new Properties();
            properties.load(is);
            System.out.println(properties.get("URL"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return properties;
    }

    public String getBaseURL() {
        return properties.get("URL").toString();
    }
}
