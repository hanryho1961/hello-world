package Controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entities.DanhMuc;
import Entities.Product;
import Model.DanhMucModel;
import Model.ProductModel;

/**
 * Servlet implementation class AjaxServlet
 */
@WebServlet("/AjaxServlet")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxServlet() {
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
		response.setContentType("text/plain");
		String action = request.getParameter("action");
		if (action.equals("insertMenu")) {
			String madm = request.getParameter("madm");
			DanhMuc dm = new DanhMucModel().getListById(madm);
			if (dm == null) {
				response.getWriter().print("Pass");
			} else {
				response.getWriter().print("Fail");
			}		
		} else if (action.equals("insertProduct")) {
			String masp = request.getParameter("masp");
			Product pro = new ProductModel().getProductByMasp(masp);
			if (pro == null) {
				response.getWriter().print("Pass");
			} else {
				response.getWriter().print("Fail");
			}		
		}
	}

}
