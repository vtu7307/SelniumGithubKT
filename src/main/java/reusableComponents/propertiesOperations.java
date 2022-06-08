package reusableComponents;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class propertiesOperations {
	 static Properties prop = new Properties();
	public static String getPropertyValueByKey(String key) throws Exception {
		String ProfFilePath = System.getProperty("user.dir")+"/src/test/resources/config.properties";
		FileInputStream fis = new FileInputStream(ProfFilePath);
		prop.load(fis);
		String Value = prop.get(key).toString();
		
		if(StringUtils.isEmpty(Value)) {
		
			throw new Exception("Value is not specified in the key: " +key+" in the properties file");
		}
		return Value;
	}

}
