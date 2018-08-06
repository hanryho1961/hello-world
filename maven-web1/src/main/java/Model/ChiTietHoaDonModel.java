package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Controller.MyConnect;
import Entities.ChiTietHoaDon;

public class ChiTietHoaDonModel {
	private ChiTietHoaDon cthd;
	
	public ChiTietHoaDonModel() {
		
	}

	public ChiTietHoaDonModel(ChiTietHoaDon cthd) {
		this.cthd = cthd;
	}
	
	public int insertChiTietHoaDoN() {
		int kq = 0;
		Connection cn = new MyConnect().getcn();
		if (cn == null) {
			return 0;
		}
		try {
			String sql = "insert into chitiethoadon values(?, ?, ?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, cthd.getMahd());
			ps.setString(2, cthd.getMasp());
			ps.setInt(3, cthd.getSoluong());
			kq = ps.executeUpdate();
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return kq;
	}
}
