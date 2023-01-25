package myapp;

import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionSupport;

import db.DAO;
import Entities.Register;

public class RegisterForm extends ActionSupport
{
private Register reg;
	
	private HttpServletRequest servletRequest;
	private int i = 0;
	private Statement stmt = null;
	private DAO dao;
	
	public Register getReg()
		{
			return reg;
		}
	public void setReg(Register reg)
		{
			this.reg=reg;   
		}
	public String execute()
		{
			return "success";
		}
}
