package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.database.Database;
import com.ecommerce.entity.Category;
import com.ecommerce.entity.Product;



public class DAO {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
//	Product DAO
	
	public List<Product> getAllProducts() {
		
		List<Product> list = new ArrayList<Product>();
        String query = "SELECT * FROM product ";
       try {
    	   conn = new Database().getConnection();
    	   ps=conn.prepareStatement(query);
    	   rs = ps.executeQuery();
    	   while (rs.next()) {
			list.add(new Product(rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getDouble(4),
					rs.getString(5),
					rs.getString(6)
					));
			
		}
    	   
	} catch (Exception e) {
		// TODO: handle exception
	}
        
        return list;
    }
	
	public List<Product> getProductsBYCID(String cid) {
		
		List<Product> list = new ArrayList<Product>();
        String query = "select * from product where cateID=? ";
       try {
    	   conn = new Database().getConnection();
    	   ps=conn.prepareStatement(query);
    	   ps.setString(1, cid);
    	   rs = ps.executeQuery();
    	   while (rs.next()) {
			list.add(new Product(rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getDouble(4),
					rs.getString(5),
					rs.getString(6)
					));
			
		}
    	   
	} catch (Exception e) {
		// TODO: handle exception
	}
        
        return list;
    }
	public Product getProductsBYID(String id) {
		
        String query = "select * from product where id=? ";
       try {
    	   conn = new Database().getConnection();
    	   ps=conn.prepareStatement(query);
    	   ps.setString(1, id);
    	   rs = ps.executeQuery();
    	   while (rs.next()) {
			return new Product(rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getDouble(4),
					rs.getString(5),
					rs.getString(6)
					);
			
		}
    	   
	} catch (Exception e) {
		// TODO: handle exception
	}
       return null;
    }
	
	

	public List<Product> get4Productsnew() {
		
		List<Product> list = new ArrayList<Product>();
        String query = "SELECT * FROM product ORDER BY id DESC LIMIT 4";
       try {
    	   conn = new Database().getConnection();
    	   ps=conn.prepareStatement(query);
    	   rs = ps.executeQuery();
    	   while (rs.next()) {
			list.add(new Product(rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getDouble(4),
					rs.getString(5),
					rs.getString(6)
					));
			
		}
    	   
	} catch (Exception e) {
		// TODO: handle exception
	}
        
        return list;
    }
	
	
	
//Category DAO
	
public List<Category> getAllCategory() {
		
		List<Category> listCategory = new ArrayList<Category>();
        String query = "SELECT * FROM category ";
       try {
    	   conn = new Database().getConnection();
    	   ps=conn.prepareStatement(query);
    	   rs = ps.executeQuery();
    	   while (rs.next()) {
			listCategory.add(new Category(rs.getInt(1),rs.getString(2)));
			
		}
    	   
	} catch (Exception e) {
		// TODO: handle exception
	}
        
        return listCategory;
    }
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		DAO dao=new DAO();
		List<Product> list=dao.getAllProducts();
		List<Product> listnew=dao.get4Productsnew();
		List<Category> listCategory=dao.getAllCategory();
		List<Product> listProductsBYCID=dao.getProductsBYCID("5");
		
		for(Product o:list) {
			System.out.println(o);
		}
		System.out.println("----------------------");
		for(Category o:listCategory) {
			System.out.println(o);
		}
		System.out.println("----------------------");
		for(Product o:listnew) {
			System.out.println(o);
		}
		System.out.println("----------------------");
		for(Product o:listProductsBYCID) {
			System.out.println(o);
		}
	}
}