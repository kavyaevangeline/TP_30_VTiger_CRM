package AutomationTestingPractice;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericUtilities.BaseClass;

public class AssertSoft extends BaseClass {

	
	@Test
	public void m1() {
		
		SoftAssert sa=new SoftAssert();
		System.out.println(" - 1 -");
		System.out.println(" - 2 -");
		sa.assertEquals("a", "b");
		System.out.println(" - 3 -");
		System.out.println(" - 4 -");
		sa.assertAll();
	}
}
