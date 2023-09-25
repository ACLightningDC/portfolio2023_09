drop TABLE BOARD;

CREATE TABLE BOARD(
	BOARD_NUM INT, /*1-글 번호 (오라클:NUMBER), 아래에서 기본키로 설정함*/

	BOARD_NAME VARCHAR(20) NOT NULL, /*2-글 작성자(오라클:V ARCHAR2)*/
	BOARD_PASS VARCHAR(15) NOT NULL, /*3-글 비밀번호*/
	BOARD_SUBJECT VARCHAR(50) NOT NULL, /*4-글 제목*/
	BOARD_CONTENT VARCHAR(2000) NOT NULL, /*5-글 내용*/
	BOARD_FILE VARCHAR(50) NOT NULL, /*6-첨부 파일*/
	/*-------------------------------------------------------------------------*/
	BOARD_RE_REF INT NOT NULL, /*7-관련글 번호*/
	BOARD_RE_LEV INT NOT NULL, /*8-답글 레벨*/
	BOARD_RE_SEQ INT NOT NULL, /*9-관련글 중 출력순서*/
	/*----------------------------------------------------------*/
	BOARD_READCOUNT INT DEFAULT 0, /*조회수*/
	BOARD_DATE DATE, /*작성일*/
	/*----------------------------------------------------------*/
	PRIMARY KEY(BOARD_NUM) /*기본키*/
);
