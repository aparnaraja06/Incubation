package runner;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.management.Query;

import material.Material;
import operation.Operation;
import query.Queries;
import student.Student;
import teacher.Teacher;
import user.User;

public class Runner {
	
	static Scanner scanner = new Scanner(System.in);
	static Operation reader = new Operation();
	
	public void student(int id) 
	{
		boolean flag=true;
		while(flag)
		{
		System.out.println("Enter the option");
		System.out.println("1.Edit profile 2.Materials 3.Ask doubt 4.Answer 5.Discussions");
		System.out.println();
		int option=scanner.nextInt();
		scanner.nextLine();
		
		switch(option)
		{
		case 1:
		{
			boolean result=editStudentProfile(id);
			if(result)
			{
				System.out.println("Successfully Edited");
			}
			
			break;
		}
		
		case 2:
		{
			Map<String,List<Material>> result=reader.showMaterial();
			
			for(String subject: result.keySet())
			{
				List<Material> list=result.get(subject);
				System.out.println("Subject  : "+subject);
				System.out.println("Material : "+list);
				System.out.println("Total material : "+list.size());
			}
			
			break;
		}
		
		case 3:
		{
			System.out.println("Enter the subject to ask question");
			String subject=scanner.nextLine();
			
			System.out.println("Enter the question");
			String question=scanner.nextLine();
			
			Queries query=new Queries();
			
			query.setStudentId(id);
			query.setSubject(subject);
			query.setQuestion(question);
			
			reader.askDoubts(query);
			System.out.println("Question posted successfully");
			break;
		}
		
		case 4:
		{
		    List<Integer> list=reader.individualQueryId(id);
		    
		    
		    if(list!=null)
		    {
		    for(int i=0;i<list.size();i++)
		    {
		    	Queries query=reader.getIndividualAnswers(list.get(i));
		    	if(query!=null)
		    	{
		    	String question=query.getQuestion();
		    	String answer=query.getAnswers();
		    	
		    	if(question!=null)
		    	{
		    	System.out.println("Question");
		    	System.out.println(question);
		    	}
		    	else
		    	{
		    		System.out.println("Question not available");
		    	}
		    	if(answer!=null)
		    	{
		    	System.out.println("Answers");
		    	System.out.println(answer);
		    	}
		    	}
		    	else
		    	{
		    		System.out.println("Answer not posted yet !");
		    	}
		    	}
		 	    }
		    else
		    {
		    	System.out.println("You have not posted any questions");
		    }
		     break;
		}
		
		case 5:
		{
			Map<Integer,Queries> result=reader.AllAnswers();
			
			for(int number:result.keySet())
			{
			      Queries query=result.get(number);
			      
			    String question=query.getQuestion();
			    String answer=query.getAnswers();
			    
			    System.out.println("Question");
		    	System.out.println(question);

		    	System.out.println("Answers");
		    	System.out.println(answer);
			}
			
			break;
		}
		
		case 6:
		{
			flag=false;
		}
		}
		}
	}
	
	public void teacher(int id)
	{
		User user=reader.editProfile(id);
		Teacher teacher=(Teacher)user;
		
		String subject=teacher.getSubject();
		
		boolean flag=true;
		while(flag)
		{
		System.out.println("Enter the option");
		System.out.println("1.Edit profile 2.Post materials 3.Check doubts 4.Post Answer");
		int option=scanner.nextInt();
		scanner.nextLine();
		
		switch(option)
		{
		case 1:
		{
			boolean result=editTeacherProfile(id);
			if(result)
			{
				System.out.println("Edited Successfully");
			}
			
			break;
		}
		
		case 2:
		{
			
			
			System.out.println("Enter how many materials to post ");
			int count=scanner.nextInt();
			scanner.nextLine();
			
			for(int i=0;i<count;i++)
			{
				System.out.println("Enter the type");
				String type=scanner.nextLine();
				
				System.out.println("Enter the size of document");
				double size=scanner.nextDouble();
				
				String date=reader.getTime();
				
				Material material=new Material();
				
				material.setSubject(subject);
				material.setSize(size);
				material.setType(type);
				material.setTeacherId(id);
				material.setDate(date);
				
				boolean result=reader.postMaterial(subject, material);
				
				if(result)
				{
					System.out.println("Sucessfully added");
				}
			}
		}
		
		case 3:
		{
			List<Queries> list=reader.getDoubts(subject);
			//System.out.println("Subject : "+list);
			if(list!=null)
			{
			for(int i=0;i<list.size();i++)
			{
				Queries query=list.get(i);
				
				System.out.println("Question");
				System.out.println(query.getQuestion());
			}
			}
			else
			{
				System.out.println("No doubts posted");
			}
			
			break;
		}
		
		case 4:
		{
            List<Queries> list=reader.getDoubts(subject);
			
            if(list!=null)
            {
			for(int i=0;i<list.size();i++)
			{
				Queries query=list.get(i);
				
				System.out.println("Question");
				System.out.println(query.getQuestion());
				
				System.out.println("1.Update Answer 2.Skip ");
				int optionn=scanner.nextInt();
				scanner.nextLine();
				
				String answer="";
				switch(optionn)
				{
				case 1:
				{
					System.out.println("Enter the answer");
					answer=scanner.nextLine();
					break;
				}
				
				case 2:
				{
					answer=null;
					break;
				}
				}
				
				boolean temp=reader.updateAnswers(query, answer);
				if(temp)
				{
				System.out.println("Successfully added");
				}
			}
            }
            else
            {
            	System.out.println("No posts yet");
            }
			break;
		}
		
		case 5:
		{
			flag=false;
		}
		}
		}
	}
	
	public void admin(int id)
	{
		boolean flag=true;
		while(flag)
		{
		System.out.println("Enter the option");
		System.out.println();
		int option=scanner.nextInt();
		scanner.nextLine();
		
		switch(option)
		{
		case 1:
		{
			Map<Integer,User> result=reader.listUsers();
			
			for(int number:result.keySet())
			{
				User user=result.get(number);
				System.out.println("Id : "+number);
				System.out.println("Details : "+user);
			}
			
			break;
		}
		
		case 2:
		{
			List<User> list=reader.getWaitingRequest();
			
			for(int i=0;i<list.size();i++)
			{
				System.out.println(list.get(i));
			}
			
			break;
		}
		
		case 3:
		{
			Map<Integer,Queries> map=reader.AllAnswers();
			
			for(int number:map.keySet())
			{
				Queries query=map.get(number);
				String subject=query.getSubject();
				System.out.println("Question number : "+number);
				System.out.println("Subject : "+subject);
				System.out.println(query);
			}
			
			boolean temp=true;
			
			while(temp)
			{
			System.out.println("1.Remove question & answers 2.exit");
			int number=scanner.nextInt();
			scanner.nextLine();
			
			switch(number)
			{
			case 1:
			{
				System.out.println("Enter question number");
				int num=scanner.nextInt();
				scanner.nextLine();
				
				reader.removeQuery(num-1);
				System.out.println("Successfully removed ");
				break;
			}
			
			case 2:
			{
				temp=false;
			}
			}
			}
		}
		
		case 4:
		{
			flag=false;
		}
		}
		}
	}
		
	public boolean editStudentProfile(int id) 
	{
		User user=reader.editProfile(id);
		Student student=(Student)user;
		System.out.println(user);
		
		boolean flag=true;
		
		while(flag)
		{
		System.out.println("Enter the option to edit");
		System.out.println("1.name 2.password 3.age 4.gender 5.class 6.section");
		int option=scanner.nextInt();
		scanner.nextLine();
		
		switch(option)
		{
		case 1:
		{
			System.out.println("Enter the name");
			String name=scanner.nextLine();
			student.setName(name);
			break;
		}
		
		case 2:
		{
			System.out.println("Enter the password");
			String pass=scanner.nextLine();
			student.setPassword(pass);
			break;
		}
		
		case 3:
		{
			System.out.println("Enter age");
			int age=scanner.nextInt();
			scanner.nextLine();
			student.setAge(age);
			break;
		}
		
		case 4:
		{
			System.out.println("Enter gender");
			String gender=scanner.nextLine();
			student.setGender(gender);
			break;
		}
		
		case 5:
		{
			System.out.println("Enter class");
			int grade=scanner.nextInt();
			scanner.nextLine();
			student.setGrade(grade);
			break;
		}
		
		case 6:
		{
			System.out.println("Enter section");
			String section=scanner.nextLine();
			student.setSection(section);
			break;
		}
		
		case 7:
		{
			System.out.println("Enter the batch");
			String batch=scanner.nextLine();
			student.setBatch(batch);
			break;
		}
		case 8:
		{
			flag=false;
		}
		}
		}
		
		boolean result=reader.editUser(user);
		return result;
	}
	
	public boolean editTeacherProfile(int id) 
	{
		User user=reader.editProfile(id);
		Teacher teacher=(Teacher)user;
		System.out.println(user);
		
		boolean flag=true;
		
		while(flag)
		{
		System.out.println("Enter the option to edit");
		System.out.println("1.name 2.password 3.age 4.gender 5.subject 6.mobile 7.qualification"
				+ "8.exit");
		int option=scanner.nextInt();
		scanner.nextLine();
		
		switch(option)
		{
		case 1:
		{
			System.out.println("Enter the name");
			String name=scanner.nextLine();
			teacher.setName(name);
			break;
		}
		
		case 2:
		{
			System.out.println("Enter the password");
			String pass=scanner.nextLine();
			teacher.setPassword(pass);
			break;
		}
		
		case 3:
		{
			System.out.println("Enter age");
			int age=scanner.nextInt();
			scanner.nextLine();
			teacher.setAge(age);
			break;
		}
		
		case 4:
		{
			System.out.println("Enter gender");
			String gender=scanner.nextLine();
			teacher.setGender(gender);
			break;
		}
		
		case 5:
		{
			System.out.println("Enter subject");
			String subject=scanner.nextLine();
			teacher.setSubject(subject);
			break;
		}
		
		case 6:
		{
			System.out.println("Enter mobile number");
			long mobile=scanner.nextLong();
			scanner.nextLine();
			teacher.setMobile(mobile);
			break;
		}
		
		case 7:
		{
			System.out.println("Enter qualification");
			String qualification=scanner.nextLine();
			teacher.setQualification(qualification);
			break;
		}
		case 8:
		{
			flag=false;
		}
		}
		}
		
		boolean result=reader.editUser(user);
		return result;
	}
	
	

	public static void main(String[] args) {
		

		reader.addDefaultStudent();
		reader.addDefaultTeachers();
		reader.addDefaultAdmin();
		
		Runner runner=new Runner();
		
		boolean flag=true;
		
		while(flag)
		{ 
			System.out.println("Enter user name");
			int id=scanner.nextInt();
			scanner.nextLine();
			
			System.out.println("Enter password");
			String pass=scanner.nextLine();
			
			String type=reader.login(id, pass);
			switch(type)
			{
			case "student":
			{
				runner.student(id);
				break;
			}
			case "teacher":
			{
				runner.teacher(id);
				break;
			}
			case "admin":
			{
				runner.admin(id);
				break;
			}
			default:
			{
				flag=false;
			}
			}
			
		}
	}


}
