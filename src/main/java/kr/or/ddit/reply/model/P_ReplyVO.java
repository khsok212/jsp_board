package kr.or.ddit.reply.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class P_ReplyVO {
	
	private int replyNo;
	private int postNo;
	private String replyContent;
	private String userId;
	private Date replyWDate;
	private int deleteYN;
	
	public String getReplyWDate_fmt() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(replyWDate);
	}
	
	public int getDeleteYN() {
		return deleteYN;
	}

	public void setDeleteYN(int deleteYN) {
		this.deleteYN = deleteYN;
	}

	public int getReplyNo() {
		return replyNo;
	}
	
	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}
	
	public int getPostNo() {
		return postNo;
	}
	
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	
	public String getReplyContent() {
		return replyContent;
	}
	
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public Date getReplyWDate() {
		return replyWDate;
	}
	
	public void setReplyWDate(Date replyWDate) {
		this.replyWDate = replyWDate;
	}
	
	@Override
	public String toString() {
		return "P_ReplyVO [replyNo=" + replyNo + ", postNo=" + postNo + ", replyContent=" + replyContent + ", userId="
				+ userId + ", replyWDate=" + replyWDate + "]";
	}
	
	
}
