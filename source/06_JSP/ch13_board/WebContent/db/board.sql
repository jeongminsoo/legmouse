DROP TABLE BOARD;
CREATE TABLE BOARD (
    NUM NUMBER(5) PRIMARY KEY,  -- 글번호
    WRITER VARCHAR2(30) NOT NULL, -- 글쓴이
    SUBJECT VARCHAR(50) NOT NULL, -- 글제목
    CONTENT VARCHAR2(4000) NOT NULL, -- 글내용
    EMAIL VARCHAR(30), -- 글쓴이 이메일
    READCOUNT NUMBER(5) DEFAULT 0, -- 글 조회수
    PW VARCHAR2(20) NOT NULL, -- 글 삭제시 사용할 비밀번호
    REF NUMBER(5) NOT NULL, -- 글 그룹(원글일 경우, 글번호/답변글일 경우 원글의 글번호)
    RE_STEP NUMBER(5) NOT NULL, -- 글그룹 내 출력 순서
    RE_INDENT NUMBER(5) NOT NULL, -- 답변글 들여쓰기 정도
    IP VARCHAR(20) NOT NULL, -- 글쓴이 IP주소
    RDATE DATE DEFAULT SYSDATE NOT NULL -- 글 작성일자
);