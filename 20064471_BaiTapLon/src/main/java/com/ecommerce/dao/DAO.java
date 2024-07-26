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

public void addToCart(int userId, int productId, int quantity) throws SQLException {
   

    try {
    	conn = new Database().getConnection();
    	   
        // Kiểm tra xem người dùng đã có giỏ hàng chưa
        String checkCartQuery = "SELECT CartID FROM Cart WHERE uID = ?";
        ps = conn.prepareStatement(checkCartQuery);
        ps.setInt(1, userId);
        rs = ps.executeQuery();

        int cartId;
        if (rs.next()) {
            cartId = rs.getInt("CartID");
        } else {
            // Nếu chưa có giỏ hàng, tạo giỏ hàng mới
            String createCartQuery = "INSERT INTO Cart (uID, totalAll) VALUES (?, 0)";
            ps = conn.prepareStatement(createCartQuery, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, userId);
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            cartId = rs.getInt(1);
        }

        // Lấy giá sản phẩm từ bảng Products
        String getPriceQuery = "SELECT Price FROM product WHERE id = ?";
        ps = conn.prepareStatement(getPriceQuery);
        ps.setInt(1, productId);
        rs = ps.executeQuery();

        float unitPrice = 0;
        if (rs.next()) {
            unitPrice = rs.getFloat("Price");
        }

        // Thêm sản phẩm vào chi tiết giỏ hàng
        String addProductQuery = "INSERT INTO CartDetail (CartID, id, quantity, unitprice, totalprice) VALUES (?, ?, ?, ?, ?)";
        ps = conn.prepareStatement(addProductQuery);
        ps.setInt(1, cartId);
        ps.setInt(2, productId);
        ps.setInt(3, quantity);
        ps.setFloat(4, unitPrice);
        ps.setFloat(5, unitPrice * quantity);
        ps.executeUpdate();

        // Cập nhật tổng tiền trong giỏ hàng
        String updateTotalQuery = "UPDATE Cart SET totalAll = (SELECT SUM(totalprice) FROM CartDetail WHERE CartID = ?) WHERE CartID = ?";
        ps = conn.prepareStatement(updateTotalQuery);
        ps.setInt(1, cartId);
        ps.setInt(2, cartId);
        ps.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        conn.close();
    }
}
public void deleteCartDetail(int cartDetailId) throws SQLException {
    String query = "DELETE FROM CartDetail WHERE cartDetail_ID = ?";
    try (Connection conn = new Database().getConnection();
         PreparedStatement ps = conn.prepareStatement(query)) {
        
        ps.setInt(1, cartDetailId);
        ps.executeUpdate();
        System.out.println("Xoá thành Công ");
        
        
    } catch (SQLException e) {
        e.printStackTrace();
        throw e;
    }
}


public void updateCartTotalAll(int cartId) throws SQLException {
    // SQL query to update the total amount in the Cart table
    String updateTotalQuery = 
        "UPDATE Cart SET totalAll = (SELECT COALESCE(SUM(totalprice), 0) FROM CartDetail WHERE CartID = ?) WHERE CartID = ?";

    try (Connection conn = new Database().getConnection();
         PreparedStatement ps = conn.prepareStatement(updateTotalQuery)) {
        
        // Set the cartId for the query
        ps.setInt(1, cartId);
        ps.setInt(2, cartId);
        
        // Execute the update
        ps.executeUpdate();
        System.out.println("Cart total updated successfully.");
        
    } catch (SQLException e) {
        e.printStackTrace();
        throw e; // Propagate the exception to the caller
    }
}
public void updateToTalprice(String cartDetailId,String quantityStr) throws SQLException {
    // SQL query to update the total amount in the Cart table
    String updateToTal = 
        "UPDATE CartDetail SET quantity = ?, totalprice = quantity * unitprice WHERE cartDetail_ID = ?";

    try (Connection conn = new Database().getConnection();
         PreparedStatement ps = conn.prepareStatement(updateToTal)) {
        
        // Set the cartId for the query
        ps.setString(2, cartDetailId);
        ps.setString(1, quantityStr);
        
        // Execute the update
        ps.executeUpdate();
        System.out.println("Cart totalprice updated successfully.");
        
    } catch (SQLException e) {
        e.printStackTrace();
        throw e; // Propagate the exception to the caller
    }
}


	
	
	public static void main(String[] args) throws SQLException {
		DAO dao=new DAO();
		 //String userId = "5";
		   int cartDetailIdToDelete = 25; 
//		List<Product> list=dao.getAllProducts();
//		List<Product> listnew=dao.get4Productsnew();
//		List<Category> listCategory=dao.getAllCategory();
//		List<Product> listProductsBYCID=dao.getProductsBYCID("5");
		System.out.println("----------------- xoa ----------------------");
		
		  try {
	            
	           
	            
	            // Gọi phương thức xóa chi tiết giỏ hàng
	            dao.deleteCartDetail(cartDetailIdToDelete);
	            
	            
	            // In thông tin chi tiết giỏ hàng sau khi xóa
	          
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    
		
		
		
		System.out.println("-----------------xoa ----------------------");
		
		
//		
//		
//		
//		
//		System.out.println("-----------------Test thêm sản ----------------------");
//
//		// Xác định dữ liệu mẫu để thêm vào giỏ hàng
//	    int user = 1; // ID người dùng (thay đổi theo nhu cầu)
//	    int productId = 7; // ID sản phẩm (thay đổi theo nhu cầu)
//	    int quantity = 3; // Số lượng sản phẩm
//
//	    try {
//	        // Thực hiện thêm sản phẩm vào giỏ hàng
//	        dao.addToCart(user, productId, quantity);
//	        System.out.println("Sản phẩm đã được thêm vào giỏ hàng thành công.");
//	    } catch (SQLException e) {
//	        System.err.println("Không thể thêm sản phẩm vào giỏ hàng.");
//	        e.printStackTrace();
//	    }
//		
//		System.out.println("-----------------Test thêm sản ----------------------");
//		System.out.println("-----------------Test thêm sản ----------------------");
//	
//		
//		
//		
//		
//		
//		
//		
//		
////		 try {
////	            // Gọi phương thức getCartByUserId để lấy giỏ hàng
////	            Cart cart = dao.getCartByUserId(userId);
////	            
////	            // Kiểm tra và hiển thị thông tin về giỏ hàng
////	            if (cart != null) {
////	                System.out.println("Cart ID: " + cart.getCartId());
////	                System.out.println("User ID: " + cart.getUserID());
////	                System.out.println("Total Amount: " + cart.getTotalAll());
////
////	                // Hiển thị thông tin chi tiết giỏ hàng (nếu có)
////	                System.out.println("Cart Details:");
////	                for (CartDetail detail : cart.getCartDetails()) {
////	                    System.out.println("Detail ID: " + detail.getCartDetail_Id());
////	                    System.out.println("Product ID: " + detail.getProductId());
////	                    System.out.println("Quantity: " + detail.getQuantity());
////	                    System.out.println("Unit Price: " + detail.getUnitPrice());
////	                    System.out.println("Total Price: " + detail.getTotalPrice());
////	                    System.out.println("Product Name: " + detail.getProductName());
////	                    System.out.println("Image URL: " + detail.getImgURL());
////	                    System.out.println("------------");
////	                }
////	            } else {
////	                System.out.println("No cart found for user ID: " + userId);
////	            }
////	        } catch (SQLException e) {
////	            e.printStackTrace();
////	        }
//		
//		
//		for(Product o:list) {
//			System.out.println(o);
//		}
//		System.out.println("----------------------");
//		for(Category o:listCategory) {
//			System.out.println(o);
//		}
//		System.out.println("----------------------");
//		for(Product o:listnew) {
//			System.out.println(o);
//		}
//		System.out.println("---------ByID-------------");
//		for(Product o:listProductsBYCID) {
//			System.out.println(o);
//		}
//		System.out.println("---------- CartDetail------------");
//		
//		
	}
}
