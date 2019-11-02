

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import DatabaseConnection.DbConnection;

public class StudentView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter writer=response.getWriter();
		writer.println("<a href= studentForm.html>Student Form</a><br><br><br>");
		try {
			Connection con=DbConnection.initDb();
			Statement st=null;
			ResultSet rs=null;
			
			st=con.createStatement();
			String str="select *from student";
			rs=st.executeQuery(str);
			
			
			
			while(rs.next()) {
				writer.print(rs.getInt(1)+"\t");
				writer.print(rs.getString(2)+"\t");
				writer.print(rs.getString(3)+"\t");
				writer.print(rs.getString(4)+"\t");
				writer.print(rs.getString(5)+"<br><br>");
			}
			
					
		} catch (ClassNotFoundException  e) {
			
			e.printStackTrace();
		}catch( SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
