package DataDrivenTesting;

import org.testng.annotations.Test;

public class ReadDataFromCmdLine {

	
	@Test
	public void cmdline() {
		String BROWSER = System.getProperty("browser");//system is local machine, launch into local machine
		String url = System.getProperty("url");
		String username = System.getProperty("username");
		String password = System.getProperty("password");
		
		
		System.out.println(BROWSER);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		
		
	}
}
