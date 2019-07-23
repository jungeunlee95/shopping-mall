package com.cafe24.shoppingmall.vo;

public class OptionNameVo {

	private Long no;
	private Long productNo;
	private String productOptionName;
	private Long additionalAmount;
	private Boolean useStock;
	private Long stock;

	public OptionNameVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OptionNameVo(Long no, Long productNo, String productOptionName, Long additionalAmount, Boolean useStock,
			Long stock) {
		super();
		this.no = no;
		this.productNo = productNo;
		this.productOptionName = productOptionName;
		this.additionalAmount = additionalAmount;
		this.useStock = useStock;
		this.stock = stock;
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

	public String getProductOptionName() {
		return productOptionName;
	}

	public void setProductOptionName(String productOptionName) {
		this.productOptionName = productOptionName;
	}

	public Long getAdditionalAmount() {
		return additionalAmount;
	}

	public void setAdditionalAmount(Long additionalAmount) {
		this.additionalAmount = additionalAmount;
	}

	public Boolean getUseStock() {
		return useStock;
	}

	public void setUseStock(Boolean useStock) {
		this.useStock = useStock;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "OptionName [no=" + no + ", productNo=" + productNo + ", productOptionName=" + productOptionName
				+ ", additionalAmount=" + additionalAmount + ", useStock=" + useStock + ", stock=" + stock + "]";
	}

}
