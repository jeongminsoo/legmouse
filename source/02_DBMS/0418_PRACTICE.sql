-- �������� 4.
CREATE TABLE BOOKCATEGORY (
    CATEGORY_CODE       NUMBER(3),
    CATEGORY_NAME       VARCHAR2(50) UNIQUE,
    OFFICE_LOC          VARCHAR2(50) NOT NULL,
    PRIMARY KEY (CATEGORY_CODE) );
    
INSERT INTO BOOKCATEGORY VALUES (100, 'ö��', '3�� �ι���');
INSERT INTO BOOKCATEGORY VALUES (200, '�ι�', '3�� �ι���');
INSERT INTO BOOKCATEGORY VALUES (300, '�ڿ�����', '4�� ���н�');
INSERT INTO BOOKCATEGORY VALUES (400, 'IT', '4�� ���н�');
    
DROP TABLE BOOK;
CREATE TABLE BOOK (
    BOOKNO          VARCHAR2(10),
    CATEGORY_CODE   NUMBER(3),
    BOOKNAME        VARCHAR(50),
    PUBLISHER       VARCHAR(50),
    PUBYEAR         NUMBER(4) DEFAULT EXTRACT(YEAR FROM SYSDATE),
    PRIMARY KEY (BOOKNO),
    FOREIGN KEY (CATEGORY_CODE) REFERENCES BOOKCATEGORY (CATEGORY_CODE) );

INSERT INTO BOOK (BOOKNO, CATEGORY_CODE, BOOKNAME, PUBLISHER)
    VALUES ('100A01', 100, 'ö������ ��', '��������');
INSERT INTO BOOK (BOOKNO, CATEGORY_CODE, BOOKNAME, PUBLISHER)
    VALUES ('400A01', 400, '�̰��� DB��', '��������');

SELECT * FROM BOOKCATEGORY;
SELECT * FROM BOOK;

-- �������� 5.
CREATE TABLE MAJOR (
    MAJOR_CODE          NUMBER(2),
    MAJOR_NAME          VARCHAR2(30) UNIQUE,
    MAJOR_OFFICE_LOC    VARCHAR2(60) NOT NULL,
    PRIMARY KEY(MAJOR_CODE) );
    
INSERT INTO MAJOR VALUES (1, '�濵����', '�濵�� 305ȣ');
INSERT INTO MAJOR VALUES (2, '����Ʈ�������', '������ 808ȣ');
INSERT INTO MAJOR VALUES (3, '������', '������ 606ȣ');
INSERT INTO MAJOR VALUES (4, '����', '���� 202ȣ');

CREATE TABLE STUDENT (
    STUDENT_CODE         VARCHAR2(5),
    STUDENT_NAME         VARCHAR2(30) NOT NULL,
    SCORE                NUMBER(3),
    MAJOR_CODE           NUMBER(2),
    PRIMARY KEY (STUDENT_CODE),
    CHECK (SCORE > 0),
    CHECK (SCORE <=100),
    FOREIGN KEY (MAJOR_CODE) REFERENCES MAJOR (MAJOR_CODE) );
    
INSERT INTO STUDENT VALUES ('A01', '��浿', 100, 1);
INSERT INTO STUDENT VALUES ('A02', '���浿', 90, 2);
INSERT INTO STUDENT VALUES ('A03', 'ȫ�浿', 95, 1);

SELECT * FROM MAJOR;
SELECT * FROM STUDENT;


-- �� �������� 1.
CREATE TABLE MEMBER_LEVEL (
    LEVELNO         NUMBER(1),
    LEVELNAME       VARCHAR2(10) NOT NULL,
    PRIMARY KEY (LEVELNO) );

INSERT INTO MEMBER_LEVEL VALUES (-1, 'black');
INSERT INTO MEMBER_LEVEL VALUES (0, '�Ϲ�');
INSERT INTO MEMBER_LEVEL VALUES (1, '�ǹ�');
INSERT INTO MEMBER_LEVEL VALUES (2, '���');

CREATE SEQUENCE MEMBER_SEQ;
    
CREATE TABLE MEMBER (
    MNO         NUMBER(3),
    MNAME       VARCHAR2(30) NOT NULL,
    MPW         VARCHAR2(8) NOT NULL,
    MMAIL       VARCHAR2(20) UNIQUE,
    MPOINT      NUMBER(6),
    MRDATE      DATE DEFAULT SYSDATE,
    LEVELNO     NUMBER(1),
    PRIMARY KEY (MNO),
    CHECK (LENGTH(MPW) <= 8),
    CHECK (MPOINT >= 0),
    FOREIGN KEY (LEVELNO) REFERENCES MEMBER_LEVEL (LEVELNO) );
    
INSERT INTO MEMBER VALUES (MEMBER_SEQ.NEXTVAL, 'ȫ�浿', 'aa', 'hong@hong.com', 0, '22/03/10', 0);
INSERT INTO MEMBER (MNO, MNAME, MPW, MMAIL, MPOINT, LEVELNO)
    VALUES (MEMBER_SEQ.NEXTVAL, '�ű浿', 'bb', 'sin@sin.com', 1000, 1);

SELECT * FROM MEMBER_LEVEL;
SELECT * FROM MEMBER;

SELECT MNO, MNAME, TO_CHAR(MRDATE, 'YYYY-MM-DD') "mRDATE", MMAIL, MPOINT, LEVELNAME||'����' "levelname"
    FROM MEMBER M, MEMBER_LEVEL ML
    WHERE M.LEVELNO = ML.LEVELNO;