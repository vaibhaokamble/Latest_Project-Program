package vaibhao.vk;
import java.util.*;
class Employee{
	private int id;
	private String name;
	private float salary;
	
	void setEmployee(int i, String n, float s) {
		id=i;
		name=n;
		salary=s;
	}
	
	void showDetails() {
		System.out.println("Employee id is: "+id);
		System.out.println("Employee name is: "+name);
		System.out.println("Employee salary is :"+salary);
	}
}
public class EmployeApp {

	public static void main(String[] args) {
	Employee emp= new Employee();
	emp.setEmployee(1,"vaibhao",5000);
	emp.showDetails();
	}
}
