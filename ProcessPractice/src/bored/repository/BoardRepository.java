package bored.repository;

import java.util.ArrayList;
import java.util.List;

import bored.entity.Board;

public class BoardRepository {
	
	public static int index = 0;
	
	
	private static List<Board> boardTable = new ArrayList<>();
	
	public Board save(Board board) {
		boolean isExist = false;
		
		for(int index = 0; index < boardTable.size(); index++) {
			Board boardItem = boardTable.get(index);
			if(boardItem.getBoardNumber() == board.getBoardNumber()) {
				boardTable.set(index,board); 
				isExist = true;
				break;
			}
		}
	if(!isExist) {
		boardTable.add(board);
		}
		return board;
	}
	
	
		
	
	
	public Board findByBoardNumber(int boardNumber) {
		Board result = null;
		for (Board board: boardTable) {
			if(board.getBoardNumber() == boardNumber) { // 문자열은equals, 정수형은 ==
				result = board;
				break;
			}
		}
		return result;
	}
	
	
	public List<Board> findBy() {
		return boardTable;
	}
	
	public void deleteByBoardNumber(int boardNumber) {
		for (int index = 0; index < boardTable.size(); index++) {
			Board board = boardTable.get(index);
			if (board.getBoardNumber() == boardNumber) {
				boardTable.remove(board);
				break;
			}
		}
	}
}
