public class Table {
    private int tableID;
    private int orderID;
    private Order order;
    private boolean occupiedStatus;
    private boolean cleanStatus;
    private Customer customer;

    public Table(int tableID, Order orderObj, boolean occupiedStatus, boolean cleanStatus) {
        this.tableID = tableID;
        order = orderObj;
        order.setTable(this);
        orderID = order.getOrderID();
        this.occupiedStatus = occupiedStatus;
        this.cleanStatus = cleanStatus;
    }

    public int getTableID() {
        return tableID;
    }

    public Order getOrder() {
        return order;
    }

    public int getOrderID() {
        return orderID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public boolean isOccupied() {
        return occupiedStatus;
    }

    public void setOccupied(boolean occupied) {
        this.occupiedStatus = occupied;
    }

    public boolean isClean() {
        return cleanStatus;
    }

    public void setClean(boolean clean) {
        this.cleanStatus = clean;
    }
}
