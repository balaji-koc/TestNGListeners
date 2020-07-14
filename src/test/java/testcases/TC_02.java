package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_02 {
	
	@Test(groups={"func", "masters"},priority=6,dependsOnMethods="method_08")
	public void method_05()
	{
		System.out.println("In method_05 .....");
		Assert.assertTrue(true);
	}
	
	@Test(groups={"func", "masters"},priority=5)
	public void method_06()
	{
		System.out.println("In method_06 .....");
		Assert.assertTrue(true);
	}
	
	@Test(groups={"func", "masters"},priority=4)
	public void method_07()
	{
		System.out.println("In method_07 .....");
		Assert.assertTrue(true);
	}
	
	@Test
	public void method_08()
	{
		System.out.println("In method_08 .....");
		Assert.assertFalse(true);
		
	}
	

}
