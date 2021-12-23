package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import guestbook.dao.GuestBookDao;
import guestbook.domain.WriteInfo;

public class WriteService {
	
	private static WriteService dao = new WriteService();
	private WriteService() {}
	public static WriteService getInstance() {
		return dao;
	}
	
	
	public int insert(Connection conn, WriteInfo post) throws SQLException {
		
		int result=0;
		
		result=GuestBookDao.getInstance().insert(conn, post);
		
		return result;
		
	}

}
