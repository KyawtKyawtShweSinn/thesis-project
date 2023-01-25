package myapp;

import Entities.Register;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionSupport;

import db.DAO;

public class RegisterAction extends ActionSupport
{
	DAO dao=new DAO();
	private Register reg;
	
	public Register getReg() 
		{
			return reg;
		}
	public void setReg(Register reg) 
		{
			this.reg = reg;
		}
	public String register()
		{
			boolean flag=dao.Register(reg);
			if(flag)
				{
					return "success";
				}
			else
				return "error";
		}
}
