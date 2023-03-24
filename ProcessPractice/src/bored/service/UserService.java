package bored.service;

import bored.common.constant.ResponseMessage;
import bored.dto.request.user.SignInDto;
import bored.dto.request.user.SignUpDto;
import bored.dto.response.ResponseDto;
import bored.dto.response.user.SignInReponseDto;
import bored.entity.User;
import bored.repository.UserRepository;

public class UserService {
	
	private UserRepository userRepository; 
	
	public UserService() {
		userRepository = new UserRepository();
	}
	
	public ResponseDto<Boolean> signUp(SignUpDto dto) {
		
		String email = dto.getEmail();
		String password = dto.getPassword();
		String passwordCheck = dto.getPasswordCheck();
	
		boolean hasEmail = userRepository.existsByEmail(email); //-> 이메일 중복
		if (hasEmail) {
			return new ResponseDto<Boolean>(false, ResponseMessage.EXIST_EMAIL, false); // 반환할 때 바로생성
		}
		if (!password.equals(passwordCheck)) { // -> 비밀번호 중복
			return new ResponseDto<Boolean>(false, ResponseMessage.PASSWORD_NOT_MATCH, false);
		}
		
		User user = new User(dto);
		userRepository.save(user);
			
		return new ResponseDto<Boolean>(true, ResponseMessage.SUCCESS, true);
		
	}
	
	public ResponseDto<SignInReponseDto> signIn(SignInDto dto) {
		
		SignInReponseDto data = null;
		
		String email = dto.getEmail();
		String password =dto.getPassword();
		// UserRepository에 userTable에서 검색
		User user = userRepository.findByEmail(email);
		if (user == null) {	
			return new ResponseDto<>(false, ResponseMessage.FAIL_SIGN_IN, null);
		}
		boolean isEqualPassword = user.getPassword().equals(password);
		if (!isEqualPassword) {
			return new ResponseDto<>(false, ResponseMessage.FAIL_SIGN_IN, null);
		}
		data = new SignInReponseDto(user);
		
		return new ResponseDto<>(true, ResponseMessage.SUCCESS, data);
		
		
	}
	
	
	
	
}
