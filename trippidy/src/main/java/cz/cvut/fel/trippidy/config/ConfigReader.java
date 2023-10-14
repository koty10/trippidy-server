package cz.cvut.fel.trippidy.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class ConfigReader {
    private static final Logger log = Logger.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
    private static final String CONFIG_FILE = "config.properties";
    private static final Properties properties;

    static {
        properties = new Properties();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        try (InputStream input = classLoader.getResourceAsStream(CONFIG_FILE)) {
            properties.load(input);
        } catch (IOException e) {
            log.severe(e.getMessage());
        }
    }

    public static String getOpenaiApiKey() {
        return properties.getProperty("openai_api_key");
    }

    public static String getOpenaiModel() {
        return properties.getProperty("openai_model");
    }
}