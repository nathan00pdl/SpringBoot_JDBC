package dao;

import impl.SellerDAOjdbc;

//Classe responsável por instanciar os 'DAOs' por meio de métodos estáticos
public class daoFactory {

	public static SellerDAO createSellerDAO() {
		return new SellerDAOjdbc(); 
	}
}
