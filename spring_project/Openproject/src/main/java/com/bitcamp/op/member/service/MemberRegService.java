package com.bitcamp.op.member.service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.dao.MemberDao;
import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.member.domain.MemberRegRequest;

@Service
public class MemberRegService {
	
	@Autowired
	private MemberDao dao;
	
	public int insertMember(MemberRegRequest regRequest, HttpServletRequest request) throws IllegalStateException, IOException, SQLException {
		
		int resultCnt = 0;
		
		//기본이미지 설정
		regRequest.setFileName("sbs.png");
		
		//DB 관련 예외 발생 시 삭제 처리를 위한 File객체
		File newFile = null;
		
		//파일이 있다면 -> 파일 저장
		if(!regRequest.getPhoto().isEmpty() && regRequest.getPhoto().getSize()>0) {
			//시스템의 경로
			String savePath = request.getSession().getServletContext().getRealPath(CommonsData.SAVE_URI);
			
			String[] files = regRequest.getPhoto().getOriginalFilename().split("\\.");
			String exet = files[files.length-1];
			
			String newFileName = System.nanoTime()+"."+exet;
			
			newFile = new File(savePath, newFileName);
			
			regRequest.getPhoto().transferTo(newFile);
			
			regRequest.setFileName(newFileName);
		}
		
		//DAO를 이용해서 데이터 베이스 처리
		Connection conn = null;
		
		try {
			
			conn = ConnectionProvider.getConnection();
			resultCnt = dao.insertMember(conn, regRequest);
		} catch (SQLException e) {
			if(newFile != null && newFile.exists()) {
				newFile.delete();
			}
			e.printStackTrace();
			throw e;
		}
		
		return resultCnt;
	}
}
