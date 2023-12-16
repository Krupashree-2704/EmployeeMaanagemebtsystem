package com.jsp.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.jsp.entity.model.Department;
import com.jsp.entity.model.Employee;
import com.jsp.entity.model.Project;

public class Controller {

	
		static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pgsql");
		static EntityManager entityManager = entityManagerFactory.createEntityManager();
		static EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Employee employee1 = new Employee();
        
		public boolean addEmployee(Employee employee)
		{
			if (employee!=null ) {
				entityTransaction.begin();
				
				Employee attachedEmployee = entityManager.merge(employee);
					entityManager.persist(attachedEmployee);
				   entityTransaction.commit();

		
				return true;
			}
			
			return false;
		}
		public boolean addProject(Project project)
		{
			if (project!=null) {
				entityTransaction.begin();
				Project attachedProject = entityManager.merge(project);
				entityManager.persist(attachedProject);
				entityTransaction.commit();
				return true;
			}
			return false;
		}
		public boolean addDepartment(Department department)
		{
			if (department!=null) {
				entityTransaction.begin();
				Department attachedDepartment = entityManager.merge(department);
				entityManager.persist(attachedDepartment);
				entityTransaction.commit();
				return true;
			}
			return false;
		}
		
//		public boolean addDeptartment()
//		{
//			return true;
//		}
		public Employee findEmployee(int employee_id)
		{
			return entityManager.find(Employee.class, employee_id);
		}
		public Department findDepartment(int depatment_id)
		{
			return entityManager.find(Department.class, depatment_id);
		}
		public Project findProject(int project_id)
		{
			return entityManager.find(Project.class, project_id);
		}
		public List<Employee> findEmployeeDetails()
		{
			TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);
			return query.getResultList();
		}
		public List<Department> findDepartmentDetails()
		{
			TypedQuery<Department> query = entityManager.createQuery("SELECT d FROM Department d", Department.class);
			return query.getResultList();
		}
		public List<Project> findProjectDetails()
		{
			TypedQuery<Project> query = entityManager.createQuery("SELECT p FROM Project p", Project.class);
			return query.getResultList();
		}
		public boolean updateEmployeeProject(int employee_id,List<Project>project)
		{
			Employee findEmployee = entityManager.find(Employee.class, employee_id);
			if (findEmployee!=null) {
				entityTransaction.begin();
				
				for (Project project2 : project) {
					findEmployee.setProject(project);
					entityManager.merge(project2);
					entityTransaction.commit();
				}
				
				
				return true;
			}
			return false;
		}
		public static boolean assignDeptToEmployee(Employee employee)
		{
			if (employee!=null) {
				entityTransaction.begin();
				entityManager.merge(employee);
				entityTransaction.commit();
				return true;
			}
			return false;
		}
//		public static boolean assignProjectToEmployee(Employee employee)
//		{
//			if (employee!=null) {
//				entityTransaction.begin();
//				entityManager.merge(employee);
//				entityTransaction.commit();
//				return true;
//			}
//			return false;
//		}
		public static boolean removeEmployee(int employee_id)
		{
			Employee removeEmployee = entityManager.find(Employee.class, employee_id);
			if (removeEmployee!=null) {
				entityTransaction.begin();
				entityManager.remove(removeEmployee);
				entityTransaction.commit();
				return true;
			}
			return false;
		}
		public static boolean removeDepartment(int department_id)
		{
			Department removeDepartment = entityManager.find(Department.class, department_id);
			if (removeDepartment!=null) {
				entityTransaction.begin();
				entityManager.remove(removeDepartment);
				entityTransaction.commit();
				return true;
			}
			return false;
		}
		public static boolean removeProject(int project_id)
		{
			Project removeProject = entityManager.find(Project.class, project_id);
			if (removeProject!=null) {
				entityTransaction.begin();
				entityManager.remove(removeProject);
				entityTransaction.commit();
				return true;
			}
			return false;
		}
//		public static boolean removeDepartment(int department_id)
//		{
//			Department removeDepartment = entityManager.find(Department.class, department_id);
//			if (removeDepartment!=null) {
//				entityTransaction.begin();
//				entityManager.remove(removeDepartment);
//				entityTransaction.commit();
//				return true;
//			}
//			return false;
//		}
		public static boolean assignProjectToEmployee(Employee findEmployee) {
			if (findEmployee!=null) {
				entityTransaction.begin();
				entityManager.merge(findEmployee);
				entityTransaction.commit();
				return true;
			}
			return false;
		}
		public static boolean updateEmployeeName(Employee updateEmployee)
		{
			if (updateEmployee!=null) {
				entityTransaction.begin();
				entityManager.merge(updateEmployee);
				entityTransaction.commit();
				return true;
			}
			return false;
		}
		public static boolean updateEmployeeSalary(Employee updateEmployee)
		{
			if (updateEmployee!=null) {
				entityTransaction.begin();
				entityManager.merge(updateEmployee);
				entityTransaction.commit();
				return true;
			}
			return false;
		}	
		public static boolean assignEmptoDept(Department updateDepartment)
		{
			if (updateDepartment!=null) {
				entityTransaction.begin();
				entityManager.merge(updateDepartment);
				entityTransaction.commit();
				return true;
			}
			return false;
		}	
		public static boolean assignEmptoProject(Project updateProject)
		{
			if (updateProject!=null) {
				entityTransaction.begin();
				entityManager.merge(updateProject);
				entityTransaction.commit();
				return true;
			}
			return false;
		}	
		public static boolean updateEmployeePosition(Employee updateEmployee)
		{
			if (updateEmployee!=null) {
				entityTransaction.begin();
				entityManager.merge(updateEmployee);
				entityTransaction.commit();
				return true;
			}
			return false;
		}
		public static boolean updateDepartmentName(Department updateDepartment)
		{
			if (updateDepartment!=null) {
				entityTransaction.begin();
				entityManager.merge(updateDepartment);
				entityTransaction.commit();
				return true;
			}
			return false;
		}
		public static boolean updateProjecttName(Project updateProject)
		{
			if (updateProject!=null) {
				entityTransaction.begin();
				entityManager.merge(updateProject);
				entityTransaction.commit();
				return true;
			}
			return false;
		}
		public boolean updateProjecttDescription(Project updateProjectDescription) {
			if (updateProjectDescription!=null) {
				entityTransaction.begin();
				entityManager.merge(updateProjectDescription);
				entityTransaction.commit();
				return true;
			}
			return false;
		}
	
		public boolean removeEmployees(int employee_id) {
		Employee find = findEmployee(employee_id);
		if (find!=null) {
			entityTransaction.begin();
			
			Department department = find.getDepartment();
			List<Employee> employeeList = department.getEmployee();
			employeeList.remove(find);
//			department-employee list removed employee
			List<Project> projectList = find.getProject();
//			department.getEmployee().remove(find);
			for (Project project : projectList) {
				List<Employee> employeeProject = project.getEmployee();
				employeeProject.remove(find);
//				project-employee list removed employee
			}
			
			find.setDepartment(null);
			find.setProject(null);
			
			entityManager.remove(find);
			
			entityTransaction.commit();
			return true;
		}
		return false;
		
	}
	public boolean removeDepartmentfromEmployee(int employee_id,int department_id)
	{
		Employee findEmployee = findEmployee(employee_id);
		Department findDepartment = findDepartment(department_id);
		if (findDepartment!=null && findEmployee!=null) {
			entityTransaction.begin();
			List<Employee> employeeList = findDepartment.getEmployee();
			employeeList.remove(findEmployee);
			findEmployee.setDepartment(null);
			entityManager.merge(findDepartment);
			entityManager.merge(findEmployee);
			
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	public boolean removeEmployeeFromProject(int employee_id,int project_id)
	{
		Employee findEmployee = findEmployee(employee_id);
		Project findProject = findProject(project_id);
		if (findEmployee!=null&&findProject!=null) {
			entityTransaction.begin();
			List<Employee> employees = findProject.getEmployee();
			if (employees!=null) {
				employees.remove(findEmployee);
			}
			List<Project> projects = findEmployee.getProject();
			if (projects!=null) {
				projects.remove(findProject);
			}
			entityManager.merge(findProject);
			entityManager.merge(findEmployee);		
			entityTransaction.commit();
			return true;
		}
		return false;
	}
	

}
