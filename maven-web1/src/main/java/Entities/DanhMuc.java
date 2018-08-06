package Entities;

public class DanhMuc {
	private String madm;
	private String tendm;
	
	public DanhMuc() {
		
	}

	public DanhMuc(String madm, String tendm) {
		this.madm = madm;
		this.tendm = tendm;
	}

	public String getMadm() {
		return madm;
	}

	public void setMadm(String madm) {
		this.madm = madm;
	}

	public String getTendm() {
		return tendm;
	}

	public void setTendm(String tendm) {
		this.tendm = tendm;
	}
}	
