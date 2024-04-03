package practice;

import org.testng.annotations.Test;

public class TestNgPractice {
	@Test(invocationCount = 0)
	/*it is used to repeat the method for particular no.of times,
	if we give 0 or -ve it is disabled*/
	public void createContact()
	{
		System.out.println("Contact Created");
	}
	
	@Test(dependsOnMethods = "createContact")
	/*it depends on the method mentioned if it is pass then only the current  will execute
	otherwise it will not*/
	public void editContact()
	{
		System.out.println("Contact Edited");
	}
	//if we don't give priority testng will execute in ASCII order
	
	@Test(enabled = false)//for not executing
	public void deleteContact()
	{
		System.out.println("Contact Deleted");
	}

}
