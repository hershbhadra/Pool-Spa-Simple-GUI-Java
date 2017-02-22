//This program takes input from users and creates customer object to be shown later in customer tab in main window

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class EnterCustomerData extends JFrame implements ActionListener 
{
	//JTextFields for Customer Information
	private JTextField txt_firstName;
    private JTextField txt_lastName;
    private JTextField txt_address1;
    private JTextField txt_address2;
    private JTextField txt_city;
    private JTextField txt_state;
    private JTextField txt_zip;
    private JTextField txt_phone;
    private JButton btn_add;//Verify all TextFields and show customers details in Customer tab
    private JButton btn_cancel;//Cancel the add process

    public EnterCustomerData()//initialize the window components and constraints 
    {
        super("Enter New Customer Data"); // set title for window
        setSize(610, 200); // set size
        setLocationRelativeTo(null); // center screen
        addComponents();
        }//end EnterCustomerData

    private void addComponents() //Create and add components to this window
    {
    	JPanel innerPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
    	//Create innerPanel to hold the text fields and label in center

        innerPanel.add(new JLabel("First Name:"));//add first name label and field
        txt_firstName = new JTextField(18);
        innerPanel.add(txt_firstName);
        innerPanel.add(new JLabel("Last Name:"));//add last name label and field
        txt_lastName = new JTextField(19);
        innerPanel.add(txt_lastName);
        innerPanel.add(new JLabel("Street Address:"));//add street address label and field
        txt_address1 = new JTextField(43);
        innerPanel.add(txt_address1);
        innerPanel.add(new JLabel("Address line 2:"));//add street address2 label and field
        txt_address2 = new JTextField(44);
        innerPanel.add(txt_address2);
        innerPanel.add(new JLabel("City:"));//add city label and field
        txt_address2 = new JTextField(12);
        innerPanel.add(txt_address2);
        innerPanel.add(new JLabel("State:"));//add state label and field
        txt_address2 = new JTextField(5);
        innerPanel.add(txt_address2);
        innerPanel.add(new JLabel("Zip:"));//add zip label and field
        txt_address2 = new JTextField(10);
        innerPanel.add(txt_address2);
        innerPanel.add(new JLabel("Phone:"));//add phone label and field
        txt_address2 = new JTextField(10);
        innerPanel.add(txt_address2);
        
        add(innerPanel, BorderLayout.CENTER);//add inner panel to center

        //Create innerPanel to hold the buttons at Center
        JPanel btnInnerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnInnerPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // create empty area from bottom
        btn_add = new JButton("Add New Customer");//create and add buttons
        btn_add.addActionListener(this);
        btnInnerPanel.add(btn_add);
        btn_cancel = new JButton("Cancel");//cancel button
        btn_cancel.addActionListener(this);
        btnInnerPanel.add(btn_cancel);
        add(btnInnerPanel, BorderLayout.SOUTH);//add inner panel to south
        }//end addComponents
    
    @Override// use @override to ensure that signatures are defined correctly. Easy to trace error type with it. 
    public void actionPerformed(ActionEvent e)//Handle button actions
    {
        JButton pressed = (JButton) e.getSource(); // get pressed button
        if (pressed == btn_add)//if add, (handled later) 
        {
            //handled later
        	}//end if
        
        if (pressed == btn_cancel)//if cancel, close and end this window 
        {
            this.setVisible(false);
            }//end if
        }//end actionPerformed
    }//end class EnterCustomerData
