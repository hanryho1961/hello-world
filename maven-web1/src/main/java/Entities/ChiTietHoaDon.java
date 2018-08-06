package Entities;

public class ChiTietHoaDon {
	private int mahd;
	private String masp;
	private int soluong;
	
	public ChiTietHoaDon() {
		
	}

	public ChiTietHoaDon(int mahd, String masp, int soluong) {
		this.mahd = mahd;
		this.masp = masp;
		this.soluong = soluong;
	}

	public int getMahd() {
		return mahd;
	}

	public void setMahd(int mahd) {
		this.mahd = mahd;
	}

	public String getMasp() {
		return masp;
	}

	public void setMasp(String masp) {
		this.masp = masp;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
}
