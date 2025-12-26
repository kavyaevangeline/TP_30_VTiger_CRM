package Sample;

import org.testng.annotations.Test;

public class Sample_dependon_Test {

	@Test
	public void sample_m4() {
		System.out.println("---- m4 ----");
	}
	
	@Test(dependsOnMethods = "sample_m3")
	public void sample_m2() {
		System.out.println("--- m2 ---");
	}
	
	@Test
	public void sample_m3() {
		int a[]= {1,2,3};
		System.out.println(a[5]);
		System.out.println("--- m3 ---");
	}
	
	@Test
	public void sample_m1() {
		System.out.println("--- m1 ---");
	}
}
