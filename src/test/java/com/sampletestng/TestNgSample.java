package com.sampletestng;


import org.testng.annotations.Test;

public class TestNgSample {
	
	@Test (priority=3)
	private void test6 () {
		System.out.println(" Test 6");
	}
	
	@Test (priority=2)
	private void test9  () {
		System.out.println(" Test 9");
	}
	
	@Test (priority=1 , invocationCount =3)
	private void test1 () {
		System.out.println(" Test 1");
	}
	@Test(priority=-2)
	private void test4 () {
		System.out.println(" Test 4");
	}
	
	@Test (priority=4 , enabled = false)
	private void test2() {
		System.out.println(" Test 2");
	}
	
	
	@Test (priority=5)
	private void test5() {
		System.out.println(" Test 5");
	}
	
	@Test (priority=-3 , enabled = false)
	private void test7 () {
		System.out.println(" Test 7 ");
	}
	@Test (priority=-1)
	private void test8 () {
		System.out.println(" Test 8");
	}
	
	
	

	

}
