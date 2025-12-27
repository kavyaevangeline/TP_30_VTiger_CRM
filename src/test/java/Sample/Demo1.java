package Sample;

import org.testng.annotations.Test;

import genericUtilities.BaseClass;

public class Demo1 extends BaseClass{
	
	@Test
	public void test1() {
		System.out.println("test-1");
	}
	
	@Test
	public void test2() {
		System.out.println("test-2");
	}
	
	@Test
	public void wish()
	{
		System.out.println("Happy new year");
	}

}
