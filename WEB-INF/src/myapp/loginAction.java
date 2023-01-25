package myapp;
import java.sql.*;

import Entities.Register;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.*;

import org.apache.struts2.ServletActionContext;

import db.DAO;


import com.opensymphony.xwork2.ActionSupport;

public class loginAction extends ActionSupport 
{
	
	private String password;
	private String email;
	DAO dao=new DAO();
	Connection con=dao.getConnection();
	Statement stmt = null;
	ResultSet rs = null;
	HttpSession session;
	Register reg=new Register();
	
	public loginAction() 
		{
			super();
		}
	

	public String getPassword() 
		{
			return password;
		}
	public void setPassword(String password) 
		{
			this.password = password;
		}
	
	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}
		
		public String login() 
		{ 	
		HttpServletRequest request=ServletActionContext.getRequest();
		session=request.getSession();
			Boolean flag=false;
			String sql="select * from Register where email='"+email+"' and password='"+password+"'";
			System.out.print(sql);
			try
				{
					stmt = con.createStatement();
					rs = stmt.executeQuery(sql);
					while(rs.next())
						{
						reg.setRid(rs.getInt(1));
						reg.setUsername(rs.getString(2));
						reg.setPassword(rs.getString(3));
						reg.setEmail(rs.getString(4));
						reg.setGender(rs.getString(5));
						reg.setPhone(rs.getString(6));
							flag=true; 
						}
				}
			catch (SQLException e)
				{
					e.printStackTrace();
				}
			System.out.println(flag);
			 if(flag)
				 {
					session.setAttribute("reg", reg);
					 return "success";
				 }
			 else
				 {
					 System.out.println("Error");
					 return "error";
				 }	
		}
}
