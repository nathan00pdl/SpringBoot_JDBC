package dao;

import java.util.List;

import entities.Seller;

public interface SellerDAO {

	void insert(Seller obj);
	void update(Seller obj);
	void deleteById(Integer id);
	
	//Obs: a operação 'findById' retornará um objeto do tipo 'Seller'
	Seller findById(Integer id); 
	
	//Obs: a operação 'findAll' retornará uma lista do tipo 'Seller'
	List<Seller> findAll();
	
}
