//This program holds the layout, calculations, and fields for Pool tab and Spa tab. 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.TitledBorder;

public class PoolAndSpaPanel extends JPanel implements ActionListener 
{
	//DropDownMenu for service(pool or spa) model and shape
    private JComboBox<String> dropDown_model;
    private JComboBox<String> dropDown_shape;
    
    //RadioButtons for measurements units
    private JRadioButton rb_us;
    private JRadioButton rb_metric;

    //TextFields for calculations
    private JTextField txt_length;
    private JTextField txt_width;
    private JTextField txt_depth;

    private JButton btn_calculate;//Button to verify all details and show the result of calculations

    private JButton btn_clear;//Button to clear the fields and set others to default values

    private JLabel lbl_volume;//Display calculated volume for pool and spa

    private JLabel lbl_gunnite;//Display gunnite required

    private String type;//Hold the type of service (Spa or Pool)

    public PoolAndSpaPanel(String type)//Initialize this panel details and store type 
    {
        this.type = type;
        addComponents();
        }//end PoolAndSpaPanel

    private void addComponents()//Create and add components for this Panel 
    {
        JPanel innerPanel = new JPanel();//create panel to hold pool information
        innerPanel.setPreferredSize(new Dimension(300, 300)); // set size for panel
        innerPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // set flowlayout from Left
        //Use BorderFactory class to add Title Border with 'Enter Data Title' for this panel
        //Also add Empty Border around this panel for some spacing on corners
        innerPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(),
        		"Enter data for " + type + ":   ",
        		TitledBorder.RIGHT, TitledBorder.TOP));
        
        innerPanel.add(new JLabel("Select " + type + " model:"));//create and add pool model label and drop down menu
        dropDown_model = new JComboBox<String>(new String[]{"Model 1"}); // create the drop down and add 1 element to it
        dropDown_model.setPreferredSize(new Dimension(162, 20)); // set size for drop down menu
        innerPanel.add(dropDown_model);
        innerPanel.add(new JLabel("Select " + type + " shape:"));//create and add pool shape label and drop down menu
        dropDown_shape = new JComboBox<String>(new String[]{"Rectangular"}); // create the drop down and add 1 element to it
        dropDown_shape.setPreferredSize(new Dimension(162, 20));
        innerPanel.add(dropDown_shape);

        innerPanel.add(new JLabel("Select measurements units:"));////create and add measurements units radio buttons
        rb_us = new JRadioButton("US");
        rb_us.setSelected(true); // set default selected button to US
        rb_metric = new JRadioButton("Metric");
        ButtonGroup group = new ButtonGroup();//// group radio buttons together (select only one of them)
        group.add(rb_us); // add US to group
        group.add(rb_metric); // add Metric to group
        innerPanel.add(rb_us);
        innerPanel.add(rb_metric);
       
        innerPanel.add(new JLabel("Enter length:"));// create and add length label and text field
        txt_length = new JTextField(12); // set size with 12 cell
        innerPanel.add(txt_length);
        innerPanel.add(new JLabel("ft."));
        
        innerPanel.add(new JLabel("Enter width: "));//create and add width label and text field
        txt_width = new JTextField(12);
        innerPanel.add(txt_width);
        innerPanel.add(new JLabel("ft."));

        innerPanel.add(new JLabel("Enter depth: "));//create and add depth label and text field
        txt_depth = new JTextField(12);
        innerPanel.add(txt_depth);
        innerPanel.add(new JLabel("ft."));

        JPanel pp = new JPanel(new FlowLayout(FlowLayout.CENTER));// create and add calculate button
        pp.setPreferredSize(new Dimension(290, 35));
        btn_calculate = new JButton("Calculate");
        btn_calculate.addActionListener(this);
        pp.add(btn_calculate);
        btn_clear = new JButton("Clear");
        btn_clear.addActionListener(this);
        pp.add(btn_clear);
        innerPanel.add(pp);

        lbl_volume = new JLabel(String.format("%33s%s Volume = Gals.", "", type));
        innerPanel.add(lbl_volume);
        lbl_gunnite = new JLabel(String.format("%33sGunnite required = cu.ft.", ""));
        innerPanel.add(lbl_gunnite);

        add(innerPanel, BorderLayout.CENTER);
        }//end addComponents

    @Override// use @override to ensure that signatures are defined correctly. Easy to trace error type with it. 
    public void actionPerformed(ActionEvent e) 
    {
        JButton pressed = (JButton) e.getSource(); // get the pressed button
        if (pressed == btn_calculate)//if calculate button is pressed
        {
            double length = 0, width = 0, depth = 0;
            try 
            {
                length = Integer.parseInt(txt_length.getText());
                width = Integer.parseInt(txt_width.getText());
                depth = Integer.parseInt(txt_depth.getText());
                }//end try
            catch (NumberFormatException ex) 
            {
            	JOptionPane.showMessageDialog(this, "Enter valid length,width and depth.");
                return;
            	}//end catch
            
            //calculate volume and gunnite
            double volume = length * width * depth * 7.48052;//1 cubic foot contains 7.48 gallons of liquid 
            double gunite = (length * width + length * depth * 2 + width * depth * 2);
            //Each gunnite size is 0.12*0.24m so we convert to feet and multiply
            gunite = Math.ceil(gunite * 0.787401574803);// get top number

            lbl_volume.setText(String.format("%33s%s Volume = %1.2f Gals.", "", type, volume));
            lbl_gunnite.setText(String.format("%33sGunnite required = %1.2f cu.ft.", "", gunite));
            }//end if
        
        if (pressed == btn_clear) //if clear button is clicked
        {
            //set all to default
            dropDown_model.setSelectedIndex(0); // set first elemnt to be selected
            dropDown_shape.setSelectedIndex(0);
            rb_us.setSelected(true); // set US measurements unit to be selected
            txt_depth.setText(""); // clear text
            txt_length.setText("");// clear text
            txt_width.setText("");// clear text
            lbl_volume.setText(String.format("%33s%s Volume = Gals.", "", type)); // set to default
            lbl_gunnite.setText(String.format("%33sGunnite required = cu.ft.", ""));
        	}//end if
        }//end actionPerformed
    }//end class PoolAndSpaPanel
