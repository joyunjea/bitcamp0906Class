package guestbook.command;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import guestbook.service.GuestBookListService;
import jdbc.ConnectionProvider;

public class GuestBookListCommandImpl implements Command {
	// request 객체에 출력에 필요한 정보들을 담아서 Viewer 로 보냄
	// 출력할 Viewer의 경로는 getPage 메소드가 반환하는 하는 문자열

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		
		String url=null;
		
		String pageNum = request.getParameter("pageNum");
		
		int pageNumber=1;
		
	
		if(pageNum != null && pageNum.length()>0) {
			try{
				pageNumber = Integer.parseInt(pageNum);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		// 사용자가 리스트를 보려고 방명록 보기 버튼을 눌렀을 때
		// >> pageNumber 에는 1이 할당됨
		// 리스트 페이지 내에서 2번 혹은 n번 페이지를 보려고 페이지 번호를 눌렀을 때
		// >> pageNumber 에는 그 페이지 번호가 할당됨
		
		// 리스트 기져와야함
		// 출력에 필요한 정보들은?
		// 전체 페이지 수
		// 전체 게시글 수
		// 현재 페이지 번호
		// 한 화면에 출력할 게시글을 담은 List >> List<GuestBook>
		
		// GuestBookListView 객체를 가져오는 일은 service 패키지 내의 GuestBookListService 클래스가 담당함.
		
		
		// GuestBookListView 객체를 가져오는 코드
		
		
		
		
		
		request.setAttribute("listView", GuestBookListService.getInstance().getPage(pageNumber));
		
		return "/WEB-INF/views/guestbook/manager/list.jsp";
	}
	

}
