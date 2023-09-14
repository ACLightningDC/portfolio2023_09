package vo;

public class Pagination {

	private int listSize = 15; //한 페이지 목록의 개수 //초기값으로 목록개수를 15으로 셋팅
	private int rangeSize = 15;//한 페이지 범위의 개수 //초기값으로 페이지범위를 15으로 셋팅
	
	private int page;   //현재 페이지
	private int range;   //현재 페이지 범위
	private int listCnt; // 전체 게시물의 개수
	private int pageCnt; //전체 페이지 범위의 개수
 
	private int startPage; //시작 번호
	private int endPage;   //끝 번호
	
	private boolean prev;  //이전 페이지
	private boolean next;  //다음 페이지
	
	private int startList;
	
	
	public Pagination() { }

	
	public Pagination(int listSize, int rangeSize, int page, int range, int listCnt, int pageCnt, int startPage,
			int endPage, boolean prev, boolean next, int startList) {
		super();
		this.listSize = listSize;
		this.rangeSize = rangeSize;
		this.page = page;
		this.range = range;
		this.listCnt = listCnt;
		this.pageCnt = pageCnt;
		this.startPage = startPage;
		this.endPage = endPage;
		this.prev = prev;
		this.next = next;
		this.startList = startList;
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

/*
	public void setRangeSize(int rangeSize) {
		this.rangeSize = rangeSize;
	}
*/
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

	public int getStartList() {
		return startList;
	}

/*
	public void setStartList(int startList) {
		this.startList = startList;
	}
*/
	

	public int getPageCnt() {
		return pageCnt;
	}


	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}


	public void setRangeSize(int rangeSize) {
		this.rangeSize = rangeSize;
	}


	public void setStartList(int startList) {
		this.startList = startList;
	}


	public void pageInfo(int page, int range, int listCnt) {
		this.page = page; // 현재 페이지 정보 
		this.range = range; //현재 페이지 범위 정보
		this.listCnt = listCnt; // (상품)게시물의 총 개수
		

		//전체 페이지수
		this.pageCnt = (int)Math.ceil(listCnt/listSize);
		
		//시작 페이지 - 각 페이지 범위의 시작 번호를 구하는 방법
		this.startPage = (range -1) * rangeSize + 1;
		
		//끝 페이지 - 각 페이지 범위의 마지막 번호를 구하는 방법
		this.endPage = range * rangeSize;
		
		//화면 시작번호
		this.startList = (page -1) * listSize;
		
		//이전 버튼 상태
		this.prev = range == 1 ? false : true;
		
		//다음 버튼 상태
		this.next = endPage > pageCnt ? false : true;
		if(this.endPage > this.pageCnt) {
			this.endPage = this.pageCnt;
			this.next = false;
		}
		System.out.println(this);

	}


	@Override
	public String toString() {
		return "Pagination [listSize=" + listSize + ", rangeSize=" + rangeSize + ", page=" + page + ", range=" + range
				+ ", listCnt=" + listCnt + ", pageCnt=" + pageCnt + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", prev=" + prev + ", next=" + next + ", startList=" + startList + "]";
	}	
}
