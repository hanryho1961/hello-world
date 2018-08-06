package Model;

import java.util.ArrayList;
import java.util.HashMap;

import Entities.Item;
import Entities.Product;

public class CartModel {
	HashMap<String, Item> cart;
	
	public CartModel() {
		cart = new HashMap<>();
	}

	public CartModel(HashMap<String, Item> cart) {
		this.cart = cart;
	}

	public HashMap<String, Item> getCart() {
		return cart;
	}

	public void setCart(HashMap<String, Item> cart) {
		this.cart = cart;
	}
	
	public void addList(String masp) {
		if (cart.containsKey(masp)) {
			Item item = cart.get(masp);
			int count = item.getSoluong();
			count++;
			item.setSoluong(count);
		} else {
			Product product = new ProductModel().getProductByMasp(masp);
			Item item = new Item(product, 1);
			cart.put(masp, item);
		}
	}
	
	public void removeProduct(String masp) {
		cart.remove(masp);
	}
	
	public void removeAll() {
		cart.clear();
	}
	
	public int totalList() {
		int total = 0;
		for (Item item: cart.values()) {
			total = total + (item.getSanpham().getGiasp() * item.getSoluong());
		}
		return total;
	}
	
	public ArrayList<Item> getListItems() {
		ArrayList<Item> list = new ArrayList<>();
		for (Item i: cart.values()) {
			list.add(i);
		}
		return list;
	}
}
