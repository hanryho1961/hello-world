package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Controller.MyConnect;
import Entities.HoaDon;

public class HoaDonModel {
	private HoaDon hoadon;

	public HoaDonModel() {
		
	}
	
	public HoaDonModel(HoaDon hoadon) {
		this.hoadon = hoadon;
	}
	
	public int insertHoaDon() {
		int kq = 0;
		Connection cn = new MyConnect().getcn();
		if (cn == null) {
			return 0;
		}
		try {
			String sql = "insert into hoadon values(null, ?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, hoadon.getNgayhd());
			kq = ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return kq;
	}
	
	public int getNewestIdHoaDon() {
		int maxID = 0;
		Connection cn = new MyConnect().getcn();
		if (cn == null) {
			return 0;
		}
		try {
			String sql = "select max(MAHD) from hoadon";
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				maxID = rs.getInt(1);
			}
			ps.close();
			rs.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return maxID;
	}
}
