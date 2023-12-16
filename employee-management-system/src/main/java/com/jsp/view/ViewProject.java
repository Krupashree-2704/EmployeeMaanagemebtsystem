package com.jsp.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//First add employee w/o assigning dept and proj
//then while adding dept and proj=>ask for list of emp 

import com.jsp.controller.Controller;
import com.jsp.entity.model.Department;
import com.jsp.entity.model.Employee;
import com.jsp.entity.model.Project;


public class ViewProject {
	static Scanner myInput=new Scanner(System.in);
	static Controller controller=new Controller();
	public static void main(String[] args) {
		boolean flag=true;
		do {
			System.out.println("1.Add Employee\n2.View Employee Information\n3.Update Employee Details\n4.Remove Employee\n5.View Department Information\n6.Add Department\n7.Add Project\n8View Project Information\n0.Exit\nEnter your choice:");
			byte userChoice=myInput.nextByte();
			myInput.nextLine();
			switch (userChoice) {
			case 1:
				ArrayList<Employee> employeeList = new ArrayList<Employee>();
				System.out.print("How many Employees you want to insert:");
				int count_of_employee=myInput.nextInt();
				myInput.nextLine();
				
				while (count_of_employee>0) {
					
					Employee employee = new Employee();
					
					System.out.println("Enter Employee Name:");
					String employee_name=myInput.nextLine();
					
					System.out.println("Enter Employee Salary:");
					double employee_salary=myInput.nextDouble();
					myInput.nextLine();
					
					System.out.println("Enter Employee Designation:");
					String employee_designation=myInput.nextLine();
					
					
					employee.setName(employee_name);
					employee.setSalary(employee_salary);
					employee.setPosition(employee_designation);
					employeeList.add(employee);
//					employee.setDepartment(null);
//					employee.setProject(null);
					
					count_of_employee--;
					if(controller.addEmployee(employee))
					{
						System.out.println("Employee Inserted!!");
					}
					else
					{
						System.out.println("Employee Not Inserted!!");
					}
				}
				
				
				
				
				break;
			case 2:
				System.out.print("Enter Employee ID:");
				int employee_id=myInput.nextInt();
				myInput.nextLine();
				Employee findEmployeeInfo = controller.findEmployee(employee_id);
				if (findEmployeeInfo!=null) {
					System.out.println("Employee ID: "+findEmployeeInfo.getId());
					System.out.println("Employee Name: "+findEmployeeInfo.getName());
					System.out.println("Employee Designation: "+findEmployeeInfo.getPosition());
					System.out.println("Employee Salary: "+findEmployeeInfo.getSalary());
					System.out.println("Employee Date of Joining: "+findEmployeeInfo.getDoj());
					Department department = findEmployeeInfo.getDepartment();
					System.out.println("Department ID:"+department.getId());
					System.out.println("Department Name:"+department.getName());
					List<Project> project = findEmployeeInfo.getProject();
					if (project!=null) {
						for (Project project2 : project) {
							System.out.println("Project Id:"+project2.getId());
							System.out.println("Project Name:"+project2.getName());
							System.out.println("Project Description:"+project2.getDescription());
						}
					}
					
				}
//				List<Employee> findEmployeeDetails = controller.findEmployeeDetails();
//				if (findEmployeeDetails!=null) {
//					for (Employee findEmployee : findEmployeeDetails) {
//							System.out.println("Employee ID: "+findEmployee.getId());
//							System.out.println("Employee Name: "+findEmployee.getName());
//							System.out.println("Employee Designation: "+findEmployee.getPosition());
//							System.out.println("Employee Salary: "+findEmployee.getSalary());
//							System.out.println("Employee Date of Joining: "+findEmployee.getDoj());
//						}
//					
//				} 
//				List<Department> findDepartmentDetails = controller.findDepartmentDetails();
//				if (findDepartmentDetails!=null) {
//					for (Department department : findDepartmentDetails) {
//						System.out.println("Department ID:"+department.getId());
//						System.out.println("Department Name:"+department.getName());
//					}
//				}
//				List<Project> findProjectDetails = controller.findProjectDetails();
//				if (findProjectDetails!=null) {
//					for (Project project : findProjectDetails) {
//						System.out.println("Project ID:"+project.getId());
//						System.out.println("Project Name:"+project.getName());
//						System.out.println("Project Description:"+project.getDescription());
//					}
//				}
				break;
			case 3:
//				position ,salary=>Employee
//				update=>for employee =>depatment and project assign
//				id known for proj,dept=>fetch all dept,proj
				System.out.print("1.Update Employee\n2.Update Department\n3.Update Project\nEnter your Choice:");
				int userUpdateChoice=myInput.nextInt();
				myInput.nextLine();
				switch (userUpdateChoice) {
				case 1:
					System.out.print("1.Update Employee Name\n2.Update Employee Salary\n3.Update Employee Position\n4.Assign Department to Employee\n5.Assign Project to Employee\nEnter Your Choice:");
					int employeeUpdateChoice=myInput.nextInt();
					myInput.nextLine();
					switch (employeeUpdateChoice) {
					case 1:
						System.out.print("Enter employee id to update it's Name:");
						int employee_id_update_project_name=myInput.nextInt();
						myInput.nextLine();
						System.out.print("Enter updated employee name :");
						String updated_employee_name=myInput.nextLine();
						Employee updateEmployeeName = controller.findEmployee(employee_id_update_project_name);
						if (updateEmployeeName!=null) {
							updateEmployeeName.setName(updated_employee_name);
							if (controller.updateEmployeeName(updateEmployeeName)) {
								System.out.println("Employee's name updated");
							}
							else {
								System.out.println("Employee's name not updated");
							}
							
						} 
						break;
					case 2:
						System.out.print("Enter employee id to update it's Salary:");
						int employee_id_update_project_salary=myInput.nextInt();
						myInput.nextLine();
						System.out.print("Enter updated employee Salary :");
						double updated_employee_salary=myInput.nextDouble();
						myInput.nextLine();
						Employee updateEmployeeSalary = controller.findEmployee(employee_id_update_project_salary);
						if (updateEmployeeSalary!=null) {
							updateEmployeeSalary.setSalary(updated_employee_salary);
							if (controller.updateEmployeeSalary(updateEmployeeSalary)) {
								System.out.println("Employee's Salary updated");
							}
							else {
								System.out.println("Employee's Salary not updated");
							}
							
						} 
						break;
					case 3:
						System.out.print("Enter employee id to update it's Position:");
						int employee_id_update_position=myInput.nextInt();
						myInput.nextLine();
						System.out.print("Enter updated employee Position :");
						String employee_upadte_position=myInput.nextLine();
						Employee updateEmployeePosition = controller.findEmployee(employee_id_update_position);
						if (updateEmployeePosition!=null) {
							updateEmployeePosition.setPosition(employee_upadte_position);
							if (controller.updateEmployeePosition(updateEmployeePosition)) {
								System.out.println("Employee's Position updated");
							}
							else {
								System.out.println("Employee's Position not updated");
							}
							
						} 
						break;
					case 4:
						List<Department> findDepartmentDetails = controller.findDepartmentDetails();
						for (Department department : findDepartmentDetails) {
							System.out.println("Department ID:"+department.getId());
							System.out.println("Department Name:"+department.getName());
						}
						System.out.print("Enter Department ID to assign to Employee:");
						int department_id_to_assign=myInput.nextInt();
						myInput.nextLine();
						Department findDepartment = controller.findDepartment(department_id_to_assign);
						System.out.print("Enter Employee ID to assign Department:");
						int employee_id_to_assign=myInput.nextInt();
						myInput.nextLine();
						Employee findEmployee = controller.findEmployee(employee_id_to_assign);
						
						if (findDepartment!=null&&findEmployee!=null) {
							findEmployee.setDepartment(findDepartment);
							if (controller.assignDeptToEmployee(findEmployee)) {
								System.out.println("Employee's Dept Updated");
							}
							else
							{
								System.out.println("Employee's Dept Not Updated");
							}
							
						}
						break;
					case 5:
						ArrayList<Project> projectList1 = new ArrayList<Project>();
						List<Project> findProjectDetails = controller.findProjectDetails();
						for (Project project : findProjectDetails) {
							System.out.println("Project ID:"+project.getId());
							System.out.println("Project Name:"+project.getName());
							System.out.println("Project Description:"+project.getDescription());
						}
						System.out.print("Enter Project ID to assign to Employee:");
						int project_id_to_assign=myInput.nextInt();
						myInput.nextLine();
						Project findProject = controller.findProject(project_id_to_assign);
						projectList1.add(findProject);
						System.out.print("Enter Employee ID to assign Department:");
						int employee_id_to_assign_project=myInput.nextInt();
						myInput.nextLine();
						Employee findEmployeeProject = controller.findEmployee(employee_id_to_assign_project);
						if (findEmployeeProject!=null) {
							findEmployeeProject.setProject(projectList1);
							if (Controller.assignProjectToEmployee(findEmployeeProject)) {
								System.out.println("Employee's Project Updated");
							}
							else
							{
								System.out.println("Employee's Project Not Updated");
							}
							
						}
						break;
					default:
						System.out.println("Please Choose the Correct Employee Option!!!");
						break;
					}
					break;
				case 2:
					System.out.print("1.Update Department Name\n2.Assign Depatment to Employee\nEnter Your Choice:");
					int departmentUpdateChoice=myInput.nextInt();
					myInput.nextLine();
					switch (departmentUpdateChoice) {
					case 1:
						System.out.print("Enter Department ID to change it's name:");
						int department_id_to_change_deartment_name=myInput.nextInt();
						myInput.nextLine();
						System.out.println("Enter Department Name:");
						String department_name_update=myInput.nextLine();
						Department updateDepartmentName = controller.findDepartment(department_id_to_change_deartment_name);
						if (updateDepartmentName!=null) {
							updateDepartmentName.setName(department_name_update);
							if (controller.updateDepartmentName(updateDepartmentName)) {
								System.out.println("Department Name Updated");
							} else {
								System.out.println("Department Name not Updated");
							}
						}
						break;
					case 2:
						ArrayList<Employee> employeeListDept = new ArrayList<Employee>();
						List<Employee> findEmployeeDetails = controller.findEmployeeDetails();
						for (Employee employee : findEmployeeDetails) {
							System.out.println("Employee ID:"+employee.getId());
							System.out.println("Employee Name:"+employee.getName());
							System.out.println("Employee Salary:"+employee.getSalary());
							System.out.println("Employee Position:"+employee.getPosition());
							System.out.println("Employee Date of Joining::"+employee.getDoj());
						}
						System.out.print("Enter Employee Id to assign Department:");
						int employee_id_assign_dept=myInput.nextInt();
						myInput.nextLine();
						Employee findEmployee = controller.findEmployee(employee_id_assign_dept);
						employeeListDept.add(findEmployee);
						System.out.println("Enter Depatment Id to set to Employee");
						int department_employee=myInput.nextInt();
						myInput.nextLine();
						Department findDepartment = controller.findDepartment(department_employee);
						findDepartment.setEmployee(employeeListDept);
						if (controller.assignEmptoDept(findDepartment)) {
							System.out.println("Department Updated");
						}
						else {
							System.out.println("Department not Updated");
						}
						break;
					default:
						System.out.println("Please Choose the Correct Department Option!!!");
						break;
					}
					break;
				case 3:
					System.out.print("1.Update Project Name\n2.Update Project Description\n3.Assign Employees to Project\nEnter your choice:");
					int projectUpdateChoice=myInput.nextInt();
					myInput.nextLine();
					switch (projectUpdateChoice) {
					case 1:
						System.out.print("Enter Project Id to Update it's name:");
						int project_id_to_change_project_name=myInput.nextInt();
						myInput.nextLine();
						System.out.print("Enter Updated Project Name");
						String updated_project_name=myInput.nextLine();
						Project updateProjectName = controller.findProject(project_id_to_change_project_name);
						if (updateProjectName!=null) {
							updateProjectName.setName(updated_project_name);
							if (controller.updateProjecttName(updateProjectName)) {
								System.out.println("Project Name Updated");
								
							} else {
								System.out.println("Project Name not Updated");
							}
						}
						break;
					case 2:
						System.out.print("Enter Project Id to Update it's description:");
						int project_id_to_change_project_description=myInput.nextInt();
						myInput.nextLine();
						System.out.print("Enter Updated Project Description");
						String updated_project_description=myInput.nextLine();
						Project updateProjectDescription = controller.findProject(project_id_to_change_project_description);
						if (updateProjectDescription!=null) {
							updateProjectDescription.setName(updated_project_description);
							if (controller.updateProjecttDescription(updateProjectDescription)) {
								System.out.println("Project Name Updated");
								
							} else {
								System.out.println("Project Name not Updated");
							}
						}
						break;
					case 3:
						ArrayList<Employee> employeeListProject = new ArrayList<Employee>();
						List<Employee> findEmployeeDetails = controller.findEmployeeDetails();
						for (Employee employee : findEmployeeDetails) {
							System.out.println("Employee ID:"+employee.getId());
							System.out.println("Employee Name:"+employee.getName());
							System.out.println("Employee Salary:"+employee.getSalary());
							System.out.println("Employee Position:"+employee.getPosition());
							System.out.println("Employee Date of Joining::"+employee.getDoj());
						}
						System.out.print("Enter Employee Id to assign Department:");
						int employee_id_assign_project=myInput.nextInt();
						myInput.nextLine();
						Employee findEmployee = controller.findEmployee(employee_id_assign_project);
						employeeListProject.add(findEmployee);
						System.out.println("Enter Project Id to set to Employee");
						int project_employee=myInput.nextInt();
						myInput.nextLine();
						Project findProject = controller.findProject(project_employee);
						findProject.setEmployee(employeeListProject);
						if (controller.assignEmptoProject(findProject)) {
							System.out.println("Project Updated");
						}
						else {
							System.out.println("Project not Updated");
						}
						break;
					default:
						System.out.println("Please Correct Option from Project.");
						break;
					}
					break;
				default:
					System.out.println("Invalid Option!!!Bad Luck");
					break;
				}
//				List<Department> findDepartmentDetails = controller.findDepartmentDetails();
//				for (Department department : findDepartmentDetails) {
//					System.out.println("Department ID:"+department.getId());
//					System.out.println("Department Name:"+department.getName());
//				}
//				System.out.print("Enter Department ID to assign to Employee:");
//				int department_id_to_assign=myInput.nextInt();
//				myInput.nextLine();
//				Department findDepartment = controller.findDepartment(department_id_to_assign);
//				System.out.print("Enter Employee ID to assign Department:");
//				int employee_id_to_assign=myInput.nextInt();
//				myInput.nextLine();
//				Employee findEmployee = controller.findEmployee(employee_id_to_assign);
//				
//				if (findDepartment!=null&&findEmployee!=null) {
//					findEmployee.setDepartment(findDepartment);
//					if (controller.assignDeptToEmployee(findEmployee)) {
//						System.out.println("Employee's Dept Updated");
//					}
//					else
//					{
//						System.out.println("Employee's Dept Not Updated");
//					}
//					
//				}
				
//				ArrayList<Project> projectList1 = new ArrayList<Project>();
//				List<Project> findProjectDetails = controller.findProjectDetails();
//				for (Project project : findProjectDetails) {
//					System.out.println("Project ID:"+project.getId());
//					System.out.println("Project Name:"+project.getName());
//					System.out.println("Project Description:"+project.getDescription());
//				}
//				System.out.print("Enter Project ID to assign to Employee:");
//				int project_id_to_assign=myInput.nextInt();
//				myInput.nextLine();
//				Project findProject = controller.findProject(project_id_to_assign);
//				projectList1.add(findProject);
//				System.out.print("Enter Employee ID to assign Department:");
//				int employee_id_to_assign=myInput.nextInt();
//				myInput.nextLine();
//				Employee findEmployee = controller.findEmployee(employee_id_to_assign);
//				if (findEmployee!=null) {
//					findEmployee.setProject(projectList1);
//					if (Controller.assignProjectToEmployee(findEmployee)) {
//						System.out.println("Employee's Project Updated");
//					}
//					else
//					{
//						System.out.println("Employee's Project Not Updated");
//					}
//					
//				}
//				
				
				
//				System.out.print("Enter employee id to update it's Position:");
//				int employee_id_update_position=myInput.nextInt();
//				myInput.nextLine();
//				System.out.print("Enter updated employee Position :");
//				String employee_upadte_position=myInput.nextLine();
//				Employee updateEmployeePosition = controller.findEmployee(employee_id_update_position);
//				if (updateEmployeePosition!=null) {
//					updateEmployeePosition.setPosition(employee_upadte_position);
//					if (controller.updateEmployeePosition(updateEmployeePosition)) {
//						System.out.println("Employee's Position updated");
//					}
//					else {
//						System.out.println("Employee's Position not updated");
//					}
//					
//				} 
//				System.out.print("Enter Department ID to change it's name:");
//				int department_id_to_change_deartment_name=myInput.nextInt();
//				myInput.nextLine();
//				System.out.println("Enter Department Name:");
//				String department_name_update=myInput.nextLine();
//				Department updateDepartmentName = controller.findDepartment(department_id_to_change_deartment_name);
//				if (updateDepartmentName!=null) {
//					updateDepartmentName.setName(department_name_update);
//					if (controller.updateDepartmentName(updateDepartmentName)) {
//						System.out.println("Department Name Updated");
//					} else {
//						System.out.println("Department Name not Updated");
//					}
//				}
//				System.out.print("Enter Project Id to Update it's name:");
//				int project_id_to_change_project_name=myInput.nextInt();
//				myInput.nextLine();
//				System.out.print("Enter Updated Project Name");
//				String updated_project_name=myInput.nextLine();
//				Project updateProjectName = controller.findProject(project_id_to_change_project_name);
//				if (updateProjectName!=null) {
//					updateProjectName.setName(updated_project_name);
//					if (controller.updateProjecttName(updateProjectName)) {
//						System.out.println("Project Name Updated");
//						
//					} else {
//						System.out.println("Project Name not Updated");
//					}
//				}
//				System.out.print("Enter Project Id to Update it's description:");
//				int project_id_to_change_project_description=myInput.nextInt();
//				myInput.nextLine();
//				System.out.print("Enter Updated Project Description");
//				String updated_project_description=myInput.nextLine();
//				Project updateProjectDescription = controller.findProject(project_id_to_change_project_description);
//				if (updateProjectDescription!=null) {
//					updateProjectDescription.setName(updated_project_description);
//					if (controller.updateProjecttDescription(updateProjectDescription)) {
//						System.out.println("Project Name Updated");
//						
//					} else {
//						System.out.println("Project Name not Updated");
//					}
//				}
//				ArrayList<Employee> employeeListDept = new ArrayList<Employee>();
//				List<Employee> findEmployeeDetails = controller.findEmployeeDetails();
//				for (Employee employee : findEmployeeDetails) {
//					System.out.println("Employee ID:"+employee.getId());
//					System.out.println("Employee Name:"+employee.getName());
//					System.out.println("Employee Salary:"+employee.getSalary());
//					System.out.println("Employee Position:"+employee.getPosition());
//					System.out.println("Employee Date of Joining::"+employee.getDoj());
//				}
//				System.out.print("Enter Employee Id to assign Department:");
//				int employee_id_assign_dept=myInput.nextInt();
//				myInput.nextLine();
//				Employee findEmployee = controller.findEmployee(employee_id_assign_dept);
//				employeeListDept.add(findEmployee);
//				System.out.println("Enter Depatment No to set to Employee");
//				int department_employee=myInput.nextInt();
//				myInput.nextLine();
//				Department findDepartment = controller.findDepartment(department_employee);
//				findDepartment.setEmployee(employeeListDept);
//				if (controller.assignEmptoDept(findDepartment)) {
//					System.out.println("Department Updated");
//				}
//				else {
//					System.out.println("Department not Updated");
//				}
//				ArrayList<Employee> employeeListProject = new ArrayList<Employee>();
//				List<Employee> findEmployeeDetails = controller.findEmployeeDetails();
//				for (Employee employee : findEmployeeDetails) {
//					System.out.println("Employee ID:"+employee.getId());
//					System.out.println("Employee Name:"+employee.getName());
//					System.out.println("Employee Salary:"+employee.getSalary());
//					System.out.println("Employee Position:"+employee.getPosition());
//					System.out.println("Employee Date of Joining::"+employee.getDoj());
//				}
//				System.out.print("Enter Employee Id to assign Department:");
//				int employee_id_assign_project=myInput.nextInt();
//				myInput.nextLine();
//				Employee findEmployee = controller.findEmployee(employee_id_assign_project);
//				employeeListProject.add(findEmployee);
//				System.out.println("Enter Project No to set to Employee");
//				int project_employee=myInput.nextInt();
//				myInput.nextLine();
//				Project findProject = controller.findProject(project_employee);
//				findProject.setEmployee(employeeListProject);
//				if (controller.assignEmptoProject(findProject)) {
//					System.out.println("Project Updated");
//				}
//				else {
//					System.out.println("Project not Updated");
//				}
				break;
			case 4:
				System.out.print("1.Remove complete Employee,Department,Project Details\n2.Remove Particular Employee,Department,Project\nEnter Your choice:");
				int userChoiceToReomve=myInput.nextInt();
				myInput.nextLine();
				switch (userChoiceToReomve) {
				case 1:
					System.out.print("1.Remove Employee\n2.Remove Department\n3.Remove Project\nEnter Your Choice:");
					int userCompleteRemove=myInput.nextInt();
					myInput.nextLine();
					switch (userCompleteRemove) {
					case 1:
						System.out.print("Enter Employee Id to remove:");
						int employee_id_remove=myInput.nextInt();
						myInput.nextLine();
						if (controller.removeEmployee(employee_id_remove)) {
							System.out.println("Employee Removed");
						} else {
							System.out.println("Employee Not Removed");
						}
						break;
					case 2:
						System.out.print("Enter Department Id to remove:");
						int department_id_remove=myInput.nextInt();
						myInput.nextLine();
						if (controller.removeDepartment(department_id_remove)) {
							System.out.println("Department Removed");
						} else {
							System.out.println("Department Not Removed");
						}
						break;
					case 3:
						System.out.print("Enter Project Id to remove:");
						int project_id_remove=myInput.nextInt();
						myInput.nextLine();
						if (controller.removeProject(project_id_remove)) {
							System.out.println("Project Removed");
						} else {
							System.out.println("Project Not Removed");
						}
						break;
					default:
						System.out.println("Please correctly select option from Complete Details");
						break;
					}
					break;
				case 2:
					System.out.print("1.Remove particular Department from Employee\n2.Remove Employee from Department_Employee\n3.Remove Employee from Project\nEnter your choice:");
					int userPartialChoice=myInput.nextInt();
					myInput.nextLine();
					switch (userPartialChoice) {
					case 1:
						System.out.print("Enter Employee Id to Remove:");
						int employee_id_to_remove=myInput.nextInt();
						myInput.nextLine();
						if (controller.removeEmployees(employee_id_to_remove)) {
							System.out.println("Employee  Removed");
						}
						else {
							System.out.println("Employee Not Removed");
						}
						break;
					case 2:
						System.out.println("Enter Employee ID:");
						int employee_id_to_remove_dept=myInput.nextInt();
						myInput.nextLine();
						System.out.println("Enter Department ID:");
						int department_id_to_remove_dept=myInput.nextInt();
						myInput.nextLine();
						if (controller.removeDepartmentfromEmployee(employee_id_to_remove_dept, department_id_to_remove_dept)) {
							System.out.println("Employee Department removed");
						} else {
							System.out.println("Employee Department NOT removed");
						}
						break;
					case 3:
						System.out.println("Enter Employee ID:");
						int employee_id_to_remove_depart=myInput.nextInt();
						myInput.nextLine();
						System.out.println("Enter Project ID:");
						int project_id_to_remove_dept=myInput.nextInt();
						myInput.nextLine();
						if (controller.removeEmployeeFromProject(employee_id_to_remove_depart, project_id_to_remove_dept)) {
							System.out.println("Employee Project removed");
						} else {
							System.out.println("Employee Project NOT removed");
						}
						break;
					default:
						System.out.println("Please correctly select option from Partial Details");
						break;
					}
					break;
				default:
					System.out.println("Please Choose Correct Option!!!My Bad");
					break;
				}
//				
//				System.out.print("Enter Employee Id to Remove:");
//				int employee_id_to_remove=myInput.nextInt();
//				myInput.nextLine();
//				if (controller.removeEmployees(employee_id_to_remove)) {
//					System.out.println("Employee  Removed");
//				}
//				else {
//					System.out.println("Employee Not Removed");
//				}
//				System.out.println("Enter Employee ID:");
//				int employee_id_to_remove_dept=myInput.nextInt();
//				myInput.nextLine();
//				System.out.println("Enter Department ID:");
//				int department_id_to_remove_dept=myInput.nextInt();
//				myInput.nextLine();
//				if (controller.removeDepartmentfromEmployee(employee_id_to_remove_dept, department_id_to_remove_dept)) {
//					System.out.println("Employee Department removed");
//				} else {
//					System.out.println("Employee Department NOT removed");
//				}
//				System.out.println("Enter Employee ID:");
//				int employee_id_to_remove_dept=myInput.nextInt();
//				myInput.nextLine();
//				System.out.println("Enter Project ID:");
//				int project_id_to_remove_dept=myInput.nextInt();
//				myInput.nextLine();
//				if (controller.removeEmployeeFromProject(employee_id_to_remove_dept, project_id_to_remove_dept)) {
//					System.out.println("Employee Project removed");
//				} else {
//					System.out.println("Employee Project NOT removed");
//				}
//				controller.deleteParticularDepartment(5,4);
//				System.out.print("Enter Employee Id to remove:");
//				int employee_id_remove=myInput.nextInt();
//				myInput.nextLine();
//				if (controller.removeEmployee(employee_id_remove)) {
//					System.out.println("Employee Removed");
//				} else {
//					System.out.println("Employee Not Removed");
//				}
//				System.out.print("Enter Department Id to remove:");
//				int department_id_remove=myInput.nextInt();
//				myInput.nextLine();
//				if (controller.removeDepartment(department_id_remove)) {
//					System.out.println("Department Removed");
//				} else {
//					System.out.println("Department Not Removed");
//				}
//				System.out.print("Enter Project Id to remove:");
//				int project_id_remove=myInput.nextInt();
//				myInput.nextLine();
//				if (controller.removeProject(project_id_remove)) {
//					System.out.println("Project Removed");
//				} else {
//					System.out.println("Project Not Removed");
//				}
				break;
			case 5:
				System.out.print("Enter Depatment ID to view it's complete details: ");
				int department_id_fetch_info=myInput.nextInt();
				myInput.nextLine();
				Department findDepartmentFullDetails = controller.findDepartment(department_id_fetch_info);
				if (findDepartmentFullDetails!=null) {
					System.out.println("Department ID:"+findDepartmentFullDetails.getId());
					System.out.println("Department Name:"+findDepartmentFullDetails.getName());
					List<Employee> employeeDetailsFromDept = findDepartmentFullDetails.getEmployee();
					if (employeeDetailsFromDept!=null) {
						for (Employee employee : employeeDetailsFromDept) {
							System.out.println("Employee Id:"+employee.getId());
							System.out.println("Employee Name:"+employee.getName());
							System.out.println("Employee Salary:"+employee.getSalary());
							System.out.println("Employee Designation:"+employee.getPosition());
							System.out.println("Employee Date of Joining:"+employee.getDoj());
							List<Project> projectDetailsFromDept = employee.getProject();
							if (projectDetailsFromDept!=null) {
								for (Project project2 : projectDetailsFromDept) {
									System.out.println("Project Id:"+project2.getId());
									System.out.println("Project Name:"+project2.getName());
									System.out.println("Project Description:"+project2.getDescription());
								}
							}
						}
					}
					
				} else {
					System.out.println("Department Information with given Id not found");
				}
				break;
			case 6:
				ArrayList<Department> departmentList = new ArrayList<Department>();
//				ArrayList<Employee> employeeInsertList = new ArrayList<Employee>();
				System.out.print("How many Departments you want to insert:");
				int count_of_department=myInput.nextInt();
				myInput.nextLine();
				while (count_of_department>0) {
					Department department = new Department();
					
					
					
					System.out.print("Enter Department Name:");
					String department_name=myInput.nextLine();
					
					
					department.setName(department_name);
					
//					System.out.print("Enter the Employee Id to whom we want to assign Department:");
//					int employee_id_to_assign_dept=myInput.nextInt();
//					myInput.nextLine();
//					Employee findEmployee = controller.findEmployee(employee_id_to_assign_dept);
//					if (findEmployee!=null) {
//						employeeInsertList.add(findEmployee);
//						department.setEmployee(employeeInsertList);
//					}
					departmentList.add(department);
					count_of_department--;
					if (controller.addDepartment(department)) {
						System.out.println("Department Inserted");
					} else {
						System.out.println("Department Not Inserted");
					}
				}
				
				

				break;
			case 7:
				
				ArrayList<Project> projectList = new ArrayList<Project>();
				
				ArrayList<Employee> employeeInsertProjectList = new ArrayList<Employee>();
				System.out.print("How many Projects you want to insert:");
				int count_of_project=myInput.nextInt();
				myInput.nextLine();
				
				while (count_of_project>0) {
					
					Project project = new Project();
					
					
					
					System.out.print("Enter Project Name:");
					String project_name=myInput.nextLine();
					
					System.out.print("Enter Project Description:");
					String project_description=myInput.nextLine();
					
					
					project.setName(project_name);
					project.setDescription(project_description);
					
//					System.out.print("Enter the Employee Id to whom we want to assign Project:");
//					int employee_id_to_assign_project=myInput.nextInt();
//					myInput.nextLine();
//					Employee findEmployee = controller.findEmployee(employee_id_to_assign_project);
//					if (findEmployee!=null) {
//						
//						
//						employeeInsertProjectList.add(findEmployee);
//						project.setEmployee(employeeInsertProjectList);
						
						
						
						
////						project.setEmployee(employeeInsertProjectList);
//					}
					
//					findEmployee.setProject(projectList);
//					employee.setDepartment(null);
//					employee.setProject(null);
					projectList.add(project);
					count_of_project--;
					if(controller.addProject(project))
					{
						System.out.println("Project Inserted!!");
					}
					else
					{
						System.out.println("Project Not Inserted!!");
					}
////					Update kartana employee set kar!!
//					boolean updateEmployeeProject = controller.updateEmployeeProject(employee_id_to_assign_project, projectList);
//					if (updateEmployeeProject) {
//						System.out.println("Success");
//					} else {
//						System.out.println("Not Success");
//					}
				}
				break;
			case 8:
//				Employee delete kela tar dept aani proj delete karo
				System.out.print("Enter Project Id to view complete details:");
				int project_id_to_view_complete_details=myInput.nextInt();
				myInput.nextLine();
				Project findProjectCompleteDetails = controller.findProject(project_id_to_view_complete_details);
				if (findProjectCompleteDetails!=null) {
					System.out.println("Project ID:"+findProjectCompleteDetails.getId());
					System.out.println("Project Name:"+findProjectCompleteDetails.getName());
					System.out.println("Project Description:"+findProjectCompleteDetails.getDescription());
					List<Employee> listOfEmployees = findProjectCompleteDetails.getEmployee();
					if (listOfEmployees!=null) {
						for (Employee employee : listOfEmployees) {
							System.out.println("Employee ID:"+employee.getId());
							System.out.println("Employee Name:"+employee.getName());
							System.out.println("Employee Salary:"+employee.getSalary());
							System.out.println("Employee Position:"+employee.getPosition());
							System.out.println("Employee Date of Joining:"+employee.getDoj());
							Department department = employee.getDepartment();
							if (department!=null) {
								System.out.println("Department ID:"+department.getId());
								System.out.println("Department Name:"+department.getName());
							}
						}
					}
				} else {
					System.out.println("Project with given Id Does not exists");
				}
				break;
			case 0:
				myInput.close();
				System.out.println("Exited");
				flag=false;
				break;
			default:
				System.out.println("Please Select Correct Option!!!");
				break;
			}
		} while (flag);

	}
	

}
