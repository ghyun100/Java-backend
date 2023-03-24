package bored.entity;
// 댓글
//
// 댓글작성자 프로필사진(문자열) / 
// 댓글 작성자 닉네임(문자열) / 
// 댓글 작성 지난 날짜 및 시간(날짜) / 
// 댓글내용(문자열)

import java.util.Date;

public class Comment {
	private String writerProfileImage;
	private String writerNickname;
	private Date writeDatetime;
	private String content;

	public Comment() {}

	public Comment(String writerProfileImage, String writerNickname, Date writeDatetime, String content) {
		this.writerProfileImage = writerProfileImage;
		this.writerNickname = writerNickname;
		this.writeDatetime = writeDatetime;
		this.content = content;
	}

	public String getWriterProfileImage() {
		return writerProfileImage;
	}

	public String getWriterNickname() {
		return writerNickname;
	}

	public Date getWriteDatetime() {
		return writeDatetime;
	}

	public String getContent() {
		return content;
	}

	public void setWriterProfileImage(String writerProfileImage) {
		this.writerProfileImage = writerProfileImage;
	}

	public void setWriterNickname(String writerNickname) {
		this.writerNickname = writerNickname;
	}

	public void setWriteDatetime(Date writeDatetime) {
		this.writeDatetime = writeDatetime;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Comment [writerProfileImage=" + writerProfileImage + ", writerNickname=" + writerNickname
				+ ", writeDatetime=" + writeDatetime + ", content=" + content + "]";
	}

	
}
