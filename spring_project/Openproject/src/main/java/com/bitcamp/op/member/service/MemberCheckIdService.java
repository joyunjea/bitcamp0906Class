package com.bitcamp.op.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.member.dao.MemberDao;

@Service
public class MemberCheckIdService {
	
	private MemberDao dao;		//인터페이스
	
	@Autowired			//주입
	private SqlSessionTemplate template;
	
	public String checkId(String userId) {		//개수반환
		dao = template.getMapper(MemberDao.class);
		return dao.selectCountByUesrId(userId)>0 ? "N" : "Y";
	}
}
