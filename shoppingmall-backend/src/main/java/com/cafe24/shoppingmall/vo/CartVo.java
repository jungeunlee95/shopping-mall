package com.cafe24.shoppingmall.vo;

public class CartVo {

	private Long no;
	private Long productOptionNo;
	private Long userNo;
	private String nonUserNo;
	private String productName;
	private String image;
	private Long price;
	private Long quantity;
	private Long sumPrice;
	private Long shippingFee;

	public CartVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartVo(Long no, Long productOptionNo, Long userNo, String nonUserNo, String productName, String image,
			Long price, Long quantity, Long sumPrice, Long shippingFee) {
		super();
		this.no = no;
		this.productOptionNo = productOptionNo;
		this.userNo = userNo;
		this.nonUserNo = nonUserNo;
		this.productName = productName;
		this.image = image;
		this.price = price;
		this.quantity = quantity;
		this.sumPrice = sumPrice;
		this.shippingFee = shippingFee;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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
		return "CartVo [no=" + no + ", productOptionNo=" + productOptionNo + ", userNo=" + userNo + ", nonUserNo="
				+ nonUserNo + ", productName=" + productName + ", image=" + image + ", price=" + price + ", quantity="
				+ quantity + ", sumPrice=" + sumPrice + ", shippingFee=" + shippingFee + "]";
	}

}
