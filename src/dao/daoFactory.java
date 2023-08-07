package dao;

import db.DB;
import impl.SellerDAOjdbc;

//Classe responsável por instanciar os 'DAOs' (DepartmentDAO e SellerDAO) por meio de métodos estáticos 
public class daoFactory {

	public static SellerDAO createSellerDAO() {
		return new SellerDAOjdbc(DB.getConnection()); 
	}
}
