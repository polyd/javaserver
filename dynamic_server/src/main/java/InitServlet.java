

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*; 


/**
 * Servlet implementation class InitServlet
 */
@WebServlet("/InitServlet")
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public InitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String q=request.getParameter("q").toString();
		String x="";
		if(q.equals("1"))
		{
		x="{\"name\":\"john\", \"phone\":\"232134\", \"address\":\"ermou 51\" }";
		}
		
		if(q.equals("2"))
		{
		x="{\"name\":\"pol\", \"phone\":\"333444\", \"address\":\"ermou 52\" }";
		}
		
		if(q.equals("3"))
		{
			try{
				System.out.println("test");
				Class.forName("com.mysql.cj.jdbc.Driver");  
				
				Connection con=DriverManager.getConnection( 
				"jdbc:mysql://localhost:3306/mydb21","root","");  
				//here sonoo is database name, root is username and password  
				
				
				Statement stmt=con.createStatement();  
				ResultSet rs=stmt.executeQuery("select * from users");  
				String comma="";
				x="[";
				while(rs.next())
				{
					
					x=x+comma+"{\"username\":\""+rs.getString(2)+"\",\"email\":\""+rs.getString(4)+"\" }";
					comma=",";
				}
				x=x+"]";
				
				con.close();  
				}
			catch(Exception e)
			{ 
				System.out.println(e);
			}  
				
		}
		
		response.getWriter().append(x);
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
