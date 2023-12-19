import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WaiterLogin extends JFrame implements ActionListener {
    private JLabel userLabel, passLabel, titleLabel;
    private JTextField userText;
    private JPasswordField passText;
    private JButton loginButton;

    public WaiterLogin() {
        //<editor-fold desc="GUI specifications for Waiter Login">
        setTitle("Waiter Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(true);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(171, 169, 169)); // sets the background color to light gray

        titleLabel = new JLabel("Login");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(880, 150, 80, 30);
        panel.add(titleLabel);

        userLabel = new JLabel("Username:");
        userLabel.setBounds(820, 220, 80, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(910, 220, 165, 25);
        panel.add(userText);

        passLabel = new JLabel("Password:");
        passLabel.setBounds(820, 270, 80, 25);
        panel.add(passLabel);

        passText = new JPasswordField(20);
        passText.setBounds(910, 270, 165, 25);
        panel.add(passText);

        loginButton = new JButton("Login");
        loginButton.setBounds(950, 320, 80, 25);
        loginButton.addActionListener(this);
        panel.add(loginButton);

        getContentPane().add(panel);
        setVisible(true);
        //</editor-fold>
    }

    public void actionPerformed(ActionEvent e) {
        String username = userText.getText();
        String password = new String(passText.getPassword());
        Waiter waiter = null;

        switch (username) {
            case "712345683":
                if (password.equals("123")) {
                    int[] myArea1 = {101, 226, 125, 229, 205, 241, 180};
                    waiter = new Waiter(712345683, "Tom", 20.0f, 5, 12, myArea1);
                }
                break;
            case "712345684":
                if (password.equals("waiter2password")) {
                    int[] myArea2 = {122, 200, 130, 234, 137, 250, 205};
                    waiter = new Waiter(712345684, "Emily", 30.5f, 3, 9, myArea2);
                }
                break;
            case "512345685":
                if (password.equals("waiter3password")) {
                    int[] myArea3 = {197, 104, 109, 212, 146, 169, 232, 261};
                    waiter = new Waiter(512345685, "David", 45.25f, 23, 0, myArea3);
                }
                break;
        }

        if (waiter != null) {
            dispose();
            FloorStatus floorStatus = new FloorStatus(waiter);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password.");
        }
    }


    public static void main(String[] args) {
        WaiterLogin waiterLogin = new WaiterLogin();
    }
}
