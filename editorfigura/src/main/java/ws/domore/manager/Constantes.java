package ws.domore.manager;

import java.io.IOException;
import java.util.Properties;

public class Constantes {
	
	public String getProp(String key)  {
		try {
			Properties properties = new Properties();
			properties.load(this.getClass().getClassLoader().getResourceAsStream("constantes.properties"));
			
			//in.close();
			return properties.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return key;

	}
	

}
