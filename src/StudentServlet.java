

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DatabaseConnection.*;

public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			
		try {
			PrintWriter writer=response.getWriter();		
			Connection con;
			
				con = DbConnection.initDb();

			PreparedStatement pstmt=con.prepareStatement("insert into student values(?,?,?,?,?)");
			
			
			writer.println("<a href= studentForm.html>Student Form</a>");
			int stud_roll=Integer.parseInt(request.getParameter("stud_roll"));
			String name=request.getParameter("stud_name");
			String branch=request.getParameter("stud_branch");
			String city=request.getParameter("stud_city");
			int age=Integer.parseInt(request.getParameter("stud_age"));
			
			pstmt.setInt(1,stud_roll);
			pstmt.setString(2,name);
			pstmt.setString(3,branch);
			pstmt.setString(4,city);
			pstmt.setInt(5,age);
			
			pstmt.executeUpdate();
			pstmt.close(); 
			con.close();
			
			
			writer.println("SUCCESSFULLY INSERTED!!");
			
			writer.println("<form method=post , action=StudentView><br>");
			writer.println("<button>View Records</button>");
			writer.println("</form>");
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
