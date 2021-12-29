package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.dao.ReplyDao;
import guestbook.domain.ReplyRequest;
import jdbc.ConnectionProvider;
import jdbc.util.JdbcUtil;

public class GuestBookReplyWriteService {

	private GuestBookReplyWriteService() {}
	private static GuestBookReplyWriteService service = new GuestBookReplyWriteService();
	public static GuestBookReplyWriteService getInstance() {
		return service;
	}
	
	public int writeRepy(HttpServletRequest request, HttpServletResponse response) {
		
		int resultCnt = 0;
		
		String memberidx = request.getParameter("memberidx");
		String guestbookidx = request.getParameter("guestbookidx");
		String message = request.getParameter("message");
		
		Connection conn =null;
		
		try {
			conn=ConnectionProvider.getConnection();
			ReplyRequest replyRequest = new ReplyRequest(Integer.parseInt(memberidx), Integer.parseInt(guestbookidx), message);
			
			resultCnt=ReplyDao.getInstance().insertReply(conn,replyRequest);
			
			request.setAttribute("result", resultCnt);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn);
		}
		
		
		
	
		
		
		return resultCnt;
		
	}
}