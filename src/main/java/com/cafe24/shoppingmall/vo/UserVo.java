package com.cafe24.shoppingmall.vo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class UserVo {

	private Long no;
	
	@NotEmpty(message="아이디를 입력해주세요.")
	// 영문시작 특수문자 불가능('-'가능), 5~12자 
	@Pattern(regexp = "^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$", message = "잘못된 아이디 형식입니다.")
	private String id;
	  
	@NotEmpty(message="이름을 입력해주세요.")
	// 영문 혹은 한글 이름(둘 다 사용 불가)
	@Pattern(regexp = "^[가-힣]{2,4}|^[a-zA-Z]*$", message = "잘못된 이름 형식입니다.")
	private String name;
	
	@Length(min=9, max=15, message="비밀번호 길이는 8~16자 입니다.")
	// 비밀번호 정규식 (최소 8자리에 대문자 1자리 소문자 한자리 숫자 한자리)
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$", message = "잘못된 비밀번호 형식입니다.")
	private String password;
	
	private String passwordQuestion;
	
	@Length(min = 2, message="답변은 2글자 이상을 입력해주세요.")
	private String passwordAnswer;
	
	@NotEmpty(message="전화번호를 입력해주세요.") 
	// 전화번호 정규식
	@Pattern(regexp = "^01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$", message = "잘못된 전화번호 형식입니다.")
	private String phoneNumber;
	
	@Email(message="잘못된 이메일 형식입니다.")
	@NotEmpty(message="이메일을 입력해주세요.")
	private String email;
	private String birthDate;
	
	private String point;
	private String endDate;

	public UserVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserVo(String id, String name, String password, String passwordQuestion, 
			String passwordAnswer, String phoneNumber, String email) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.passwordQuestion = passwordQuestion;
		this.passwordAnswer = passwordAnswer;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordQuestion() {
		return passwordQuestion;
	}

	public void setPasswordQuestion(String passwordQuestion) {
		this.passwordQuestion = passwordQuestion;
	}

	public String getPasswordAnswer() {
		return passwordAnswer;
	}

	public void setPasswordAnswer(String passwordAnswer) {
		this.passwordAnswer = passwordAnswer;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "UserVo [no=" + no + ", id=" + id + ", name=" + name + ", password=" + password + ", passwordQuestion="
				+ passwordQuestion + ", passwordAnswer=" + passwordAnswer + ", phoneNumber=" + phoneNumber + ", email="
				+ email + ", birthDate=" + birthDate + ", point=" + point + ", endDate=" + endDate + "]";
	}

}
