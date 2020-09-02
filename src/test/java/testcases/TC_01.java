package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_01 {
	
	@Test(groups={"func", "masters"},priority=2)
	public void method_01()
	{
		System.out.println("In method_01 .....");
		Assert.assertTrue(true);
	}
	
	@Test(groups={"masters"},priority=0)
	public void method_02()
	{
		System.out.println("In method_02 .....");
		Assert.assertTrue(true);
	}
	
	@Test(groups={"func"},priority=1)
	public void method_03()
	{
		System.out.println("In method_03 .....");
		Assert.assertTrue(true);
	}
	
	@Test(groups={"masters"},priority=3)
	public void method_04()
	{
		System.out.println("In method_04 .....");
		Assert.assertFalse(true);
		
	}
	
	@Test(groups={"masters"},priority=3)
	public void method_05()
	{
		System.out.println("In method_04 .....WSP 01_01");
		Assert.assertFalse(true);
		
	}
}
