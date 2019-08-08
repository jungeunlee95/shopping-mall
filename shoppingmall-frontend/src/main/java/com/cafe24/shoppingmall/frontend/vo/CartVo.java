package com.cafe24.shoppingmall.frontend.vo;

public class CartVo {

	private Long cartNo;
	private Long productNo;
	private Long productOptionNo;
	private Long userNo;
	private String nonUserNo;
	private String productName;
	private String optionName;
	private String mainImg;
	private Long price;
	private Long quantity;
	private Long sumPrice;
	private Long shippingFee;

	public CartVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartVo(Long cartNo, Long productNo, Long productOptionNo, Long userNo, String nonUserNo, String productName,
			String optionName, String mainImg, Long price, Long quantity, Long sumPrice, Long shippingFee) {
		super();
		this.cartNo = cartNo;
		this.productNo = productNo;
		this.productOptionNo = productOptionNo;
		this.userNo = userNo;
		this.nonUserNo = nonUserNo;
		this.productName = productName;
		this.optionName = optionName;
		this.mainImg = mainImg;
		this.price = price;
		this.quantity = quantity;
		this.sumPrice = sumPrice;
		this.shippingFee = shippingFee;
	}

	public Long getCartNo() {
		return cartNo;
	}

	public void setCartNo(Long cartNo) {
		this.cartNo = cartNo;
	}

	public Long getProductNo() {
		return productNo;
	}

	public void setProductNo(Long productNo) {
		this.productNo = productNo;
	}

	public Long getProductOptionNo() {
		return productOptionNo;
	}

	public void setProductOptionNo(Long productOptionNo) {
		this.productOptionNo = productOptionNo;
	}

	public Long getUserNo() {
		return userNo;
	}

	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}

	public String getNonUserNo() {
		return nonUserNo;
	}

	public void setNonUserNo(String nonUserNo) {
		this.nonUserNo = nonUserNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public String getMainImg() {
		return mainImg;
	}

	public void setMainImg(String mainImg) {
		this.mainImg = mainImg;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(Long sumPrice) {
		this.sumPrice = sumPrice;
	}

	public Long getShippingFee() {
		return shippingFee;
	}

	public void setShippingFee(Long shippingFee) {
		this.shippingFee = shippingFee;
	}

	@Override
	public String toString() {
		return "CartVo [cartNo=" + cartNo + ", productNo=" + productNo + ", productOptionNo=" + productOptionNo
				+ ", userNo=" + userNo + ", nonUserNo=" + nonUserNo + ", productName=" + productName + ", optionName="
				+ optionName + ", mainImg=" + mainImg + ", price=" + price + ", quantity=" + quantity + ", sumPrice="
				+ sumPrice + ", shippingFee=" + shippingFee + "]";
	}

}
