show databases;  -- database 리스트 보기

-- DCL (계정생성, 권한부여, 권한박탈, 계정삭제)
create  user user01 identified by 'password';  -- 계정 생성
grant all on *.* to user01;  -- 권한 부여
revoke all on *.* from user01;  -- 권한 박탈
drop user user01;  -- 계정 삭제

-- DDL (테이블 생성, 제약조건, 시퀀스 없음)
-- 테이블 생성 (먼저 데이터베이스로 접속해야 테이블 생성 가능)
create database kimdb;  -- 데이터베이스 생성
use kimdb;    -- 데이터베이스 접속
select database();
show tables;  -- 현재 접속한 데이터베이스의 테이블 보기

create table emp(
	empno numeric(4) primary key,
    ename varchar(20) not null,
    nickname varchar(20) unique,
    sal numeric(7, 2) check(sal>0),
    hiredate datetime default now(), -- now() = sysdate()
	comm numeric(7, 2) default 0 );
    
select * from emp;
drop table if exists emp;
    
-- Major(mCode(시퀀스같은 순차번호) : PK, mName, mOffice)
-- Student (sNo : PK, sName, mCode)
create table major (
	mCode int primary key auto_increment,  -- auto_increment 일 경우 꼭 int 형으로 와야함
	mName varchar(20),
	mOffice varchar(50) );
    
create table student (
	sNo int primary key,
	sName varchar(20),
	mCode int references major (mCode) );
    
select * from major;
select * from student;
    
insert into major (mName, mOffice) values ('컴공', '402호');
insert into major (mName, mOffice) values ('경영', '502호');
insert into major (mName, mOffice) values ('경제', '301호');
select * from major;
    
insert into student values (1111, '홍', 1);
insert into student values (2222, '이', 2);
insert into student values (3333, '사', 3);
insert into student values (4444, '박', 4);
select * from student;
    
drop table if exists student;
drop table if exists major;
    
create table major (
	mCode int auto_increment,
	mName varchar(30) not null,
	mOffice varchar(30),
	primary key (mCode) );
        
create table student (
	sNo int,
	sName varchar(30),
	mCode int,
	primary key (sNo),
	foreign key (mCode) references major (mCode) );
    
-- 학번, 이름, 학과코드, 학과명, 사무실
select sNo, sName, s.mCode, mName, mOffice
	from student s, major m
	where s.mCode = m.mCode;
	
-- 자바(JDBC) 수업시간에 쓸 테이블
drop table if exists personal;
drop table if exists division;
	
create table division (       
    dno   int,  	   -- 부서번호
    dname varchar(20), -- 부서이름
    tel	  varchar(20), -- 부서전화
    position varchar(20),  -- 부서위치
    primary key (dno) );

insert into division values (10, 'finance', '02-545-5555', '강남');        
insert into division values (20, 'research', '02-777-7777', '회현');        
insert into division values (30, 'sales', '02-333-3333', '서초');
insert into division values (40, 'marketing', '02-666-6666', '과천');
select * from division;

create table personal (
	pno int,  -- 사번
    pname varchar(20) not null,  -- 사원명
	job varchar(20) not null, -- 직책
    manager int, -- 상사의 사번
    startdate date, -- 입사일
    pay int,  -- 급여
    bonus int, -- 상여
    dno int, -- 부서번호
    primary key (pno),
    foreign key (dno) references division (dno));

insert into personal values (1111,'smith','manager', 1001, '1990-12-17', 1000, null, 10);
insert into personal values (1112,'ally','salesman',1116,'1991-02-20',1600,500,30);
insert into personal values (1113,'word','salesman',1116,'1992-02-24',1450,300,30);
insert into personal values (1114,'james','manager',1001,'1990-04-12',3975,null,20);
insert into personal values (1001,'bill','president',null,'1989-01-10',7000,null,10);
insert into personal values (1116,'johnson','manager',1001,'1991-05-01',3550,null,30);
insert into personal values (1118,'martin','analyst',1111,'1991-09-09',3450,null,10);
insert into personal values (1121,'kim','clerk',1114,'1990-12-08',4000,null,20);
insert into personal values (1123,'lee','salesman',1116,'1991-09-23',1200,0,30);
insert into personal values (1226,'park','analyst',1111,'1990-01-03',2500,null,10);
select * from personal;
commit;

-- Oracle에서의 단일행함수와 MySQL 컬럼함수의 다른 부분
select round(789.56, 2);  -- from 절 생략 가능
select concat(pname, '은', job, '이다') from personal;  -- 연결연산자 concat 에서 매개변수 무한 추가 가능

-- 날짜 관련 컬럼함수
select year(startdate), month(startdate), day(startdate), hour(startdate),
	minute(startdate), second(startdate) from personal;

-- date_format(날짜형이나 시간형데이터, '포맷') : 날짜형 -> 문자형
-- %y : 연도2자리 / %Y : 연도4자리 / %M : 월이름 / %b : 짧은 월이름 / %m : 월 2자리 / %c : 월수
-- %d : 일 2자리 / %e : 일수 / %H : 24시간단위 / %h : 12시간 단위 / %p : 오전오후 / %i : 분 / %s : 초
select date_format(now(), '%y년%m월%e일%p%H시%i분%s초');
select date_format(now(), '%Y년%M%e일%p%H시%i분%s초');
select date_format(now(), '%y년%b%e일%p%H시%i분%s초');
select date_format(now(), '%Y년%c월%e일%p%h시%i분%s초');

-- 현재 날짜와 시간 : sysdate(), now()
select sysdate();
select now();

-- 현재 날짜만 : current_date(), curdate()
select current_date();
select curdate();

-- 현재 시간만 : current_time(), curtime()
select current_time();
select curtime();

-- format(숫자데이터, '포맷') : 3자리 마다 콤마 추가
-- format(숫자데이터, 소수점자리수) : 3자리 콤마 + 소수점 확보
select format(pay, 1) from personal;

-- workbench에서 데이터 삭제하거 수정 (where절에 primary key를 이용한 비교)
insert into personal (pno, pname, job, manager, startdate, pay, bonus, dno)
	values (1000, 'hong', 'manager', '1001', curdate(), 9000, 900, 40);

commit;
set sql_safe_updates = 0;  -- 삭제 권한 부여
delete from personal where pname = 'hong';
select * from personal;

-- top-N 구문
select pname, pay from personal order by pay desc;

-- limit n : 1등부터 n등까지
-- limite n-1,m+1 : n등부터 m등
select pname, pay from personal order by pay desc limit 5;
select pname, pay from personal order by pay desc limit 3,3;
select pname, pay from personal order by pay desc limit 5,4;



