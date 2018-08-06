package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entities.Account;
import Model.AccountModel;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/AccountServlet")
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("txtuser");
		String password = request.getParameter("txtpass");
		String thongbao = "";
		String page = "";
		int found = 0;
		
		AccountModel accModel = new AccountModel();
		ArrayList<Account> list = accModel.getList();
		for (Account acc: list) {
			if (acc.getUsername().equals(username)) {
				found = 1;
				if (acc.getPassword().equals(password)) {
					found = 2;
					if (username.equalsIgnoreCase("admin")) {
						page = "view"+"/WorkList.jsp";
					} else if (username.equalsIgnoreCase("customer")) {
						page = "view"+"/CustomerCss.jsp";
					}
				}
			}
		}
		if (found == 0) {
			thongbao = "Username doesn't exist";
			page = "view/Error.jsp";
		} else if (found == 1) {
			thongbao = "Unable to login";
			page = "view/Error.jsp";
		}
		request.setAttribute("thongbao", thongbao);
		request.getRequestDispatcher(page).forward(request, response);
	}

}
