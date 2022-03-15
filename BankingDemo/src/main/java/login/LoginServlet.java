package login;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bankinginfo.logic.BankingLogic;
import customexception.CustomException;

/**
 * Servlet implementation class Login
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 //public BankingLogic logic=null;
	
	public void init(ServletConfig config)throws ServletException
	{
		
		BankingLogic  logic=new BankingLogic();
		config.getServletContext().setAttribute("Instance", logic);
		super.init(config);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		//LoginDao login=new LoginDao();
		//BankingLogic logic=new BankingLogic();
		try
		{
			
		BankingLogic logic=(BankingLogic) request.getServletContext().getAttribute("Instance");
		Map<String,Integer> loginDetails=logic.loginDetails(username, password);
		
		if(loginDetails==null || loginDetails.isEmpty())
		{
			String error="Sorry! Invalid username or password";
			request.setAttribute("Error",error);
			//out.print("<h2><h2>");
			RequestDispatcher dispatch=request.getRequestDispatcher("/Login.jsp");
			dispatch.include(request, response);
			//request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
		else
		{
		
		int role=loginDetails.get("role_Id");
		int customerId=loginDetails.get("customer_id");
		
		if(role==101)
		{
			
			HttpSession session=request.getSession();
			session.setAttribute("customerId", customerId);
			

			RequestDispatcher dispatch=request.getRequestDispatcher("HomeCustomer.jsp");
			dispatch.forward(request, response);
			
		}
		else if(role==102)
		{			
			HttpSession session=request.getSession();
			session.setAttribute("customerId", 0);
			session.setAttribute("username",username);
			
			RequestDispatcher dispatch=request.getRequestDispatcher("Welcome.jsp");
			dispatch.forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
		}
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}

		
		   
	}

}
