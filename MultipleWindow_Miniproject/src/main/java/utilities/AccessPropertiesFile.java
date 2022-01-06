package utilities;

import java.util.Properties;

public class AccessPropertiesFile {
	public static Properties prop = ReadPropertiesFile.readConfigProperties();
	public static String getBrowserProperty()
	{
		return prop.getProperty("browser");
	}
	public static String getUrlProp()
	{
		return prop.getProperty("baseURL");
	}



}
