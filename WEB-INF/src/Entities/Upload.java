package Entities;

import java.io.File;

public class Upload 
{
	private int id;
	private String name;
	private File file;
	private String fileFileName;
	private String fileContentType;
	public Upload() 
		{
			super();
			// TODO Auto-generated constructor stub
		}
	public Upload(int id, String name, File file, String fileFileName, String fileContentType) 
		{
			super();
			this.id = id;
			this.name = name;
			this.file = file;
			this.fileFileName = fileFileName;
			this.fileContentType = fileContentType;
		}
	public int getId() 
		{
			return id;
		}
	public void setId(int id) 
		{
			this.id = id;
		}
	public String getName() 
		{
			return name;
		}
	public void setName(String name)
		{
			this.name = name;
		}
	public File getFile()
		{
			return file;
		}
	public void setFile(File file) 
		{
			this.file = file;
		}
	public String getFileFileName() 
		{
			return fileFileName;
		}
	public void setFileFileName(String fileFileName) 
		{
			this.fileFileName = fileFileName;
		}
	public String getFileContentType() 
		{
			return fileContentType;
		}
	public void setFileContentType(String fileContentType)
		{
			this.fileContentType = fileContentType;
		}
}	
	