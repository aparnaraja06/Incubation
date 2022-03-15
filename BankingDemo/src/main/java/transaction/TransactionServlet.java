package transaction;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import account.AccountInfo;
import bankinginfo.logic.BankingLogic;
import bankinginfo.validate.ValidateInput;
import customexception.CustomException;

/**
 * Servlet implementation class WithdrawServlet
 */
public class TransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransactionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		

		ValidateInput validate=new ValidateInput();
		String from=request.getParameter("selectAccount");	
		String amount=request.getParameter("amount");
		
		
		BankingLogic logic=(BankingLogic) request.getServletContext().getAttribute("Instance");
		int fromAccount=Integer.valueOf(from);
		String temp=null;
		double amountt=0.0;
		try
		{
		
if(request.getParameter("type").equals("withdraw"))
{
	amountt=Double.valueOf(amount);
	validate.validateAmount(amountt);
	int customerId1=0;
		Map<Integer,Map<Integer,AccountInfo>> accountMap=logic.showAllAccounts();
		for(Map.Entry<Integer, Map<Integer,AccountInfo>> entry:accountMap.entrySet())
		{
			int customer_id=entry.getKey();
	
			Map<Integer,AccountInfo> tempMap=entry.getValue();
			for(Map.Entry<Integer,AccountInfo> entry1:tempMap.entrySet())
			{
				int acc_num=entry1.getKey();
					
				if(acc_num==fromAccount)
				{
					
					customerId1=customer_id;
					break;
				}
				
			}
		}
		boolean result=logic.withdraw(customerId1, fromAccount, amountt);
		
		if(result)
		{
			
			temp="Successfully withdrawn";
		}
		request.setAttribute("result",temp);
		RequestDispatcher dispatch=request.getRequestDispatcher("Welcome.jsp");
		dispatch.forward(request, response);
	}


else if(request.getParameter("type").equals("deposit"))
{
	amountt=Double.valueOf(amount);
	validate.validateAmount(amountt);
	int customerId1=0;
			Map<Integer,Map<Integer,AccountInfo>> accountMap=logic.showAllAccounts();
			for(Map.Entry<Integer, Map<Integer,AccountInfo>> entry:accountMap.entrySet())
			{
				int customer_id=entry.getKey();
		
				Map<Integer,AccountInfo> tempMap=entry.getValue();
				for(Map.Entry<Integer,AccountInfo> entry1:tempMap.entrySet())
				{
					int acc_num=entry1.getKey();
						
					if(acc_num==fromAccount)
					{
						
						customerId1=customer_id;
						break;
					}
					
				}
			}
			boolean result=logic.deposit(customerId1, fromAccount, amountt);
		
			if(result)
			{
				temp="Successfully deposited";
			}
			request.setAttribute("result",temp);
			RequestDispatcher dispatch=request.getRequestDispatcher("Welcome.jsp");
			dispatch.forward(request, response);
		}
		}
		catch(NumberFormatException e)
		{
			temp="Amount should be entered in number";
			request.setAttribute("Error", temp);
			RequestDispatcher dispatch=request.getRequestDispatcher("/Withdraw.jsp");
			dispatch.forward(request, response);
		}
		catch(CustomException e)
		{
			temp=e.getMessage();
			request.setAttribute("Error", temp);
			RequestDispatcher dispatch=request.getRequestDispatcher("/Withdraw.jsp");
			dispatch.forward(request, response);

		}


 if(request.getParameter("type").equals("transfer"))
{
	try
	{
	        amountt=Double.valueOf(amount);
	        validate.validateAmount(amountt);
			String to=request.getParameter("toAccount");
			int customerId1=0;
			int customerId2=0;
			boolean result=false;
			
			int toAccount=Integer.valueOf(to);
			Map<Integer,Map<Integer,AccountInfo>> accountMap=logic.showAllAccounts();
			for(Map.Entry<Integer, Map<Integer,AccountInfo>> entry:accountMap.entrySet())
			{
				
				int customer_id=entry.getKey();
				//System.out.println("from map:"+customer_id);
				Map<Integer,AccountInfo> tempMap=entry.getValue();
				for(Map.Entry<Integer,AccountInfo> entry1:tempMap.entrySet())
				{
					int acc_num=entry1.getKey();
						
					if(acc_num==fromAccount)
					{
						
						customerId1=customer_id;
						//System.out.println("Customer id setting"+customerId1);
					
					}
					if(acc_num==toAccount)
					{
						
						customerId2=customer_id;
					
					}
					
				}
			}
			
			result=logic.withdraw(customerId1, fromAccount, amountt);
			result=logic.deposit(customerId2, toAccount, amountt);
			if(result)
			{
			temp="Transaction completed";
			}
			
			request.setAttribute("result", temp);
			RequestDispatcher dispatch=request.getRequestDispatcher("Welcome.jsp");
			dispatch.include(request, response);
		}
    catch(NumberFormatException e)
     {
	temp="Amount should be entered in number";
	request.setAttribute("Error",temp);
	RequestDispatcher dispatch=request.getRequestDispatcher("/Transfer.jsp");
	dispatch.forward(request, response);
    }
	
		catch(CustomException e)
		{
			temp=e.getMessage();
			request.setAttribute("Error", temp);
			RequestDispatcher dispatch=request.getRequestDispatcher("/Transfer.jsp");
			dispatch.forward(request, response);
		}
}
	}
}
