package tools.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {

	private static PropertyManager propertyManager = new PropertyManager();
	private Properties properties;
	public final static String propertiesPath = "./classNameList.properties";

    private PropertyManager() {
        properties = new Properties();
    }
    
    
    
    public static PropertyManager getPropertyManager() {
		return propertyManager;
	}



	public Properties getProperties() {
        return properties;
    }
    
    public void loadProp(String path) throws IOException {

        InputStream inputStream = getClass().getResourceAsStream(path);
        properties.load(inputStream);
        inputStream.close();
    }
    
    public static Properties loadPropForStatic(String path) throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = PropertyManager.class.getClassLoader().getResourceAsStream(path);
        properties.load(inputStream);
        inputStream.close();
        return properties;
    }
    
    public String getPropertiesValue(String key){
    	String value = "";
    	try {
			this.loadProp(propertiesPath);
			Properties properties = this.getProperties();
			value = properties.getProperty(key);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return value;
    }
}
