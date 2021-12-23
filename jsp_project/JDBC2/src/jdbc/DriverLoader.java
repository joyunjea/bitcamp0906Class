package jdbc;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;



public class DriverLoader extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		
		//드라이버를 가져오기 위해 생성, getIninparameter의 드라이버 이름을 적어줌
		String driver = config.getInitParameter("driver");
		
		//DB드라이버 로드
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
