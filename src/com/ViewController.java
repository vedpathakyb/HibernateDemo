package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
/**
 * Servlet implementation class ViewController
 */
@WebServlet("/ViewController")
public class ViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		Connection conn=null;
		Statement stmt; 
		ArrayList all=new ArrayList();
		
		SessionFactory factory=new Configuration().configure().addAnnotatedClass(AV.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		try
		{
		/*Class.forName("org.postgresql.Driver");
		conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/family","postgres"," ");
		stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT *FROM AV");
		while(rs.next())
		{
		int id=rs.getInt(1);
		String name=rs.getString(2);
		int age=rs.getInt(3);
		System.out.println(id+" "+name+" "+age);
		AV a=new AV(id,name,age);
		all.add(a);
		/*out.print(id);
		out.print(name);
		out.print(age);
		}*/
			
			
		
		session.beginTransaction();
		Query query = session.createQuery("from AV");
		all=(ArrayList) query.list();
	
		/*rs.close();
		stmt.close();
		conn.close();*/
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		session.close();
		factory.close();
		out.println("Hi");
		request.setAttribute("All Members",all);
		RequestDispatcher rd=request.getRequestDispatcher("display.jsp");
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
