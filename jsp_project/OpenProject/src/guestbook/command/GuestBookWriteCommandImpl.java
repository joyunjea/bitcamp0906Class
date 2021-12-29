package guestbook.command;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import guestbook.domain.WriteInfo;
import guestbook.service.WriteService;
import jdbc.ConnectionProvider;

public class GuestBookWriteCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		// 방명록 글 쓰기
		String method=request.getMethod();
		String URL=null;
		if(method.equals("GET")) {
			// 글쓰는 화면 보여줌
			URL="/WEB-INF/views/guestbook/manager/writeform.jsp";
			
		}else if(method.equals("POST")) {
			// 글을 DB에 등록하고 결과에 따라 분기하는 view 페이지로 URL 설정
			// 1. 데이터 처리
			Connection conn=null;
			
			try {
				conn=ConnectionProvider.getConnection();
				WriteInfo post=new WriteInfo(request.getParameter("subject"), request.getParameter("content"), Integer.parseInt(request.getParameter("memberidx")));
				WriteService.getInstance().insert(conn, post);
				
				
				request.setAttribute("msg", "등록완료!");
				
			} catch (SQLException e) {
				// 에러 메세지를 request 객체에 담음
				request.setAttribute("msg", "에러발생!");
				e.printStackTrace();
			}
			
			// 2. 경로 설정
			URL="/WEB-INF/views/guestbook/manager/write.jsp";
			
		}
		return URL;
	}

}