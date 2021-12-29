SELECT * FROM project.guestbook gb join project.member mem on gb.memberidx=mem.idx order by gb.idx;

INSERT INTO guestbook (subject, content, memberidx) VALUES(?,?,?);
select*from project.member;

select * from project.guestbook;
select*from project.guestbook gb join project.member mem on gb.memberidx=mem.idx where mem.idx=3;


select gb.idx, gb.subject, m.username, gb.regdate, gb.content from project.guestbook gb join project.member m on gb.memberidx=m.idx order by gb.regdate desc limit 0,7;

select gb.idx, gb.subject, gb.content, gb.regdate, m.username, m.photo from project.guestbook gb join project.member m on gb.memberidx=m.idx WHERE gb.idx = 5;

select* from project.guestbook gb join project.member m on gb.memberidx=m.idx ;

SELECT * FROM `project`.`guestbook` where idx;
DELETE FROM `project`.`guestbook` where idx=16;

INSERT INTO reply (content, memberidx, guestbookidx) VALUES (?, ?, ?);

update project.guestbook set  subject =? ,content =? where idx =? and memberidx =? ;
update project.guestbook set  subject = '수정된 제목' ,content = '수정된 내용' where idx = 12 and memberidx = 2 ;