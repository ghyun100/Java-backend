package com.gahyun.board.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.gahyun.board.dto.request.board.PostBoardRequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Board")
@Table(name="Board")
public class BoardEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int boardNumber;
    private String writerEmail;
    private String title;
    private String content;
    private String boardImageUrl;
    private String writeDatetime;
    private int viewCount;

    public BoardEntity(PostBoardRequestDto dto) {
        Date now = new Date();
        SimpleDateFormat simpleDateFormat =
        new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        
        String writeDatetime = simpleDateFormat.format(now);

        this.writerEmail = dto.getBoardWriterEmail();
        this.title = dto.getBoardTitle();
        this.content = dto.getBaordContent();
        this.boardImageUrl = dto.getBoardImageUrl();
        this.writeDatetime = writeDatetime;
        this.viewCount = 0;
    }
}
