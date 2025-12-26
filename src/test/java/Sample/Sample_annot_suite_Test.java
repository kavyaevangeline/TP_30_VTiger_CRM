package Sample;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Sample_annot_suite_Test {

	@Test
	public void sample_test() {
		System.out.println("--- test ---");
	}
	
	@BeforeSuite
	public void sample_bs() {
		System.out.println("--- sample before suit ---");
	}
	
	@AfterSuite
	public void sample_as() {
		System.out.println("--- after suit ---");
	}
	
	@BeforeClass
	public void sample_bc() {
		System.out.println("--- sample before class");
	}
	
	@AfterClass
	public void sample_ac() {
		System.out.println("--- sample after class ---");
	}
	
	@BeforeMethod
	public void sample_bm() {
		System.out.println("--- sample before method");
	}
	
	@AfterMethod
	public void sample_am() {
		System.out.println("--- sample after method ---");
	}
}
