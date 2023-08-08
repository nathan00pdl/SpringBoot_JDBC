package impl;  //'impl' -> implementação

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.SellerDAO;
import db.DB;
import db.dbException;
import entities.Department;
import entities.Seller;

//Obs: 'SellerDAOjdbc' é uma implementação jdbc da interface 'SellerDAO'
public class SellerDAOjdbc implements SellerDAO{
	
	//Gerando dependência
	private Connection conn;
	
	public SellerDAOjdbc(Connection conn) {
		this.conn = conn;
	}

	
	//Declarando métodos estáticos
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
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName \r\n"
				  + "FROM seller INNER JOIN department \r\n"
				  + "ON seller.DepartmentId = department.Id \r\n"
				  + "WHERE seller.Id = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			
			//testando se a querie foi executada (se retornou dados ou não)
			if (rs.next()) {
				Department dep = instantiateDepartment(rs);
				Seller obj = instantiateSeller(rs,dep);
				return obj;
			}
			return null;
		}
		catch(SQLException e) {
			throw new dbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {
		Seller obj = new Seller();
		obj.setId(rs.getInt("Id"));
		obj.setName(rs.getString("Name"));
		obj.setEmail(rs.getString("Email"));
		obj.setBaseSalary(rs.getDouble("BaseSalary"));
		obj.setBirthDate(rs.getDate("BirthDate"));
		obj.setDepartment(dep);
		return obj;
	}

	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("DepartmentId"));
		dep.setName(rs.getString("DepName"));
		return dep;
	}

	@Override
	public List<Seller> findAll() {
		return null;
	}

	@Override
	public List<Seller> findByDepartement(Department department) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					 "SELECT seller.*, department.Name as DepName \r\n"
				   + "FROM seller \r\n"
				   + "INNER JOIN department ON seller.DepartmentId = department.Id \r\n"
				   + "WHERE DepartmentId = ? \r\n"
				   + "ORDER BY Name");
			
			st.setInt(1, department.getId());
			rs = st.executeQuery();
			
			//Declaração de uma lista para guardar os resultados da querie
			List<Seller> list = new ArrayList<>();
			
			//Declaração de uma estrutura 'map' para controlar a não repetição de departamentos gerados
			Map<Integer, Department> map = new HashMap<>();
			
			while (rs.next()) {
				//Controle da não repetição dos departamentos
				Department dep  = map.get(rs.getInt("DepartmentId"));
				
				if (dep == null) {
					dep = instantiateDepartment(rs);
					map.put(rs.getInt("DepartmentId"), dep);
				}
				
				Seller obj = instantiateSeller(rs,dep);
				list.add(obj);
			}
			return list;
		}
		catch(SQLException e) {
			throw new dbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}  
}
