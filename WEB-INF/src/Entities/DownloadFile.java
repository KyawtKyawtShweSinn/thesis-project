package Entities;

public class DownloadFile 
{
	private int did;
	private int rid;
	private int fid;
	private String keyactive;
	
	
	public DownloadFile() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public DownloadFile(int did, int rid, int fid, String keyactive, String email) {
		super();
		this.did = did;
		this.rid = rid;
		this.fid = fid;
		this.keyactive = keyactive;
	
	}


	public int getDid() 
	{
		return did;
	}
	public void setDid(int did) 
	{
		this.did = did;
	}
	public int getRid() 
	{
		return rid;
	}
	public void setRid(int rid) 
	{
		this.rid = rid;
	}
	public int getFid() 
	{
		return fid;
	}
	public void setFid(int fid) 
	{
		this.fid = fid;
	}
	public String getKeyactive() 
	{
		return keyactive;
	}
	public void setKeyactive(String keyactive) 
	{
		this.keyactive = keyactive;
	}
	
}
