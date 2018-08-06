package Entities;

public class Item {
	private Product sanpham;
	private int soluong;
	
	public Item() {
		
	}

	public Item(Product sanpham, int soluong) {
		super();
		this.sanpham = sanpham;
		this.soluong = soluong;
	}

	public Product getSanpham() {
		return sanpham;
	}

	public void setSanpham(Product sanpham) {
		this.sanpham = sanpham;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
}
