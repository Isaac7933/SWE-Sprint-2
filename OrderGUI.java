import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;

public class OrderGUI extends JFrame implements ActionListener {
    private Order order;
    private JButton categoryType1, categoryType2, categoryType3, categoryType4, categoryType5;
    public static String category;
    private FloorStatus floorStatus;
    public OrderGUI(Order order, FloorStatus floorStatus) {
        this.order = order;
        this.floorStatus = floorStatus;
        this.setTitle("Order GUI");
        this.getRootPane().setBorder((
                BorderFactory.createEmptyBorder(40, 40, 40, 40)));
        this.setLayout(new GridLayout(5, 1, 10, 10));
        this.setSize(500, 500);
        // Initializes button
        categoryType1 = new JButton("Appetizers");
        categoryType2 = new JButton("Salads");
        categoryType3 = new JButton("J's Favorites");
        categoryType4 = new JButton("Sandwiches");
        categoryType5 = new JButton("Wraps");
        // Changes button's background color
        categoryType1.setBackground(Color.white);
        categoryType2.setBackground(Color.white);
        categoryType3.setBackground(Color.white);
        categoryType4.setBackground(Color.white);
        categoryType5.setBackground(Color.white);
        // Adds button to the frame
        this.add(categoryType1);
        this.add(categoryType2);
        this.add(categoryType3);
        this.add(categoryType4);
        this.add(categoryType5);
        // Adds Action Listener so button can be used
        categoryType1.addActionListener(this);
        categoryType2.addActionListener(this);
        categoryType3.addActionListener(this);
        categoryType4.addActionListener(this);
        categoryType5.addActionListener(this);
        // Makes frame visible
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Checks which button is pressed and stores it to the variable category
        // Checks which button is pressed and stores it to the variable category
        if (e.getSource() == categoryType1) {
            category = "Appetizers";
            dispose(); // Dispose of the OrderGUI window
            new Menu(order, this, floorStatus); // Pass the current instance
        } else if (e.getSource() == categoryType2) {
            category = "Salads";
            dispose(); // Dispose of the OrderGUI window
            new Menu(order, this, floorStatus); // Pass the current instance
        } else if (e.getSource() == categoryType3) {
            category = "Burgers";
            dispose(); // Dispose of the OrderGUI window
            new Menu(order, this, floorStatus); // Pass the current instance
        } else if (e.getSource() == categoryType4) {
            category = "Sandwiches";
            dispose(); // Dispose of the OrderGUI window
            new Menu(order, this, floorStatus); // Pass the current instance
        } else if (e.getSource() == categoryType5) {
            category = "Wraps";
            dispose(); // Dispose of the OrderGUI window
            new Menu(order, this, floorStatus); // Pass the current instance
        }
    }

}