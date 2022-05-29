package operation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mail.Mail;
import user.User;

public class Operation {
	
	Map<String,User> userMap=new HashMap<>();
	Map<String,List<String>> groupMap=new HashMap<>();
	Map<String,Map<String,List<Mail>>> mailMap=new HashMap<>();
	
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
	
	public boolean composeMail(Mail mail)
	{
		String from=mail.getFrom();
		String to=mail.getTo();
		
		String date=getDate();
		
		mail.setDate(date);
		
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
		
		updateSent(from,mail);
		
		return true;
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
	
	public List<Mail> sentMail(String mail)
	{
		
		Map<String,List<Mail>>tempMap=mailMap.get(mail);
		
		if(tempMap==null)
		{
			tempMap=new HashMap<>();
		}
		
		List<Mail> list=tempMap.get("Inbox");
		
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
		
       Map<String,List<Mail>>tempMap=mailMap.get(to);
		
		List<Mail> list=tempMap.get("Inbox");
		
		list.remove(mail);
		
       tempMap.put("Inbox", list);
		
		mailMap.put(to, tempMap);
		
		updateStatus(id,mail);
		
		return true;
	}
	
	public void updateStatus(String id,Mail mail)
	{
		 Map<String,List<Mail>>tempMap=mailMap.get(id);
			
			List<Mail> list=tempMap.get("Sent");
			
			mail.setRecalled(true);
			
			list.add(mail);
			
			tempMap.put("Sent", list);
			
			mailMap.put(id, tempMap);
			
	}
	
	public boolean inboxSharing(String mail,List<Mail> list)
	{
       Map<String,List<Mail>>tempMap=mailMap.get(mail);
		
		if(tempMap==null)
		{
			tempMap=new HashMap<>();
		}
		
		tempMap.put("Share", list);
		
		mailMap.put(mail, tempMap);
		
		return true;
	}

}
