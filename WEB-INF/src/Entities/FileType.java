package Entities;

import java.io.File;

public class FileType 
{
	private int fid;
	private int rid;
	private File photo;
	private String photoFileName;
	private String photoContentType;
	private String ciphertext;
	private String keytext;
	private String email;
	private String remail;
	private String uploaddate;
	
	public FileType()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public FileType(int fid, int rid, File photo, String photoFileName, String photoContentType, String ciphertext,
			String keytext, String email, String remail, String uploaddate) 
	{
		super();
		this.fid = fid;
		this.rid = rid;
		this.photo = photo;
		this.photoFileName = photoFileName;
		this.photoContentType = photoContentType;
		this.ciphertext = ciphertext;
		this.keytext = keytext;
		this.email = email;
		this.remail = remail;
		this.uploaddate = uploaddate;
	}





	public String getUploaddate() 
	{
		return uploaddate;
	}





	public void setUploaddate(String uploaddate) 
	{
		this.uploaddate = uploaddate;
	}





	public String getRemail() 
	{
		return remail;
	}





	public void setRemail(String remail) 
	{
		this.remail = remail;
	}





	public int getRid() 
	{
		return rid;
	}


	public void setRid(int rid) 
	{
		this.rid = rid;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) 
	{
		this.email = email;
	}


	public int getFid() 
	{
		return fid;
	}
	public void setFid(int fid) 
	{
		this.fid = fid;
	}
	public int getSid() 
	{
		return rid;
	}
	public void setSid(int sid) 
	{
		this.rid = sid;
	}
	public File getPhoto() 
	{
		return photo;
	}
	public void setPhoto(File photo) 
	{
		this.photo = photo;
	}
	
	public String getPhotoFileName() 
	{
		return photoFileName;
	}
	public void setPhotoFileName(String photoFileName) 
	{
		this.photoFileName = photoFileName;
	}
	public String getPhotoContentType() 
	{
		return photoContentType;
	}
	public void setPhotoContentType(String photoContentType) 
	{
		this.photoContentType = photoContentType;
	}
	public String getCiphertext() 
	{
		return ciphertext;
	}
	public void setCiphertext(String ciphertext) 
	{
		this.ciphertext = ciphertext;
	}
	public String getKeytext() 
	{
		return keytext;
	}
	public void setKeytext(String keytext) 
	{
		this.keytext = keytext;
	}
	
	
}
