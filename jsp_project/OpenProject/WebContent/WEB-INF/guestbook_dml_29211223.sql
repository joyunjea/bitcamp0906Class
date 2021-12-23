SELECT * FROM project.guestbook;

INSERT INTO guestbook (subject, content, memberidx) VALUES (?,?,?);
select*from project.member;

select count(*) as sum from project.guestbook;

select gb.regdate gb.idx from project.Guestbook gb join project.member m;
