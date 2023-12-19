public class Waiter extends Worker {
    private String name;
    private float hoursWorked;
    private int currentlyServing;
    private int tablesServed;
    public int[] myArea;

    public Waiter(int id, String name, float hoursWorked, int currentlyServing, int tablesServed, int[] area) {
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.currentlyServing = currentlyServing;
        this.tablesServed = tablesServed;
        this.myArea = area;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(float hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public int getCurrentlyServing() {
        return currentlyServing;
    }

    public void setCurrentlyServing(int currentlyServing) {
        this.currentlyServing = currentlyServing;
    }

    public int getTablesServed() {
        return tablesServed;
    }

    public void setTablesServed(int tablesServed) {
        this.tablesServed = tablesServed;
    }

    public void sendOrder(Order order) {
        // send order to the cooks
    }
}
