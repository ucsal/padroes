package ws.domore.manager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Constantes {
	
//	src/main/java/ws/domore/manager/Constantes.java
//	src/main/resources/constantes.properties
	
	public static String getProp(String key)  {
		try {
			Properties properties = new Properties();
			FileInputStream in = new FileInputStream("src/main/resources/constantes.properties");
			properties.load(in);
			in.close();
			return properties.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return key;

	}
	

}
