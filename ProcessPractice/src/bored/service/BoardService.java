package bored.service;

import java.util.List;

import bored.common.constant.ResponseMessage;
import bored.dto.request.PatchBoardDto;
import bored.dto.request.board.PostBoardDto;
import bored.dto.response.ResponseDto;
import bored.dto.response.board.DeleteBoardResponseDto;
import bored.dto.response.board.GetBoardListResponseDto;
import bored.dto.response.board.GetBoardResponseDto;
import bored.dto.response.board.PatchBoardResponseDto;
import bored.dto.response.board.PostBoardResponseDto;
import bored.entity.Board;
import bored.entity.User;
import bored.repository.BoardRepository;
import bored.repository.UserRepository;

public class BoardService {
	
	private BoardRepository boardRepository;
	private UserRepository userRepository;
	
	public BoardService() {
		boardRepository = new BoardRepository();
		userRepository = new UserRepository();
	}
	
	public ResponseDto<PostBoardResponseDto> postBoard(PostBoardDto dto) {
		PostBoardResponseDto data = null;
		
		String email = dto.getWriterEmail();
		
		User user = userRepository.findByEmail(email);
		if (user == null) {
			return new ResponseDto<>(false, ResponseMessage.NOT_EXIST_USER, null);
		}
		
		Board board = new Board(dto, user); // 보드라는 정보를 만드려고 유저를 받아오려함 
		                                    // 받아오려면 사용자로부터 받은 이메일이 필요(메서드안 이줄 윗부분)
		boardRepository.save(board);
		
		data = new PostBoardResponseDto(board);
		return new ResponseDto<>(true, ResponseMessage.SUCCESS, data);
	}
	
		public ResponseDto<List<GetBoardListResponseDto>> getBoardList() {
			
			List<GetBoardListResponseDto> data = null;
		
			List<Board> boardList = boardRepository.findBy();
			
			data = GetBoardListResponseDto.copyList(boardList);
			return new ResponseDto<>(true, ResponseMessage.SUCCESS, data);
		}
		
		public ResponseDto<GetBoardResponseDto> getBoard(int boardNumber) {
			
			GetBoardResponseDto data = null;
			
			Board board = boardRepository.findByBoardNumber(boardNumber);
			if (board == null) {
				return new ResponseDto<>(false, ResponseMessage.NOT_EXIST_BOARD, null);
			}
			
			board.increaseViewCount();
			boardRepository.save(board);
			
			data = new GetBoardResponseDto(board);
			
			return new ResponseDto<>(true, ResponseMessage.SUCCESS, data);
		}
		
		public ResponseDto<PatchBoardResponseDto> patchBoard(PatchBoardDto dto) {
			
			PatchBoardResponseDto data = null;
			
			String email = dto.getEmail();
			int boardNumber = dto.getBoardNumber();
			User user = userRepository.findByEmail(email);
			if (user == null) {
				return new ResponseDto<>(false, ResponseMessage.NOT_EXIST_USER, null );
			}
			
			Board board = boardRepository.findByBoardNumber(boardNumber);
			if (board == null) {
				return new ResponseDto<>(false, ResponseMessage.NOT_EXIST_BOARD, null);
			}
			if (!board.getWriterEmail().equals(email)) {
				return new ResponseDto<>(false, ResponseMessage.NOT_PERMISSION, null);
			}
			
			board.patch(dto);
			boardRepository.save(board);
			
			data = new PatchBoardResponseDto(board);
			
			return new ResponseDto<>(true, ResponseMessage.SUCCESS, data);
		}
		
		public ResponseDto<List<DeleteBoardResponseDto>> deleteBoard(int boardNumber, String email) {
			
			List<DeleteBoardResponseDto> data = null;
			
			User user = userRepository.findByEmail(email);
			if(user == null) {
				return new ResponseDto<>(false, ResponseMessage.NOT_EXIST_USER, null);
			}
			Board board = boardRepository.findByBoardNumber(boardNumber);
			if(board == null) {
				return new ResponseDto<>(false, ResponseMessage.NOT_EXIST_BOARD, null);
				
			}
			if (!board.getWriterEmail().equals(email)) {
				return new ResponseDto<>(false, ResponseMessage.NOT_PERMISSION, null);
			}
			// 삭제
			boardRepository.deleteByBoardNumber(boardNumber);
			// 반환해줄 리스트
			List<Board> boardList = boardRepository.findBy();
			
			data = DeleteBoardResponseDto.copyList(boardList);
			return new ResponseDto<>(true, ResponseMessage.SUCCESS, data);
			
		}
		
	}
	

