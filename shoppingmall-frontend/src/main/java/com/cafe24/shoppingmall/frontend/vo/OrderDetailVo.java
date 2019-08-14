package com.cafe24.shoppingmall.frontend.vo;

public class OrderDetailVo {

	private Long no;
	private Long orderNo;
	private String mainImg;
	private String orderStringNo;
	private Long productNo;
	private Long productOptionNo;
	private String productName;
	private String productOptionName;
	private Long quantity;
	private String status;
	private Long price;

	public OrderDetailVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMainImg() {
		return mainImg;
	}

	public void setMainImg(String mainImg) {
		this.mainImg = mainImg;
	}

	public OrderDetailVo(Long no, Long orderNo, String mainImg, String orderStringNo, Long productNo,
			Long productOptionNo, String productName, String productOptionName, Long quantity, String status,
			Long price) {
		super();
		this.no = no;
		this.orderNo = orderNo;
		this.mainImg = mainImg;
		this.orderStringNo = orderStringNo;
		this.productNo = productNo;
		this.productOptionNo = productOptionNo;
		this.productName = productName;
		this.productOptionName = productOptionName;
		this.quantity = quantity;
		this.status = status;
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

	public String getOrderStringNo() {
		return orderStringNo;
	}

	public void setOrderStringNo(String orderStringNo) {
		this.orderStringNo = orderStringNo;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	} 

	@Override
	public String toString() {
		return "OrderDetailVo [no=" + no + ", orderNo=" + orderNo + ", mainImg=" + mainImg + ", orderStringNo="
				+ orderStringNo + ", productNo=" + productNo + ", productOptionNo=" + productOptionNo + ", productName="
				+ productName + ", productOptionName=" + productOptionName + ", quantity=" + quantity + ", status="
				+ status + ", price=" + price + "]";
	}

}
