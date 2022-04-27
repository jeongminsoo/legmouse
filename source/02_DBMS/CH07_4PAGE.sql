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
    
CREATE TABLE BOOK (
    BOOKNO          VARCHAR2(10),
    CATEGORY_CODE   NUMBER(3),
    BOOKNAME        VARCHAR2(50),
    PUBLISHER       VARCHAR2(50),
    PUBYEAR         NUMBER(4) DEFAULT EXTRACT(YEAR FROM SYSDATE),
    PRIMARY KEY (BOOKNO),
    FOREIGN KEY (CATEGORY_CODE) REFERENCES BOOKCATEGORY (CATEGORY_CODE) );

INSERT INTO BOOK (BOOKNO, CATEGORY_CODE, BOOKNAME, PUBLISHER)
    VALUES ('100A01', 100, 'ö������ ��', '��������');
INSERT INTO BOOK (BOOKNO, CATEGORY_CODE, BOOKNAME, PUBLISHER)
    VALUES ('400A01', 400, '�̰��� DB��', '��������');

COMMIT;

SELECT * FROM BOOKCATEGORY;
SELECT * FROM BOOK;