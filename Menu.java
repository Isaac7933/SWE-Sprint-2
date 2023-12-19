import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.cert.TrustAnchor;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Menu extends JFrame implements ActionListener{
	JLabel item1, item2, item3, item4;
	JButton add1, add2, add3, add4;
	String itemName1, itemName2, itemName3, itemName4;
	ArrayList<String> orderArr;
	FloorStatus floorStatus;
	Menu thisMenu = this;
	TableGUI table;
	Order order;



	public Menu(Order order, OrderGUI orderGUI, FloorStatus floorStatus) {
		this.setTitle("Menu");
		this.order = order;
		this.floorStatus = floorStatus;
		orderArr = order.getOrderArray();
		//Gets rid of previous menu
		orderGUI.setVisible(true);
		//Allows access to category in Order class
		String orderType = OrderGUI.category;
		this.setLayout(new GridBagLayout());
		this.setSize(500, 500);
		//Keep blank Menu window invisible
		this.setVisible(false);
		//If the category selected in the previous menu is Appetizers displays appetizers
		if(orderType.equals("Appetizers")) {
			this.setVisible(true);
			itemName1 = "Chips & Dip";
			item1 = new JLabel(itemName1);
			itemName2 = "Buffalo Blue Chips";
			item2 = new JLabel(itemName2);
			itemName3 = "Chicken Nachos";
			item3 = new JLabel(itemName3);
			itemName4 = "Pork Nachos";
			item4 = new JLabel(itemName4);
		}
		//If the category selected in the previous menu is Salads displays salads
		if(orderType.equals("Salads")) {
			this.setVisible(true);
			itemName1 = "House Salads";
			item1 = new JLabel(itemName1);
			itemName2 = "Wedge Salad";
			item2 = new JLabel(itemName2);
			itemName3 = "Caeser Salad";
			item3 = new JLabel(itemName3);
			itemName4 = "Sweet Potato Chicken Salad";
			item4 = new JLabel(itemName4);
		}
		//If the category selected in the previous menu is Burgers displays burgers
		if(orderType.equals("Burgers")) {
			this.setVisible(true);
			itemName1 = "J's Burger";
			item1 = new JLabel(itemName1);
			itemName2 = "Bacon Cheeseburger";
			item2 = new JLabel(itemName2);
			itemName3 = "Mushroom Swiss Burger";
			item3 = new JLabel(itemName3);
			itemName4 = "Carolina Burger";
			item4 = new JLabel(itemName4);
		}
		//If the category selected in the previous menu is Sandwiches displays sandwiches
		if(orderType.equals("Sandwiches")) {
			this.setVisible(true);
			itemName1 = "Grilled Cheese";
			item1 = new JLabel(itemName1);
			itemName2 = "100% Beef Hot Dog";
			item2 = new JLabel(itemName2);
			itemName3 = "Chicken BLT & A";
			item3 = new JLabel(itemName3);
			itemName4 = "Cordon Bleu";
			item4 = new JLabel(itemName4);
		}
		//If the category selected in the previous menu is Wraps displays wraps
		if(orderType.equals("Wraps")) {
			this.setVisible(true);
			itemName1 = "Club Wrap";
			item1 = new JLabel(itemName1);
			itemName2 = "Chickem BLT Wrap";
			item2 = new JLabel(itemName2);
			itemName3 = "Veggie Wrap";
			item3 = new JLabel(itemName3);
			itemName4 = "Chicken Ceaser Wrap";
			item4 = new JLabel(itemName4);
		}
		GridBagConstraints gbc = new GridBagConstraints();  
		//Handles item 1 and the button associated with it
		item1.setPreferredSize(new Dimension(250,50));
		gbc.gridy = 0;
		this.add(item1, gbc);
		add1 = new JButton("Add");
		add1.addActionListener(this);
		add1.setBackground(Color.white);
		this.add(add1);
		//Handles item 2 and the button associated with it
		item2.setPreferredSize(new Dimension(250,50));
		gbc.gridy = 1;
		this.add(item2, gbc);
		add2 = new JButton("Add");
		add2.addActionListener(this);
		add2.setBackground(Color.white);
		this.add(add2, gbc);
		//Handles item 3 and the button associated with it
		item3.setPreferredSize(new Dimension(250,50));
		gbc.gridy = 2;
		this.add(item3, gbc);
		add3 = new JButton("Add");
		add3.addActionListener(this);
		add3.setBackground(Color.white);
		this.add(add3, gbc);
		//Handles item 4 and the button associated with it
		item4.setPreferredSize(new Dimension(250,50));
		gbc.gridy = 3;
		this.add(item4, gbc);
		add4 = new JButton("Add");
		add4.addActionListener(this);
		add4.setBackground(Color.white);
		this.add(add4, gbc);

	}

	public void disposeMenu()
	{

		//thisMenu.setVisible(false);
		this.dispose();
		TableGUI table = new TableGUI(order.getTable());
	}



	public void actionPerformed(ActionEvent e) {	
		if (e.getSource() == add1) {
			//Adds to arraylist
			disposeMenu();

		}
		if (e.getSource() == add2) {
			//Adds to arraylist
			orderArr.add(itemName2);
			//Put a call to go back to table specific page
			//Disposes this page
			disposeMenu();

		}
		if (e.getSource() == add3) {
			//Adds to arraylist
			orderArr.add(itemName3);
			//Put a call to go back to table specific page
			//Disposes this page
			disposeMenu();

		}
		if (e.getSource() == add4) {
			//Adds to arraylist
			orderArr.add(itemName4);
			//Put a call to go back to table specific page
			//Disposes this page
			disposeMenu();

		}

	}
}
