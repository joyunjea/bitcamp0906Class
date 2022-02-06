package kr.bit.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		Enumeration<String> emer = request.getParameterNames();
		if(emer.hasMoreElements()) {
			String key = emer.nextElement();
			String value = request.getParameter(key);
			map.put(key, value);			
		}
		
		
		request.setAttribute(name, o);
		
		try {
			Connection connection = DriverManager.getConnection("","","");
			//Statement stat = connection.createStatement("sleect * Fo wehr aas = aaa AND name = ""diam);
			//stat.execute(sql);
			 
			PreparedStatement pre = connection.prepareStatement("Select * FROM WHERE aas = ? ANd name = ? "
					+ ");"
					+ "
			pre.setDate(0, "aaa");
			--Parameter
					
			ResultSet resultset = pre.executeQuery();
			
			resultset.
			
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		response.getWriter().append("<H1>AAAa</H1>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
