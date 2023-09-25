package vo;

public class PageInfo {
	
	private int Page;   // 기본 페이지 
	private int maxPage; // 총 페이지
	private int startPage; // 시작 페이지
	private int endPage;   // 마지막 페이지
	private int listCount; // 

		
	public PageInfo() {	}



	public PageInfo(int page, int maxPage, int startPage, int endPage, int listCount) {
		super();
		Page = page;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
		this.listCount = listCount;
	}


	public PageInfo(int page, int listCount) {
		super();
		Page = page;
		this.listCount = listCount;
	}



	public int getPage() {
		return Page;
	}



	public void setPage(int page) {
		Page = page;
	}



	public int getMaxPage() {
		return maxPage;
	}



	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}



	public int getStartPage() {
		return startPage;
	}



	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}



	public int getEndPage() {
		return endPage;
	}



	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}



	public int getListCount() {
		return listCount;
	}



	public void setListCount(int listCount) {
		this.listCount = listCount;
	}




}
