package edbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import customexception.EmployeeNotFoundException;
import customexception.InvalidChoiceException1;
import customsorting.SortEmployeeByAge;
import customsorting.SortEmployeeById;
import customsorting.SortEmployeeByName;
import customsorting.SortEmployeeBySal;


public class employeeDatabaseProjectImpl implements  EmployeeDatabaseProject
{
Scanner sc=new Scanner(System.in);
Map <String,Employee>db=new LinkedHashMap<String,Employee>();
	@Override
	public void addEmployee() 
	{
		//Accept the name
				System.out.println("Enter the name");
				String name=sc.next();
				//Accepting the age
				System.out.println("Enter the age");
				 int age=sc.nextInt();
				//Accepting the sal
				System.out.println("Enter the sal");
				Double sal=sc.nextDouble();

				//creating the Student Object
				Employee emp=new Employee(name,sal,age);

				db.put(emp.getId(), emp);
				System.out.println("employee record inserted successfully");
				System.out.println("your employee id is"+emp.getId());


	}

	@Override
	public void displayEmployee() 
	{
		System.out.println("enter id");
		String  id=sc.next();
		id=id.toUpperCase();
		if(db.containsKey(id))
		{
			Employee emp=db.get(id);
			//System.out.println(emp);
			System.out.println("ID="+emp.getId());//
			System.out.println("Name="+emp.getName());
			System.out.println("Age="+emp.getAge());
			System.out.println("Salary="+emp.getSal());

		}
		else
		{ 
			try {
			String message="Invalid id,please enter the correct id";
			throw new EmployeeNotFoundException(message);
		}
		catch(EmployeeNotFoundException s)
		{
			System.out.println(s.getMessage())  ;
		}
		}
		
	}

	@Override
	public void displayallEmployee()
	{  
		if(!db.isEmpty()) {
			System.out.println("Employee records as follows");
		Set<String> key=db.keySet();
		for(String k:key)
		{
			System.out.println(""+db.get(k));
		}
	}else {
		try {
			String message="Invalid id,please enter the correct id";
			throw new EmployeeNotFoundException(message);
		}
		catch(EmployeeNotFoundException s)
		{
			System.out.println(s.getMessage())  ;
		}
		
	}
		
	}

	@Override
	public void removeEmployee() 
	{
		System.out.println("enter id");
		String  id=sc.next();
		id=id.toUpperCase();
		if(db.containsKey(id))
		{
			db.remove(id);
			System.out.println("employee with id"+id+"removed successfully");
		}
		else {
			try {
				String message="Invalid id,please enter the correct id";
				throw new EmployeeNotFoundException(message);
			}
			catch(EmployeeNotFoundException i)
			{
				System.out.println(i.getMessage())  ;
			}
		}
		
	}

	@Override
	public void removeallEmployee() 
	{
		db.clear();
		System.out.println("successfully removed all employee data");
		
		
	}

	@Override
	public void updateEmployee() 
	{
		System.out.println("enter emp id");
		String id=sc.next();
		id=id.toUpperCase();
		if(db.containsKey(id))
		{   
			Employee emp=db.get(id);
			System.out.println("1.update name");
			System.out.println("2.update age");
			System.out.println("3.update sal");
			System.out.println("enter your choice");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:System.out.println("enter name");
			String name=sc.next();
			emp.setName(name);
			case 2:System.out.println("enter age");
			int age=sc.nextInt();
			emp.setAge(age);
			case 3:System.out.println("enter sal");
			Double sal=sc.nextDouble();
				emp.setSal(sal);
			}
		}
			else {
				try {
					String message="Invalid id,please enter the correct id";
					throw new InvalidChoiceException1(message);
				}
				catch(InvalidChoiceException1 i)
				{
					System.out.println(i.getMessage())  ;
				}
			}



		}
		
	

	@Override
	public void countEmployee()
	{
		System.out.println("no of employees="+db.size());
		
	}

	@Override
	public void sortEmployee()
	
	{
		List<Employee> l=new ArrayList<Employee>();
		Set<String>k=db.keySet();
		for(String s:k)
		{
			Employee emp=db.get(s);
			l.add(emp);
		}
		System.out.println("1.sort by id");
		System.out.println("2.sort by name");
		System.out.println("3.sort by age");
		System.out.println("4.sort by sal");
		System.out.println("enter your choice");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:Collections.sort(l,new SortEmployeeById());
		for(Employee e1:l) {
			System.out.println(e1);

		}
		break;
		case 2:Collections.sort(l,new SortEmployeeByName());
		for(Employee e1:l) {
			System.out.println(e1);

		}
		break;

		case 3:Collections.sort(l,new SortEmployeeByAge());
		for(Employee e1:l) {
			System.out.println(e1);

		}
		break;
		case 4:Collections.sort(l,new SortEmployeeBySal());
		for(Employee e1:l) {
			System.out.println(e1);

		}
		break;
		default:try {
			String message="Invalid id,please enter the correct id";
			throw new InvalidChoiceException1(message);
		}
		catch(InvalidChoiceException1 i)
		{
			System.out.println(i.getMessage())  ;
		}

		}

		
		
	}

	@Override
	public void employeewithhighestsalary()
	{
		List<Employee> l=new ArrayList<Employee>();
		Set<String>k=db.keySet();
		for(String s:k)
		{
			Employee emp=db.get(s);
			l.add(emp);
		}
		Collections.sort(l,new SortEmployeeBySal());
		System.out.println("employee with highest salary");
		System.out.println(l.get(l.size()-1));
		
	}

	@Override
	public void employeewithlowestsalary() 
	{
		List<Employee> l=new ArrayList<Employee>();
		Set<String>k=db.keySet();
		for(String s:k)
		{
			Employee emp=db.get(s);
			l.add(emp);
		}
		Collections.sort(l,new SortEmployeeBySal());
		System.out.println("employee with lowest salary");
		System.out.println(l.get(0));
		
		
	}
	

}
