package com.gahyun.board.dto.request.board;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostBoardRequestDto {
    @NotBlank
    @Email
    private String boardWriterEmail;
    @NotBlank
    private String boardTitle;
    @NotBlank
    private String baordContent;
    private String boardImageUrl;
}
