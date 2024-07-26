package com.ecommerce.entity;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private String cartId;
	private String userID;
	private float totalAll;
	private List<CartDetail> cartDetails;
	public Cart() {
		super();
	}
	
	public Cart(String cartId, String userID, float totalAll) {
		super();
		this.cartId = cartId;
		this.userID = userID;
		this.totalAll = totalAll;
		this.cartDetails = new ArrayList<>();
	}

	
	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}



	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public float getTotalAll() {
		return totalAll;
	}

	public void setTotalAll(float totalAll) {
		this.totalAll = totalAll;
	}

	public List<CartDetail> getCartDetails() {
		return cartDetails;
	}

	public void setCartDetails(List<CartDetail> cartDetails) {
		this.cartDetails = cartDetails;
	}

	public void addCartDetail(CartDetail cartDetail) {
		this.cartDetails.add(cartDetail);
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", userID=" + userID + ", totalAll=" + totalAll + ", cartDetails="
				+ cartDetails + "]";
	}
	

}
