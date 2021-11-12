package javaking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuDao {

	public static Scanner sc = new Scanner(System.in);

	// 외부에서 인스턴스를 생성하지 못하도록 처리! -> 생성자의 접근제어자를 private
	private MenuDao() {
	}

	// 클래스 내부에서 인스턴스를 생성!!! , 이 이스턴스를 직접 접근 안되도록!
	private static MenuDao dao = new MenuDao();

	// 내부에서 만들어진 인스턴스를 특정 메소드를 이용해서 받을 수 있도록 해주자!!!
	static public MenuDao getInstance() {
		return dao;
	}

	// 메뉴종류를 검색 메소드 : select -> Connection을 전달 받고, 메뉴 번호, menu
	public List<MenuDto> selectByMtype(Connection conn, int mtype) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 검색 결과 : 메뉴정보
		List<MenuDto> menu = new ArrayList<MenuDto>();

		String sql = "select * from menu where mType=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mtype);
			// Sql : Select

			// 결과 -> 1 또는 0행
			rs = pstmt.executeQuery();
			while (rs.next()) {
				menu.add(new MenuDto(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}

		return menu;
	}
//	 신메뉴를 추가하는 메소드 : insert -> Connection을 전달 받고, Dept 객체를 전달 받아서 입력
public int insertMenu(Connection conn, MenuDto menu) {

	PreparedStatement pstmt = null;

	int resultCnt = 0;

	// Sql : insert
	String sql = "insert into menu(mid,mname,mprice,mtype) values (menu_seq.nextVal, ?, ?, ?)";

	try {
		pstmt = conn.prepareStatement(sql);
		// sql 파라미터 설정
		pstmt.setString(1, menu.getMname());
		pstmt.setInt(2, menu.getMprice());
		pstmt.setInt(3, menu.getMtype());

		resultCnt = pstmt.executeUpdate();

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		JdbcUtil.close(pstmt);
	}

	return resultCnt;

}

	// 기존 메뉴를 수정하는 메소드 : update -> Connection을 전달 받고, Dept 객체를 전달 받아서 수정
				public int updateMenu(Connection conn, int mid, int mprice ) {

					PreparedStatement pstmt = null;

					int resultCnt = 0;

					// Sql : update  
					String sql = "update menu set mprice=? where mid=?";

					try {
						pstmt = conn.prepareStatement(sql);
						pstmt.setInt(1, mprice);
						pstmt.setInt(2, mid);
						

						resultCnt = pstmt.executeUpdate();

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						JdbcUtil.close(pstmt);
					}

					return resultCnt;
				}
				
				
				public int deleteMenu(Connection conn, int mid) {

					PreparedStatement pstmt = null;

					int resultCnt = 0;

					// Sql : update  
					String sql = "delete from menu where mid=?";

					try {
						pstmt = conn.prepareStatement(sql);
						pstmt.setInt(1, mid);

						resultCnt = pstmt.executeUpdate();

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						JdbcUtil.close(pstmt);
					}

					return resultCnt;
				}


}
