package com.cafe24.shoppingmall.vo;

import java.util.List;

public class ProductVo {

	private Long no; // 상품 번호
	private String code; // 상품 코드
	private String name; // 상품 이름
	private int price; // 상품 가격
	private String regDate; // 등록일
	private boolean isShow; // 진열 여부
	private boolean isOption; // 옵션 여부
	private int shippingFee; // 배송비
	private int orderNo; // 진열 순위
	private String contents; // 본문 내용

	private List<OptionNameVo> optionNameList; // 옵션(상위) 리스트
	private List<OptionVo> optionList; // 옵션(상위) 리스트
	private List<OptionValueVo> optionValueList; // 옵션(하위) 리스트
	private List<CategoryVo> categoryList; // 카테고리 리스트

	public ProductVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductVo(Long no, String code, String name, int price, String regDate, boolean isShow, boolean isOption,
			int shippingFee, int orderNo, String contents, List<OptionNameVo> optionNameList, List<OptionVo> optionList,
			List<OptionValueVo> optionValueList, List<CategoryVo> categoryList) {
		super();
		this.no = no;
		this.code = code;
		this.name = name;
		this.price = price;
		this.regDate = regDate;
		this.isShow = isShow;
		this.isOption = isOption;
		this.shippingFee = shippingFee;
		this.orderNo = orderNo;
		this.contents = contents;
		this.optionNameList = optionNameList;
		this.optionList = optionList;
		this.optionValueList = optionValueList;
		this.categoryList = categoryList;
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

	public boolean getIsShow() {
		return isShow;
	}

	public void setIsShow(boolean isShow) {
		this.isShow = isShow;
	}

	public boolean getIsOption() {
		return isOption;
	}

	public void setIsOption(boolean isOption) {
		this.isOption = isOption;
	}

	public int getShippingFee() {
		return shippingFee;
	}

	public void setShippingFee(int shippingFee) {
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

	public List<OptionNameVo> getOptionNameList() {
		return optionNameList;
	}

	public void setOptionNameList(List<OptionNameVo> optionNameList) {
		this.optionNameList = optionNameList;
	}

	public List<OptionVo> getOptionList() {
		return optionList;
	}

	public void setOptionList(List<OptionVo> optionList) {
		this.optionList = optionList;
	}

	public List<OptionValueVo> getOptionValueList() {
		return optionValueList;
	}

	public void setOptionValueList(List<OptionValueVo> optionValueList) {
		this.optionValueList = optionValueList;
	}

	public List<CategoryVo> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<CategoryVo> categoryList) {
		this.categoryList = categoryList;
	}

	@Override
	public String toString() {
		return "ProductVo [no=" + no + ", code=" + code + ", name=" + name + ", price=" + price + ", regDate=" + regDate
				+ ", isShow=" + isShow + ", option=" + isOption + ", shippingFee=" + shippingFee + ", orderNo="
				+ orderNo + ", contents=" + contents + ", optionNameList=" + optionNameList + ", optionList="
				+ optionList + ", optionValueList=" + optionValueList + ", categoryList=" + categoryList + "]";
	}

}
