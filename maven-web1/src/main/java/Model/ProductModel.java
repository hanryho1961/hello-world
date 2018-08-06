package Model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Part;

import Controller.MyConnect;
import Entities.Product;

public class ProductModel {
	private Product product;
	private Part file;
	
	public ProductModel() {
		
	}
	
	public ProductModel(Part file) {
		this.file = file;
	}

	public ProductModel(Product product) {
		super();
		this.product = product;
	}
	
	public ArrayList<Product> getList() {
		ArrayList<Product> list = new ArrayList<>();
		Connection cn = new MyConnect().getcn();
		if (cn == null) {
			return null;
		}
		try {
			String sql = "select * from sanpham";
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product temp = new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
				list.add(temp);
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return list;
	}
	
	public Product getProductByMasp(String masp) {
		Product temp = null;
		Connection cn = new MyConnect().getcn();
		if (cn == null) {
			return null;
		}
		try {
			String sql = "select * from sanpham where MASP like ?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, masp);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				temp = new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return temp;
	}
	
	public ArrayList<Product> getProductByMadm(String madm) {
		ArrayList<Product> list = new ArrayList<>();
		Connection cn = new MyConnect().getcn();
		if (cn == null) {
			return null;
		}
		try {
			String sql = "select * from sanpham where MADM like ?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, madm);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product temp = new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
				list.add(temp);
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return list;
	}
	
	public String getFileName(Part filepart) {
		 String filename="";
	     String header = filepart.getHeader("Content-Disposition");
	     //System.out.println("header:" + header);
	     int beginIndex = header.lastIndexOf("=");
	     filename = header.substring(beginIndex+1);
	                    
	     //remove "" quotes 2 dau chuoi
	     Pattern p = Pattern.compile("\"([^\"]*)\"");
	     Matcher m = p.matcher(filename);
	     while (m.find()) 
	            filename = m.group(1);
	                    
	     //danh cho IE 
	     beginIndex = filename.lastIndexOf("\\");
	     filename = filename.substring(beginIndex+1);
	     //System.out.println("filename:" + filename);
	 
	     return filename;
	}
	
	public void uploadFile(String uploadRootPath) {
		try
		{
		     InputStream fis = file.getInputStream();
		     byte[]data = new byte[fis.available()];
		     fis.read(data);
		                        
		     FileOutputStream out = new FileOutputStream(new File( uploadRootPath + "\\" + getFileName(file)));
		     out.write(data);
		                        
		     out.close();
		}
		catch(IOException e)
		{
		     e.printStackTrace();
		     System.out.println("That bai");
		     return;
		}
		System.out.println("Thanh cong");
	}
	
	public int insertProduct() {
		Connection cn = new MyConnect().getcn();
		int kq = 0;
		if (cn == null) {
			return 0;
		}
		try {
			String sql = "insert into sanpham values(?, ?, ?, ?, ?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, product.getMasp());
			ps.setString(2, product.getTensp());
			ps.setInt(3, product.getGiasp());
			ps.setString(4, product.getHinhsp());
			ps.setString(5, product.getMadm());
			kq = ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return kq;
	}
	
	public int updateProduct() {
		Connection cn = new MyConnect().getcn();
		int kq = 0;
		if (cn == null) {
			return 0;
		}
		try {
			String sql = "update sanpham set TENSP=?, GIASP=?, HINHSP=?, MADM=? where MASP=?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, product.getTensp());
			ps.setInt(2, product.getGiasp());
			ps.setString(3, product.getHinhsp());
			ps.setString(4, product.getMadm());
			ps.setString(5, product.getMasp());
			kq = ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return kq;
	}
	
	public int clearList() {
		Connection cn = new MyConnect().getcn();
		int kq = 0;
		if (cn == null) {
			return 0;
		}
		try {
			String sql = "delete from sanpham";
			PreparedStatement ps = cn.prepareStatement(sql);
			kq = ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return kq;
	}
	
	public int deletePart(String masp) {
		Connection cn = new MyConnect().getcn();
		int kq = 0;
		if (cn == null) {
			return 0;
		}
		try {
			String sql = "delete from sanpham where MASP=?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, masp);
			kq = ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return kq;
	}
}
