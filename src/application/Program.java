package application;

import java.util.Date;

import dao.SellerDAO;
import dao.daoFactory;
import entities.Department;
import entities.Seller;

public class Program {

	public static void main(String[] args) {

		//Department obj = new Department(1, "department 1");
		//System.out.println(obj);
		
		//Seller seller = new Seller(20, "joao", "joao@gmail.com", new Date(), 300.00);
		//System.out.println(seller);
		
		SellerDAO sellerDao = daoFactory.createSellerDAO();
		Seller seller1 = sellerDao.findById(3);
		System.out.println(seller1);
	}
}
