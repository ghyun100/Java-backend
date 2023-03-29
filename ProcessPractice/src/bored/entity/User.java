package bored.entity;

import bored.dto.request.user.SignUpDto;

//회원
//
// 이메일주소(문자열) / 비밀번호(문자열)  / 닉네임(문자열) /
// 핸드폰번호(문자열) / 주소(문자열) / 상세주소(문자열) /
// 프로필사진(문자열(이미지의 링크주소=url, 파일객체를 쓸수도 있지만 안그러고 링크주소로 하겠다))

public class User { // 보관하고 관리하는 용도
	private String email;
	private String password;
	private String nickname;
	private String phoneNumber;
	private String address;
	private String addressDetail;
	private String profileImageUrl;
	
	public User() {}

	public User(String email, String password, String nickname, String phoneNumber, String address,
			String addressDetail, String profileImageUrl) {
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.addressDetail = addressDetail;
		this.profileImageUrl = profileImageUrl;
	}
	
	public User(SignUpDto dto) {
		this.email = dto.getEmail();
		this.password = dto.getPassword();
		this.nickname = dto.getNickName();
		this.phoneNumber = dto.getPhoneNumber();
		this.address = dto.getAddrress();
		this.addressDetail = dto.getAddrressDetail();
	} // 이해가 안됨.

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getNickname() {
		return nickname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", nickname=" + nickname + ", phoneNumber="
				+ phoneNumber + ", address=" + address + ", addressDetail=" + addressDetail + ", profileImageUrl="
				+ profileImageUrl + "]";
	}
	
	
	
	
	
}
