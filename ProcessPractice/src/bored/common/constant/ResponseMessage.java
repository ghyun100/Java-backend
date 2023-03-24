package bored.common.constant;

public interface ResponseMessage {
	public static final String SUCCESS = "Success";
	
	public static final String EXIST_EMAIL = "Existed Email";
	
	public static final String NOT_EXIST_USER = "Does Not Exist User"; 
	                                            // User가 존재하지 않습니다.
	public static final String NOT_EXIST_BOARD = "Dose Not Exist Board";
	                                            // Board가 존재하지 않습니다.
	public static final String PASSWORD_NOT_MATCH = "Password Does Not Match";
	public static final String FAIL_SIGN_IN = "Sign in Failed";
	
	public static final String NOT_PERMISSION = "Do Not Have Permission";
}
