package Entities;

public class SendFile 
{
private int sid;
private int rid;
private String sendactive;
	public SendFile() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public SendFile(int sid, int rid, String sendactive) 
	{
		super();
		this.sid = sid;
		this.rid = rid;
		this.sendactive = sendactive;
	}
	public int getSid() 
	{
		return sid;
	}
	public void setSid(int sid) 
	{
		this.sid = sid;
	}
	public int getRid() 
	{
		return rid;
	}
	public void setRid(int rid) 
	{
		this.rid = rid;
	}
	public String getSendactive() 
	{
		return sendactive;
	}
	public void setSendactive(String sendactive) 
	{
		this.sendactive = sendactive;
	}
}
