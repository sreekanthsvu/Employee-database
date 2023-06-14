package edbms;

import java.util.Scanner;

import customexception.InvalidChoiceException1;


public class Solution 
{
	public static void main(String[] args) {
		System.out.println("welcome to Employee database project");
		System.out.println("=====================");
	
	EmployeeDatabaseProject e=  new employeeDatabaseProjectImpl();
	Scanner sc=new Scanner(System.in );
	while(true)
	{
		System.out.println("1.addemployee");
		System.out.println("2.displayEmployee");
		System.out.println("3.displayallEmployee");
		System.out.println("4.removeEmployee");
		System.out.println("5.removeallEmployee");
		System.out.println("6.updateEmployee");
		System.out.println("7.sortEmployee");
		System.out.println("8.employeewithhighestsalary");
		System.out.println("9.employeewithlowestsalary");
		System.out.println("10.countemployee");
		System.out.println("enter your choice");


	int choice=sc.nextInt();
	switch(choice)
	{
	case 1:e.addEmployee();
	break;
	case 2:e.displayEmployee();
	break;
	case 3:e.displayallEmployee();
	break;
	case 4:e.removeEmployee();
	break;
	case 5:e.removeallEmployee();
	break;
	case 6:e.updateEmployee();
	break;
	case 7:e.sortEmployee();
	break;
	case 8:e.employeewithhighestsalary();
	break;
	case 9:e.employeewithlowestsalary();
	break;
	case 10:e.countEmployee();
	break;
	default:
		try {
			String message="invalid choice ,Kindely enter valid choice";
			throw new InvalidChoiceException1(message);
		}
		catch(Exception E)
		{
			System.out.println(E.getMessage());
		}
	}
	}
	}

}
