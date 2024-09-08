package com.samfoods.model;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class Cart {
	
	LinkedHashMap<Integer,CartItem> items = new LinkedHashMap<Integer,CartItem> ();
	
	
	// Method to add an item to the cart
    public void addItem(CartItem item) {
        int menuId = item.getMenuId();
        
        // If item already exists, update the quantity and subtotal
        if (items.containsKey(menuId)) {
            CartItem existingItem = items.get(menuId);
            existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
            existingItem.setSubTotal((int)(existingItem.getPrice() * existingItem.getQuantity()));
        } else {
            // Calculate the subtotal for the new item
            item.setSubTotal((int)(item.getPrice() * item.getQuantity()));
            // Add the new item to the cart
            items.put(menuId, item);
        }
    }
	
	
	
	public void updateItem(int menuId, int quantity) {
		if (items.containsKey(menuId)) {
            CartItem item = items.get(menuId);
            if (quantity <= 0) {
                // Remove item if quantity is zero or less
                items.remove(menuId);
            } else {
                // Update quantity and subtotal
                item.setQuantity(quantity);
                item.setSubTotal((int)(item.getPrice() * quantity));
            }
        }
		
	}
	
	
	public void removeItem(int menuId) {
		items.remove(menuId);
	}
	
	
	public LinkedHashMap<Integer,CartItem> getItems(){
		return items;
	}
	
	public void clear() {
		items.clear();
	}
	
	// Method to get a string representation of the cart
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Entry<Integer, CartItem> entry : items.entrySet()) {
            sb.append(entry.getValue().toString()).append("\n");
        }
        sb.append("Total Price: ").append(getTotalPrice());
        return sb.toString();
    }



    public double getTotalPrice() {
        double total = 0;
        for (CartItem item : items.values()) {
            total += item.getSubTotal();
        }
        return total;
    }

}
