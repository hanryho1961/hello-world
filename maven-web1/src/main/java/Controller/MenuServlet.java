package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

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
 * Servlet implementation class MenuServlet
 */
@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("clearList")) {
			DanhMucModel dmModel = new DanhMucModel();
			int kq = dmModel.clearList();
			if (kq == 0) {
				request.setAttribute("thongbao", "Unable to Delete");
				request.getRequestDispatcher("view/Error.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("view/AdminMenuPage.jsp").forward(request, response);
			}
		} else if (action.equals("delete")) {
			String madm = request.getParameter("madm");
			ProductModel pm = new ProductModel();
			ArrayList<Product> list = pm.getProductByMadm(madm);
			if (list.size()==0) {
				DanhMucModel dmModel = new DanhMucModel();
				dmModel.deletePart(madm);
				request.getRequestDispatcher("view/AdminMenuPage.jsp").forward(request, response);
			} else {
				request.setAttribute("list", list);
				request.getRequestDispatcher("view/MenuProduct.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("insert")) {
			String madm = request.getParameter("txtmadm");
			String tendm = request.getParameter("txttendm");
			DanhMuc dm = new DanhMuc(madm, tendm);
			DanhMucModel dmModel = new DanhMucModel(dm);
			int kq = dmModel.insert();
			if (kq == 0) {
				request.setAttribute("thongbao", "Unable to Insert new Menu");
				request.getRequestDispatcher("view/Error.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("view/AdminMenuPage.jsp").forward(request, response);
			}
		} else if (action.equals("update")) {
			String madm = request.getParameter("txtmadm");
			String tendm = request.getParameter("txttendm");
			DanhMuc dm = new DanhMuc(madm, tendm);
			DanhMucModel dmModel = new DanhMucModel(dm);
			int kq = dmModel.update();
			if (kq == 0) {
				request.setAttribute("thongbao", "Unable to Update");
				request.getRequestDispatcher("view/Error.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("view/AdminMenuPage.jsp").forward(request, response);
			}
		}
	}

}
