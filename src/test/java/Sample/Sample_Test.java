package Sample;

import org.testng.annotations.Test;

public class Sample_Test {

	@Test
	public void sample_m1() {
		System.out.println("---- first ----");
	}
	
	@Test(invocationCount = 2)
	public void sample_m4() {
		System.out.println("---- fourth ----");
	}
	
	@Test(dependsOnMethods = "sample_m3")
	public void sample_m2() {
		System.out.println("---- second ----");
	}
	
	@Test
	public void sample_m3() { 
		
		System.out.println("---- third ----");
	}
	
}
