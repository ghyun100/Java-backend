package com.gahyun.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gahyun.board.entity.BoardEntity;



@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
    
    public BoardEntity findByBoardNumber(int boardNumber);

}
