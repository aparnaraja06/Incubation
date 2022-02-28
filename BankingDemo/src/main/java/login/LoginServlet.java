package login;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import account.AccountInfo;
import bankinginfo.logic.BankingLogic;
import customer.CustomerInfo;
import customexception.CustomException;
import login.db.LoginDao;

/**
 * Servlet implementation class Login
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html");
		//PrintWriter out=response.getWriter();
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		LoginDao login=new LoginDao();
		try
		{
		Map<String,Integer> loginDetails=login.check(username, password);
		
		System.out.println("Map:"+loginDetails);
		int role=loginDetails.get("role_Id");
		int customerId=loginDetails.get("customer_id");
		
		if(role==101)
		{
			BankingLogic logic=new BankingLogic();
			CustomerInfo customer=logic.getCustomerById(customerId);
			System.out.println("i amd customer:"+customer);
			request.setAttribute("customerId", customer);

			RequestDispatcher dispatch=request.getRequestDispatcher("HomeCustomer.jsp");
			dispatch.forward(request, response);
			
		}
		else if(role==102)
		{
			RequestDispatcher dispatch=request.getRequestDispatcher("Welcome.jsp");
			dispatch.forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
		
		
		        
//		response.sendRedirect("Login.jsp");
	
		//out.close();
	}

}
