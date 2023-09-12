package vo;

public class Pagination {

	private int page;   //현재 페이지
	private int range;   //현재 페이지 범위
	private int listCnt; // 전체 게시물의 개수
	private int pageCnt; //전체 페이지 범위의 개수
	private int listSize; //한 페이지 목록의 개수
	private int rangeSize; //한 페이지 범위의 개수
	private int startPage; //시작 번호
	private int endPage;   //끝 번호
	private boolean prev;  //이전 페이지
	private boolean next;  //다음 페이지
	
	
	public Pagination() { }


	public Pagination(int page, int range, int listCnt, int pageCnt, int listSize, int rangeSize, int startPage,
			int endPage, boolean prev, boolean next) {
		super();
		this.page = page;
		this.range = range;
		this.listCnt = listCnt;
		this.pageCnt = pageCnt;
		this.listSize = listSize;
		this.rangeSize = rangeSize;
		this.startPage = startPage;
		this.endPage = endPage;
		this.prev = prev;
		this.next = next;
	}


	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}


	public int getRange() {
		return range;
	}


	public void setRange(int range) {
		this.range = range;
	}


	public int getListCnt() {
		return listCnt;
	}


	public void setListCnt(int listCnt) {
		this.listCnt = listCnt;
	}


	public int getPageCnt() {
		return pageCnt;
	}


	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}


	public int getListSize() {
		return listSize;
	}


	public void setListSize(int listSize) {
		this.listSize = listSize;
	}


	public int getRangeSize() {
		return rangeSize;
	}


	public void setRangeSize(int rangeSize) {
		this.rangeSize = rangeSize;
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


	public boolean isPrev() {
		return prev;
	}


	public void setPrev(boolean prev) {
		this.prev = prev;
	}


	public boolean isNext() {
		return next;
	}


	public void setNext(boolean next) {
		this.next = next;
	}
	
	
}
