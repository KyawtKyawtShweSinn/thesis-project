package db;

import java.io.File;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import Entities.DownloadFile;
import Entities.FileType;
import Entities.Register;

public class DAO 
{
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	private List<Register> rlist=new ArrayList<Register>();
	
	Date date;
	
	public Connection getConnection()
		{
			try 
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
				} 
			catch (ClassNotFoundException e)
				{
					System.out.println("Driver not found");
					e.printStackTrace();
				}
			try 
				{
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","aaaa");
				} 
			catch (SQLException e)
				{
					System.out.println("not connection");
					e.printStackTrace();
				}
			System.out.println("Got connection");
			return con;
		}
	public boolean Register(Register reg)
		{
			if(con==null)
			getConnection();
			try 
				{
					stmt=con.createStatement();
					String sql="insert into Register values((select max(rid) from Register)+1,'"+reg.getUsername()+"','"+reg.getPassword()+"','"+reg.getEmail()+"','"+reg.getGender()+"','"+reg.getPhone()+"')";
					System.out.println(sql);
					
					int i=stmt.executeUpdate(sql);
					if(i>0)
						{
							return true;
						}
					
				}
			catch (SQLException e) 
				{
					e.printStackTrace();
				}
			finally
				{
					if(con!=null)
						{
							try 
								{
									stmt.close();
									con.close();
									con=null;
									stmt=null;
								}
							catch (SQLException e) 
								{
									e.printStackTrace();
								}
						}
				}
			
		return false;
		}
	
	public int uploadfile(FileType sendfile,int rid)
	{
			int id = 0;
			if(con==null)
				getConnection();
			try 
			{
				stmt=con.createStatement();
				String sql="insert into SendFile values((select max(sid) from SendFile)+1,"+rid+",'false')";
				System.out.println(sql);
				
				String sql2="select max(sid) from SendFile";
				int i=stmt.executeUpdate(sql);
				if(i>1)
				{
					rs=stmt.executeQuery(sql2);
					while(rs.next())
					{
						id=rs.getInt(1);
					}
					
				}
			}
			catch (SQLException e)
				{
					e.printStackTrace();
				}
			finally
			{
				if(con!=null)
					{
						try 
							{
								stmt.close();
								con.close();
								con=null;
								stmt=null;
							}
						catch (SQLException e) 
							{
								e.printStackTrace();
							}
					}
			}
		return id;
	}
	public boolean insertupload(int id,String email,FileType filetype,File encyptedFile)
	{
		try
		{
			String filePath=System.getProperty("catalina.base")+"\\webapps\\files";
			System.out.println(filePath);
			System.out.println(filetype.getPhotoFileName());
			
			File fileToCreate=new File(filePath,filetype.getPhotoFileName());
			File fileToCreate1=new File(filePath,encyptedFile.getName());
			FileUtils.copyFile(filetype.getPhoto(), fileToCreate);
			FileUtils.copyFile(encyptedFile, fileToCreate1);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(con==null)
			getConnection();
		try 
		{
			date=new Date();
			DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
			String stdate=df.format(date);
			
			stmt=con.createStatement();
			String sql="insert into FileType values((select max(fid) from FileType)+1,"+id+",'"+filetype.getPhotoFileName()+"','"+encyptedFile.getName()+"','"+filetype.getKeytext()+"','"+email+"',' ','"+stdate+"')";
			
			System.out.println("reach"+sql);
			
			int i=stmt.executeUpdate(sql);
			if(i>0)
				{
					return true;
				}
			
		} 
		catch (SQLException e) 
			{
				e.printStackTrace();
			}
		finally
			{
				if(con!=null)
				{
					try 
						{
							
							stmt.close();
							con.close();
							con=null;
							stmt=null;
						}
					catch (SQLException e) 
						{
							e.printStackTrace();
						}
				}
			}
		return false;
	}
	
	public List<FileType> shareRetrieve(int rid)
	{
		List<FileType> flist=new ArrayList<FileType>();
		if(con==null)
			getConnection();
		try 
		{
			stmt=con.createStatement();
			String sql="select * from FileType where rid="+rid;
			rs=stmt.executeQuery(sql);
			System.out.println(sql);
			
			while(rs.next())
			{
				FileType f=new FileType();
				f.setFid(rs.getInt(1));
				f.setSid(rs.getInt(2));
				f.setPhotoFileName(rs.getString(3));
				f.setCiphertext(rs.getString(4));
				f.setKeytext(rs.getString(5));
				f.setEmail(rs.getString(6));
				f.setRemail(rs.getString(7));
				f.setUploaddate(rs.getString(8));
				flist.add(f);
			}
		} 
		catch (SQLException e) 
			{
				e.printStackTrace();
			}
		finally
			{
				if(con!=null)
				{
					try 
						{
							
							stmt.close();
							con.close();
							con=null;
							stmt=null;
						}
					catch (SQLException e) 
						{
							e.printStackTrace();
						}
				}
			}
		return flist;
		
	}

	public List<Register> shareFileSuccessRetrieve(int rid)
	{
		List<Register> rlist=new ArrayList<Register>();
		if(con==null)
			getConnection();
		try 
		{
			stmt=con.createStatement();
			String sql="select * from Register where rid!="+rid;
			rs=stmt.executeQuery(sql);
			System.out.println(sql);
			
			while(rs.next())
			{
				Register r=new Register();
				r.setRid(rs.getInt(1));
				r.setUsername(rs.getString(2));
				r.setPassword(rs.getString(3));
				r.setEmail(rs.getString(4));
				r.setGender(rs.getString(5));
				r.setPhone(rs.getString(6));
				rlist.add(r);
			}
		} 
		catch (SQLException e) 
			{
				e.printStackTrace();
			}
		finally
			{
				if(con!=null)
				{
					try 
						{
							
							stmt.close();
							con.close();
							con=null;
							stmt=null;
						}
					catch (SQLException e) 
						{
							e.printStackTrace();
						}
				}
			}
		return rlist;
		
	}
	public List<FileType> viewFileRetrieve(int rid)
	{
		List<DownloadFile> dlist=new ArrayList<DownloadFile>();
		List<FileType> flist=new ArrayList<FileType>();
		
		
		if(con==null)
			getConnection();
		try 
		{
			stmt=con.createStatement();
			String sql="select * from DownloadFile where rid="+rid;
			rs=stmt.executeQuery(sql);
			System.out.println(sql);
			while(rs.next())
			{
				DownloadFile d=new DownloadFile();
				d.setDid(rs.getInt(1));
				d.setRid(rs.getInt(2));
				d.setFid(rs.getInt(3));
				d.setKeyactive(rs.getString(4));
				
						
				dlist.add(d);
			}
			System.out.println("dlist size"+dlist.size());
			for(int i=0;i<dlist.size();i++)
			{
				String sql2="select * from FileType where fid="+dlist.get(i).getFid();
				rs=stmt.executeQuery(sql2);
				while(rs.next())
				{
					FileType f=new FileType();
					f.setFid(rs.getInt(1));
					f.setSid(rs.getInt(2));
					f.setPhotoFileName(rs.getString(3));
					f.setCiphertext(rs.getString(4));
					f.setKeytext(rs.getString(5));
					f.setEmail(rs.getString(6));
					f.setRemail(rs.getString(7));
					f.setUploaddate(rs.getString(8));
					flist.add(f);
				}
			}
			
		} 
		catch (SQLException e) 
			{
				e.printStackTrace();
			}
		finally
			{
				if(con!=null)
				{
					try 
						{
							
							stmt.close();
							con.close();
							con=null;
							stmt=null;
						}
					catch (SQLException e) 
						{
							e.printStackTrace();
						}
				}
			}
		return flist;
		
	}
	
	public List<FileType> viewRequestRetrieve(int rid)
	{
		List<DownloadFile> dlist=new ArrayList<DownloadFile>();
		List<FileType> flist=new ArrayList<FileType>();
		
		
		if(con==null)
			getConnection();
		/*try 
		{
			stmt=con.createStatement();
			String sql="select * from DownloadFile where rid="+rid+" and keyactive='true'";
			rs=stmt.executeQuery(sql);
			System.out.println(sql);
			while(rs.next())
			{
				DownloadFile d=new DownloadFile();
				d.setDid(rs.getInt(1));
				d.setRid(rs.getInt(2));
				d.setFid(rs.getInt(3));
				d.setKeyactive(rs.getString(4));
				
				
				
				dlist.add(d);
			}
			
			for(int i=0;i<dlist.size();i++)
			{
				String sql2="select * from FileType where fid="+dlist.get(i).getFid();
				rs=stmt.executeQuery(sql2);
				while(rs.next())
				{
					FileType f=new FileType();
					f.setFid(rs.getInt(1));
					f.setSid(rs.getInt(2));
					f.setPhotoFileName(rs.getString(3));
					f.setCiphertext(rs.getString(4));
					f.setKeytext(rs.getString(5));
					f.setEmail(rs.getString(6));
					flist.add(f);
				}
			}
			
		} 
		catch (SQLException e) 
			{
				e.printStackTrace();
			}
		finally
			{
				if(con!=null)
				{
					try 
						{
							
							stmt.close();
							con.close();
							con=null;
							stmt=null;
						}
					catch (SQLException e) 
						{
							e.printStackTrace();
						}
				}
			}*/
		try 
		{
			stmt=con.createStatement();
			
				String sql2="select f.*,d.email from FileType f, DownloadFile d where f.rid="+rid+" and f.fid in(select d.fid from DOWNLOADFILE d where d.keyactive='true')";
				rs=stmt.executeQuery(sql2);
				System.out.println(sql2);
				while(rs.next())
				{
					FileType f=new FileType();
					f.setFid(rs.getInt(1));
					f.setSid(rs.getInt(2));
					f.setPhotoFileName(rs.getString(3));
					f.setCiphertext(rs.getString(4));
					f.setKeytext(rs.getString(5));
					f.setEmail(rs.getString(6));
					f.setRemail(rs.getString(7));
					f.setUploaddate(rs.getString(8));
					flist.add(f);
				}
			
			
		} 
		catch (SQLException e) 
			{
				e.printStackTrace();
			}
		finally
			{
				if(con!=null)
				{
					try 
						{
							
							stmt.close();
							con.close();
							con=null;
							stmt=null;
						}
					catch (SQLException e) 
						{
							e.printStackTrace();
						}
				}
			}
		return flist;
		
	}
	public List<FileType> downloadFileRetrieve()
	{
		List<FileType> flist=new ArrayList<FileType>();
		if(con==null)
			getConnection();
		try 
		{
			stmt=con.createStatement();
			String sql="select * from FileType";
			rs=stmt.executeQuery(sql);
			System.out.println(sql);
			
			while(rs.next())
			{
				FileType f=new FileType();
				f.setFid(rs.getInt(1));
				f.setSid(rs.getInt(2));
				f.setPhotoFileName(rs.getString(3));
				f.setCiphertext(rs.getString(4));
				f.setKeytext(rs.getString(5));
				f.setEmail(rs.getString(6));
				f.setRemail(rs.getString(7));
				f.setUploaddate(rs.getString(8));
				flist.add(f);
			}
		} 
		catch (SQLException e) 
			{
				e.printStackTrace();
			}
		finally
			{
				if(con!=null)
				{
					try 
						{
							
							stmt.close();
							con.close();
							con=null;
							stmt=null;
						}
					catch (SQLException e) 
						{
							e.printStackTrace();
						}
				}
			}
		return flist;
		
	}
	/*public boolean Download(DownloadFile download)
		{
			try
			{
				String filePath=System.getProperty("catalina.base")+"\\webapps\\file";
				File fileToCreate=new File(filePath,download.getFileFlieName());
				FileUtils.copyFile(download.getText(), fileToCreate);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			if(con==null)
				getConnection();
			try 
			{
				stmt=con.createStatement();
				String sql="insert into download values((select max(id) from upload)+1,'"+download.getName()+"','"+download.getFileFlieName()+"')";
				
				System.out.println(sql);
				
				int i=stmt.executeUpdate(sql);
				if(i>0)
					{
						return true;
					}
				
			} 
			catch (SQLException e) 
				{
					e.printStackTrace();
				}
			finally
				{
					if(con!=null)
					{
						try 
							{
								
								stmt.close();
								con.close();
								con=null;
								stmt=null;
							}
						catch (SQLException e) 
							{
								e.printStackTrace();
							}
					}
				}
			return false;
		}
	*/

	
	public List<Register> userRetrieve()
	{
		List<Register> rlist=new ArrayList<Register>();
		if(con==null)
			getConnection();
		try 
		{
			stmt=con.createStatement();
			String sql="select * from Register";
			rs=stmt.executeQuery(sql);
			System.out.println(sql);
			
			while(rs.next())
			{
				Register r=new Register();
				r.setRid(rs.getInt(1));
				r.setUsername(rs.getString(2));
				r.setPassword(rs.getString(3));
				r.setPhone(rs.getString(4));
				r.setEmail(rs.getString(5));
				r.setGender(rs.getString(6));
			}
		} 
		catch (SQLException e) 
			{
				e.printStackTrace();
			}
		finally
			{
				if(con!=null)
				{
					try 
						{
							
							stmt.close();
							con.close();
							con=null;
							stmt=null;
						}
					catch (SQLException e) 
						{
							e.printStackTrace();
						}
				}
			}
		return rlist;
		
	}
	public FileType FileRetrieve(int id) 
	{
		FileType f=new FileType();
		if(con==null)
			getConnection();
		try 
		{
			stmt=con.createStatement();
			String sql="select * from FileType where fid="+id;
			rs=stmt.executeQuery(sql);
			System.out.println(sql);
			
			while(rs.next())
			{
				f.setFid(rs.getInt(1));
				f.setSid(rs.getInt(2));
				f.setPhotoFileName(rs.getString(3));
				f.setCiphertext(rs.getString(4));
				f.setKeytext(rs.getString(5));
				f.setEmail(rs.getString(6));
				f.setRemail(rs.getString(7));
				f.setUploaddate(rs.getString(8));
				
			}
		} 
		catch (SQLException e) 
			{
				e.printStackTrace();
			}
		finally
			{
				if(con!=null)
				{
					try 
						{
							
							stmt.close();
							con.close();
							con=null;
							stmt=null;
						}
					catch (SQLException e) 
						{
							e.printStackTrace();
						}
				}
			}
		return f;
	}
	public int insertshareFileSuccessSend(int id, int fileid, String madd) 
	{
		int i=0;
		if(con==null)
			getConnection();
		try 
		{
			stmt=con.createStatement();
			String sql="insert into DownloadFile values((select max(did) from DownloadFile)+1,"+id+","+fileid+",'false','"+madd+"')";
			System.out.println(sql);
						
			i=stmt.executeUpdate(sql);
		}
		catch (SQLException e)
		{
				e.printStackTrace();
		}
		finally
		{
			if(con!=null)
				{
					try 
						{
							stmt.close();
							con.close();
							con=null;
							stmt=null;
						}
					catch (SQLException e) 
						{
							e.printStackTrace();
						}
				}
		}
		return i;
	}
	public int viewFileRequest(int rid, int id,String rmadd) 
	{
		int i=0;
		if(con==null)
			getConnection();
		try 
		{
			stmt=con.createStatement();
			String sql="update DownloadFile set keyactive='true' where rid="+rid+" and fid="+id;
			System.out.println(sql);
						
			i=stmt.executeUpdate(sql);
			if(i>0)
			{
				String sql2="update FileType set remail='"+rmadd+"' where fid="+id;
				System.out.println(sql2);
				
				i=stmt.executeUpdate(sql2);
			}
		}
		catch (SQLException e)
		{
				e.printStackTrace();
		}
		finally
		{
			if(con!=null)
				{
					try 
						{
							stmt.close();
							con.close();
							con=null;
							stmt=null;
						}
					catch (SQLException e) 
						{
							e.printStackTrace();
						}
				}
		}
		return i;
		
	}
}
