package com.cafe24.shoppingmall.vo;

public class OptionValueVo {

	private Long no;
	private Long productNo;
	private Long optionNo;
	private String value;

	public OptionValueVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OptionValueVo(Long no, Long productNo, Long optionNo, String value) {
		super();
		this.no = no;
		this.productNo = productNo;
		this.optionNo = optionNo;
		this.value = value;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public Long getProductNo() {
		return productNo;
	}

	public void setProductNo(Long productNo) {
		this.productNo = productNo;
	}

	public Long getOptionNo() {
		return optionNo;
	}

	public void setOptionNo(Long optionNo) {
		this.optionNo = optionNo;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "OptionValueVo [no=" + no + ", productNo=" + productNo + ", optionNo=" + optionNo + ", value=" + value
				+ "]";
	}

}
