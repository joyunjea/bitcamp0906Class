-- 새 테이블
ALTER TABLE Member
	DROP CONSTRAINT PK_Member; -- 새 테이블 기본키

-- 새 테이블
DROP TABLE Member;

-- 새 테이블
CREATE TABLE Member (
	id       NUMBER(6)    NOT NULL, -- 회원번호
	userid   VARCHAR2(10) NOT NULL, -- 아이디
	username VARCHAR(50)  NOT NULL, -- 이름
	password VARCHAR2(10) NOT NULL, -- 비밀번호
	address  VARCHAR2(60) NOT NULL, -- 주소
	phone    VARCHAR(30)  NOT NULL, -- 전화번호
	email    VARCHAR(40)  NULL      -- 이메일
);

-- 새 테이블 기본키
CREATE UNIQUE INDEX PK_Member
	ON Member ( -- 새 테이블
		id ASC -- 회원번호
	);

-- 새 테이블
ALTER TABLE Member
	ADD
		CONSTRAINT PK_Member -- 새 테이블 기본키
		PRIMARY KEY (
			id -- 회원번호
		);
        
select * from Member;
commit;


insert into Member values(2,'손흥민','12ab','qwe123','서울시','010-1234-1234','12@gmail.com');

-----------------------------------------------------------------------------------------
-- 메뉴
ALTER TABLE menu
	DROP CONSTRAINT PK_menu; -- 메뉴 기본키

-- 메뉴
DROP TABLE menu;

-- 메뉴
CREATE TABLE Menu (
	mid   NUMBER(6)    NOT NULL, -- 메뉴번호
	mname     varchar2(40) NOT NULL, -- 메뉴명
	mprice    INTEGER      NOT NULL, -- 가격
	mtype NUMBER(1)    NOT NULL  -- 종류
);

-- 메뉴 기본키
CREATE UNIQUE INDEX K_menu
	ON menu ( -- 메뉴
		menuid ASC -- 메뉴번호
	);

-- 메뉴
ALTER TABLE menu
	ADD
		CONSTRAINT PK_menu -- 메뉴 기본키
		PRIMARY KEY (
			menuid -- 메뉴번호
		);
insert into menu values(1,'불고기버거',3500,1);
insert into menu values(2,'상하이버거',4500,1);
insert into menu values(3,'감자튀김',2000,2);
insert into menu values(4,'치즈볼',3000,2);
insert into menu values(5,'콜라',1000,3);
insert into menu values(6,'사이다',1000,3);
insert into menu values(7,'환타',1000,3);
insert into menu values(8,'아이스크림',1000,2);
insert into menu values(9,'쉐이크',2000,2);
commit;
select * from menu ;