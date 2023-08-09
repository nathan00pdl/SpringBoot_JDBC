package dao;

import db.DB;
import impl.DepartmentDAOjdbc;
import impl.SellerDAOjdbc;

//Classe responsável por instanciar os 'DAOs' (DepartmentDAO e SellerDAO) por meio de métodos estáticos 
public class daoFactory {
	
	//DAO referente à classe 'Seller'
	public static SellerDAO createSellerDAO() {
		return new SellerDAOjdbc(DB.getConnection()); 
	}

	//DAO referente à classe 'Department'
	public static DepartmentDAO createDepartmentDAO() {
		return new DepartmentDAOjdbc(DB.getConnection());
	}
}
