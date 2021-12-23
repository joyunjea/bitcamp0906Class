package guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import guestbook.domain.WriteInfo;
import jdbc.util.JdbcUtil;

public class GuestBookDao {
	
	private static GuestBookDao dao = new GuestBookDao();
	private GuestBookDao() {}
	public static GuestBookDao getInstance() {
		return dao;
	}
	
	
	
	// 게시글 추가
	public int insert(Connection conn, WriteInfo post) throws SQLException {
		int result=0;
		PreparedStatement pstmt =null;
		
		try {
		pstmt = conn.prepareStatement("insert into project.guestbook(subject,content,memberidx) values(?,?,?)");
		pstmt.setString(1, post.getSubject());
		pstmt.setString(2, post.getContent());
		pstmt.setInt(3, post.getMemberidx());
		
		result=pstmt.executeUpdate();
		
		
		}finally {
			JdbcUtil.close(pstmt);
		}
		
		return result;
		
		
	}
	

}
