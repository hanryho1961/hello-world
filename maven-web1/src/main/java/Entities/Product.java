package Entities;

public class Product {
	private String masp;
	private String tensp;
	private int giasp;
	private String hinhsp;
	private String madm;
	
	public Product() {
		
	}

	public Product(String masp, String tensp, int giasp, String hinhsp) {
		this.masp = masp;
		this.tensp = tensp;
		this.giasp = giasp;
		this.hinhsp = hinhsp;
	}

	
	public Product(String masp, String tensp, int giasp, String hinhsp, String madm) {
		this.masp = masp;
		this.tensp = tensp;
		this.giasp = giasp;
		this.hinhsp = hinhsp;
		this.madm = madm;
	}

	public String getMasp() {
		return masp;
	}

	public void setMasp(String masp) {
		this.masp = masp;
	}

	public String getTensp() {
		return tensp;
	}

	public void setTensp(String tensp) {
		this.tensp = tensp;
	}

	public int getGiasp() {
		return giasp;
	}

	public void setGiasp(int giasp) {
		this.giasp = giasp;
	}

	public String getHinhsp() {
		return hinhsp;
	}

	public void setHinhsp(String hinhsp) {
		this.hinhsp = hinhsp;
	}

	public String getMadm() {
		return madm;
	}

	public void setMadm(String madm) {
		this.madm = madm;
	}
}
