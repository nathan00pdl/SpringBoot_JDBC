package dao;

import java.util.List;

import entities.Department;

public interface DepartmentDAO {

	void insert(Department obj);
	
	void update(Department obj);
	
	void deleteById(Integer id);
	
	//Obs: a operação 'findById' retornará um objeto do tipo 'Department'
	Department findById(Integer id); 
	
	//Obs: a operação 'findAll' retornará uma lista do tipo 'Department'
	List<Department> findAll();
	
}
