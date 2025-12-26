
package genericUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class FileUtils {

	/**
	 * This method is used to read data from property file
	 * @author Kavya
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public String readDataFromPropertyFile(String key) throws Exception {
		
		FileInputStream fi = new FileInputStream(IpathConstants.filepath);
		Properties pro= new Properties();
		pro.load(fi);
		String value=pro.getProperty(key);
		return value;
	}

}
