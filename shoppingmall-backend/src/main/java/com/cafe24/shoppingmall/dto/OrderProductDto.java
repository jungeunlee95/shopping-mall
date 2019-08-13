package com.cafe24.shoppingmall.dto;

public class OrderProductDto {

	private String mainImg;
	private Long productNo;
	private Long productOptionNo;
	private String productName;
	private String optionName;
	private Long quantity;
	private Long price;

	public OrderProductDto() {
		super();
		// TODO Auto-generated constructor stub
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

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getMainImg() {
		return mainImg;
	}

	public void setMainImg(String mainImg) {
		this.mainImg = mainImg;
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

	public OrderProductDto(Long productNo, Long productOptionNo, Long quantity, Long price, String mainImg,
			String productName, String optionName) {
		super();
		this.productNo = productNo;
		this.productOptionNo = productOptionNo;
		this.quantity = quantity;
		this.price = price;
		this.mainImg = mainImg;
		this.productName = productName;
		this.optionName = optionName;
	} 

	@Override
	public String toString() {
		return "OrderProductDto [productNo=" + productNo + ", productOptionNo=" + productOptionNo + ", quantity="
				+ quantity + ", price=" + price + ", mainImg=" + mainImg + ", productName=" + productName
				+ ", optionName=" + optionName + "]";
	}

}
