/*This class takes Employee (Contractor or Vendor) details from user 
and create Employee object to be shown later in either Contractor or Vendor tab*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class EnterEmployeeData extends JFrame implements ActionListener 
{
	//TextField for Employee details
    private JTextField txt_companyName;
    private JTextField txt_address1;
    private JTextField txt_address2;
    private JTextField txt_city;
    private JTextField txt_state;
    private JTextField txt_zip;
    private JTextField txt_phone;
    private JTextField txt_contactPerson;
    private JTextField txt_products;

    private JButton btn_add;//Button to verify textFields details , add and show in Contractor or Vendor

    private JButton btn_cancel;//Button to cancel the employee add process
    private String type;//String to store the current type of employee (Vendor or Contractor)
    
    public EnterEmployeeData(String type)//Create and initialize components of this window
    {
        super("Enter New " + type + " Data"); // set title
        this.type = type; // save type
        setSize(610, 250); //size
        setLocationRelativeTo(null); // center screen
        addComponents();
    	}//end EnterEmployeeData

    private void addComponents()//Create and add the components for this window
    {
        JPanel innerPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        //Create innerPanel to hold the text fields and label in center
        
        innerPanel.add(new JLabel("Company Name:"));//add company name label and field
        txt_companyName = new JTextField(43);
        innerPanel.add(txt_companyName);
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
        innerPanel.add(new JLabel("Zip:"));//add zip code label and field
        txt_address2 = new JTextField(10);
        innerPanel.add(txt_address2);
        innerPanel.add(new JLabel("Phone:"));//add phone label and field
        txt_address2 = new JTextField(10);
        innerPanel.add(txt_address2);
        innerPanel.add(new JLabel("Contact Person:"));//add contact person label and field
        txt_contactPerson = new JTextField(43);
        innerPanel.add(txt_contactPerson);
        innerPanel.add(new JLabel("Products:"));//add Products label and field
        txt_products = new JTextField(46);
        innerPanel.add(txt_products);
      
        add(innerPanel, BorderLayout.CENTER);//add inner panel to center

        JPanel btnInnerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));//Create innerPanel to hold the buttons at south
        btnInnerPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // create empty area from bottom

        btn_add = new JButton("Add New " + type);//create and add buttons
        btn_add.addActionListener(this);
        btnInnerPanel.add(btn_add);

        btn_cancel = new JButton("Cancel");//cancel button
        btn_cancel.addActionListener(this);
        btnInnerPanel.add(btn_cancel);
       
        add(btnInnerPanel, BorderLayout.SOUTH);//add inner panel to center
        }//end addComponents

    @Override// use @override to ensure that signatures are defined correctly. Easy to trace error type with it. 
    public void actionPerformed(ActionEvent e)//Handle the buttons actions 
    {
        JButton pressed = (JButton) e.getSource(); // get pressed buttons
      
        if (pressed == btn_add) //if add button
        {
        	//**Pending code**
        	}//end if
        //if cancel, close this window
        if (pressed == btn_cancel) 
        {
            this.setVisible(false);
            }//end if
        }//end actionPerformed
    }//end class EnterEmployeeData
