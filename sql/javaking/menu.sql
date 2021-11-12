-- 메뉴
alter table menu
	drop constraint pk_menu; -- 메뉴 기본키

-- 메뉴
drop table menu;

-- 메뉴
create table menu (
	menuid  number(6)CONSTRAINT menu_pk PRIMARY KEY not null, -- 메뉴번호
	menuname     varchar2(40) not null, -- 메뉴명
	price    integer      not null, -- 가격
	menuType number(2,0) not null -- 종류
);

desc menu;

insert into menu values(1,'불고기버거',3500,10);
insert into menu values(2,'상하이버거',4500,10);
insert into menu values(3,'감자튀김',2000,20);
insert into menu values(4,'치즈볼',3000,20);
insert into menu values(5,'콜라',1000,30);
insert into menu values(6,'사이다',1000,30);
insert into menu values(7,'환타',1000,30);
insert into menu values(8,'아이스크림',1000,40);
insert into menu values(9,'쉐이크',2000,40);


select menuname,price from menu where menutype=10;
select menuname,price from menu where menutype=20;
select menuname,price from menu where menutype=30;
select menuname,price from menu where menutype=40;

select * from menu;
-- 메뉴 기본키
create unique index "pk_menu"
	on "menu" ( -- 메뉴
		"menuid" asc -- 메뉴번호
	);

-- 메뉴
alter table "menu"
	add
		constraint "pk_menu" -- 메뉴 기본키
		primary key (
			"menuid" -- 메뉴번호
		);
        
select * from dept;



