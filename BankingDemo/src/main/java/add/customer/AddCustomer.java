package add.customer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bankinginfo.logic.BankingLogic;
import bankinginfo.validate.ValidateInput;
import customer.CustomerInfo;
import customexception.CustomException;

/**
 * Servlet implementation class AddCustomer
 */

public class AddCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String typeName=(String)request.getParameter("status"); 
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
	String id = request.getParameter("customerId");
	try {
		 int customer_id = Integer.parseInt(id);
		
		 BankingLogic logic=(BankingLogic) request.getServletContext().getAttribute("Instance");
			boolean result=false;
			String temp=null;
			if(typeName.equals("inactive"))
			{
			result=logic.changeCustomerStatus(customer_id, false);
			if(!result)
			{
				temp="Successfully set to inactive !";
			}
			}
			else if(typeName.equals("active"))
			{
				result=logic.changeCustomerStatus(customer_id,true);
				if(result)
				{
					temp="Successfully set to active !";
				}
			}
			request.setAttribute("result", temp);
			//RequestDispatcher dispatch=request.getRequestDispatcher("Welcome.jsp");
			//dispatch.forward(request, response);
			
			RequestDispatcher dispatch=request.getRequestDispatcher("CustomerDetails.jsp");
			dispatch.forward(request, response);
		} catch (CustomException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		

		BankingLogic logic=(BankingLogic) request.getServletContext().getAttribute("Instance");
		
		String name=request.getParameter("customername");
		String gender=request.getParameter("gender");
		String mobile=request.getParameter("mobile");
		String temp=null;
		ValidateInput validate=new ValidateInput();
		
		String result=null;
		try
		{
		validate.validateName(name);
		validate.checkAlpha(name);
		long mobileNum=Long.parseLong(mobile);
		
		if(request.getParameter("type").equals("addCustomer"))
		{
		
		CustomerInfo customer=new CustomerInfo();
		
		customer.setCustomerName(name);
		customer.setGender(gender);
		customer.setMobileNum(mobileNum);

			logic.addNewCustomer(customer);
			result="Successfully Added";
			request.setAttribute("result",result);
			RequestDispatcher dispatch=request.getRequestDispatcher("CustomerDetails.jsp");
			dispatch.include(request, response);
		}
		
		if(request.getParameter("type").equals("editCustomer"))
		{
		String customerId=request.getParameter("customerId");
		int cust_id=Integer.valueOf(customerId);
		CustomerInfo customer=new CustomerInfo();
		customer.setCustomerName(name);
		customer.setGender(gender);
		customer.setMobileNum(mobileNum);
		customer.setCustomerID(cust_id);

		logic.updateCustomer(customer);
		result="Successfully Edited";
		request.setAttribute("result",result);
		RequestDispatcher dispatch=request.getRequestDispatcher("CustomerDetails.jsp");
		dispatch.include(request, response);
		}
		}
		catch(NumberFormatException e)
		{
			result="Mobile Number should be entered in number";
			request.setAttribute("Error", result);
			RequestDispatcher dispatch=request.getRequestDispatcher("AddUpdateCustomer.jsp");
			dispatch.include(request, response);
		}
		catch(CustomException e)
		{
			temp=e.getMessage();
			request.setAttribute("Error", temp);
			RequestDispatcher dispatch=request.getRequestDispatcher("AddUpdateCustomer.jsp");
			dispatch.include(request, response);
			
		}
	}
	}

