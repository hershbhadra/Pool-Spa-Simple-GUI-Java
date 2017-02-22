// The Main Window displays tabs to show the main layout for program

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindow extends JFrame implements ActionListener 
{
	private JTabbedPane tabs;//The main Pane to hold tabs
    //The added tabs (panels) to JTabbedPane
    private PersonPanel vendorsPanel;
    private PersonPanel contractorPanel;
    private PoolAndSpaPanel poolPanel;
    private PoolAndSpaPanel spaPanel;
    private PersonPanel customersPanel;
    
    private JButton btn_exit;//Button to exit program
    
    public MainWindow()//Initialize the Window components
    {
        super("Devry Pool & Spas"); // set title
        setSize(400, 400); // set width for window
        setLocationRelativeTo(null); // center the screen
        setDefaultCloseOperation(EXIT_ON_CLOSE); // exit on 'X' 
        setLayout(new BorderLayout(10, 10)); // border layout as center-south-west-east-north layout with 10px gap between
        addComponents();
        }//end MainWindow

    private void addComponents()//This method add the components used in the Window
    {
        //Create the panels which are added as tabs to TabbedPane
        vendorsPanel = new PersonPanel("Vendors");
        contractorPanel = new PersonPanel("Contractors");
        customersPanel = new PersonPanel("Customers");
        poolPanel = new PoolAndSpaPanel("pool");
        spaPanel = new PoolAndSpaPanel("spa");
        
        //Create inner panel to hold the JTabbedPane in center of window
        JPanel innerPanel = new JPanel();
        innerPanel.setLayout(new BorderLayout());// border layout as center-south-west-east-north layout
        //use BorderFactory class to create empty border (empty area) around the pane
        //free space -> 5px top, 20px left, 0px bottom, 20px right
        innerPanel.setBorder(BorderFactory.createEmptyBorder(5, 20, 0, 20));
        
        tabs = new JTabbedPane();// Create the JTabbedPane and add panels as tabs to it
        tabs.add(poolPanel, "Pool", 0); // add with title and index
        tabs.add(spaPanel, "Spa", 1);
        tabs.add(customersPanel, "Customers", 2);
        tabs.add(contractorPanel, "Contractors", 3);
        tabs.add(vendorsPanel, "Vendors", 4);
        innerPanel.add(tabs);//add the JTabbedPane to innerPanel
        add(innerPanel, BorderLayout.CENTER); // place this innerPanel at center of window
        
        JPanel innerPanel2 = new JPanel();//create another innerPanel for button
        innerPanel2.setLayout(new FlowLayout(FlowLayout.CENTER)); // FlowLayout makes elements go after each other(Center flow)
        
        btn_exit = new JButton("Exit");//create and add Exit button
        btn_exit.addActionListener(this);
        innerPanel2.add(btn_exit);
        add(innerPanel2, BorderLayout.SOUTH); // add the button panel to south
        }//end addComponents

    //This method called when exit button is pressed (it's the only action in this class)
    @Override// use @override to ensure that signatures are defined correctly. Easy to trace error type with it. 
    public void actionPerformed(ActionEvent e) 
    {
        System.exit(0);//exit program
        }//end actionPerformed
    }//end class MainWindow
