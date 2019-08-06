package com.cafe24.shoppingmall.frontend.vo;

public class CategoryVo {

	private Long no;
	private String name;
	private Long depth;
	private Long groupNo;
	private Long orderNo;

	public CategoryVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryVo(Long no, String name, Long depth, Long groupNo, Long orderNo) {
		super();
		this.no = no;
		this.name = name;
		this.depth = depth;
		this.groupNo = groupNo;
		this.orderNo = orderNo;
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

	public Long getDepth() {
		return depth;
	}

	public void setDepth(Long depth) {
		this.depth = depth;
	}

	public Long getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(Long groupNo) {
		this.groupNo = groupNo;
	}

	public Long getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Long orderNo) { 
		this.orderNo = orderNo;
	}

	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", name=" + name + ", depth=" + depth + ", groupNo=" + groupNo + ", orderNo="
				+ orderNo + "]";
	}

}
