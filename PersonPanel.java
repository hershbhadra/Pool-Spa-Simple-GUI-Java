//This program holds the main panel for people; customers, employees, contractors, and vendors. 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PersonPanel extends JPanel implements ActionListener 
{
	private JTextArea txt_contractors;
    //Display Person Information depending on the tab opened in (could be Customer, Vendor or Contractor Informations)

	private JButton btn_add;//Open another window to prompt user to enter Person details
    private String type;//Save the current type for object created from this class

    public PersonPanel(String type)//initialize this window and save the type of person
    {
    	this.type = type;
        addComponents();
    	}//end PersonalPanel

    private void addComponents()//Create and add components to this panel
    {
        //create and add text area
        txt_contractors = new JTextArea(13, 26); // read and set number of rows and columns
        JScrollPane scrol = new JScrollPane(txt_contractors); // add scroll to handle big data
        add(scrol, BorderLayout.CENTER); // add to center of panel
        //create jpanel to place at south 
        // make layout for this panel flow with center flowing
        JPanel innerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Flow from center
        btn_add = new JButton("Add " + type);//create and add button
        btn_add.addActionListener(this); // add action to fire when button pressed
        innerPanel.add(btn_add); // add button to this inner panel
        add(innerPanel, BorderLayout.SOUTH); //add panel to bottom of the main panel
        }//end addComponents

    @Override// use @override to ensure that signatures are defined correctly. Easy to trace error type with it. 
    public void actionPerformed(ActionEvent e)//Handle Button action (we have one button only)
    {
        
        if (type.equals("Contractors") || type.equals("Vendors"))//if type is employee(contractor or vendor) 
        {
        	new EnterEmployeeData(type).setVisible(true); // open employee data window
        	}//end if
        if (type.equals("Customers"))//if type is customer 
        {
            new EnterCustomerData().setVisible(true); // open customer data window
        	}//end if
        }//end actionPerformed
    }//end class PersonPanel
