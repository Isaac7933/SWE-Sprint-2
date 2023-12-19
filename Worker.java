public class Worker {
    private int id;
    private String name;
    private float hoursWorked;
    private String type;

    public Worker() {
        // default constructor
    }

    public Worker(int id, String name, float hoursWorked, String type) {
        this.id = id;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.type = type;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHours() {
        return hoursWorked;
    }

    public void setHours(float hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
