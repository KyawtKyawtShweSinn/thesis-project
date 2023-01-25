package myapp;

import Entities.SendFile;
import Entities.DownloadFile;
import Entities.FileType;
import Entities.Register;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import db.DAO;


public class homeAction extends ActionSupport 
{
	private FileType filetype;
	private SendFile upload;
	private DownloadFile download;
	DAO dao=new DAO();
	int id;
	
	private InputStream inputStream;
	private String fileName;
	private long contentLength;
	private String name;
	
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpSession session=request.getSession();
	
	private List<SendFile> dlist=new ArrayList<SendFile>();
	private List<FileType> flist=new ArrayList<FileType>();
	private List<Register> rlist=new ArrayList<Register>();
	
	private String keytext;
	
	private int count=0;
	private int fileid;
	private String madd;
	
	private String rmadd;
	private String ciphertext;
	
	
	public String getCiphertext()
	{
		return ciphertext;
	}
	public void setCiphertext(String ciphertext)
	{
		this.ciphertext = ciphertext;
	}
	public String getRmadd() 
	{
		return rmadd;
	}
	public void setRmadd(String rmadd) 
	{
		this.rmadd = rmadd;
	}
	public String getMadd() 
	{
		return madd;
	}
	public void setMadd(String madd) 
	{
		this.madd = madd;
	}
	public int getFileid()
	{
		return fileid;
	}
	public void setFileid(int fileid) 
	{
		this.fileid = fileid;
	}
	public int getCount() 
	{
		return count;
	}
	public void setCount(int count) 
	{
		this.count = count;
	}
	public String getKeytext() 
	{
		return keytext;
	}
	public void setKeytext(String keytext) {
		this.keytext = keytext;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	
	
	public InputStream getInputStream() 
	{
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) 
	{
		this.inputStream = inputStream;
	}
	public String getFileName() 
	{
		return fileName;
	}
	public void setFileName(String fileName)
{
		this.fileName = fileName;
	}
	public long getContentLength() 
	{
		return contentLength;
	}
	public void setContentLength(long contentLength) 
	{
		this.contentLength = contentLength;
	}
	public List<Register> getRlist() 
	{
			return rlist;
	}
	public void setRlist(List<Register> rlist) 
	{
			this.rlist = rlist;
	}
	
	
	
	public List<SendFile> getDlist() 
	{
			return dlist;
	}
	public void setDlist(List<SendFile> dlist) 
	{
			this.dlist = dlist;
	}
	
	
	public List<FileType> getFlist() 
	{
			return flist;
	}
	public void setFlist(List<FileType> flist) 
	{
			this.flist = flist;
	}
	
	public int getId() 
	{
			return id;
	}
	public void setId(int id) 
	{
			this.id = id;
	}
	public SendFile getUpload() 
	{
			return upload;
	}
	public void setUpload(SendFile upload) 
	{
			this.upload = upload;
	}
	
	public FileType getFiletype() 
	{
		return filetype;
	}
	public void setFiletype(FileType filetype) 
	{
		this.filetype = filetype;
	}
	
	
	public String execute()
	{
			return "success";
	}
	
	
	public String logout() 
	{ 	
		session.setAttribute("reg", null);
		session.setAttribute("fileid", null);
				 
		return "success";	 
	}
	
	
	public String uploadFileForm() 
	{ 	
			 return "success";	 
	}
	
	
	public String uploadFile() throws CryptoException
	{
		Register r=(Register) session.getAttribute("reg");
		//Encryption Process
		//String key = "Mary has one dog";
		String key=filetype.getKeytext();
		//File inputFile = new File("document.txt");
		String fileName=filetype.getPhotoFileName();
		StringTokenizer stk=new StringTokenizer(fileName,".");
		String fName=stk.nextToken();
		
		File encryptedFile = new File(fName+".encrypted");
		encryptedFile=CryptoUtils.encrypt(key, filetype.getPhoto(), encryptedFile);
			
		
		//id=dao.uploadfile(filetype,r.getRid());
			
			
		dao.insertupload(r.getRid(),r.getEmail(), filetype,encryptedFile);
		return "success";
		}
	
	
	public String shareFile()
	{
		Register r=(Register) session.getAttribute("reg");
		flist=dao.shareRetrieve(r.getRid());
		if(flist!=null)
		{
			System.out.println("Size of flist "+flist.size());
			return "success";
		}
		else
			return "error";
	}
	
	public String viewFile()
	{
		Register r=(Register) session.getAttribute("reg");
		
		flist=dao.viewFileRetrieve(r.getRid());
		
		if(flist!=null)
		{
			System.out.println("Size of flist "+flist.size());
			return "success";
		}
		else
			return "error";
	}
	
	public String viewRequest()
	{
		Register r=(Register) session.getAttribute("reg");
		flist=dao.viewRequestRetrieve(r.getRid());
		if(flist!=null)
		{
			System.out.println("Size of flist "+flist.size());
			return "success";
		}
		else
			return "error";
	}
	public String viewFileRequest()
	{
		Register r=(Register) session.getAttribute("reg");
		System.out.println("View File RequestEmail"+r.getEmail());
		
		dao.viewFileRequest(r.getRid(),id,r.getEmail());
		return "success";
	}
	public String viewRequestResponse() throws MessagingException
	{
		
		Register r=(Register) session.getAttribute("reg");
		
		System.out.println("from email"+r.getEmail()+"Password "+r.getPassword()+"Remail "+rmadd);
		final String from=r.getEmail();
		final String password=r.getPassword();
		String to=rmadd;//change accordingly 
		//String to="ayekyipyarshwe@gmail.com";
		  
		
		  //Get the session object  
		  Properties props = new Properties();  
		  props.put("mail.smtp.host", "smtp.gmail.com");  
		  props.put("mail.smtp.socketFactory.port", "465");  
		 // props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		  props.put("mail.smtp.socketFactory.class",  
		            "javax.net.ssl.SSLSocketFactory");  
		  props.put("mail.smtp.auth", "true");  
		  props.put("mail.smtp.port", "465");  
		   
		  Session session = Session.getDefaultInstance(props,  
		   new javax.mail.Authenticator() {  
		   protected PasswordAuthentication getPasswordAuthentication() {  
		   return new PasswordAuthentication(from,password);//change accordingly  
		   }  
		  });  
		   
		  //compose message  
		  try {  
		   MimeMessage message = new MimeMessage(session);  
		   message.setFrom(new InternetAddress("ayekyipyarshwe@gmail.com"));//change accordingly  
		   message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
		   message.setSubject("Hello");  
		   message.setText("Ciphertext File Name:"+ciphertext+"key : "+keytext);  
		     
		   //send message  
		   Transport.send(message);  
		  
		   System.out.println("message sent successfully");  
		   
		  } catch (MessagingException e) {throw new RuntimeException(e);
		  } 
		
		return "success";
	}
	public String shareFileSuccess()
	{
		Register r=(Register) session.getAttribute("reg");
		rlist=dao.shareFileSuccessRetrieve(r.getRid());
		session.setAttribute("fileid", fileid);
		if(rlist!=null)
		{
			System.out.println("Size of rlist "+rlist.size());
			return "success";
		}
		else
			return "error";
	}
	public String shareFileSuccessSend()
	{
		fileid=(int) session.getAttribute("fileid");
		System.out.println("madd  "+madd);
		int result=dao.insertshareFileSuccessSend(id,fileid,madd);
		
		
		Register r=(Register) session.getAttribute("reg");
		//send email
		String from =r.getEmail();
	     String pass =r.getPassword();
	    // Recipient's email ID needs to be mentioned.
	   String to = madd;

	   String host = "smtp.gmail.com";

	   // Get system properties
	  /* Properties properties = System.getProperties();
	   // Setup mail server
	   properties.put("mail.smtp.starttls.enable", "true");
	   properties.put("mail.smtp.host", host);
	   properties.put("mail.smtp.user", from);
	   properties.put("mail.smtp.password", pass);
	   properties.put("mail.smtp.port", "25");
	   properties.put("mail.smtp.auth", "true");

	   // Get the default Session object.
	   Session session = Session.getDefaultInstance(properties);

	   try{
	      // Create a default MimeMessage object.
	      MimeMessage message = new MimeMessage(session);

	      // Set From: header field of the header.
	      message.setFrom(new InternetAddress(from));

	      // Set To: header field of the header.
	      message.addRecipient(Message.RecipientType.TO,
	                               new InternetAddress(to));

	      // Set Subject: header field
	      message.setSubject("This is the Subject Line!");

	      // Now set the actual message
	      message.setText("This is actual message");

	      // Send message
	      Transport transport = session.getTransport("smtp");
	      transport.connect(host, from, pass);
	      transport.sendMessage(message, message.getAllRecipients());
	      transport.close();
	      System.out.println("Sent message successfully....");
	   }catch (MessagingException mex) {
	      mex.printStackTrace();
	   }*/
		
		return "success";
	}
	
	
	public String downloadFile()
	{
		Register r=(Register) session.getAttribute("reg");
		flist=dao.viewFileRetrieve(r.getRid());
		if(flist!=null)
		{
			System.out.println("Size of flist "+flist.size());
			return "success";
		}
		else
			return "error";
	}
	
	public String downloadFileSuccess() throws FileNotFoundException
	{
		//System.out.println(name);
		filetype=dao.FileRetrieve(id);
		session.setAttribute("filetype", filetype);
		return "success";
	}
	
	
	
	public String download() throws IOException
	{
		
		filetype=(FileType) session.getAttribute("filetype");
		filetype.setKeytext(keytext);
		
		String defileName="decrypted"+filetype.getPhotoFileName();
		File decryptedFile=new File(defileName);
		File inputFile=new File(filetype.getCiphertext());
		
		try {
			decryptedFile=CryptoUtils.decrypt(filetype.getKeytext(), inputFile, decryptedFile);
		
		String filePath=System.getProperty("catalina.base")+"\\webapps\\files";
		
		
		File fileToCreate1=new File(filePath,decryptedFile.getName());
		
		FileUtils.copyFile(decryptedFile, fileToCreate1);
		
		System.out.println("Decrypted File Name  "+decryptedFile.getName());
		
		

		File fileToDownload = new File(filePath+"\\"+decryptedFile.getName());

		inputStream = new FileInputStream(fileToDownload);
		fileName = fileToDownload.getName();
		contentLength = fileToDownload.length();
		} catch (CryptoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			addActionError("Key don't match");
			return "error";
		}
		
		return "success";
				
	}
	
	
	
	
	

	
	
}
