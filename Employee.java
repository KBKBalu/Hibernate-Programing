package balu.app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee 
{
	
	@Id@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Employee_ID")
	private long employeeID;
	
	
	@Column(name="Employee_FN")
	private String firstName;
	
	@Column(name="Employee_LN")
	private String lastName;
	
	@Column(name="Employee_Designation")
	private String designation;
	
	@Column(name="Employee_salary")
	private long salary;

	public Employee() {
		super();
	}
	
	public Employee(String firstName, String lastName, String dessignation, long salary)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.designation = dessignation;
		this.salary = salary;
	}
	public long getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(long employeeID) {
		this.employeeID = employeeID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDessignation() {
		return designation;
	}
	public void setDessignation(String dessignation) {
		designation = dessignation;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", designation=" + designation + ", salary=" + salary + "]";
	}
}
