package kr.or.ddit.postfile.model;

public class PostFileVO {
	
	private int fileNo;
	private String fileName;
	private String realFileName;
	private int postNo;
	
	public int getFileNo() {
		return fileNo;
	}
	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getRealFileName() {
		return realFileName;
	}
	public void setRealFileName(String realFileName) {
		this.realFileName = realFileName;
	}
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	
	@Override
	public String toString() {
		return "PostFileVO [fileNo=" + fileNo + ", fileName=" + fileName + ", realFileName=" + realFileName
				+ ", postNo=" + postNo + "]";
	}
	
}
