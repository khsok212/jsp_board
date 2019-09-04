package kr.or.ddit.board.model;

public class Board1VO {
	
	private int boardNo;		// 게시판 번호
	private String boardName;	// 게시판 이름
	private int useYN;			// 게시판 사용여부
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public int getUseYN() {
		return useYN;
	}
	public void setUseYN(int useYN) {
		this.useYN = useYN;
	}
	
	@Override
	public String toString() {
		return "Board1VO [boardNo=" + boardNo + ", boardName=" + boardName + ", useYN=" + useYN + "]";
	}
	
	
	
}
