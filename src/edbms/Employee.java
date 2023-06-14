package edbms;

public class Employee
{
	private int id;
	private String name;
	private Double sal;
	private int age;
	static int count=200;
	public Employee( String name, Double sal, int age) {
		super();
		this.id  =count;
		count++;
		this.name = name;
		this.sal = sal;
		this.age = age;
		
		
	}
	public String getId() {
		return "EMP"+id;
	}
	
	@Override
	public String toString() {
		return "Employee id= " + id + ", name=" + name + ", sal=" + sal + ", age=" + age + ", count=" + count ;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	

}
