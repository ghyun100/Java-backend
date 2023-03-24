package bored.dto.request.user;

public class SignUpDto {

	private String email;
	private String password;
	private String passwordCheck;
	private String nickName;
	private String phoneNumber;
	private String addrress;
	private String addrressDetail;
	
	public SignUpDto() {}

	public SignUpDto(String email, String password, String passwordCheck, String nickName, String phoneNumber,
			String addrress, String addrressDetail) {
		this.email = email;
		this.password = password;
		this.passwordCheck = passwordCheck;
		this.nickName = nickName;
		this.phoneNumber = phoneNumber;
		this.addrress = addrress;
		this.addrressDetail = addrressDetail;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public String getNickName() {
		return nickName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAddrress() {
		return addrress;
	}

	public String getAddrressDetail() {
		return addrressDetail;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setAddrress(String addrress) {
		this.addrress = addrress;
	}

	public void setAddrressDetail(String addrressDetail) {
		this.addrressDetail = addrressDetail;
	}

	@Override
	public String toString() {
		return "SignUpDto [email=" + email + ", password=" + password + ", passwordCheck=" + passwordCheck
				+ ", nickName=" + nickName + ", phoneNumber=" + phoneNumber + ", addrress=" + addrress
				+ ", addrressDetail=" + addrressDetail + "]";
	}
	
	public boolean validate() {
		boolean result = 
				this.email.isBlank() ||
				this.password.isBlank() ||
				this.passwordCheck.isBlank() ||
				this.nickName.isBlank() ||
				this.phoneNumber.isBlank() ||
				this.addrress.isBlank() ||
				this.addrressDetail.isBlank();
		return result;
	}
	
	
	
	
	
}








