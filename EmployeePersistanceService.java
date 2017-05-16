package balu.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmployeePersistanceService {

	public static void main(String[] args) {
		
		EmployeePersistanceService empPerservice = new EmployeePersistanceService();
		EntityManager em = empPerservice.getEntityManager();
		//empPerservice.insertingEmployees(em);
		//empPerservice.createEmployeeAndPersist(em);
		//empPerservice.getAllTheEmployees(em);
		//empPerservice.getIndividualEmployee(em, 3);
		//empPerservice.removeEmployee(em, 5);
		//empPerservice.updateEmployee(em, 4);
		//empPerservice.removelAllEmployees(em);
		System.exit(0);
	}

	

	private EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("employeePersistance");
		return emf.createEntityManager();
	}

	private void createEmployeeAndPersist(EntityManager em) {
		Employee e1 = new Employee("Emp4FirstName","Emp4LastName","Emp4Designation",800000);
		EntityTransaction tx= em.getTransaction();
		System.out.println("> inserting to Employee");
		tx.begin();
		
		em.persist(e1);
		
		tx.commit();
		System.out.println("< inserted to Employee");
		em.close();
	}

	private void getAllTheEmployees(EntityManager em) {
		Employee e1 ;
		EntityTransaction tx= em.getTransaction();
		System.out.println("> getting to Employees");
		//tx.begin();
		
		List<Employee> employees = em.createQuery("select m from Employee m").getResultList();
		
		for(Employee emp : employees)
		{
			System.out.println(emp);
			emp.setSalary(100);
		}
		//tx.commit();
		em.close();
		
	}
	
	private void getIndividualEmployee(EntityManager em,long id) {
		Employee e1 ;
		EntityTransaction tx= em.getTransaction();
		System.out.println("> getting to Employees");
		//tx.begin();
		  e1= 	em.find(Employee.class, id);
		System.out.println(e1);
		e1.setLastName("YIYIYIYIYI");
		//tx.commit();
		em.close();
		
	}
	
	private void removeEmployee(EntityManager em,long id) {
		Employee e1 ;
		EntityTransaction tx= em.getTransaction();
		System.out.println("> removing to Employee"+id);
		e1= 	em.find(Employee.class, id);
		System.out.println(e1);
		tx.begin();
		 	em.remove(e1);
		
		tx.commit();
		em.close();
		
	}
	
	private void updateEmployee(EntityManager em,long id) {
		Employee e1 ;
		EntityTransaction tx= em.getTransaction();
		System.out.println("> updating to Employee"+id);
		tx.begin();
		  e1= 	em.find(Employee.class, id);
		System.out.println(e1);
		e1.setLastName("YIYIYIYIYI");
		tx.commit();
		em.close();
		
	}
	
	private void insertingEmployees(EntityManager em) {
		Employee e1 ;
		EntityTransaction tx= em.getTransaction();
		System.out.println("> inserting Employees");
		tx.begin();
		 for(int i=1;i<=5;i++){
			 em.persist(new Employee("Emp"+i+"FirstName","Emp"+i+"LastName","Emp"+i+"Designation",i*100000));
			 em.flush();
			 em.clear();
		 }
		tx.commit();
		em.close();
		
	}
	
	private void removelAllEmployees(EntityManager em) {
		Employee e1 ;
		EntityTransaction tx= em.getTransaction();
		System.out.println("> removing Employees");
		tx.begin();
		 List employees = em.createQuery("select m from Employee m").getResultList();
		 for (Object object : employees) {
			Employee e= (Employee) object;
			em.remove(e);
		}
		tx.commit();
		em.close();
		
	}
}
