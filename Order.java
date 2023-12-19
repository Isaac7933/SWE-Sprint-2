import java.util.ArrayList;

public class Order {
	private int OrderID;
	private int TableID;
	private int CustomerID;
	private Table table;
	private ArrayList<String> orderArray;

	public Order(int orderID, int tableID, int customerID) {
		this.OrderID = orderID;
		this.TableID = tableID;
		this.CustomerID = customerID;
	}

	public int getOrderID() {
		return OrderID;
	}

	public void setOrderID(int orderID) {
		OrderID = orderID;
	}

	public int getTableID() {
		return TableID;
	}

	public void setTableID(int tableID) {
		TableID = tableID;
	}

	public int getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}

	public ArrayList<String> getOrderArray() {
		return orderArray;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public Table getTable() {
		return table;
	}

	public void setOrderArray(ArrayList<String> orderArray) {
		this.orderArray = orderArray;
	}
}
