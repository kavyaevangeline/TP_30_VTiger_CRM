package Sample;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Demo_annot_Test {

	
	@Test
	public void demo_test() {
		System.out.println("--- demo test ---");
	}
	
	@BeforeSuite
	public void bs() {
		System.out.println("--- demo before suit ---");
	}
	
	@AfterSuite
	public void as() {
		System.out.println("--- demo after suit ---");
	}
	
	@BeforeClass
	public void bc() {
		System.out.println("--- demo before class ---");
	}
	
	@AfterClass
	public void ac() {
		System.out.println("--- demo after class ---");
	}
	
	@BeforeMethod
	public void bm() {
		System.out.println("--- demo before method ---");
	}
	
	@AfterMethod
	public void am() {
		System.out.println("--- demo after method ---");
	}
	
}
