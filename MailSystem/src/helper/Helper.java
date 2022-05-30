package helper;

import java.util.List;

import mail.Mail;
import operation.Operation;
import user.User;

public class Helper {
	
	Operation reader=new Operation();
	
	public Helper()
	{
		reader.addDefaultUsers();
		reader.addDefaultGroup();
	}

	public boolean addUser(User user)
	{
		return reader.addUser(user);
	}
	
	public User getUser(String mail)
	{
		return reader.getUser(mail);
	}
	
	public boolean addMembers(String mail,String mails)
	{
		return reader.addMembers(mail, mails);
	}
	
	public boolean login(String mail,String pass)
	{
		return reader.login(mail, pass);
	}
	
	public boolean checkPass(String pass1,String pass2)
	{
		return reader.checkPass(pass1, pass2);
	}
	
	public boolean checkUnique(String mail)
	{
		return reader.checkUnique(mail);
	}
	
	public boolean passwordValidation(String mail,String pass)
	{
		return reader.passwordValidation(mail, pass);
	}
	
	public boolean composeMail(Mail mail)
	{
		return reader.composeMail(mail);
	}
	
	public List<Mail> inbox(String mail)
	{
		return reader.inbox(mail);
	}
	
	public List<Mail> shared(String mail)
	{
		return reader.shared(mail);
	}
	
	public List<Mail> sentMail(String mail)
	{
		return reader.sentMail(mail);
	}
	
	public boolean deleteMail(List<Mail> list,String mail,String type)
	{
		return reader.deleteMail(list, mail, type);
	}
	
	public boolean recallMail(String id,Mail mail)
	{
		return reader.recallMail(id, mail);
	}
	
	public boolean inboxSharing(String mail,String to,List<Mail> list)
	{
		return reader.inboxSharing(mail, to, list);
	}
	
	public List<String> getSharedMail(String mail)
	{
		return reader.getSharedMail(mail);
	}
	
	public boolean revokeInbox(String mail,String to)
	{
		return reader.revokeInbox(mail, to);
	}
}
