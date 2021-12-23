package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.dao.GuestBookDao;
import guestbook.domain.GuestBook;
import guestbook.domain.GuestBookListView;
import guestbook.domain.PageInfo;
import jdbc.ConnectionProvider;
import jdbc.util.JdbcUtil;


public class GuestBookListService {
	private GuestBookListService() {
	}

	private static GuestBookListService service = new GuestBookListService();

	public static GuestBookListService getInstance() {
		return service;
	}

	public GuestBookListView getPage(int pageNumber) {

		GuestBookListView listView = null;
		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();

			// 현재 페이지 번호
			int currentPage = pageNumber;

			// 페이지 당 표현할 개수
			final int COUNT_PER_PAGE = 5;

			// 항목 가져오기 : limit index
			int index = (currentPage - 1) * COUNT_PER_PAGE;
			//sql문 limit a, b  ->  a => (n-1)5 b => 5개  ->  3페이지기준: (3-1)5 , 5 -> 인덱스가 10부터 시작해서 3페이지는 5개  10,11,12,13,14

			// List<Member> 구하기
			List<PageInfo> list = GuestBookDao.getInstance().selectList(conn, index, COUNT_PER_PAGE);

			// 전체 게시글의 수 구하기 = totalCount
			int totalCount = GuestBookDao.getInstance().selectTotalCount(conn);

			listView = new GuestBookListView(0, totalCount, COUNT_PER_PAGE, currentPage, list);

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn);
		}

		return listView;
	}

	
}