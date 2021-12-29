package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import guestbook.dao.GuestBookDao;
import guestbook.domain.ContentInfo;
import jdbc.ConnectionProvider;
import jdbc.util.JdbcUtil;

public class GuestBookContentService {
	
	private GuestBookContentService() {
	}

	private static GuestBookContentService service = new GuestBookContentService();

	public static GuestBookContentService getInstance() {
		return service;
	}

	public ContentInfo getContentInfo(Connection conn, int idx) throws SQLException {
		
		ContentInfo contentInfo = null;
	 
		
		try {
			
			contentInfo = GuestBookDao.getInstance().selectByIdx(conn, idx);
		}finally{
			JdbcUtil.close(conn);
		}
		
		
		return contentInfo;
	}


	
}
