package in.sihle.test;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username="root";
		String password="admin";
		String jdbcURL = "jdbc:mysql://localhost:3306/employeedirectory?characterEncoding=utf8";
		String driver ="com.mysql.jdbc.Driver";
		
		try {
			PrintWriter writer =  response.getWriter();
			writer.println("Connecting to database");
			
			Class.forName(driver);
			
			Connection connection = DriverManager.getConnection(jdbcURL,username, password);
			writer.println("Connection successful");
			connection.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Cannot connect Baba!", e);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
