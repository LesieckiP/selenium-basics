package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetProperties {

	static Properties p = new Properties();


	public static String getProperty(String property){
		String prop;
		try{
			InputStream is = ClassLoader.getSystemResourceAsStream("config.properties");
			p.load(is);
			prop = p.getProperty(property);
			is.close();
		}catch(IOException e){
			throw new RuntimeException(e);
		}
		return prop;
	}
}
