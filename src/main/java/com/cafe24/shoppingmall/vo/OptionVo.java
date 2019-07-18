package com.cafe24.shoppingmall.vo;

import java.util.List;

public class OptionVo {

	private Long no;
	private String name;
	private List<OptionValueVo> optionValueList;

	public OptionVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OptionVo(Long no, String name, List<OptionValueVo> optionValueList) {
		super();
		this.no = no;
		this.name = name;
		this.optionValueList = optionValueList;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<OptionValueVo> getOptionValueList() {
		return optionValueList;
	}

	public void setOptionValueList(List<OptionValueVo> optionValueList) {
		this.optionValueList = optionValueList;
	}

	@Override
	public String toString() {
		return "OptionVo [no=" + no + ", name=" + name + ", optionValueList=" + optionValueList + "]";
	}

}
