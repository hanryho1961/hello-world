package Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entities.ChiTietHoaDon;
import Entities.HoaDon;
import Entities.Item;
import Model.CartModel;
import Model.ChiTietHoaDonModel;
import Model.HoaDonModel;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CartModel cartModel = new CartModel();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = "";
		String action = request.getParameter("action");
		String masp = request.getParameter("masp");
		HttpSession session = request.getSession();
		if (action.equals("add")) {
			cartModel.addList(masp);
		} else if (action.equals("delete")) {
			cartModel.removeProduct(masp);
		} else if (action.equals("removeAll")) {
			cartModel.removeAll();
		}
		request.setAttribute("list", cartModel.getListItems());
		request.setAttribute("total", cartModel.totalList());
		page = "view/CartCss.jsp";
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = "";
		String action = request.getParameter("action");
		String masp = request.getParameter("masp");
		HttpSession session = request.getSession();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY/MM/dd");
		Calendar cal = Calendar.getInstance();
		String ngayhd = dateFormat.format(cal.getTime());
		
		HoaDon hoadon = new HoaDon(0, ngayhd);
		HoaDonModel hdModel = new HoaDonModel(hoadon);
		hdModel.insertHoaDon();
		int newestIdHoaDon = hdModel.getNewestIdHoaDon();
		
		ArrayList<Item> cart = cartModel.getListItems();
		for (Item i: cart) {
			ChiTietHoaDon cthd = new ChiTietHoaDon(newestIdHoaDon, i.getSanpham().getMasp(), i.getSoluong());
			ChiTietHoaDonModel cthdModel = new ChiTietHoaDonModel(cthd);
			cthdModel.insertChiTietHoaDoN();
		}
		
		cartModel.removeAll();
		page = "view/CustomerCss.jsp";
		request.getRequestDispatcher(page).forward(request, response);
	}

}
