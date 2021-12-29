package guestbook.command;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import guestbook.service.GuestBookContentService;
import jdbc.ConnectionProvider;

public class GuestBookContentImpl implements Command{

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		Connection conn=null;
		String idx = request.getParameter("guestbookidx");
		
		try {
			
			
			conn=ConnectionProvider.getConnection();
			request.setAttribute("contentInfo", GuestBookContentService.getInstance().getContentInfo(conn, Integer.parseInt(idx)));
			
		} catch (NumberFormatException e) {
			request.setAttribute("msg", "잘못된 요청입니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			request.setAttribute("msg","일시적 오류입니다, 다시 시도해주세요");
			e.printStackTrace();
		}
		
		return "/WEB-INF/views/guestbook/manager/content.jsp";
	}
	
	
	

}
