package bored.controller;

import bored.common.constant.HttpStatus;
import bored.dto.request.user.SignInDto;
import bored.dto.request.user.SignUpDto;
import bored.dto.response.ResponseDto;
import bored.dto.response.user.SignInReponseDto;
import bored.service.UserService;

public class UserController {
	
	private UserService userService;
	
	public UserController() {
		userService = new UserService();
	}
	
	public void signUp(SignUpDto dto) {
		
		if (dto.validate()) {
			System.out.println(HttpStatus.BAD_REQUEST);
			return;
		}
		
		ResponseDto<Boolean> response = userService.signUp(dto);
		System.out.println(response.toString());
	}
	
	public void signIn(SignInDto dto) {
		
		if (dto.validate()) {
			System.out.println(HttpStatus.BAD_REQUEST);
			return;
		}
		ResponseDto<SignInReponseDto> response = userService.signIn(dto);
		System.out.println(response.toString());
	}
	
	
}
