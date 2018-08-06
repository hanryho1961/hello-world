package Entities;

public class HoaDon {
	private int mahd;
	private String ngayhd;
	
	private HoaDon() {
		
	}

	public HoaDon(int mahd, String ngayhd) {
		this.mahd = mahd;
		this.ngayhd = ngayhd;
	}

	public int getMahd() {
		return mahd;
	}

	public void setMahd(int mahd) {
		this.mahd = mahd;
	}

	public String getNgayhd() {
		return ngayhd;
	}

	public void setNgayhd(String ngayhd) {
		this.ngayhd = ngayhd;
	}
}
