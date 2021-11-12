package javaking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void memberStart() {

		MemberDao memberDao = MemberDao.getInstance();
		Connection conn = null;
		List<MemberDto> list = null;

		try {
			conn = ConnectionProvider.getConnection();

			// 트렌젝션 일의 단위
			conn.setAutoCommit(false); // 트렌젝션의 컨트롤 하겠다!

			// 회원정보 리스트를 확인
			list = memberDao.memberAllList(conn);

			System.out.println("회원 정보 리스트");
			for (MemberDto member : list) {
				System.out.println("회원번호: " + member.getId() + "\t아이디: " + member.getUserid());
			}

			System.out.println("==================================================");

			System.out.println("상세보기할 회원번호를 입력해주세요.");
			System.out.print("> ");
			int	id = sc.nextInt();

			MemberDto memberDto = memberDao.MemberDetail(conn, id);
			System.out.println(memberDto.getUserid() + "님의 회원정보: \n" + memberDto);

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public static void menuAll() {
		MenuDao menuDao = MenuDao.getInstance();
		Connection conn = null;
		List<MenuDto> list2 = null;

		try {
			conn = ConnectionProvider.getConnection();

			System.out.println("1. 햄버거 2. 사이드 3. 음료");
			System.out.print("> ");
			int sMtype = sc.nextInt();
			// 트렌젝션 일의 단위
			conn.setAutoCommit(false); // 트렌젝션의 컨트롤 하겠다!
			// 상품 메뉴 리스트를 확인
			list2 = menuDao.selectByMtype(conn, sMtype);

			System.out.println("상품 메뉴 리스트");
			for (MenuDto menu : list2) {
				System.out.println(menu.toString());
			}

			System.out.println("==================================================");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void newMenu() {
		MenuDao menuDao = MenuDao.getInstance();
		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();

			System.out.println("신메뉴 번호종류 선택");
			System.out.println("1. 햄버거 2. 사이드 3. 음료");
			System.out.print("> ");
			int sMtype = sc.nextInt();
			sc.nextLine();

			// 트렌젝션 일의 단위
			conn.setAutoCommit(false); // 트렌젝션의 컨트롤 하겠다!

			System.out.println("메뉴명을 입력해주세요.");
			System.out.print("> ");
			String mname = sc.nextLine();

			System.out.println("메뉴가격을 입력해주세요.");
			System.out.println("> ");
			int mprice = sc.nextInt();

			MenuDto menuDto = new MenuDto(0, mname, mprice, sMtype);
			menuDao.insertMenu(conn, menuDto);

			conn.commit(); // 완료
			System.out.println("입력이 완료되었습니다.");
			System.out.println("==================================================");
		} catch (SQLException e) {
			System.out.println("입력 실패");
			e.printStackTrace();

		}
	}

	public static void updateMenu() {
		MenuDao menuDao = MenuDao.getInstance();

		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();

			menuAll();
			System.out.println("수정할 메뉴 번호를 입력하세요.");
			System.out.print("> ");
			int mid = sc.nextInt();

			System.out.println("수정할 금액을 입력하세요.");
			System.out.print("> ");
			int mprice = sc.nextInt();

			menuDao.updateMenu(conn, mid, mprice);

			// 트렌젝션 일의 단위
			conn.setAutoCommit(false); // 트렌젝션의 컨트롤 하겠다!

			conn.commit(); // 완료
			System.out.println("수정이 완료되었습니다.");
			System.out.println("==================================================");
		} catch (SQLException e) {
			System.out.println("수정 실패");
			e.printStackTrace();

		}
	}

	public static void deleteMenu() {
		MenuDao menuDao = MenuDao.getInstance();

		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();

			menuAll();
			System.out.println("삭제할 메뉴 번호를 입력하세요.");
			System.out.print("> ");
			int mid = sc.nextInt();

			menuDao.deleteMenu(conn, mid);

			// 트렌젝션 일의 단위
			conn.setAutoCommit(false); // 트렌젝션의 컨트롤 하겠다!

			conn.commit(); // 완료
			System.out.println("삭제가 완료되었습니다.");
			System.out.println("==================================================");
		} catch (SQLException e) {
			System.out.println("삭제 실패");
			e.printStackTrace();

		}
	}

}
