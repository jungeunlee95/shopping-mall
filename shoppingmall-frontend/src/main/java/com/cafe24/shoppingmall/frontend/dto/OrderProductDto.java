package com.cafe24.shoppingmall.frontend.dto;

public class OrderProductDto {

	private Long no;
	private String mainImg;
	private Long productNo;
	private Long productOptionNo;
	private String productName;
	private String optionName;
	private String status;
	private Long quantity;
	private Long price;

	public OrderProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getMainImg() {
		return mainImg;
	}

	public void setMainImg(String mainImg) {
		this.mainImg = mainImg;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public OrderProductDto(Long no, String mainImg, Long productNo, Long productOptionNo, String productName,
			String optionName, String status, Long quantity, Long price) {
		super();
		this.no = no;
		this.mainImg = mainImg;
		this.productNo = productNo;
		this.productOptionNo = productOptionNo;
		this.productName = productName;
		this.optionName = optionName;
		this.status = status;
		this.quantity = quantity;
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrderProductDto [no=" + no + ", mainImg=" + mainImg + ", productNo=" + productNo + ", productOptionNo="
				+ productOptionNo + ", productName=" + productName + ", optionName=" + optionName + ", status=" + status
				+ ", quantity=" + quantity + ", price=" + price + "]";
	}

}
