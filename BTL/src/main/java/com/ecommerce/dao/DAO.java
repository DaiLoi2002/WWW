package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.entity.Product;
import com.mysql.cj.xdevapi.Result;

public class DAO {
	Connection conn=null;
	PreparedStatement ps=null;
	Result rs=null;
	public List<Product> getAllProducts() {
		
		List<Product> list=new ArrayList();
        String query = "SELECT * FROM product ";
        return list;
    }

}
