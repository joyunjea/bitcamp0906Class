package com.bitcamp.op;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bitcamp.op.member.dao.MemberDao;
import com.bitcamp.op.member.domain.EditRequest;
import com.bitcamp.op.member.domain.Member;
import com.bitcamp.op.member.domain.MemberRegRequest;
import com.bitcamp.op.member.domain.SearchParams;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DaoTest {

	private MemberDao dao;

	@Autowired
	SqlSessionTemplate template;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

//	@Test
//	public void 회원의전체수구하는데스트1() {
//
//		dao = template.getMapper(MemberDao.class);
//
//		// 전체 회원의 수를 반환하는 메소드 테스트는 결과가 MySql Workbench에서 select 한 결과 6와 같아야 한다.
//		int cnt = dao.selectTotalCount(new HashMap<String, String>());
//		assertEquals("전체 회원수 확인 : 27 기대", 27, cnt);
//
//	}
//
//	@Test
//	public void 회원의전체수구하는데스트2() {
//
//		dao = template.getMapper(MemberDao.class);
//
//		// case : 검색 타입과 검색어를 전달해주면 결과가 2 가 반환되어야 한다
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("searchType", "uid");
//		map.put("keyword", "cool");
//		int cnt = dao.selectTotalCount(map);
//		assertEquals("아이디가 cool 문자열을 포함하는 회원의 수 ", 2, cnt);
//
//		// fail("Not yet implemented");
//	}
//	
//	@Test
//	public void selectByIdTest() {
//		dao = template.getMapper(MemberDao.class);
//		// case : gmail을 사용하고 있는 회원수5가 반환되어야 한다
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("searchType", "uid");
//		map.put("keyword", "gmail");
//		int cnt = dao.selectTotalCount(map);
//		assertEquals("gamil을 사용하는 회원의 수", 5, cnt);
//		
//	}
	
	
	
	
	
	
//	@Test
//	public void insertMemberTest() {
//		dao = template.getMapper(MemberDao.class);
//		
//		MemberRegRequest regRequest = new MemberRegRequest();
//		regRequest.setUserid("123456@naver.com");
//		regRequest.setPw("123456");
//		regRequest.setUsername("테스트123456");
//		regRequest.setFileName("sbs.png");
//				
//		// 회원 가입 메소드 실행 후 1을 반환해야 한다.
//		int cnt = dao.insertMember(regRequest);
//		assertEquals("회원가입 메소드 실행 : 기대값 1", 1, cnt);
//		
//		// idx값의 유무확인
//		assertNotNull("idx값의 존재유무", regRequest.getIdx());
//	}
	
	
//	@Test
//	public void selectListTest() {
//		dao = template.getMapper(MemberDao.class);
//		SearchParams params = new SearchParams();
//		
//		// 가장 최근에 만든 회원의  userid가 1페이지 가장 윗줄에 확인되어야 한다.
//		params.setCount(3);
//		params.setIndex(0);
//		
//		List<Member> list = dao.selectList(params);
//		
//		assertEquals("1페이지 가장 윗줄의 userid : 123456@naver.com", "123456@naver.com", list.get(0).getUserid());
//	}
	
	
//	@Test
//	public void editMemberTest() {
//		dao = template.getMapper(MemberDao.class);
//		
//		EditRequest editRequest = new EditRequest();
//		editRequest.setIdx(10);
//		editRequest.setUserid("test2");
//		editRequest.setPw("12345");
//		editRequest.setUsername("cook12345");
//		
//		int cnt = dao.editMember(editRequest);
//		
//		assertEquals("회원수정 메소드 실행 :1", 1, cnt);
//		
//		Member member = dao.selectByIdx(10);
//		//idx가 10인  test2의 username을 cook12345, 비밀번호를 12345로 변경한다.
//		assertEquals("수정된 이름 확인", "cook12345", member.getUsername());
//		assertEquals("수정된 비밀번호 확인", "12345", member.getPassword());
//	}
	
	@Test
	public void deleteByIdxTest() {
		dao = template.getMapper(MemberDao.class);
		
		int cnt = dao.deleteByIdx(11);
		
		assertEquals("회원 삭제 메소드 실행: 1", 1, cnt);
		
		//idx 11번째인 회원을 삭제하고 null 인 것을 확인한다.
		Member member = dao.selectByIdx(11);
		
		assertNull("member is null", member);
	}

}