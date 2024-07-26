package com.ecommerce.entity;

public class CartDetail {
	 private int cartDetail_Id;
	 private String cardId;
	 private int productId;
	 private int quantity;
	 private float unitPrice;
	 private float totalPrice;
	 private String productName;
	 private String imgURL;
	public CartDetail() {
		super();
	}
	public CartDetail(int cartDetail_Id, String cardId, int productId, int quantity, float unitPrice, float totalPrice,
			String productName, String imgURL) {
		super();
		this.cartDetail_Id = cartDetail_Id;
		this.cardId = cardId;
		this.productId = productId;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
		this.productName = productName;
		this.imgURL = imgURL;
	}
	public int getCartDetail_Id() {
		return cartDetail_Id;
	}
	public void setCartDetail_Id(int cartDetail_Id) {
		this.cartDetail_Id = cartDetail_Id;
	}
	
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getImgURL() {
		return imgURL;
	}
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	@Override
	public String toString() {
		return "CartDetail [cartDetail_Id=" + cartDetail_Id + ", cardId=" + cardId + ", productId=" + productId
				+ ", quantity=" + quantity + ", unitPrice=" + unitPrice + ", totalPrice=" + totalPrice
				+ ", productName=" + productName + ", imgURL=" + imgURL + "]";
	}
	 
	 

}
