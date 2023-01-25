package Entities;

import java.io.File;

public class Download 
{
	private int id;
	private String name;
	private File text;
	private String filename;
	public Download() 
		{
			super();
			// TODO Auto-generated constructor stub
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
	public File getText() 
		{
			return text;
		}
	public void setText(File text) 
		{
			this.text = text;
		}
	public String getFilename() 
		{
			return filename;
		}
	public void setFilename(String filename) 
		{
			this.filename = filename;
		}
	public Download(int id, String name, File text, String filename) 
		{
			super();
			this.id = id;
			this.name = name;
			this.text = text;
			this.filename = filename;
		}
}
