package bored;

import java.util.Scanner;

import bored.common.constant.HttpStatus;
import bored.controller.BoardController;
import bored.controller.UserController;
import bored.dto.request.PatchBoardDto;
import bored.dto.request.board.PostBoardDto;
import bored.dto.request.user.SignInDto;
import bored.dto.request.user.SignUpDto;

public class BoardApplication {

	private static UserController userController = new UserController();
	private static BoardController boardController = new BoardController();
	
	private static final String SIGN_UP = "POST /sign-up";
	private static final String SIGN_IN = "POST /sign-in";
	
	private static final String POST_BOARD = "POST /board"; //글을 씀,게시 함
	
	private static final String GET_BOARD_LIST = "GET /board/list"; // 리스트를 보여줌
	private static final String GET_BOARD = "GET /board";
	
	
	private static final String PATCH_BOARD = "PATCH /board";// 수정
	
	private static final String DELETE_BOARD = "DELETE /board";
	
	public static void main(String[] args) {
		
		while(true) {
			
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("URL End point : ");
			String endPoint = scanner.nextLine();
			
			switch(endPoint) {
			
			case SIGN_UP:
				SignUpDto signUpDto = new SignUpDto();
				System.out.print("이메일 주소 : ");
				signUpDto.setEmail(scanner.nextLine());
				System.out.print("비밀번호 : "); 
				signUpDto.setPassword(scanner.nextLine());
				System.out.print("비밀번호 확인 : ");
				signUpDto.setPasswordCheck(scanner.nextLine());
				System.out.print("닉네임 : ");
				signUpDto.setNickName(scanner.nextLine());
				System.out.print("휴대전화번호 : ");
				signUpDto.setPhoneNumber(scanner.nextLine());
				System.out.print("주소 : ");
				signUpDto.setAddrress(scanner.nextLine());
				System.out.print("상세주소 주소 : ");
				signUpDto.setAddrressDetail(scanner.nextLine());
				
				//System.out.println(signUpDto.toString());  // ->잘 만든건지 확인
				
				userController.signUp(signUpDto);
				
				break; // swhitch를 빠져나가는거지 while을 빠져나가는게 아님
				
			case SIGN_IN:
				SignInDto signInDto = new SignInDto();
				System.out.println("이메일 주소 : ");
				signInDto.setEmail(scanner.nextLine());
				System.out.println("비밀번호 : ");
				signInDto.setPassword(scanner.nextLine());
				
			//	System.out.println(signInDto.toString());
				
				userController.signIn(signInDto);
				break;
			case POST_BOARD:
				PostBoardDto postBoardDto = new PostBoardDto();
				System.out.println("제목 :");
				postBoardDto.setTitle(scanner.nextLine());
				System.out.println("내용 :");
				postBoardDto.setContent(scanner.nextLine());
				System.out.println("이미지 :");
				postBoardDto.setBoardImageUrl(scanner.nextLine());
				System.out.println("작성자 이메일 :");
				postBoardDto.setWriterEmail(scanner.nextLine());
				
				boardController.postBoard(postBoardDto);//만들거를 컨트롤러에 옮겨서 검증
				break;
				
			case GET_BOARD_LIST:
				
				boardController.getBoardList();
				break;
				
			case GET_BOARD: // 특정 게시물 들어가기
				int boardNumber = 0;
				try {
					System.out.print("게시물 번호 : ");
					boardNumber = scanner.nextInt();
					
				} catch (Exception exception) {
					exception.printStackTrace();
					continue;
				}
					boardController.getBoard(boardNumber);
					break;
					
			case PATCH_BOARD:
				PatchBoardDto patchBoardDto = new PatchBoardDto();
				
				try {
					System.out.print("게시물 번호 : ");
					String boardNumberString = scanner.nextLine();
					patchBoardDto.setBoardNumber(Integer.parseInt(boardNumberString));// 문자열을 정수로 바꿔줌
					System.out.print("제목 : ");
					patchBoardDto.setTitle(scanner.nextLine());
					System.out.print("내용 : ");
					patchBoardDto.setContent(scanner.nextLine());
					System.out.print("이미지 : ");
					patchBoardDto.setBoardImageUrl(scanner.nextLine());
					System.out.println("작성자 이메일 : ");
					patchBoardDto.setEmail(scanner.nextLine());
				} catch (Exception exception) {
					exception.printStackTrace();
					continue;
				}
				
				boardController.patchBoard(patchBoardDto);
				
				break;	
				
			case DELETE_BOARD:
				int deleteBoardNumber = 0;
				String deleteEmail = null;
				try {
					System.out.println("게시물 번호 :");
					deleteBoardNumber = Integer.parseInt(scanner.nextLine());
					System.out.println("이메일 :");
					deleteEmail = scanner.nextLine();
					
					
				} catch (Exception exception) {
					exception.printStackTrace();
					continue;
				}
				boardController.deleteBoard(deleteBoardNumber, deleteEmail);
				
				break;
					
				default:
					System.out.println(HttpStatus.NOT_FOUND);
				}
			
		}
		
	}
}
