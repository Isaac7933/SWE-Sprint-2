import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FloorStatus extends JFrame {
    FloorStatus temp = this;
    //<editor-fold desc="Main Method">
    public static void main(String[] args) {
        int[] myArea = {101, 104, 109, 116, 122, 125, 130, 137}; // sample myArea
        Waiter sampleWaiter = new Waiter(1, "John Doe", 40.0f, 3, 20, myArea);
        FloorStatus floorStatus = new FloorStatus(sampleWaiter);
    }
    //</editor-fold>

    //<editor-fold desc="Variables">
    private JPanel panel;
    //</editor-fold>

    //<editor-fold desc="Constructor">
    public FloorStatus(Waiter waiter) {
        setTitle("Floor Status");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(true);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(230, 230, 230));

        JLabel titleLabel = new JLabel("Floor Status");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(800, 50, 200, 30);
        panel.add(titleLabel);

        Table[] tables = Driver.createTables();
        addTableStatusBoxes(tables, waiter);

        // Add the Logout button to the top right corner
        JButton logoutButton = new JButton("Log Out");
        logoutButton.setBackground(new Color(255, 102, 102)); // Light red color
        logoutButton.setBounds(1830, 20, 100, 20); // Adjust these values to position the button in the desired location
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current FloorStatus window
                WaiterLogin loginScreen = new WaiterLogin(); // Create a new WaiterLogin instance
            }
        });
        panel.add(logoutButton);

        getContentPane().add(panel);
        setVisible(true);

        // add row numbers
        String[] rowNumbers = {"1", "2", "3", "4", "5", "6"};
        int x = 600; // adjust the x position to center the row numbers to the left of the table
        int y = 200 + 30; // add half of the height of the table label to center the row numbers vertically
        for (String rowNumber : rowNumbers) {
            JLabel rowLabel = new JLabel(rowNumber);
            rowLabel.setHorizontalAlignment(SwingConstants.CENTER); // center the row numbers horizontally
            rowLabel.setBounds(x, y, 20, 20);
            panel.add(rowLabel);
            y += 100; // move to the next row
        }

        // add column letters
        String[] colLetters = {"A", "B", "C", "D", "E", "F"};
        x = 625;
        y = 160; // adjust the y position to center the column letters beneath the grid of tables
        for (String colLetter : colLetters) {
            JLabel colLabel = new JLabel(colLetter);
            colLabel.setHorizontalAlignment(SwingConstants.CENTER); // center the column letters horizontally
            colLabel.setBounds(x, y, 80, 20);
            panel.add(colLabel);
            x += 100; // move to the next column
        }



    }
    //</editor-fold>


    //<editor-fold desc="Method to Check if Table is a Bar Table">
    public static boolean isBarTable(int tableID) {
        int[] barTables = {197, 226, 200, 229, 205, 234, 212, 241};
        for (int id : barTables) {
            if (tableID == id) {
                return true;
            }
        }
        return false;
    }
    //</editor-fold>

    //<editor-fold desc="Method to Add Table Status Boxes">
    public void addTableStatusBoxes(Table[] tables, Waiter waiter) {
        int[] waiterArea = waiter.myArea;
        int x = 625;
        int y = 200;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                JLabel tableLabel = new JLabel();
                tableLabel.setOpaque(true);
                tableLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                tableLabel.setBounds(x, y, 80, 80);

                int tableIndex = i * 6 + j;
                Table currentTable = tables[tableIndex];
                boolean isDirty = !currentTable.isClean();
                boolean isOccupied = currentTable.isOccupied();

                if (contains(waiterArea, currentTable.getTableID())) {
                    if (isOccupied) {
                        tableLabel.setBackground(Color.RED);
                    } else if (isDirty) {
                        tableLabel.setBackground(Color.YELLOW);
                    } else {
                        tableLabel.setBackground(Color.GREEN);
                    }
                    int tableID = currentTable.getTableID();
                    tableLabel.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent e) {
                            TableGUI expandTable = new TableGUI(currentTable,temp);
                        }
                    });
                } else if (currentTable.getTableID() == 0) {
                    tableLabel.setBackground(Color.BLACK);
                } else {
                    tableLabel.setBackground(Color.GRAY);
                }

                panel.add(tableLabel);
                x += 100;
            }
            x = 625;
            y += 100;
        }
    }

    private static boolean contains(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }
}
//</editor-fold>

