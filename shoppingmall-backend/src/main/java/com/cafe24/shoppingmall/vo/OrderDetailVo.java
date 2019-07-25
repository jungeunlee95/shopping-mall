package com.cafe24.shoppingmall.vo;

public class OrderDetailVo {

	private Long no;
	private Long orderNo;
	private Long productNo;
	private String productName;
	private String productOptionName;
	private Long quantity;
	private Long price;

	public OrderDetailVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetailVo(Long no, Long orderNo, Long productNo, String productName, String productOptionName,
			Long quantity, Long price) {
		super();
		this.no = no;
		this.orderNo = orderNo;
		this.productNo = productNo;
		this.productName = productName;
		this.productOptionName = productOptionName;
		this.quantity = quantity;
		this.price = price;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public Long getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}

	public Long getProductNo() {
		return productNo;
	}

	public void setProductNo(Long productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductOptionName() {
		return productOptionName;
	}

	public void setProductOptionName(String productOptionName) {
		this.productOptionName = productOptionName;
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

	@Override
	public String toString() {
		return "OrderDetailVo [no=" + no + ", orderNo=" + orderNo + ", productNo=" + productNo + ", productName="
				+ productName + ", productOptionName=" + productOptionName + ", quantity=" + quantity + ", price="
				+ price + "]";
	}

}
