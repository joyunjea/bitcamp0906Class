package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberDao {
	public static Scanner sc = new Scanner(System.in);

	private MemberDao() {}
	private static MemberDao dao = new MemberDao();
	static public MemberDao getInstance() {
		return dao;
	}
	//회원 정보 출력
	public static List<MemberDto> memberAllList(Connection conn) {
		Statement stmt = null;
		ResultSet rs = null;
		List<MemberDto> result = new ArrayList<MemberDto>();
		try {
			stmt = conn.createStatement();
			String sql = "select * from Member";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				result.add(new MemberDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7)));
			}
		} catch (SQLException e) {
			System.out.println("예외");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
		return result;
	}
	
	public MemberDto MemberDetail(Connection conn, int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDto result = null;
		String sql = "select * from member where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();	
			if (rs.next()) {
				result = new MemberDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return result;
	}
}
