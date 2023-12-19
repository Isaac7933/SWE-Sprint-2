import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableGUI {
    private Table table;
    private JFrame tableFrame;
    private JPanel tablePanel;
    private JLabel tableIDLabel;
    private JButton checkOutButton, viewOrderButton, addItemButton, updateStatusButton;
    private FloorStatus floorStatus;
    TableGUI thisTableGui = this;

    public TableGUI(Table table) {
        this.table = table;
        createTableGUI();
    }

    public TableGUI(Table table, FloorStatus floorStatus) {
        this.table = table;
        createTableGUI();
    }

    private void createTableGUI() {
        tableFrame = new JFrame("Table " + table.getTableID());
        tableFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tableFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        tableFrame.setUndecorated(true);

        tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout());
        tablePanel.setBackground(Color.LIGHT_GRAY);

        tableIDLabel = new JLabel("Table ID: " + table.getTableID(), SwingConstants.CENTER);
        tableIDLabel.setPreferredSize(new Dimension(0, 30));

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.setBackground(Color.LIGHT_GRAY);

        GridBagConstraints centerConstraints = new GridBagConstraints();

        JPanel statusPanel = new JPanel();
        statusPanel.setPreferredSize(new Dimension(500, 500));
        updateStatusPanelColor(statusPanel);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        updateStatusPanelColor(buttonPanel);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(50, 0, 0, 0);

        checkOutButton = new JButton("Check out");
        viewOrderButton = new JButton("View Order");
        addItemButton = new JButton("Add Item");
        updateStatusButton = new JButton("Update Status");

        checkOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add your check out functionality here
            }
        });

        viewOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add your view order functionality here
            }
        });

        addItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrderGUI orderGUI = new OrderGUI(table.getOrder(), floorStatus);
                orderGUI.dispose(); // Add this line to dispose of the OrderGUI window
                Menu menu = new Menu(table.getOrder(), orderGUI, floorStatus);
            }
        });

        updateStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add your update status functionality here
            }
        });

        constraints.gridx = 0;
        constraints.gridy = 0;
        buttonPanel.add(checkOutButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        buttonPanel.add(viewOrderButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        buttonPanel.add(addItemButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        buttonPanel.add(updateStatusButton, constraints);

        statusPanel.add(buttonPanel);

        centerPanel.add(statusPanel, centerConstraints);
        tablePanel.add(centerPanel, BorderLayout.CENTER);

        // Add the Logout button to the top right corner
        JButton logoutButton = new JButton("Log Out");
        logoutButton.setBackground(new Color(255, 102, 102)); // Light red color
        logoutButton.setPreferredSize(new Dimension(100, 30));

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableFrame.dispose(); // Close the current TableGUI window
                WaiterLogin loginScreen = new WaiterLogin(); // Create a new WaiterLogin instance
            }
        });

        // Create a JPanel for the north area of the BorderLayout
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());
        northPanel.setOpaque(false);

        // Add the tableIDLabel to the left side of the northPanel
        northPanel.add(tableIDLabel, BorderLayout.WEST);

        // Create a JPanel for the Logout button on the top right corner
        JPanel topRightPanel = new JPanel();
        topRightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        topRightPanel.setOpaque(false);
        topRightPanel.add(logoutButton);

        // Add the topRightPanel to the northPanel
        northPanel.add(topRightPanel, BorderLayout.EAST);

        // Add the northPanel to the BorderLayout's NORTH area
        tablePanel.add(northPanel, BorderLayout.NORTH);
        tableFrame.add(tablePanel);
        tableFrame.setVisible(true);
    }

    private void updateStatusPanelColor(JPanel statusPanel) {
        if (table.isOccupied()) {
            statusPanel.setBackground(Color.YELLOW);
        } else if (!table.isClean()) {
            statusPanel.setBackground(Color.RED);
        } else {
            statusPanel.setBackground(Color.GREEN);
        }
    }
}