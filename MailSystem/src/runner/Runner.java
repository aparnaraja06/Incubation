package runner;

import java.util.List;
import java.util.Scanner;

import mail.Mail;
import operation.Operation;
import user.User;

public class Runner 
{
	
	static Scanner scanner=new Scanner(System.in);
	static Operation reader=new Operation();
	
	public String addUser()
	{
		System.out.println("Enter mail id");
		String mail=scanner.nextLine();
		
		boolean checkMail=reader.checkUnique(mail);
		
		if(checkMail)
		{
		System.out.println("Enter user name");
		String name=scanner.nextLine();
		
		checkPassword(name,mail);
		
		}
		else
		{
			System.out.println("Mail already exists");
			addUser();
		}
		
		return mail;
	}
	
	public void checkPassword(String name,String mail)
	{
		System.out.println("Enter password");
		String pass1=scanner.nextLine();
		
		System.out.println("Enter password");
		String pass2=scanner.nextLine();
		
		boolean check=reader.checkPass(pass1, pass2);
		
		User user=new User();
		
		user.setName(name);
		user.setMail(mail);
		if(check)
		{
			System.out.println("Enter description");
			String about=scanner.nextLine();
			
			user.setPassword(pass2);
			user.setDescription(about);
			
			boolean result=reader.addUser(user);
			
			if(result)
			{
				System.out.println("Successfully added");
			}
		}
		
		else
		{
			System.out.println("Password entered incorrectly");
			checkPassword(name,mail);
		}
	}
	
	public void addMembers(String mail)
	{
		User user=reader.getUser(mail);
		
		user.setGroup(true);
		
		reader.addUser(user);
		
		System.out.println("Enter number of users to add");
		int count=scanner.nextInt();
		scanner.nextLine();
		
		for(int i=0;i<count;i++)
		{
			System.out.println("Enter mail id");
			String id=scanner.nextLine();
			
			reader.addMembers(mail, id);
		}
		
		System.out.println("Successfully added");
	}
	
	public void login()
	{
		System.out.println("Enter mail id");
		String mail=scanner.nextLine();
		
		System.out.println("Enter password");
		String password=scanner.nextLine();
		
		boolean result=reader.login(mail, password);
		
		if(result)
		{
			System.out.println("Enter option");
			int option=scanner.nextInt();
			scanner.nextLine();
			
			switch(option)
			{
			case 1:
			{
				composeMail(mail);
				break;
			}
			
			case 2:
			{
				List<Mail> list=reader.inbox(mail);
				
				for(int i=0;i<list.size();i++)
				{
					Mail mails=list.get(i);
					
					System.out.println(mails);
				}
				
				break;
			}
			
			case 3:
			{
				List<Mail> list=reader.sentMail(mail);
				
				for(int i=0;i<list.size();i++)
				{
					Mail mails=list.get(i);
					
					System.out.println(mails);
				}
				
				break;
			}
			
			case 4:
			{
               List<Mail> list=reader.inbox(mail);
				
               int i=0;
               
				while(i<list.size())
				{
					Mail mails=list.get(i);
					
					System.out.println(mails);
					
					System.out.println("1.Remove 2.Skip");
					int num=scanner.nextInt();
					scanner.nextLine();
					
					switch(num)
					{
					case 1:
					{
						list.remove(i);
						i++;
						break;
					}
					
					case 2:
					{
						i++;
					}
					}
					
				}
				
				boolean check=reader.deleteMail(list, mail, "Inbox");
				
				if(check)
				{
					System.out.println("Updated Successfully");
				}
				
				break;
			}
			
			case 5:
			{
				List<Mail> list=reader.sentMail(mail);
				
	               int i=0;
	               
					while(i<list.size())
					{
						Mail mails=list.get(i);
						
						System.out.println(mails);
						
						System.out.println("1.Remove 2.Skip");
						int num=scanner.nextInt();
						scanner.nextLine();
						
						switch(num)
						{
						case 1:
						{
							list.remove(i);
							i++;
							break;
						}
						
						case 2:
						{
							i++;
						}
						}
						
					}
					
					boolean check=reader.deleteMail(list, mail, "Sent");
					
					if(check)
					{
						System.out.println("Updated Successfully");
					}
					
					break;
			}
			
			case 6:
			{
				List<Mail> list=reader.sentMail(mail);
				
	               int i=0;
	               
					while(i<list.size())
					{
						Mail mails=list.get(i);
						
						System.out.println(mails);
						
						System.out.println("1.Recall 2.Skip");
						int num=scanner.nextInt();
						scanner.nextLine();
						
						switch(num)
						{
						case 1:
						{
						boolean check=reader.recallMail(mail, mails);
						
						if(check)
						{
						System.out.println("Recalled Successfully");
						}
							i++;
							break;
						}
						
						case 2:
						{
							i++;
						}
						}
						
					}
					
					break;
			}
			
			case 7:
			{
				System.out.println("Enter the mail id to share");
				String id=scanner.nextLine();
				
				List<Mail> list=reader.inbox(mail);
				
				boolean check=reader.inboxSharing(id, list);
				
				if(check)
				{
					System.out.println("Inbox Shared Successfully");
				}
				
				break;
			}
			}
		}
	}
	
	public void composeMail(String mail)
	{
		System.out.println("Enter to address");
		String to=scanner.nextLine();
		
		System.out.println("Enter subject");
		String subject=scanner.nextLine();
		
		System.out.println("Enter content");
		String content=scanner.nextLine();
		
		Mail mailObj = new Mail();
		
		mailObj.setFrom(mail);
		mailObj.setTo(to);
		mailObj.setContent(content);
		mailObj.setSubject(subject);
		
		boolean check=reader.composeMail(mailObj);
		
		if(check)
		{
			System.out.println("Successfully sent");
		}
	}
	
	public static void main(String[] args)
	{
		Runner runner=new Runner();
		
		System.out.println("Enter option");
		int option=scanner.nextInt();
		scanner.nextLine();
		
		switch(option)
		{
		case 1:
		{
			runner.addUser();
			break;
		}
		
		case 2:
		{
			String mail=runner.addUser();
			runner.addMembers(mail);
			break;
		}
		
		case 3:
		{
			runner.login();
			break;
		}
		}
	}

}
