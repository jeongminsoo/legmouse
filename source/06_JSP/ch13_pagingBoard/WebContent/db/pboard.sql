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



-- 쿼리 만들기
-- 한 페이지에 나타나는 글 개수 : 페이징
SELECT COUNT(*) FROM BOARD;
-- 글 목록
SELECT * FROM BOARD ORDER BY NUM DESC;
SELECT * FROM BOARD ORDER BY REF DESC;
-- 글쓰기
INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)
    VALUES ((SELECT NVL(MAX(NUM), 0)+1 FROM BOARD), '홍길동', '글제목1', '본문', NULL, '1', (SELECT NVL(MAX(NUM), 0)+1 FROM BOARD), 0, 0, '192.168.10.30');
INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)
    VALUES ((SELECT NVL(MAX(NUM), 0)+1 FROM BOARD), '홍길동', '글제목2', '본문', NULL, '1', (SELECT NVL(MAX(NUM), 0)+1 FROM BOARD), 0, 0, '192.168.10.30');
INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)
    VALUES ((SELECT NVL(MAX(NUM), 0)+1 FROM BOARD), '홍길동', '글제목3', '본문', NULL, '1', (SELECT NVL(MAX(NUM), 0)+1 FROM BOARD), 0, 0, '192.168.10.30');
INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)
    VALUES ((SELECT NVL(MAX(NUM), 0)+1 FROM BOARD), '홍길동', '글제목10', '본문', NULL, '1', (SELECT NVL(MAX(NUM), 0)+1 FROM BOARD), 0, 0, '192.168.10.30');
-- 글번호로 글 가져오기
SELECT * FROM BOARD WHERE NUM = 1;
-- 조회수 올리기
UPDATE BOARD SET READCOUNT = READCOUNT + 1 WHERE NUM = 2;
-- 글 수정
UPDATE BOARD SET SUBJECT  = '수정된제목1',  CONTENT = '수정된 본문', EMAIL = 'HONG@HONG.COM', PW = '1', IP = '127.0.0.1' WHERE NUM = 1;
-- 글 삭제
DELETE FROM BOARD WHERE NUM = '1' AND PW = '1';

ROLLBACK;
COMMIT;
SELECT * FROM BOARD;


SELECT  * FROM BOARD ORDER BY REF DESC, RE_STEP;

SELECT ROWNUM RN, A.* FROM (SELECT  * FROM BOARD ORDER BY REF DESC, RE_STEP) A;

SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT  * FROM BOARD ORDER BY REF DESC, RE_STEP) A)
    WHERE RN BETWEEN 11 AND 20;





