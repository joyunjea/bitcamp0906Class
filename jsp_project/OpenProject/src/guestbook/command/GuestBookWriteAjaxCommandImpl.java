package guestbook.command;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import guestbook.domain.WriteInfo;
import guestbook.service.WriteService;
import jdbc.ConnectionProvider;

public class GuestBookWriteAjaxCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		if(request.getMethod().equals("POST")) {
			Connection conn=null;
			int result=0;
			try {
				conn=ConnectionProvider.getConnection();
				WriteInfo post=new WriteInfo(request.getParameter("subject"), request.getParameter("content"), Integer.parseInt(request.getParameter("memberidx")));
				result=WriteService.getInstance().insert(conn, post);
				
				
				request.setAttribute("result", result);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
		}
		
		return "/WEB-INF/views/guestbook/manager/writeAjax.jsp";
	}

}