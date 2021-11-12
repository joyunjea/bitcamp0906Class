package javaking;

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

	// 외부에서 인스턴스를 생성하지 못하도록 처리! -> 생성자의 접근제어자를 private
	private MemberDao() {
	}

	// 클래스 내부에서 인스턴스를 생성!!! , 이 이스턴스를 직접 접근 안되도록!
	private static MemberDao dao = new MemberDao();

	// 내부에서 만들어진 인스턴스를 특정 메소드를 이용해서 받을 수 있도록 해주자!!!
	static public MemberDao getInstance() {
		return dao;
	}

	


	// 전체 리스트 구하는 메소드 : select -> Connection을 전달 받고, List<Dept>
	static public List<MemberDto> memberAllList(Connection conn) {

		Statement stmt = null;
		ResultSet rs = null;
		List<MemberDto> result = new ArrayList<MemberDto>();

		try {
			// 결과 생성
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

		// 검색 결과 : 메뉴정보
		MemberDto result = null;

		String sql = "select * from member where id=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			// Sql : Select

			// 결과 -> 1 또는 0행
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
