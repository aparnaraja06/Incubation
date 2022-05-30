package runner;

import java.util.List;
import java.util.Scanner;

import helper.Helper;
import mail.Mail;
import operation.Operation;
import user.User;

public class Runner 
{
	
	static Scanner scanner=new Scanner(System.in);
	static Helper reader=new Helper();
	
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
		
		boolean find=reader.passwordValidation(mail, pass2);
		
		User user=new User();
		
		user.setName(name);
		user.setMail(mail);
		if(check && find)
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
			boolean flag=true;
			
			while(flag)
			{
			System.out.println("Enter option");
			System.out.println("1.Compose mail 2.Inbox 3.Sent 4.Delete in Inbox "
					+ "5.Delete in sent 6.Recall 7.Share Inbox 8.Revoke 9.Exit");
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
				
				if(list!=null)
				{
				for(int i=0;i<list.size();i++)
				{
					Mail mails=list.get(i);
					
					System.out.println(mails);
				}
				}
				
				List<Mail> listt=reader.shared(mail);
				
				if(listt != null)
				{
				for(int i=0;i<listt.size();i++)
				{
					Mail mails=listt.get(i);
					
					System.out.println(mails);
				}
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
				
				System.out.println("Size : "+list.size());
				
	               int i=0;
	               
					while(i<list.size())
					{
						Mail mails=list.get(i);
						
						boolean recall=mails.isRecalled();
						
						if(!recall)
						{
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
							break;
						}
						
						case 2:
						{
							i++;
						}
						}
						}
						else
						{
							System.out.println("No mails found");
							break;
						}
						
					}
					
					break;
			}
			
			case 7:
			{
				System.out.println("Enter the mail id to share");
				String id=scanner.nextLine();
				
				List<Mail> list=reader.inbox(mail);
				
				boolean check=reader.inboxSharing(mail,id, list);
				
				if(check)
				{
					System.out.println("Inbox Shared Successfully");
				}
				
				break;
			}
			
			case 8:
			{
				List<String> list=reader.getSharedMail(mail);
				
				int i=0;
				
				while(i<list.size())
				{
					String to=list.get(i);
					
					System.out.println("1.Revoke 2.Skip");
					int num=scanner.nextInt();
					scanner.nextLine();
					
					switch(num)
					{
					case 1:
					{
						boolean check=reader.revokeInbox(mail, to);
						
						if(check)
						{
							System.out.println("Successfully revoked");
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
			
			case 9:
			{
				flag=false;
			}
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
		
		
		boolean flag=true;
		
		while(flag)
		{
		System.out.println("Enter option");
		System.out.println("1.Add User 2.Add group 3.Login 4.Exit");
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
		
		case 4:
		{
			flag=false;
		}
		}
		}
	}

}
