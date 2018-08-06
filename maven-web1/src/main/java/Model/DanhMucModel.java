package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Controller.MyConnect;
import Entities.DanhMuc;

public class DanhMucModel {
	private DanhMuc dm;

	public DanhMucModel() {
		
	}
	
	public DanhMucModel(DanhMuc dm) {
		this.dm = dm;
	}
	
	public ArrayList<DanhMuc> getList() {
		ArrayList<DanhMuc> list = new ArrayList<>();
		Connection cn = new MyConnect().getcn();
		if (cn == null) {
			return null;
		}
		try {
			String sql = "select * from danhmuc";
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DanhMuc temp = new DanhMuc(rs.getString(1), rs.getString(2));
				list.add(temp);
			}
			ps.close();
			cn.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return list;
	}
	
	public DanhMuc getListById(String madm) {
		DanhMuc dm = null;
		Connection cn = new MyConnect().getcn();
		if (cn == null) {
			return null;
		}
		try {
			String sql = "select * from danhmuc where MADM=?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, madm);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				dm = new DanhMuc(rs.getString(1), rs.getString(2));
			}
			ps.close();
			cn.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return dm;
	}
	
	public int insert() {
		int kq = 0;
		Connection cn = new MyConnect().getcn();
		if (cn == null) {
			return 0;
		}
		try {
			String sql = "insert into danhmuc values(?, ?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, dm.getMadm());
			ps.setString(2, dm.getTendm());
			kq = ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return kq;
	}
	
	public int update() {
		int kq = 0;
		Connection cn = new MyConnect().getcn();
		if (cn == null) {
			return 0;
		}
		try {
			String sql = "update danhmuc set TENDM=? where MADM=?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, dm.getTendm());
			ps.setString(2, dm.getMadm());
			kq = ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return kq;
	}
	
	public int clearList() {
		int kq = 0;
		Connection cn = new MyConnect().getcn();
		if (cn == null) {
			return 0;
		}
		try {
			String sql = "delete from danhmuc";
			PreparedStatement ps = cn.prepareStatement(sql);
			kq = ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return kq;
	}
	
	public int deletePart(String madm) {
		int kq = 0;
		Connection cn = new MyConnect().getcn();
		if (cn == null) {
			return 0;
		}
		try {
			String sql = "delete from danhmuc where MADM=?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, madm);
			kq = ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return kq;
	}
}
