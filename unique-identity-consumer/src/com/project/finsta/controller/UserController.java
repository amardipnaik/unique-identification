package com.project.finsta.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.project.finsta.bean.CardBean;
import com.project.finsta.bean.FeedBackBean;
import com.project.finsta.bean.Notification;
import com.project.finsta.bean.OrderBean;
import com.project.finsta.bean.ProductBean;
import com.project.finsta.bean.RequestWrapper;
import com.project.finsta.bean.UserBean;
import com.project.finsta.bean.WebDetails;
import com.project.finsta.service.IUserBeanService;



@RestController
public class UserController {

    private IUserBeanService iuserBeanService;
    
    
	
	@Autowired(required=true)
	@Qualifier(value="iuserBeanService")
	public void setPersonService(IUserBeanService userBeanService){
		this.iuserBeanService = userBeanService;
	}
	
	
	
	 @RequestMapping(value="/login", method = RequestMethod.POST)
	    public ModelAndView loginMain(HttpServletRequest req, HttpServletResponse res)
	    {
		 
		 	HttpSession session=req.getSession();
	    	String login=req.getParameter("login");
	    	String password=req.getParameter("password");
	    	
	    	UserBean userBean=new UserBean();
	    	userBean.setLogin(login);
	    	userBean.setPassword(password);
	    	
	    	System.out.println("Login ::"+login);
	    	System.out.println("password ::"+password);
	    	
	    	List<UserBean> userBeanList=new ArrayList<UserBean>();
			try {
				userBeanList = iuserBeanService.userBeanList(userBean);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	String profile=null;
	    	long userId=0;
	    	UserBean user=new UserBean();
	    	
	    	if(!userBeanList.isEmpty())
	    	{
	    		
	    		user=userBeanList.get(0);
	    		profile=user.getProfile();
	    		userId=user.getId();
	    	}
	    	else
	    	{
	    		return new ModelAndView("redirect:loginAuth");
	    	}
	    	
	    	session.setAttribute("userId",userId );
	    	session.setAttribute("user",user );
	    	
	    	session.setAttribute("profile",profile );
	    	
	    	
	    	session.setAttribute("loggedInUser", req.getAttribute("uname"));
	    	return new ModelAndView("login");
		
	    }
	
	 
	 @RequestMapping(value="/register", method = RequestMethod.POST)
	    public ModelAndView regitserUser(HttpServletRequest req, HttpServletResponse res)
	    {
		 
			HttpSession session=req.getSession();
	    	String login=req.getParameter("login");

	    	int RandomPassword=getRandomIntegerBetweenRange();
	    	String password=String.valueOf(RandomPassword);
	    	String fname=req.getParameter("fname");
	    	String lname=req.getParameter("lname");
	    	String cn=req.getParameter("cn");
	    	String em=req.getParameter("em");
	    	String ct=req.getParameter("ct");
	    	String middleName=req.getParameter("mname");
	    	String dateOfBirth=req.getParameter("dbth");
	    	String adharNumber=req.getParameter("adh");
	    	String panNumber=req.getParameter("pan");
	    	String drivingLicence=req.getParameter("dr");
	    	String passportNumber=req.getParameter("pn");
	    	String rationCard=req.getParameter("rcard");
	    	String passportExpireDate=req.getParameter("pexp");
	    	String street=req.getParameter("street");
	    	String state=req.getParameter("state");
	    	
	    	UserBean userBean=new UserBean();
	    	userBean.setLogin(login);
	    	userBean.setPassword(password);
	    	userBean.setFirstName(fname);
	    	userBean.setLastName(lname);
	    	userBean.setEmail(em);
	    	userBean.setContactNumber(cn);
	    	userBean.setProfile("user");
	    	userBean.setCity(ct);
	    	userBean.setMiddleName(middleName);
	    	userBean.setDateOfBirth(dateOfBirth);
	    	userBean.setAdharNumber(adharNumber);
	    	userBean.setPanNumber(panNumber);
	    	userBean.setDrivingLicence(drivingLicence);
	    	userBean.setPassportNumber(passportNumber);
	    	userBean.setRationCard(rationCard);
	    	userBean.setPassportExpireDate(passportExpireDate);
	    	userBean.setStreet(street);
	    	userBean.setState(state);
	    	
	    	
	    	
	    	iuserBeanService.adduserBean(userBean);
	    	
	    	mailSender(RandomPassword, em, fname);
	    	
	    	return new ModelAndView("redirect:loginAuth");
		
	    }
	 
	 public static int getRandomIntegerBetweenRange(){
			Random rand = new Random(); 
			int value = rand.nextInt(1000000);
			return value;
		}
	 
	 
	 private static void  mailSender(int RandomPassword,String em,String fname) {                                         
		  //It works as a process bar            
		  
		  System.out.println("In Mail Sender");
		  String host="smtp.gmail.com";   
		  final String user = "citizencardonline@gmail.com";  
		  final String password = "go4it*123";
		  


		   if(!user.equals("") && !password.equals(""))
		   {
		     String SMTP_PORT = "465";
		     String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";    
		    
		    
		  
		     //Get the session object  
		     Properties props = new Properties();
		     props.put("mail.smtp.starttls.enable", "true");
		     props.put("mail.smtp.host",host);  
		     props.put("mail.smtp.auth", "true");  
		     props.put("mail.debug", "true");
		     props.put("mail.smtp.port", SMTP_PORT);
		     props.put("mail.smtp.socketFactory.port", SMTP_PORT);
		     props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
		     props.put("mail.smtp.socketFactory.fallback", "false");  
		     props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		     Session session = Session.getDefaultInstance(props,  
		     new javax.mail.Authenticator() {
		        
		       protected PasswordAuthentication getPasswordAuthentication() {  
		       return new PasswordAuthentication(user,password);  
		       }  
		     });    
		   
		 
		     try 
		     {  
		        MimeMessage message = new MimeMessage(session);  
		        
		        // creates message part
		        MimeBodyPart messageBodyPart = new MimeBodyPart();
		        messageBodyPart.setContent(message, "text/html");     
		     
		        message.setFrom(new InternetAddress(user));  
		        message.addRecipient(Message.RecipientType.TO,new InternetAddress(em));        
		        
		        message.setSubject("Unique Identification Two Way Authentication");
		       
		        StringBuilder builder=new StringBuilder();
		        builder.append("Hi "+fname);
		      
		        builder.append(",Welcome to unique identification two way authenticaton process");
		        builder.append(",Your autogenarted password is "+RandomPassword);
		        builder.append(",You can change your password from edit profile. ");
		        
		       /* builder.append("  *********This is a autogenarated mail Please do not reply ************* ");*/
		        
		        System.out.println("Body is "+builder);
		        message.setText(builder.toString());  
		        //send the message  
		        Transport.send(message);    
		     
		     System.out.println("Message Send Successfully.....");
		       
		      } 
		      catch (MessagingException e) {e.printStackTrace();}  
		      }
		  
		   else 
		   {
		      
		   }  
		}
	 
	 
	 
	 
	 @RequestMapping(value="/loginAuth", method = RequestMethod.GET)
	    public ModelAndView loginAuth(HttpServletRequest req, HttpServletResponse res)
	    {
		 	return new ModelAndView("loginAuth");
		
	    }
	 
	 
	 
	 
	 
	 

	
	@RequestMapping(value = "userList", method = RequestMethod.GET)
	public List<UserBean> listuserBean() {
		System.out.println("In Controller userList");
		
		List<UserBean> userBeanList=new ArrayList<>();
		userBeanList=iuserBeanService.userList();
		
		return userBeanList;
	}
	
	
	@RequestMapping(value = "getUser", method = RequestMethod.GET)
	public UserBean getUser(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("In Controller getUser");
		HttpSession session=req.getSession();
		UserBean userBean=new UserBean();
		 userBean= (UserBean) session.getAttribute("user");
		 
		 
			UserBean userBean2=new UserBean();
			userBean2.setLogin(userBean.getLogin());
			userBean2.setPassword(userBean.getPassword());
	    	
	  
	    	
	    	List<UserBean> userBeanList=new ArrayList<UserBean>();
			try {
				userBeanList = iuserBeanService.userBeanList(userBean);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	UserBean user=new UserBean();
	    	
	    	if(!userBeanList.isEmpty())
	    	{
	    		
	    		user=userBeanList.get(0);
	    		
	    	}
	    
		 
		 
		 
		 
		
		return user;
	}
	
	
	@RequestMapping(value = "feedbackList", method = RequestMethod.GET)
	public List<FeedBackBean> feedbackList() {
		System.out.println("In Controller feedbackList");
		
		List<FeedBackBean> feedBackBeanList=new ArrayList<>();
		feedBackBeanList=iuserBeanService.feedbackList();
		
		return feedBackBeanList;
	}
	
	@RequestMapping(value = "webDetailsList", method = RequestMethod.GET)
	public List<WebDetails> webDetailsList() {
		System.out.println("In Controller webDetailsList");
		
		List<WebDetails> webDetailsList=new ArrayList<>();
		webDetailsList=iuserBeanService.webDetailsList();
		
		return webDetailsList;
	}
	
	
	@RequestMapping(value = "productList", method = RequestMethod.GET)
	public List<ProductBean> productList() {
		System.out.println("In Controller productList");
		
		List<ProductBean> productBeanList=new ArrayList<>();
		productBeanList=iuserBeanService.productList();
		System.out.println("In Controller productList::"+productBeanList.toString());
		return productBeanList;
		
	}
	
	
	@RequestMapping(value = "addProduct", method = RequestMethod.POST)
	public ModelAndView addProduct(HttpServletRequest req, HttpServletResponse res,@RequestParam("file") MultipartFile file) throws IOException {
		System.out.println("In Controller addProduct");
		Map<String,String> resultMap=new HashMap<String,String>();
		
		File image=convert(file);
	
		
		String productName=req.getParameter("pname");
		String productPrice=req.getParameter("pprice");
		String productBrand=req.getParameter("pbrand");
		String sex=req.getParameter("sex");
		
		
		
		String imageString=encodeFileToBase64Binary(image);
		
		
		ProductBean productBean=new ProductBean();
		productBean.setBrand(productBrand);
		productBean.setPrice(productPrice);
		productBean.setName(productName);
		productBean.setImage(imageString);
		iuserBeanService.addProduct(productBean);
		
		return new ModelAndView("login");
		
	}
	
	public File convert(MultipartFile file) throws IOException
	{    
	    File convFile = new File(file.getOriginalFilename());
	    convFile.createNewFile(); 
	    FileOutputStream fos = new FileOutputStream(convFile); 
	    fos.write(file.getBytes());
	    fos.close(); 
	    return convFile;
	}
	
	
	private String encodeFileToBase64Binary(File file)
			throws IOException {

		
		byte[] bytes = loadFile(file);
		byte[] encoded = Base64.encodeBase64(bytes);
		String encodedString = new String(encoded);

		return encodedString;
	}

	private static byte[] loadFile(File file) throws IOException {
	    InputStream is = new FileInputStream(file);

	    long length = file.length();
	    if (length > Integer.MAX_VALUE) {
	        // File is too large
	    }
	    byte[] bytes = new byte[(int)length];
	    
	    int offset = 0;
	    int numRead = 0;
	    while (offset < bytes.length
	           && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
	        offset += numRead;
	    }

	    if (offset < bytes.length) {
	        throw new IOException("Could not completely read file "+file.getName());
	    }

	    is.close();
	    return bytes;
	}
	
	
	

	@RequestMapping(value = "updateProduct", method = RequestMethod.POST)
	public Map<String,String> updateProduct(@RequestBody ProductBean productBean) {
		System.out.println("In Controller updateProduct");
		
		
		
		
		
		Map<String,String> resultMap=new HashMap<String,String>();
	
		
		String status=null;
		
		try {
			iuserBeanService.updateProduct(productBean);
			status="SUCCESS";
		} catch (Exception e) {
			status="ERROR:Kindly Check With Database Connectin";
			
		}
		
		resultMap.put("result", status);
		return resultMap;
		
		
		
	}
	
	@RequestMapping(value = "updateFeedback", method = RequestMethod.POST)
	public Map<String,String> updateFeedback(@RequestBody RequestWrapper RequestWrapper) {
		System.out.println("In Controller updateFeedback");
		
		FeedBackBean feedback=new FeedBackBean();
		feedback.setId(Long.parseLong(RequestWrapper.getUserId()));
		
	
		
		
	
		
		Map<String,String> resultMap=new HashMap<String,String>();
	
		
		String status=null;
		
		try {
			iuserBeanService.updateFeedback(feedback);
			status="SUCCESS";
		} catch (Exception e) {
			status="ERROR:Kindly Check With Database Connectin";
			
		}
		
		resultMap.put("result", status);
		return resultMap;
		
		
		
		
	}
	
	@RequestMapping(value = "updateWebDetails", method = RequestMethod.POST)
	public Map<String,String> updateWebDetails(@RequestBody WebDetails webDetails) {
		System.out.println("In Controller webDetails");
		
		Map<String,String> resultMap=new HashMap<String,String>();
	
		
		String status=null;
		
		try {
			iuserBeanService.updateWebDetails(webDetails);
			status="SUCCESS";
		} catch (Exception e) {
			status="ERROR:Kindly Check With Database Connectin";
			
		}
		
		resultMap.put("result", status);
		return resultMap;
	}
	
	@RequestMapping(value = "addCardBean", method = RequestMethod.POST)
	public Map<String,String> addCardBean(@RequestBody CardBean cardBean) {
		System.out.println("In Controller addCardBean");
		Map<String,String> resultMap=new HashMap<String,String>();
	
		
		String status=null;
		
		try {
			iuserBeanService.addCardBean(cardBean);
			status="SUCCESS";
		} catch (Exception e) {
			status="ERROR:Kindly Check With Database Connectin";
			
		}
		
		resultMap.put("result", status);
		return resultMap;
		
	}
	
	
	@RequestMapping(value = "addNotification", method = RequestMethod.POST)
	public Map<String,String> addNotification(@RequestBody Notification notification) {
		System.out.println("In Controller addCardBean");
		Map<String,String> resultMap=new HashMap<String,String>();
		
		String status=null;
		
		try {
			iuserBeanService.addNotification(notification);
			status="SUCCESS:Record Added Successfully";
		} catch (Exception e) {
			status="ERROR:Kindly Check With Database Connectin";
			
		}
		
		resultMap.put("result", status);
		return resultMap;
		
	}
	
	
	@RequestMapping(value = "addFeedback", method = RequestMethod.POST)
	public Map<String,String> addFeedback(@RequestBody FeedBackBean feedBackBean,HttpServletRequest req, HttpServletResponse res) {
		System.out.println("In Controller feedBackBean");
		
		HttpSession session=req.getSession();
		UserBean userBean=new UserBean();
		 userBean= (UserBean) session.getAttribute("user");
		
		 feedBackBean.setDeleteFlag("F");
		 feedBackBean.setUsername(userBean.getLogin());
		 feedBackBean.setEmail(userBean.getEmail());
		 
		 System.out.println("Feedback Bean Is::::"+feedBackBean);
		Map<String,String> resultMap=new HashMap<String,String>();
		
		String status=null;
		
		try {
			iuserBeanService.addFeedback(feedBackBean);
			status="SUCCESS:Record Added Successfully";
		} catch (Exception e) {
			status="ERROR:Kindly Check With Database Connectin";
			
		}
		
		resultMap.put("result", status);
		return resultMap;
		
	}
	
 
	@RequestMapping(value = "productListByUserId", method = RequestMethod.POST)
	public List<ProductBean> productListByUserId(@RequestBody CardBean cardBean) {
		System.out.println("In Controller productList");
		
		List<ProductBean> productBeanList=new ArrayList<>();
		productBeanList=iuserBeanService.productListByUserId(cardBean);
		System.out.println("In Controller productListByUserId::"+productBeanList.toString());
		return productBeanList;
		
	}
	
	@RequestMapping(value = "notificationList", method = RequestMethod.GET)
	public List<Notification> notificationList() {
		System.out.println("In Controller notificationList");
		
		List<Notification> notificationList=new ArrayList<>();
		notificationList=iuserBeanService.notificationList();
		System.out.println("In Controller productListByUserId::"+notificationList.toString());
		return notificationList;
		
	}
	
	
	@RequestMapping(value = "addOrder", method = RequestMethod.POST)
	public Map<String,String> addOrder(@RequestBody OrderBean order) throws IOException {
		System.out.println("In Controller addOrder");
		
		
	
	/*
		
		String productName=req.getParameter("pname");
	
		
		
		

		
		
		OrderBean order=new OrderBean();
	
		order.setBuilding(req.getParameter("bd"));
		order.setState(req.getParameter("ste"));
		order.setStreet(req.getParameter("st"));
		order.setCity(req.getParameter("ct"));
		order.setPinCode(req.getParameter("pn"));
		order.setCardNumber(req.getParameter("cn"));
		order.setYear(req.getParameter("mn"));
		order.setCvvNumber(req.getParameter("cvn"));*/
	
		
	
		Map<String,String> resultMap=new HashMap<String,String>();
	
		
		String status=null;
		
		try {
			iuserBeanService.addOrder(order);
			iuserBeanService.addCardUpdate(order);
			
			status="SUCCESS";
			
			
			
			
		} catch (Exception e) {
			status="ERROR:Kindly Check With Database Connectin";
			
		}
		
		resultMap.put("result", status);
		return resultMap;
	}
	
	
	@RequestMapping(value = "orderList", method = RequestMethod.GET)
	public List<OrderBean> orderList(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("In Controller notificationList");
		
		HttpSession session=req.getSession();
		long userId=(long) session.getAttribute("userId" );
		String userIdString=String.valueOf(userId);
		
		List<OrderBean> orderList=new ArrayList<>();
		orderList=iuserBeanService.orderList(userIdString);
		System.out.println("In Controller productListByUserId::"+orderList.toString());
		return orderList;
		
	}
	
	
	
	@RequestMapping(value = "resetPassword", method = RequestMethod.POST)
	public Map<String,String> resetPassword(@RequestBody RequestWrapper requestWrapper) throws IOException {
		System.out.println("In Controller addOrder");
		Map<String,String> resultMap=new HashMap<String,String>();
	
		
		String status=null;
		
		try {
			iuserBeanService.resetPassword(requestWrapper.getUserId());
			
			
			status="SUCCESS";
			
			
			
			
		} catch (Exception e) {
			status="ERROR:Kindly Check With Database Connectin";
			
		}
		
		resultMap.put("result", status);
		return resultMap;
	}
	
	
	@RequestMapping(value = "addMoney", method = RequestMethod.POST)
	public Map<String,String> addMoney(@RequestBody RequestWrapper requestWrapper) throws IOException {
		System.out.println("In Controller addMoney");
		Map<String,String> resultMap=new HashMap<String,String>();
	
		
		String status=null;
		
		try {
			iuserBeanService.addMoney(requestWrapper);
			
			
			status="SUCCESS";
			
			
			
			
		} catch (Exception e) {
			status="ERROR:Kindly Check With Database Connection";
			
		}
		
		resultMap.put("result", status);
		return resultMap;
	}
	
	
	
	
	

	
}
