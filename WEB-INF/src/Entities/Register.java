package Entities;

public class Register 
{
	private int rid;
	private String username;
	private String email;
	private String password;
	private String phone;
	private String gender;
	public Register() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public Register(int rid, String username, String email, String password, String phone, String gender) 
	{
		super();
		this.rid = rid;
		this.username = username;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.gender = gender;
	}
	public int getRid()
	{
		return rid;
	}
	public void setRid(int rid)
	{
		this.rid = rid;
	}
	public String getUsername() 
	{
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public String getPhone() 
	{
		return phone;
	}
	public void setPhone(String phone) 
	{
		this.phone = phone;
	}
	public String getGender() 
	{
		return gender;
	}
	public void setGender(String gender) 
	{
		this.gender = gender;
	}
	
}