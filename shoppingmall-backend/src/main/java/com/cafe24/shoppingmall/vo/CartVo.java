package com.cafe24.shoppingmall.vo;

public class CartVo {

	private Long no;
	private String image;
	private int productName;
	private String optionName;
	private boolean price;
	private String quantity;
	private boolean shippingFee;
	private int shoppingFee;

	public CartVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getProductName() {
		return productName;
	}

	public void setProductName(int productName) {
		this.productName = productName;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public boolean isPrice() {
		return price;
	}

	public void setPrice(boolean price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public boolean isShippingFee() {
		return shippingFee;
	}

	public void setShippingFee(boolean shippingFee) {
		this.shippingFee = shippingFee;
	}

	public int getShoppingFee() {
		return shoppingFee;
	}

	public void setShoppingFee(int shoppingFee) {
		this.shoppingFee = shoppingFee;
	}

	public CartVo(Long no, String image, int productName, String optionName, boolean price, String quantity,
			boolean shippingFee, int shoppingFee) {
		super();
		this.no = no;
		this.image = image;
		this.productName = productName;
		this.optionName = optionName;
		this.price = price;
		this.quantity = quantity;
		this.shippingFee = shippingFee;
		this.shoppingFee = shoppingFee;
	}

	@Override
	public String toString() {
		return "CartVo [no=" + no + ", image=" + image + ", productName=" + productName + ", optionName=" + optionName
				+ ", price=" + price + ", quantity=" + quantity + ", shippingFee=" + shippingFee + ", shoppingFee="
				+ shoppingFee + "]";
	}

}
