package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.ecommerce.control.CartControl;
import com.ecommerce.database.Database;
import com.ecommerce.entity.Account;
import com.ecommerce.entity.Cart;
import com.ecommerce.entity.CartDetail;
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
	
public List<Product> getsearchBYName(String txtSearch) {
		
		List<Product> list = new ArrayList<Product>();
        String query = "select * from product where name like ? ";
       try {
    	   conn = new Database().getConnection();
    	   ps=conn.prepareStatement(query);
    	   ps.setString(1,"%" + txtSearch + "%");
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
	
	
	
	
	
	//Account DAO
public Account login(String user,String pass) {
	String query="select * from account where user =? and pass=?";
	try {
		  conn = new Database().getConnection();
   	   ps=conn.prepareStatement(query);
   	   
   	   ps.setString(1, user);
   	   ps.setString(2, pass);
   	   
   	   rs = ps.executeQuery();
   	   while(rs.next()) {
   		   return new Account(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
   	   }	
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	return null;
}
public void SignUp(String user,String pass) {
	String query="INSERT INTO account (user, pass, isSell, isAdmin) VALUES (?, ?, 0, 0);";
	try {
		conn = new Database().getConnection();
   	   ps=conn.prepareStatement(query);
   	   ps.setString(1, user);
   	   ps.setString(2, pass);
   	   ps.executeUpdate();
   	   
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	
}
public Account checkAcountExit(String user) {
	String query="select * from account where user =?";
	try {
		  conn = new Database().getConnection();
   	   ps=conn.prepareStatement(query);
   	   
   	   ps.setString(1, user);

   	   
   	   rs = ps.executeQuery();
   	   while(rs.next()) {
   		   return new Account(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
   	   }	
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	return null;
}



//DAO CART
public Cart getCartByUserId(String userId) throws SQLException {
    String query = "SELECT CartID, totalAll FROM Cart WHERE uID = ?";
    Cart cart = null;
    
    try (Connection conn = new Database().getConnection();
         PreparedStatement ps = conn.prepareStatement(query)) {
        
        int uID = Integer.parseInt(userId);
        ps.setInt(1, uID);
        
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                int cartId = rs.getInt("CartID");
                
                String cid = String.valueOf(cartId);
                float totalAll = rs.getFloat("totalAll");
                
                cart = new Cart(cid, userId, totalAll);
                
                // Retrieve cart details
                String cartDetailQuery = "SELECT cd.cartDetail_ID, cd.id, cd.quantity, cd.unitprice, cd.totalprice, p.name, p.image FROM CartDetail cd JOIN product p ON cd.id = p.id WHERE cd.CartID = ?";
                try (PreparedStatement psDetail = conn.prepareStatement(cartDetailQuery)) {
                    psDetail.setInt(1, cartId);
                    try (ResultSet rsDetail = psDetail.executeQuery()) {
                        while (rsDetail.next()) {
                            int cartDetailId = rsDetail.getInt("cartDetail_ID");
                            int productId = rsDetail.getInt("id");
                            int quantity = rsDetail.getInt("quantity");
                            float unitPrice = rsDetail.getFloat("unitprice");
                            float totalPrice = rsDetail.getFloat("totalprice");
                            String productName = rsDetail.getString("name");
                            String imgURL = rsDetail.getString("image");
                            
                            CartDetail cartDetail = new CartDetail(cartDetailId, cid, productId, quantity, unitPrice, totalPrice, productName, imgURL);
                            cart.addCartDetail(cartDetail);
                        }
                    }
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return cart;
}


	
	
	public static void main(String[] args) throws SQLException {
		DAO dao=new DAO();
		 String userId = "5";
		
		List<Product> list=dao.getAllProducts();
		List<Product> listnew=dao.get4Productsnew();
		List<Category> listCategory=dao.getAllCategory();
		List<Product> listProductsBYCID=dao.getProductsBYCID("5");
		
		 try {
	            // Gọi phương thức getCartByUserId để lấy giỏ hàng
	            Cart cart = dao.getCartByUserId(userId);
	            
	            // Kiểm tra và hiển thị thông tin về giỏ hàng
	            if (cart != null) {
	                System.out.println("Cart ID: " + cart.getCartId());
	                System.out.println("User ID: " + cart.getUserID());
	                System.out.println("Total Amount: " + cart.getTotalAll());

	                // Hiển thị thông tin chi tiết giỏ hàng (nếu có)
	                System.out.println("Cart Details:");
	                for (CartDetail detail : cart.getCartDetails()) {
	                    System.out.println("Detail ID: " + detail.getCartDetail_Id());
	                    System.out.println("Product ID: " + detail.getProductId());
	                    System.out.println("Quantity: " + detail.getQuantity());
	                    System.out.println("Unit Price: " + detail.getUnitPrice());
	                    System.out.println("Total Price: " + detail.getTotalPrice());
	                    System.out.println("Product Name: " + detail.getProductName());
	                    System.out.println("Image URL: " + detail.getImgURL());
	                    System.out.println("------------");
	                }
	            } else {
	                System.out.println("No cart found for user ID: " + userId);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		
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
		System.out.println("---------ByID-------------");
		for(Product o:listProductsBYCID) {
			System.out.println(o);
		}
		System.out.println("---------- CartDetail------------");
		
		
	}
}
