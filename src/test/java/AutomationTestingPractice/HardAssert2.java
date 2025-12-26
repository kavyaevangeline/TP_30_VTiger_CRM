package AutomationTestingPractice;

import org.testng.Assert;
import org.testng.annotations.Listeners;

@Listeners(genericUtilities.Listnerimp.class)

public class HardAssert2 {

	public void m1() {
		
		System.out.println(" -- 1 --");
		System.out.println(" -- 2 --");
		Assert.assertEquals("A", "B");
		
	}
	
	
}
