package org.pwl.framework;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Properties;

public class PropertiesUtils {
    public static String getProperty(String file, String key) {
        Properties properties = new Properties();
        try {
            properties.load(PropertiesUtils.class.getClassLoader().getResourceAsStream(file));
        } catch (IOException exception) {
            throw new UncheckedIOException(exception);
        }
        return properties.getProperty(key);
    }
}
