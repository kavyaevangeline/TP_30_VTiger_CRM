package Sample;

import org.testng.annotations.Test;

public class Sample_depen_prior {
	
	@Test(priority = 5)
	public void m4() {
		System.out.println("m4");
	}
	
	@Test(dependsOnGroups = "m4", priority = 1)
	public void m1() {
		System.out.println("m1");
	}
	
	@Test(dependsOnGroups = "m1", priority = 2)
	public void m3() {
		System.out.println("m3");
	}
	
	@Test(priority = 4)
	public void m2() {
		System.out.println("m2");
	}
	
}
