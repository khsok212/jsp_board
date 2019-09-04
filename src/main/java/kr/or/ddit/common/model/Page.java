package kr.or.ddit.common.model;

public class Page {
	
	private int page;
	private int pagesize;
	private int boardNo;
	
	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public Page() {	}
	
	public Page(int page, int pagesize) {
		this.page = page;
		this.pagesize = pagesize;
	}
	
	public Page(int page, int pagesize, int boardNo) {
		super();
		this.page = page;
		this.pagesize = pagesize;
		this.boardNo = boardNo;
	}

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	@Override
	public String toString() {
		return "Page [boardNo=" + boardNo + ", page=" + page + ", pagesize=" + pagesize + "]";
	}
}
