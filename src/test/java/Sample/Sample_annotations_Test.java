package Sample;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sample_annotations_Test {

	@Test
	public void sample_test() {
		System.out.println("--- Test ---");
	}
	
	@BeforeSuite
	public void sample_bs() {
		System.out.println("--- before suite ---");
	}
	
	@AfterMethod
	public void sample_am() {
		System.out.println("--- after method ---");
	}
	
	@BeforeClass
	public void sample_bc() {
		System.out.println("--- before class ---");
	}
	
	@AfterClass
	public void sample_ac() {
		System.out.println("--- afrer class ---");
	}
	
	@BeforeMethod
	public void sample_bm() {
		System.out.println("--- before method ---");
	}
	
	@AfterSuite
	public void sample_as() {
		System.out.println("--- after suite ---");
	}
	
	@BeforeMethod
	public void sample_bm2() {
		System.out.println("--- before method 2 ---");
	}
	
	@AfterSuite
	public void sample_as2() {
		System.out.println("--- after suite 2 ---");
	}
	
	@BeforeTest
	public void sample_bt() {
		System.out.println("--- before test ---");
	}
	
	@Test
	public void sample_test1() {
		System.out.println("--- test 2 ---");
	}
	
	@Test
	public void sample_test3() {
		System.out.println("--- test 3 ---");
	}
}
