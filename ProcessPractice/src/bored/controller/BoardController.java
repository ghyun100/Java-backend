package bored.controller;

import java.util.List;


import bored.common.constant.HttpStatus;
import bored.dto.request.PatchBoardDto;
import bored.dto.request.board.PostBoardDto;
import bored.dto.response.ResponseDto;
import bored.dto.response.board.DeleteBoardResponseDto;
import bored.dto.response.board.GetBoardListResponseDto;
import bored.dto.response.board.GetBoardResponseDto;
import bored.dto.response.board.PatchBoardResponseDto;
import bored.dto.response.board.PostBoardResponseDto;
import bored.service.BoardService;

public class BoardController {
	private BoardService boardService;
	
	public BoardController () {
		boardService = new BoardService();
	}
	
	public void postBoard(PostBoardDto dto) {
		if(dto.auth()) {
			System.out.println(HttpStatus.UNAUTHORIZED);
			return;
		}
		
		if(dto.vaild()) {
			System.out.println(HttpStatus.BAD_REQUEST);
			return;
		}
		ResponseDto<PostBoardResponseDto> response = boardService.postBoard(dto);
		// <PostBoardResponseDto> 이걸 <Board>로 쓰면 안되냐는 의문이 있음 
		// 근데 엔터티에 Board는 반환하는 용도가 아님.         
		
		System.out.println(response.toString());
		
	}
	
	public void getBoardList() {
		ResponseDto<List<GetBoardListResponseDto>> response = boardService.getBoardList();
		// 얘리스트안에 전달해 줄거다, 보드서비스에서 getBoardList만들어 줌
		System.out.println(response.toString());
	}
	
	public void getBoard(int boardNumber) {
		
		if (boardNumber <= 0) {
			System.out.println(HttpStatus.BAD_REQUEST);
			return;
		}
		ResponseDto<GetBoardResponseDto> response = 
				boardService.getBoard(boardNumber);
		System.out.println(response.toString());
	}
	
	public void patchBoard(PatchBoardDto dto) {
		if (dto.auth()) {
			System.out.println(HttpStatus.UNAUTHORIZED);
			return;
		}
		if (dto.valid()) {
			System.out.println(HttpStatus.BAD_REQUEST);
			return;
		}
		ResponseDto<PatchBoardResponseDto> response = 
				boardService.patchBoard(dto);
				System.out.println(response.toString());
	}
	
	public void deleteBoard(int boardNumber, String email) {
		boolean auth = email.isBlank();
		if (auth) {
			System.out.println(HttpStatus.UNAUTHORIZED);
			return;
		}
	
	boolean valid = boardNumber <= 0;
	if (valid) {
		System.out.println(HttpStatus.BAD_REQUEST);
		return;
		}
	
	ResponseDto<List<DeleteBoardResponseDto>> response = 
			boardService.deleteBoard(boardNumber, email);
			System.out.println(response.toString());
	
	}
	
}
