package com.mt.jee.ioc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
	
	public static Properties loadProperties() {
		try {
			InputStream input = Configuration.class.getResourceAsStream("/jee-ioc-config.properties");
            Properties prop = new Properties();
            // load a properties file
            prop.load(input);
            return prop;

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
	}

}
