package guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import guestbook.domain.ContentInfo;
import guestbook.domain.GuestBook;
import guestbook.domain.PageInfo;
import guestbook.domain.WriteInfo;
import jdbc.util.JdbcUtil;

public class GuestBookDao {
	// 싱글톤 패턴
	// 여러개의 인스턴스를 만드는 것이 메모리 측면에 보았을때 비효율적일때 사용 
	// 그래서 단 하나의 주소만 가지는 인스턴스(유일)를 만들어서 사용하기 위함

	// 이를 구현하기 위해서는 먼저 이 클래스 내의 변수하나를 자기 자신으로 만들고 이를 JVM 이 실행될때 메모리에 먼저 올려놓기 위해서
	// 이 변수를 static으로 선언하고 새 인스턴스를 하나 만들어놓음 (new GuestBookDao();)
	private static GuestBookDao dao = new GuestBookDao();
	
	// 그리고 외부에서 (다른 클래스에서) 이 클래스의 인스턴스를 생성하지 못하도록 하기 위해서
	// 생성자를 private 으로 선언
	private GuestBookDao() {}
	
	// 그리고 외부에서 이 클래스 내의 dao 변수  만 받아서 쓸수 있게 하기 위해서 getInstance 메소드를 만들어서 이 클래스의 메소드를 사용할 수 있게 함.
	// 외부에서 호출해야 하는 메소드이기 떄문에 public으로 선언하는 것이고
	// 이 getInstance()메소드 또한 이 클래스의 인스턴스를 만들어야 사용할 수 있는데, 인스턴스 만드는것을 막아놓았으므로 (생성자가 private)
	// 이 메소드 또한 JVM 이 실행될 때에 메모리에 올라가 있어야 함.(static으로 선언)
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
	
	// CRUD (Create :등록 Read : 읽기 Update: 수정  Delete : 삭제)
	
	// C, U, D 의 경우 사용자가 DB에 데이터를 추가/변경/삭제 >> DB는 작업 후 결과 (1 또는 0 또는 에러) 를 반환함(int)
	// R 의 경우 우리가 받아서 출력해야 하는 데이터를 DB에 요청 하고 DB는 그 요청 결과(1개 이상의 행) 을 반환
	
	// 행을 받기 위해 ResultSet 이라는 클래스를 사용하여 결과 행을 저장함.
	// 행이 여러개라면 한 행의 정보들을 List 에 추가해서 반환하면 됨
	
	
	public ContentInfo selectByIdx(Connection conn, int idx) throws SQLException {
		
		ContentInfo result = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select gb.idx, gb.subject, gb.content, m.username,gb.regdate, m.idx from project.guestbook gb join project.member m on gb.memberidx=m.idx WHERE gb.idx = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				result = new ContentInfo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		
		return result;
		
	}

	public int insertArticle(Connection conn, WriteInfo writeRequest) throws SQLException {

		int resultCnt = 0;
		PreparedStatement pstmt = null;

		String sql = "INSERT INTO guestbook (subject, content, memberidx) VALUES (?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writeRequest.getSubject());
			pstmt.setString(2, writeRequest.getContent());
			pstmt.setInt(3, writeRequest.getMemberidx());

			resultCnt = pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}

		return resultCnt;
	}

}
