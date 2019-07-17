package com.cafe24.shoppingmall.vo;

public class ProductVo {

	private Long no;
	private String code;
	private String name;
	private int price;
	private String regDate;
	private boolean show;
	private boolean option;
	private int shippingFee;
	private int orderNo;
	private String contents;
	private Long categoryNo;
	
//	private List<OptionVo> optionList;
//	private List<OptionChildVo> optionChildList;
	
	public ProductVo() {
		super();
	}

	public ProductVo(Long no, String code, String name, int price, String regDate, boolean show, boolean option,
			int shippingFee, int orderNo, String contents, Long categoryNo) {
		super();
		this.no = no;
		this.code = code;
		this.name = name;
		this.price = price;
		this.regDate = regDate;
		this.show = show;
		this.option = option;
		this.shippingFee = shippingFee;
		this.orderNo = orderNo;
		this.contents = contents;
		this.categoryNo = categoryNo;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	public boolean isOption() {
		return option;
	}

	public void setOption(boolean option) {
		this.option = option;
	}

	public int getshippingFee() {
		return shippingFee;
	}

	public void setshippingFee(int shippingFee) {
		this.shippingFee = shippingFee;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Long getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(Long categoryNo) {
		this.categoryNo = categoryNo;
	}

	@Override
	public String toString() {
		return "ProductVo [no=" + no + ", code=" + code + ", name=" + name + ", price=" + price + ", regDate=" + regDate
				+ ", show=" + show + ", option=" + option + ", shippingFee=" + shippingFee + ", orderNo=" + orderNo
				+ ", contents=" + contents + ", categoryNo=" + categoryNo + "]";
	}

}
