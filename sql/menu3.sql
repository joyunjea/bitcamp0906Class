DROP INDEX PK_delivery;

/* 배달정보 */
DROP TABLE delivery 
	CASCADE CONSTRAINTS;

/* 배달정보 */
CREATE TABLE delivery (
	adressnum number(6) NOT NULL, /* 주소번호 */
	dname VARCHAR2(50) default 'N' NOT NULL, /* 이름 */
	daddr VARCHAR2(255) default 'N' NOT NULL, /* 주소 */
	dphn VARCHAR2(50) default 'N' NOT NULL /* 전화번호*/
);

desc delivery;

COMMENT ON TABLE delivery IS '배달정보';

COMMENT ON COLUMN delivery.adressnum IS '주소번호';

COMMENT ON COLUMN delivery.dname IS '이름';

COMMENT ON COLUMN delivery.daddr IS '주소';

COMMENT ON COLUMN delivery.dphn IS '전화번호';

CREATE UNIQUE INDEX PK_delivery
	ON delivery (
		adressnum ASC
	);

ALTER TABLE delivery
	ADD
		CONSTRAINT PK_delivery
		PRIMARY KEY (
			adressnum
		);

delete from delivery;
        


drop sequence del_seq;
--시퀀스생성
create sequence del_seq
start with 1
minvalue 1
increment by 1
;




/* 메뉴 */
DROP TABLE menu 
	CASCADE CONSTRAINTS;
drom * from menu;
/* 메뉴 */
CREATE TABLE menu (
	mid NUMBER(6) CONSTRAINT mid_pk PRIMARY KEY NOT NULL, /* 메뉴번호 */
	mname VARCHAR(50) NOT NULL, /* 메뉴명 */
	mprice INTEGER NOT NULL, /* 메뉴가격 */
	mtype number(1) NOT NULL, /* 메뉴종류 */
    mcount INTEGER DEFAULT 1 NOT NULL /* 메뉴수량 */
);

/* 메뉴 추가 */
insert into menu (MID, MNAME, MPRICE, MTYPE) values (menu_seq.nextVal, '불고기버거(콜라)', 5800, 1);
insert into menu (MID, MNAME, MPRICE, MTYPE) values (menu_seq.nextVal, '불고기버거(사이다)', 5800, 1);
insert into menu (MID, MNAME, MPRICE, MTYPE) values (menu_seq.nextVal, '불고기버거(환타)', 5800, 1);
insert into menu (MID, MNAME, MPRICE, MTYPE) values (menu_seq.nextVal, '상하이버거(콜라)', 6300, 1);
insert into menu (MID, MNAME, MPRICE, MTYPE) values (menu_seq.nextVal, '상하이버거(사이다)', 6300, 1);
insert into menu (MID, MNAME, MPRICE, MTYPE) values (menu_seq.nextVal, '상하이버거(환타)', 6300, 1);
insert into menu (MID, MNAME, MPRICE, MTYPE) values (menu_seq.nextVal, '불고기버거', 3500, 2);
insert into menu (MID, MNAME, MPRICE, MTYPE) values (menu_seq.nextVal, '상하이버거', 4000, 2);
insert into menu (MID, MNAME, MPRICE, MTYPE) values (menu_seq.nextVal, '후렌치후라이', 2000, 3);
insert into menu (MID, MNAME, MPRICE, MTYPE) values (menu_seq.nextVal, '치즈볼', 3000,  3);
insert into menu (MID, MNAME, MPRICE, MTYPE) values (menu_seq.nextVal, '아이스크림', 1000, 3);
insert into menu (MID, MNAME, MPRICE, MTYPE) values (menu_seq.nextVal, '쉐이크', 1000, 3);
insert into menu (MID, MNAME, MPRICE, MTYPE) values (menu_seq.nextVal, '콜라', 1000, 4);
insert into menu (MID, MNAME, MPRICE, MTYPE) values (menu_seq.nextVal, '사이다', 1000, 4);
insert into menu (MID, MNAME, MPRICE, MTYPE) values (menu_seq.nextVal, '환타', 1000, 4);

--select menu_seq.currval from menu;
--시퀀스 삭제
drop sequence menu_seq;

--시퀀스생성
create sequence menu_seq
start with 1
minvalue 1
increment by 1
;
-- 메뉴수량을 1로 수정(메뉴 수량 초기화)
update menu set mcount =1;
-- 1번 메뉴를 출력
select * from menu where mid = 1;
-- 모든 행을 출력
select * from menu;
-- 저장
COMMIT;
-- commit한 부분까지 되돌리기
rollback;





DROP INDEX PK_users;

/* 회원 */
DROP TABLE users 
	CASCADE CONSTRAINTS;

/* 회원 */
CREATE TABLE users (
	id number(6) NOT NULL, /* 회원번호 */
	username VARCHAR2(50) NOT NULL, /* 이름 */
	userid VARCHAR2(40) NOT NULL, /* 아이디 */
	password VARCHAR2(40) NOT NULL, /* 비밀번호 */
	address VARCHAR2(255) NOT NULL, /* 주소 */
	phone VARCHAR2(30) NOT NULL, /* 전화번호 */
	email VARCHAR2(40) /* 이메일 */
);

COMMENT ON TABLE users IS '회원';

COMMENT ON COLUMN users.id IS '회원번호';

COMMENT ON COLUMN users.username IS '이름';

COMMENT ON COLUMN users.userid IS '아이디';

COMMENT ON COLUMN users.password IS '비밀번호';

COMMENT ON COLUMN users.address IS '주소';

COMMENT ON COLUMN users.phone IS '전화번호';

COMMENT ON COLUMN users.email IS '이메일';

CREATE UNIQUE INDEX PK_users
	ON users (
		id ASC
	);

ALTER TABLE users
	ADD
		CONSTRAINT PK_users
		PRIMARY KEY (
			id
		);
delete from users;
delete from users where id != 0;  
delete from users where id >2;   
--관리자 정보(회원번호 0 임의로 정함)
insert into users values(0, 'manager', 'm1', 'm1', '서울특별시 강남구 비트캠프', '010-0101-1010', 'jkmanager@gmail.com');  
insert into users values(users_seq.nextval, 'tName1', 'tId1', 'tPw1', '서울특별시 강남구 비트캠프', '010-0101-1010', 'jkmanager@gmail.com');  
insert into users values(users_seq.nextval, 'tName2', 'tId2', 'tPw2', '서울특별시 강남구 비트캠프', '010-0101-1010', 'jkmanager@gmail.com');  

select users_seq.currval from users;
select * from users;


drop sequence users_seq;
--시퀀스생성
create sequence users_seq
start with 1
minvalue 1
increment by 1
;

commit;


Drop Table Menu;
DROP TABLE delivery ;
drop table users;

select * from menu;
select * from delivery;
select * from users;

-- 주문정보
ALTER TABLE "dorder"
	DROP CONSTRAINT "FK_users_TO_dorder"; -- 새 테이블 -> 주문정보

-- 주문정보
ALTER TABLE "dorder"
	DROP CONSTRAINT "PK_dorder"; -- 주문정보 기본키

-- 주문정보
DROP TABLE "dorder";

-- 주문정보
CREATE TABLE "dorder" (
	"doid"    NUMBER(6)    NOT NULL, -- 주문번호
	"doprice" INTEGER      NOT NULL, -- 주문금액
	"dodate"  TIMESTAMP    NOT NULL, -- 주문일자
	"payment" varchar2(30) NOT NULL, -- 결제수단
	"id"      NUMBER(6)    NULL      -- 회원번호
);

-- 주문정보 기본키
CREATE UNIQUE INDEX "PK_dorder"
	ON "dorder" ( -- 주문정보
		"doid" ASC -- 주문번호
	);

-- 주문정보
ALTER TABLE "dorder"
	ADD
		CONSTRAINT "PK_dorder" -- 주문정보 기본키
		PRIMARY KEY (
			"doid" -- 주문번호
		);

-- 주문정보
ALTER TABLE "dorder"
	ADD
		CONSTRAINT "FK_users_TO_dorder" -- 새 테이블 -> 주문정보
		FOREIGN KEY (
			"id" -- 회원번호
		)
		REFERENCES "users" ( -- 새 테이블
			"id" -- 회원번호
		)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION;