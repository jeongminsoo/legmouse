DROP TABLE MEMBER CASCADE CONSTRAINTS; -- 제약조건 상관없이 삭제
CREATE TABLE MEMBER (
    ID VARCHAR2(30) PRIMARY KEY,
    PW VARCHAR2(30) NOT NULL,
    NAME VARCHAR(30) NOT NULL,
    PHONE1 VARCHAR2(5),
    PHONE2 VARCHAR2(5),
    PHONE3 VARCHAR2(5),
    GENDER VARCHAR(1),
    EMAIL VARCHAR2(30),
    BIRTH DATE,
    RDATE DATE NOT NULL,
    ADDRESS VARCHAR2(200)
);
-- 1. 회원가입시 ID 중복체크 : public int cofirmId(String id)
SELECT * FROM MEMBER WHERE ID = 'AAA';
-- 2. 회원가입 : public int joinMember(MemberDto dto)
INSERT INTO MEMBER (ID, PW, NAME, PHONE1, PHONE2, PHONE3, GENDER, EMAIL, BIRTH, RDATE, ADDRESS)
    VALUES ('aaa', '111', '홍길동', '02', '1111', '1111', 'm', 'HONG@H.COM', '1995-12-12', SYSDATE, '서울');
-- 3. 로그인 : public int loginCheck(String id, String pw)
SELECT ID, PW FROM MEMBER WHERE ID = 'AAA';
-- 4. ID로 dto 가져오기 : public MemberDto getMember(String id)
SELECT * FROM MEMBER WHERE ID = 'AAA';
-- 5. 회원정보 수정 : public int modifyMember(MemberDto dto)
UPDATE MEMBER SET PW = '111', NAME = '신길동', PHONE1 = '010', PHONE2 = '9999', PHONE3 = '9999',
    GENDER = 'F', EMAIL = 'SIN@S.COM', BIRTH = '1990-12-01', ADDRESS = '안양' WHERE ID = 'aaa';
    
SELECT * FROM MEMBER;
COMMIT;
