package login;

import java.util.Map;

import user.User;

public class Login {

	
	public String login(User login,Map<Long,User> userMap)
	{
		long userName=login.getCustomerId();
		String pass=login.getPassword();
		
		String result="Successfully logged in";
		
		if(!userMap.containsKey(userName))
		{
			return result="Invalid username";
		}
	
		User temp=userMap.get(userName);
		
		String getPass=temp.getPassword();
		
		if(!pass.equals(getPass))
		{
			return result="Invalid password";
		}
		
		
		return result;
	}
	
	public String createLogin(User login,Map<Long,User> loginMap)
	{
		long cust_id=login.getCustomerId();
		String pass=login.getPassword();
		
		loginMap.put(cust_id,login);
		return pass;
	}
}
