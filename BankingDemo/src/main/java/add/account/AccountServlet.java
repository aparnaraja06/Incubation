package add.account;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.NumberFormatException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import account.AccountInfo;
import bankinginfo.logic.BankingLogic;
import bankinginfo.validate.ValidateInput;
import customexception.CustomException;

/**
 * Servlet implementation class AddAccount
 */
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String typeName=(String)request.getParameter("status"); 
		
		response.setContentType("text/html");
		
		BankingLogic logic=(BankingLogic) request.getServletContext().getAttribute("Instance");
		
		String id = request.getParameter("customerId");
		String account = request.getParameter("accountNum");
		int customer_id = Integer.parseInt(id);
		int acc_num = Integer.parseInt(account);
		boolean result=false;
		String temp=null;
		try {
			
			if(typeName.equals("inactive"))
			{
			result=logic.changeStatus(customer_id, acc_num, false);
			if(!result)
			{
				temp="Successfully Set to inactive !";
			}
			}
			else if(typeName.equals("active"))
			{
				
				result=logic.changeStatus(customer_id, acc_num, true);
				
				if(result)
				{
					temp="Successfully Set to active !";
				}
			}
			
			//RequestDispatcher dispatch=request.getRequestDispatcher("Welcome.jsp");
			//dispatch.forward(request, response);
			
			
			request.setAttribute("result", temp);
			RequestDispatcher dispatch=request.getRequestDispatcher("Welcome.jsp");
			dispatch.include(request, response);
		} catch (CustomException e) {
			System.out.println(e.getMessage());
		}
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		ValidateInput validate=new ValidateInput();
		String customer_id=request.getParameter("customerid");
		String branch=request.getParameter("branch");
		String balance=request.getParameter("balance");
		String result=null;
		
		try
		{
		BankingLogic logic=(BankingLogic) request.getServletContext().getAttribute("Instance");
		int customerId=Integer.parseInt(customer_id);
		double balancee=Double.parseDouble(balance);
		validate.validateAmount(balancee);
				
		//BankingLogic logic=new BankingLogic();
		
		if(request.getParameter("type").equals("addAccount"))
		{
		//String page=request.getParameter("page");
		AccountInfo account=new AccountInfo();
		account.setCustomerId(customerId);
		account.setBranch(branch);
		account.setBalance(balancee);

		System.out.println("Object "+logic);
		logic.addAccount(account);

		result="Successfully Added";
		request.setAttribute("result", result);
		RequestDispatcher dispatch=request.getRequestDispatcher("/Welcome.jsp");
		dispatch.include(request, response);
		}
		else if(request.getParameter("type").equals("editAccount"))
		{
			String accountNum=request.getParameter("accountNum");
			int acc_num=Integer.valueOf(accountNum);
			
			AccountInfo account=new AccountInfo();
			account.setAccountNum(acc_num);
			account.setCustomerId(customerId);
			account.setBranch(branch);
			account.setBalance(balancee);
			
			logic.updateAccount(account);
			result="Successfully Edited";
			request.setAttribute("result", result);
			RequestDispatcher dispatch=request.getRequestDispatcher("/Welcome.jsp");
			dispatch.include(request, response);
		}
		}
			catch(NumberFormatException ex)
			{
				request.setAttribute("Error", "Balance should be entered in number ");
				RequestDispatcher dispatch=request.getRequestDispatcher("/AddUpdateAccount.jsp");
				dispatch.include(request, response);
			}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
			
		}
	}

