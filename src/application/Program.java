package application;

import java.util.Date;
import java.util.List;

import dao.SellerDAO;
import dao.daoFactory;
import entities.Department;
import entities.Seller;

public class Program {

	public static void main(String[] args) {

		Department dep1 = new Department(1, "department 1");
		System.out.println(dep1);
		
		System.out.println("------------------------------------------------------------");
		
		Seller seller = new Seller(20, "joao", "joao@gmail.com", new Date(), 300.00, dep1);
		System.out.println(seller);
		
		System.out.println("------------------------------------------------------------");
		
		System.out.println("TEST 1: Seller findById");
		SellerDAO sellerDao = daoFactory.createSellerDAO();
		Seller seller1 = sellerDao.findById(3);
		System.out.println(seller1);
		
		System.out.println("------------------------------------------------------------");
		
		System.out.println("TEST 2: Seller findByDepartment");
		Department dep2 = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartement(dep2);
		for(Seller obj : list) {
			System.out.println(obj);
		}
	}
}
