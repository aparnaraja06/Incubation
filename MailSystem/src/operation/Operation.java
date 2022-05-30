package operation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import mail.Mail;
import user.User;

public class Operation {
	
	Map<String,User> userMap=new HashMap<>();
	Map<String,List<String>> groupMap=new HashMap<>();
	Map<String,Map<String,List<Mail>>> mailMap=new HashMap<>();
	Map<String,List<String>> shareMap=new HashMap<>();
	
	
	public void addDefaultUsers()
	{
		String[] mail= {"karthik@gmail.com","ram@gmail.com","sam@gmail.com","uma@gmail.com","suba@gmail.com"};
		String[] name= {"kathik","ram","sam","uma","suba"};
		String[] pass= {"pass","pass","pass","pass","pass"};
		
		
		for(int i=0;i<mail.length;i++)
		{
			User user=new User();
			
			user.setName(name[i]);
			user.setMail(mail[i]);
			user.setPassword(pass[i]);
			
			userMap.put(mail[i], user);
		}
	}
	
	public void addDefaultGroup()
	{
		String mail="student@gmail.com";
				
		User user=new User();
		
		user.setName("student");
		user.setMail(mail);
		user.setPassword("pass");
		user.setGroup(true);
		
		userMap.put(mail, user);
		
		List<String> list=groupMap.get(mail);
		
		if(list==null)
		{
			list=new ArrayList<>();
		}
		
		list.add("uma@gmail.com");
		list.add("suba@gmail.com");
		
		groupMap.put(mail, list);
	}
	
	public boolean addUser(User user)
	{
		String mail=user.getMail();
		
		userMap.put(mail, user);
		
		return true;
	}
	
	public User getUser(String mail)
	{
		User user=userMap.get(mail);
		
		return user;
	}
	
	public boolean addMembers(String mail,String mails)
	{
		List<String> list=groupMap.get(mail);
		
		if(list==null)
		{
			list=new ArrayList<>();
		}
		
		list.add(mails);
		
		groupMap.put(mail, list);
		
		return true;
	}
	
	public boolean login(String mail,String pass)
	{
		User user=userMap.get(mail);
		
		if(user==null)
		{
			return false;
		}
		
		String password=user.getPassword();
		
		boolean result=pass.equals(password);
		
		return result;
	}
	
	public String getDate()
	{
		String time="";
		
		long millis=System.currentTimeMillis();
		
		SimpleDateFormat format=new SimpleDateFormat("dd:MMM:yyyy HH:mm:ss");
		
		Date date=new Date(millis);
		
		time=format.format(date);
		
		return time;
	}
	
	public boolean checkPass(String pass1,String pass2)
	{
		boolean result=pass1.equals(pass2);
		
		return result;
	}
	
	public boolean checkUnique(String mail)
	{
		User user=userMap.get(mail);
		
		if(user==null)
		{
			return true;
		}
		
		return false;
	}
	
	public boolean passwordValidation(String mail,String pass)
	{
		if(pass.length()<8)
		{
			return false;
		}
		
		Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(pass);
        
        boolean result=matcher.find();
        
        return result;
	}
	
	public boolean composeMail(Mail mail)
	{
		String from=mail.getFrom();
		String to=mail.getTo();
		
		String date=getDate();
		
		mail.setDate(date);
		
		boolean check=groupMap.containsKey(to);
		
		if(check)
		{
			sentGroup(to,mail);
		}
		else
		{
			updateInbox(to,mail);
		}
		
		updateSent(from,mail);
		
		return true;
	}
	
	public void sentGroup(String to,Mail mail)
	{
		List<String> list=groupMap.get(to);
		
		for(int i=0;i<list.size();i++)
		{
			String temp=list.get(i);
			
			updateInbox(temp,mail);
		}
	}
	
	public void updateInbox(String to,Mail mail)
	{
       Map<String,List<Mail>>tempMap=mailMap.get(to);
		
		if(tempMap==null)
		{
			tempMap=new HashMap<>();
		}
		
		List<Mail> list=tempMap.get("Inbox");
		
		if(list==null)
		{
			list=new ArrayList<>();
		}
		
		list.add(mail);
		
		tempMap.put("Inbox", list);
		
		mailMap.put(to, tempMap);
	}
	
	public void updateSent(String from,Mail mail)
	{
      Map<String,List<Mail>>tempMap=mailMap.get(from);
		
		if(tempMap==null)
		{
			tempMap=new HashMap<>();
		}
		
		List<Mail> list=tempMap.get("Sent");
		
		if(list==null)
		{
			list=new ArrayList<>();
		}
		
		list.add(mail);
		
		tempMap.put("Sent", list);
		
		mailMap.put(from, tempMap);
	}
	
	public List<Mail> inbox(String mail)
	{
		
		Map<String,List<Mail>>tempMap=mailMap.get(mail);
		
		if(tempMap==null)
		{
			tempMap=new HashMap<>();
		}
		
		List<Mail> list=tempMap.get("Inbox");
		
		return list;
	}
	
	public List<Mail> shared(String mail)
	{
		
        Map<String,List<Mail>>tempMap=mailMap.get(mail);
		
		if(tempMap==null)
		{
			tempMap=new HashMap<>();
		}
		
		List<Mail> list=tempMap.get("Share");
		
		return list;
	}
	
	public List<Mail> sentMail(String mail)
	{
		
		Map<String,List<Mail>>tempMap=mailMap.get(mail);
		
		if(tempMap==null)
		{
			tempMap=new HashMap<>();
		}
		
		List<Mail> list=tempMap.get("Sent");
		
		return list;
	}
	
	public boolean deleteMail(List<Mail> list,String mail,String type)
	{
		if(type.equals("Inbox"))
		{
			updateDeleteInbox(list, mail);
		}
		
		else if(type.equals("Sent"))
		{
			updateDeleteSent(list, mail);
		}
		
		return true;
	}
	
	public void updateDeleteInbox(List<Mail> list,String mail)
	{
		Map<String,List<Mail>>tempMap=mailMap.get(mail);
		
		tempMap.put("Inbox", list);
		
		mailMap.put(mail, tempMap);
	}
	
	public void updateDeleteSent(List<Mail> list,String mail)
	{
		Map<String,List<Mail>>tempMap=mailMap.get(mail);
		
		tempMap.put("Sent", list);
		
		mailMap.put(mail, tempMap);
	}
	
	public boolean recallMail(String id,Mail mail)
	{
		String to=mail.getTo();
		
     boolean check=groupMap.containsKey(to);
		
		if(check)
		{
			recallGroup(to,mail);
		}
		else
		{
			recallUser(to,mail);
		}
		
		updateStatus(id,mail);
		
		return true;
	}
	
	public void recallGroup(String to,Mail mail)
	{
		List<String> list=groupMap.get(to);
		
		for(int i=0;i<list.size();i++)
		{
			String temp=list.get(i);
			
			recallUser(temp,mail);
		}
	}
	
	public void recallUser(String to,Mail mail)
	{
       Map<String,List<Mail>>tempMap=mailMap.get(to);
		
		List<Mail> list=tempMap.get("Inbox");
		
		list.remove(mail);
		
       tempMap.put("Inbox", list);
		
		mailMap.put(to, tempMap);
	}
	
	public void updateStatus(String id,Mail mail)
	{
		 Map<String,List<Mail>>tempMap=mailMap.get(id);
			
			List<Mail> list=tempMap.get("Sent");
			
			list.remove(mail);
			
			mail.setRecalled(true);
			
			list.add(mail);
			
			tempMap.put("Sent", list);
			
			mailMap.put(id, tempMap);
			
	}
	
	public boolean inboxSharing(String mail,String to,List<Mail> list)
	{
       Map<String,List<Mail>>tempMap=mailMap.get(to);
		
		if(tempMap==null)
		{
			tempMap=new HashMap<>();
		}
		
		tempMap.put("Share", list);
		
		mailMap.put(to, tempMap);
		
	    List<String> listt=shareMap.get(mail);
	    
	    if(listt==null)
	    {
	    	listt=new ArrayList<>();
	    }
	    
	    listt.add(to);
	    
	    shareMap.put(mail, listt);
		
		return true;
	}
	
	public List<String> getSharedMail(String mail)
	{
		List<String> list=shareMap.get(mail);
		
		return list;
	}
	
	public boolean revokeInbox(String mail,String to)
	{
		 Map<String,List<Mail>>tempMap=mailMap.get(to);
		 
		 tempMap.remove("Share");
		 
		 mailMap.put(to, tempMap);
		 
		List<String> list= shareMap.get(mail);
		
		list.remove(to);
		
		shareMap.put(mail, list);
		 
		 return true;
	}

}
