package impl;  //'impl' -> implementação

import java.util.List;

import dao.SellerDAO;
import entities.Seller;

//Obs: 'SellerDAOjdbc' é uma implementação jdbc da classe 'SellerDAO'
public class SellerDAOjdbc implements SellerDAO{

	@Override
	public void insert(Seller obj) {
		
	}

	@Override
	public void update(Seller obj) {
		
	}

	@Override
	public void deleteById(Integer id) {
		
	}

	@Override
	public Seller findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seller> findAll() {
		return null;
	}  

}
