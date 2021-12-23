-- select
select * from project.member;
select * from member where userid=? and password=?
;
select * from project.member where userid='test@gmail.com' and password='12341';

-- limit index, count
select * from project.member limit 0, 2; -- 1p
select * from project.member limit 2, 2; -- 2p

select * from member order by regdate desc limit ?, ?;

-- index : (page-1)*count


select count(*) from project.member;

select count(*) from member;


-- insert
INSERT INTO member ( userid, password, username ) VALUES (?,?,?)
;