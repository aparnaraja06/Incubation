package operation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.Query;

import material.Material;
import query.Queries;
import student.Student;
import teacher.Teacher;
import user.User;

public class Operation {
	
	private int studentId=100;
	private int teacherId=1000;
	private int adminId=10000;
	private int queryId=0;
	
	Map<Integer,User> userMap=new HashMap<>();
	List<User> waitingList=new ArrayList<>();
	Map<String,List<Material>> materialMap=new HashMap<>();
	Map<String,List<Queries>> posted=new HashMap<>();
	Map<Integer,List<Integer>> queryMap=new HashMap<>();
	Map<Integer,Queries> answered=new HashMap<>();
	
	
	private int generateStudentId() {
		
		return ++studentId;
	}
	
	private int generateTeacherId() {
		
		return ++teacherId;
	}
	
	private int generateAdminId() {
		
		return ++adminId;
	}
	
	private int generateQueryId() {
		
		return ++queryId;
	}
	
	public void addDefaultStudent() {
		String[] name= {"Ram","Meenu","Raju","Kumar","Princy"};
		int[] age= {10,10,10,10,10};
		String[] gender= {"male","female","male","male","female"};
		String[] password= {"pass","pass","pass","pass","pass"};
		int[] grade= {5,5,5,5,5};
		String[] section= {"A","A","A","A","A"};
		String[] batch= {"2022-23","2022-23","2022-23","2022-23","2022-23"};
		
		for(int i=0;i<name.length;i++)
		{
			
			int id=generateStudentId();

			
			User user=new Student();
			Student student=(Student)user;
			
			student.setName(name[i]);
			student.setAge(age[i]);
			student.setGender(gender[i]);
			student.setPassword(password[i]);
			student.setGrade(grade[i]);
			student.setSection(section[i]);
			student.setBatch(batch[i]);
			student.setId(id);
			
			userMap.put(id, user);
		}
	
	}
	
	public void addDefaultTeachers() 
	{
		String[] name= {"Tara","Saravana","Leena","Nancy","Mukesh","Madona"};
		int[] age= {30,40,35,30,33,44};
		String[] gender= {"female","male","female","female","male","female"};
		String[] password= {"pass","pass","pass","pass","pass","pass"};
		String[] subject= {"english","maths","science","social","tamil","computer"};
		long[] mobile= {9832738762L,9387387863L,8236873679L,8926387688L,8263287687L,9278372388L};
		String[] qualification= {"B.A","M.sc","B.sc","B.A","B.A","M.sc"};
		
		for(int i=0;i<name.length;i++)
		{
			
			int id=generateTeacherId();
			
			User user=new Teacher();
			Teacher teacher=(Teacher)user;
			
			teacher.setName(name[i]);
			teacher.setAge(age[i]);
			teacher.setGender(gender[i]);
			teacher.setPassword(password[i]);
			teacher.setSubject(subject[i]);
			teacher.setMobile(mobile[i]);
			teacher.setQualification(qualification[i]);
			teacher.setId(id);
			
			userMap.put(id, teacher);
		}
		
	}
	
	public void addDefaultAdmin() 
	{
		String[] name= {"Admin1","Admin2","Admin3"};
		int[] age= {40,25,37,30};
		String[] gender= {"male","male","male"};
		String[] password= {"pass","pass","pass"};
		
		for(int i=0;i<name.length;i++)
		{
			int id=generateAdminId();
			
			User user=new User();
			
			user.setId(id);
			user.setName(name[i]);
			user.setAge(age[i]);
			user.setGender(gender[i]);
			user.setPassword(password[i]);
			
			userMap.put(id, user);
			
		}
		
		//System.out.println(userMap);
	}
	
	public User editProfile(int id)
	{
		User user=userMap.get(id);
		
		return user;
	}
	
	public boolean postMaterial(String subject,Material material)
	{
		List<Material> list=materialMap.get(subject);
		
		if(list==null)
		{
			list=new ArrayList<>();
		}
		
		list.add(material);
		
		materialMap.put(subject, list);
		
		return true;
	}
	
	public Map<String,List<Material>> showMaterial()
	{
		return materialMap;
	}
	
	public boolean setLoginRequest(User user)
	{
		waitingList.add(user);
		
		return true;
		
	}
	
	public List<User> getWaitingRequest()
	{
		return waitingList;
	}
	
	public String login(int id,String pass)
	{
		User user=userMap.get(id);
		
		String result=getUserType(user);
		User temp=getObject(user);
		
		if(user==null)
		{
			return "Invalid username";
		}
		
		String password=temp.getPassword();
		
		System.out.println("Pass word : "+password);
		
		if(!password.equals(pass))
		{
			return "Invalid password";
		}
		
		return result;
		
	}
	
	public User getObject(User user)
	{
		if(user instanceof Student)
		{
			Student student=(Student)user;
			return student;
		}
	    
	    else if(user instanceof Teacher)
	    {
	    	Teacher teacher=(Teacher)user;
	    	return teacher;
	    }
	    
	    else if(user instanceof User)
		{
			return user;
		}
	    
	    return null;

	}
	
	public String getUserType(User user)
	{
		
	    if(user instanceof Student)
		{
			return "student";
		}
	    
	    else if(user instanceof Teacher)
	    {
	    	return "teacher";
	    }
	    
	    else if(user instanceof User)
		{
			return "admin";
		}
	    
	    return null;
		
	}
	
	public int getIdForType(String type)
	{
		int id=0;
		if(type.equals("student"))
		{
			id=generateStudentId();
		}
		
		else if(type.equals("teacher"))
		{
			id=generateTeacherId();
		}
		else
		{
			id=generateAdminId();
		}
		
		return id;
	}
	
	public boolean editUser(User user)
	{
		int id=user.getId();
		
		userMap.put(id, user);
		
		return true;
	}
	
	public int addUser(User user) 
	{
		String type=getUserType(user);
		
		int id=getIdForType(type);
		
		userMap.put(id, user);
		
		return id;
		
	}
	
	public String getTime() 
	{
		
		String time="";
		
		long millis=System.currentTimeMillis();
		
		DateFormat date=new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
		
		Date result=new Date(millis);
		
		time=date.format(result);
		
		return time;
	}
	
	public void askDoubts(Queries query)
	{
		String subject=query.getSubject();
		
		int id=query.getStudentId();
		int query_id=generateQueryId();
		
		String time=getTime();
		
		query.setPostedTime(time);
		query.setQueryId(query_id);
		
		List<Queries> list=posted.get(subject);
		
		if(list==null)
		{
			list=new ArrayList<>();
		}
		
		list.add(query);
		
		posted.put(subject, list);
		
		System.out.println("Posted : "+posted);
		
		updateStudentQuery(id,query_id);
		
	}

	
	public void updateStudentQuery(int id,int query_id)
	{
		List<Integer> list=queryMap.get(id);
		
		if(list==null)
		{
			list=new ArrayList<>();
		}
		
		list.add(query_id);
		
		queryMap.put(id, list);
		
	}
	
	public List<Queries> getDoubts(String subject)
	{
		List<Queries> list=posted.get(subject);
		
		System.out.println("Queries  : "+list);
		
		if(list==null)
		{
			return null;
		}
		
		return list;
	}
	
	public String getQuestion(Queries query)
	{
		return query.getQuestion();
	}
	
	public boolean updateAnswers(Queries query,String answer)
	{
		query.setAnswers(answer);
		String subject=query.getSubject();
		int id=query.getQueryId();
		String time=getTime();
		query.setReplyTime(time);
		
		answered.put(id, query);
		
		removeInPosted(subject,query);
		
		return true;
	}
	
	/*public int getTimeGap(Queries query) throws ParseException
	{
		String time1=query.getPostedTime();
		String time2=query.getReplyTime();
		
		SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		
		Date date1=format.parse(time1);
		long milli1=date1.getTime();
		
		Date date2=format.parse(time2);
		long milli2=date2.getTime();
		
		long milli=milli1-milli2;
		
		Date date=new Date(milli);
		
		
	}*/
	
	public void removeInPosted(String subject,Queries query)
	{
		List<Queries> list=posted.get(subject);
		list.remove(query);
	}
	
	public List<Integer> individualQueryId(int id)
	{
		List<Integer> list=queryMap.get(id);
		
		return list;
		
	}
	
	public Queries getIndividualAnswers(int id)
	{
		Queries query=answered.get(id);
		
		if(query==null)
		{
			return null;
		}
		
		return query;
	}
	
	public String getAnswer(Queries query)
	{
		return query.getAnswers();
	}
	
	public Map<Integer,Queries> AllAnswers()
	{
		
		return answered;
	}
	
	public Map<Integer,User> listUsers()
	{
		return userMap;
	}
	
	public Map<Integer,Queries> removeQuery(int id)
	{
		Queries query=answered.get(id);
		
		int student_id=query.getStudentId();
		int query_id=query.getQueryId();
		String subject=query.getSubject();
		
		List<Integer> list=queryMap.get(student_id);
		list.remove(query_id);
		
		queryMap.put(student_id, list);
		
		List<Queries> listt=posted.get(subject);
		listt.remove(query);
		
		posted.put(subject, listt);
		
		answered.remove(id);
		
		return answered;
		
	}
	

}
