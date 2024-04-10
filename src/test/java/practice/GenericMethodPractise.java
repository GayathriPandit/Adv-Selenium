package practice;

public class GenericMethodPractise {
		//23/02/24									//user
	public static void main(String[] args) {//caller function
		
		//int a= 20;Hard coded
		//int b=20;
		//int c= a+b;
		//System.out.println(c);
		
		
		int sum = add(19,40);
		System.out.println(sum);
		
		int data = sum+10;
		System.out.println(data);
		
		sub();
		add(30,50);
		add(50,60);
		
	}
	//Parameterization - inputs from caller - 1
	public static int add(int a,int b)//called function - generic methods
	{
		int c =a+b;
		return c;
		//return the output to caller - 2
	}
	
	public static void sub()
	{
		int a=20;
		int b= 10;
		int c = b-a;
		System.out.println(c);
	}

}
