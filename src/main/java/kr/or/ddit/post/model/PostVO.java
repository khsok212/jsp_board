package kr.or.ddit.post.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PostVO {
	
	private int postNo;
	private int boardNo;
	private String postTitle;
	private String postContent;
	private String userId;
	private Date postWDate;
	private int deleteYN;
	private Integer parentPostNo;
	private int level;
	private int gn;
	
	public String getPostWDate_fmt() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(postWDate);
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getGn() {
		return gn;
	}

	public void setGn(int gn) {
		this.gn = gn;
	}

	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getPostWDate() {
		return postWDate;
	}
	public void setPostWDate(Date postWdate) {
		this.postWDate = postWdate;
	}
	public int getDeleteYN() {
		return deleteYN;
	}
	public void setDeleteYN(int deleteYN) {
		this.deleteYN = deleteYN;
	}
	public Integer getParentPostNo() {
		return parentPostNo;
	}
	public void setParentPostNo(Integer parentPostNo) {
		this.parentPostNo = parentPostNo;
	}
	
	@Override
	public String toString() {
		return "BoardVO [postNo=" + postNo + ", boardNo=" + boardNo + ", postTitle=" + postTitle + ", postContent="
				+ postContent + ", userId=" + userId + ", postWDate=" + postWDate + ", deleteYN=" + deleteYN
				+ ", parentPostNo=" + parentPostNo + "]";
	}
	
	
	
	
}
