package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Entities.Product;
import Model.ProductModel;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		ProductModel pm = new ProductModel();
		if (action.equals("clearList")) {
			int kq = pm.clearList();
			if (kq == 0) {
				request.setAttribute("thongbao", "Unable to Clear the List");
				request.getRequestDispatcher("Error.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("view/AdminPageCss.jsp").forward(request, response);
			}
		} else if (action.equals("deletePart")) {
			String masp = request.getParameter("masp");
			int kq = pm.deletePart(masp);
			if (kq == 0) {
				request.setAttribute("thongbao", "Unable to Delete the Product");
				request.getRequestDispatcher("view/Error.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("view/AdminPageCss.jsp").forward(request, response);
			}
		} else if (action.equals("deleteMenuProduct")) {
			String madm = request.getParameter("madm");
			String masp = request.getParameter("masp");
			int kq = pm.deletePart(masp);
			if (kq == 0) {
				request.setAttribute("thongbao", "Unable to Delete the Product");
				request.getRequestDispatcher("view/Error.jsp").forward(request, response);
			} else {
				ArrayList<Product> list = pm.getProductByMadm(madm);
				if (list.isEmpty()) {
					request.getRequestDispatcher("view/AdminMenuPage.jsp").forward(request, response);
				} else {
					request.setAttribute("list", list);
					request.getRequestDispatcher("view/MenuProduct.jsp").forward(request, response);
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String action = request.getParameter("action");
		if (action.equals("insert")) {
			Part file = request.getPart("file");
			ProductModel pm = new ProductModel(file);
			String uploadRootPath = request.getServletContext().getRealPath("Images");
			pm.uploadFile(uploadRootPath);
			
			String masp = request.getParameter("txtmasp");
			String tensp  = request.getParameter("txttensp");
			int giasp  = Integer.parseInt(request.getParameter("txtgia"));
			String hinhsp = pm.getFileName(file);
			String madm = request.getParameter("madm");
			
			Product temp = new Product(masp, tensp, giasp, hinhsp, madm);
			pm = new ProductModel(temp);
			int kq = pm.insertProduct();
			if (kq == 0) {
				request.setAttribute("thongbao", "Unable to Insert");
				request.getRequestDispatcher("view/Error.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("view/AdminPageCss.jsp").forward(request, response);
			}
		} else if (action.equals("update")) {
			Part file = request.getPart("file");
			ProductModel pm = new ProductModel(file);
			String hinhsp = "";
			if (file.getSize() == 0) {
				hinhsp = request.getParameter("txthinhsp");
			} else {			
				String uploadRootPath = request.getServletContext().getRealPath("Images");
				pm.uploadFile(uploadRootPath);
				System.out.println(uploadRootPath);
				hinhsp = pm.getFileName(file);
			}
			String masp = request.getParameter("txtmasp");
			String tensp  = request.getParameter("txttensp");
			int giasp  = Integer.parseInt(request.getParameter("txtgia"));
			String madm = request.getParameter("madm");
			Product pro = new Product(masp, tensp, giasp, hinhsp, madm);
			pm = new ProductModel(pro);
			int kq = pm.updateProduct();
			if (kq == 0) {
				request.setAttribute("thongbao", "Unable to update");
				request.getRequestDispatcher("view/Error.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("view/AdminPageCss.jsp").forward(request, response);
			}
		} else if (action.equals("updateMenuProduct")) {
			Part file = request.getPart("file");
			ProductModel pm = new ProductModel(file);
			String hinhsp = "";
			if (file.getSize() == 0) {
				hinhsp = request.getParameter("txthinhsp");
			} else {			
				String uploadRootPath = request.getServletContext().getRealPath("Images");
				pm.uploadFile(uploadRootPath);
				System.out.println(uploadRootPath);
				hinhsp = pm.getFileName(file);
			}
			String masp = request.getParameter("txtmasp");
			String tensp  = request.getParameter("txttensp");
			int giasp  = Integer.parseInt(request.getParameter("txtgia"));
			String madm = request.getParameter("madm");
			Product pro = new Product(masp, tensp, giasp, hinhsp, madm);
			pm = new ProductModel(pro);
			int kq = pm.updateProduct();
			if (kq == 0) {
				request.setAttribute("thongbao", "Unable to update");
				request.getRequestDispatcher("view/Error.jsp").forward(request, response);
			} else {
				ArrayList<Product> list = pm.getProductByMadm(request.getParameter("oldmadm"));
				if (list.isEmpty()) {
					request.getRequestDispatcher("view/AdminMenuPage.jsp").forward(request, response);
				} else {
					request.setAttribute("list", list);
					request.getRequestDispatcher("view/MenuProduct.jsp").forward(request, response);
				}
			}
		}
	}
}
