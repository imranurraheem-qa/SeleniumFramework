package testcases;

import org.testng.annotations.Test;

import utilities.BaseClass;

public class Test1 extends BaseClass
{
	
	@Test(description="Test1")
	public void testMethod()
	{
		System.out.println("hello");
	}

}
