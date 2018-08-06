package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Controller.MyConnect;
import Entities.Account;

public class AccountModel {
	private Account acc;
	
	public AccountModel() {
		
	}

	public AccountModel(Account acc) {
		super();
		this.acc = acc;
	}
	
	public ArrayList<Account> getList() {
		ArrayList<Account> list = new ArrayList<>();
		Connection cn = new MyConnect().getcn();
		if (cn == null) {
			return null;
		}
		String sql = "select * from account";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Account temp = new Account(rs.getString(1), rs.getString(2));
				list.add(temp);
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return list;
	}
}
