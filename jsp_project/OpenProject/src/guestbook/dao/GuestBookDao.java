package guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import guestbook.domain.GuestBook;
import guestbook.domain.PageInfo;
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
	public List<PageInfo> selectList(Connection conn, int index, int COUNT_PER_PAGE) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		List<PageInfo> list=null;
		try {
			
			pstmt=conn.prepareStatement("select gb.idx, gb.subject, m.username, gb.regdate, gb.content from project.guestbook gb join project.member m on gb.memberidx=m.idx order by gb.regdate desc limit ?,?");
			pstmt.setInt(1, index);
			pstmt.setInt(2, COUNT_PER_PAGE);
			
			list=new LinkedList<PageInfo>();
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new PageInfo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
			}
			
		}finally {
		 JdbcUtil.close(rs);
		 JdbcUtil.close(pstmt);
		 
		}
		return list;
	}
	public int selectTotalCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs=null;
		int result=0;
		
		try {
			
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select count(*) as sum from project.guestbook");
			
			if(rs.next()) {
				
				result=rs.getInt("sum");
			}
			

		}finally {
		 JdbcUtil.close(rs);
		 JdbcUtil.close(stmt);
		 
		}
		return result;
	}
	

}
