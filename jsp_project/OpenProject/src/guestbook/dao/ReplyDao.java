package guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import guestbook.domain.ReplyRequest;
import jdbc.util.JdbcUtil;

public class ReplyDao {
	
	private ReplyDao() {}
	private static ReplyDao dao = new ReplyDao();
	public static ReplyDao getInstance() {
		return dao;
	}
	
	public int insertReply(Connection conn, ReplyRequest request) throws SQLException {
		
		int resultCnt = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO reply (content, memberidx, guestbookidx) VALUES (?, ?, ?)";
		
		try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, request.getMessage());
		pstmt.setInt(2, request.getMemberidx());
		pstmt.setInt(3, request.getGuestbookidx());
		
		resultCnt = pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return resultCnt;
	}

}
