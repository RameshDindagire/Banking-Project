package com.banking.servlet;


import java.io.IOException;


import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banking.dao.BankDao;
import com.banking.pojo.bank;



@WebServlet("/bookurl")
public class BankingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String action;
	List<bank> bList = null;
	BankDao bookdao = new BankDao();
	HttpSession session = null;
	bank book;
	int bookId;
	String bookName;
	String bookPrice;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		action = req.getParameter("action");
		session = req.getSession();

		if (action != null && action.equals("list")) {
			// HERE WE WRITE LOGIC TO SHOW BOOK LIST
			bList = bookdao.getAllBooks();
			session.setAttribute("bList", bList);

			resp.sendRedirect("booklist.jsp");
			// SEND REDIRECT IS USED TO COMMUNICATE WITH THE ANOTHER RESOURCE
			// BUT USING NEW REQUEST ALWAYS
		}

		else if (action != null && action.equals("add")) {
			book = new bank(0, "", "");
			req.setAttribute("action", "add");// FOR ADD BOOK IS EMPTY
			req.setAttribute("book", book);
			RequestDispatcher rd = req.getRequestDispatcher("bookForm.jsp");
			rd.forward(req, resp);
			// REQUEST DISPATCHER IS USED TO COMMUNICATE WITH ANOTHER RESOURCE USING SAME
			// REQUEST

		}

		else if (action != null && action.equals("update")) {
			bookId = Integer.parseInt(req.getParameter("bookId"));
			book = bookdao.getBankById(bookId);// FOR UPDATE BOOK IS GET BY DATABASE

			req.setAttribute("action", "update");
			req.setAttribute("book", book);
			RequestDispatcher rd = req.getRequestDispatcher("bookForm.jsp");
			rd.forward(req, resp);
		} else if (action != null && action.equals("delete")) {
			bookId = Integer.parseInt(req.getParameter("bookId"));// FOR DELETEING BOOK BY ITS ID NUMBER
			book = bookdao.getBankById(bookId);

			req.setAttribute("book", book);
			RequestDispatcher rd = req.getRequestDispatcher("confirm.jsp");
			rd.forward(req, resp);

		}
		

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		action =req.getParameter("action");
		session=req.getSession();
		if(action!=null && action.equals("add"))
		{
			bookName=req.getParameter("bookName");
			bookPrice=req.getParameter("bookPrice");
			book=new bank(bookName, bookPrice);
			bookdao.addbank(book);
			session.setAttribute("msg", "New book added successfully!!");
			resp.sendRedirect("bookurl?action=list");
		}
		else if(action!=null && action.equals("update"))
		{
			bookId=Integer.parseInt(req.getParameter("bookId"));
			bookName=req.getParameter("bookName");
			bookPrice=req.getParameter("bookPrice");
			book=new bank(bookId, bookName, bookPrice);
			bookdao.updateBank(bookId, book);
			session.setAttribute("msg", "Book updated successfully!!");
			resp.sendRedirect("bookurl?action=list");
		}
		else if (action!=null && action.equals("delete")) 
		{
			bookId=Integer.parseInt(req.getParameter("bookId"));
			bookdao.deleteBank(bookId);
			session.setAttribute("msg", "Book deleted successfully!!");
			resp.sendRedirect("bookurl?action=list");
		}
	}
}
