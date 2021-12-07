package first;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//localHost:8080 /hello 경로를 요청하면
// 이 서블릿이 실행됨
// web.xml 에 이 서블릿을 맵핑해놓았기 때문에 가능
// web.xml 에 맵핑하지 않고 이 서블릿을등록하려면 webservlet 어노테이션을 사용하면 됨
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Get 요청 처리!!!");

		resp.getWriter().println("<html>");
		resp.getWriter().println("<head>");
		resp.getWriter().println("<title>Servlet</title>");

		Date now = new Date();

		resp.getWriter().println("</head>");
		resp.getWriter().println("<body>");
		resp.getWriter().println("<h1>Get Request !!!" + now + "</h1>");
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}