package v_builders;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class budget{

	public int  estimated_budget;
	public int  employee_budget;
	public int  budget_occurred;
	public int  foundation_budget ;
	public int base_material_budget;
	public int plumbing_budget ;
	public int   electrical_budget;
	public int  design_budget;
	public int  interior_budget ;
	public int   comissions_budget;
	public int  brokerage_budget;
	public int paymentpaid;
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new budget();
	}
	
	public budget()
	{
		JFrame frame = new JFrame("BUDGET");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Windows 11\\Downloads\\v small.png"));
	    frame.setBackground(Color.BLACK);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(1007,721);
	    frame.getContentPane().setLayout(null);
	    
	    JPanel panel = new JPanel();
	    panel.setBackground(Color.BLACK);
	    panel.setBounds(0, 0, 993, 684);
	    frame.getContentPane().add(panel);
	    panel.setLayout(null);
	    
	    
	    
	    // connecting with data base
//String username = "user_"+login.name();
	    
	    // getting database connection
	    Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        ResultSet resultSet_;
        PreparedStatement pstmt_;

        try {
            // Step 1: Establishing a connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/v_builders", "root", "I7585040714m");

            // Step 2: Create a SQL SELECT query
            String sql = "SELECT estimated_budget,employee_budget,budget_occurred,foundation_budget,base_material_budget,plumbing_budget,electrical_budget,design_budget,interior_budget,comissions_budget,brokerage_budget FROM user_jabs WHERE id = ?";
            String sql_ = "SELECT paymentpaid FROM user_jabs WHERE id = ?";
            // Step 3: Create a PreparedStatement
            pstmt = connection.prepareStatement(sql);
            pstmt_ = connection.prepareStatement(sql_);
            pstmt.setInt(1, 2); // Replace 101 with the id value you are looking for
            pstmt_.setInt(1, 4);
            // Step 4: Execute the query and retrieve the result
            resultSet = pstmt.executeQuery();
            resultSet_ = pstmt_.executeQuery();


            // Step 5: Process the ResultSet
            if (resultSet.next()) { // Check if a row is returned
               
            	estimated_budget = resultSet.getInt("estimated_budget");
            	 employee_budget = resultSet.getInt("employee_budget");
            	 budget_occurred= resultSet.getInt("budget_occurred");
            	 foundation_budget = resultSet.getInt("foundation_budget");
            	 base_material_budget  = resultSet.getInt("base_material_budget");
            	 plumbing_budget = resultSet.getInt("plumbing_budget");
            	 electrical_budget = resultSet.getInt("electrical_budget");
            	 design_budget = resultSet.getInt("design_budget");
            	 interior_budget = resultSet.getInt("interior_budget");
            	 comissions_budget = resultSet.getInt("comissions_budget");
            	 brokerage_budget  = resultSet.getInt("brokerage_budget");
            } else {
                System.out.println("No employee found with the given id.");
            }

        
        if (resultSet_.next()) { // Check if a row is returned
            
        	paymentpaid = resultSet_.getInt("paymentpaid");
        } else {
            System.out.println("No employee found with the given id.");
        }}
        catch (SQLException e) {
            e.printStackTrace();
        }
       
	    JLabel lblBudget = new JLabel("BUDGET");
	    lblBudget.setForeground(new Color(255, 255, 134));
	    lblBudget.setFont(new Font("Felix Titling", Font.BOLD, 35));
	    lblBudget.setBounds(419, 0, 193, 33);
	    panel.add(lblBudget);
	    
	    JButton back = new JButton("BACK");
	    back.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		frame.dispose();
	    		new Home_page();
	    	}
	    });
	    back.setOpaque(false);
	    back.setForeground(new Color(255, 255, 134));
	    back.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    back.setBorder(new LineBorder(new Color(255, 255, 134), 1));
	    back.setBackground(Color.BLACK);
	    back.setBounds(0, 0, 65, 15);
	    panel.add(back);
	    
	    
	    
	    //------------------------------------------------------------------------------------ ADDING DATE TO THE TOP RIGHT CORNER --------------------------------------------------------------------
	    LocalDate currentDate = LocalDate.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	    String formattedDate = currentDate.format(formatter);
	    JLabel date = new JLabel("DATE -  " + formattedDate);
	    date.setBounds(829,10,154,13);
	    date.setForeground(new Color(255, 255, 134));
	   	date.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    panel.add(date);
	    
	    JLabel vbuilders = new JLabel("© 2024 VBUILDERS INC");
	    vbuilders.setForeground(new Color(255, 255, 134));
	    vbuilders.setFont(new Font("Felix Titling", Font.BOLD, 16));
	    vbuilders.setBounds(420, 661, 236, 13);
	    panel.add(vbuilders);
	    
	    JLabel lblEstimatedBudget = new JLabel("ESTIMATED BUDGET");
	    lblEstimatedBudget.setForeground(new Color(255, 255, 134));
	    lblEstimatedBudget.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    lblEstimatedBudget.setBounds(10, 116, 143, 13);
	    panel.add(lblEstimatedBudget);
	    String new1 = Integer.toString(estimated_budget);
	    String new2 = Integer.toString(employee_budget);
	    String new3 = Integer.toString(budget_occurred);
	    String new4 = Integer.toString( foundation_budget );
	    String new5 = Integer.toString(base_material_budget);
	    String new6 = Integer.toString(plumbing_budget);
	    String new7 = Integer.toString(electrical_budget);
	    String new8 = Integer.toString( design_budget );
	    String new9 = Integer.toString(interior_budget);
	    String new10 = Integer.toString(comissions_budget );
	    String new11 = Integer.toString( brokerage_budget);
	    String new12 = Integer.toString(paymentpaid );
	    JLabel lblExample = new JLabel(new1);
	    lblExample.setForeground(new Color(255, 255, 134));
	    lblExample.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    lblExample.setBounds(262, 116, 84, 13);
	    panel.add(lblExample);
	    
	    JLabel lblBudgetOccured = new JLabel("EMPLOYEE BUDGET");
	    lblBudgetOccured.setForeground(new Color(255, 255, 134));
	    lblBudgetOccured.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    lblBudgetOccured.setBounds(10, 150, 143, 13);
	    panel.add(lblBudgetOccured);
	    
	    JLabel lblExample_1 = new JLabel(new2);
	    lblExample_1.setForeground(new Color(255, 255, 134));
	    lblExample_1.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    lblExample_1.setBounds(262, 151, 84, 13);
	    panel.add(lblExample_1);
	    
	    JLabel lblFoundationBudget = new JLabel("FOUNDATION BUDGET ");
	    lblFoundationBudget.setForeground(new Color(255, 255, 134));
	    lblFoundationBudget.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    lblFoundationBudget.setBounds(10, 221, 167, 13);
	    panel.add(lblFoundationBudget);
	    
	    JLabel lblExample_1_1 = new JLabel(new3);
	    lblExample_1_1.setForeground(new Color(255, 255, 134));
	    lblExample_1_1.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    lblExample_1_1.setBounds(262, 222, 84, 13);
	    panel.add(lblExample_1_1);
	    
	    JLabel lblBudget_1 = new JLabel("BASE MATERIALS BUDGET ");
	    lblBudget_1.setForeground(new Color(255, 255, 134));
	    lblBudget_1.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    lblBudget_1.setBounds(10, 264, 182, 13);
	    panel.add(lblBudget_1);
	    
	    JLabel lblElectricalBudget = new JLabel("ELECTRICAL BUDGET");
	    lblElectricalBudget.setForeground(new Color(255, 255, 134));
	    lblElectricalBudget.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    lblElectricalBudget.setBounds(10, 305, 167, 13);
	    panel.add(lblElectricalBudget);
	    
	    JLabel lblExample_1_1_1 = new JLabel(new4);
	    lblExample_1_1_1.setForeground(new Color(255, 255, 134));
	    lblExample_1_1_1.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    lblExample_1_1_1.setBounds(262, 264, 84, 13);
	    panel.add(lblExample_1_1_1);
	    
	    JLabel lblExample_1_1_2 = new JLabel(new5);
	    lblExample_1_1_2.setForeground(new Color(255, 255, 134));
	    lblExample_1_1_2.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    lblExample_1_1_2.setBounds(262, 306, 84, 13);
	    panel.add(lblExample_1_1_2);
	    
	    JLabel lblPlumbingBudget = new JLabel("PLUMBING BUDGET");
	    lblPlumbingBudget.setForeground(new Color(255, 255, 134));
	    lblPlumbingBudget.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    lblPlumbingBudget.setBounds(10, 347, 167, 13);
	    panel.add(lblPlumbingBudget);
	    
	    JLabel lblExample_1_1_2_1 = new JLabel(new6);
	    lblExample_1_1_2_1.setForeground(new Color(255, 255, 134));
	    lblExample_1_1_2_1.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    lblExample_1_1_2_1.setBounds(262, 348, 84, 13);
	    panel.add(lblExample_1_1_2_1);
	    
	    JLabel lblDesign = new JLabel("DESIGN ");
	    lblDesign.setForeground(new Color(255, 255, 134));
	    lblDesign.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    lblDesign.setBounds(10, 385, 167, 13);
	    panel.add(lblDesign);
	    
	    JLabel lblInterior = new JLabel("INTERIOR ");
	    lblInterior.setForeground(new Color(255, 255, 134));
	    lblInterior.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    lblInterior.setBounds(10, 428, 167, 13);
	    panel.add(lblInterior);
	    
	    JLabel lblComissions = new JLabel("COMISSIONS");
	    lblComissions.setForeground(new Color(255, 255, 134));
	    lblComissions.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    lblComissions.setBounds(10, 466, 167, 13);
	    panel.add(lblComissions);
	    
	    JLabel lblBrokerage = new JLabel("BROKERAGE");
	    lblBrokerage.setForeground(new Color(255, 255, 134));
	    lblBrokerage.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    lblBrokerage.setBounds(10, 506, 167, 13);
	    panel.add(lblBrokerage);
	    
	    JLabel lblExample_1_1_2_1_1 = new JLabel(new7);
	    lblExample_1_1_2_1_1.setForeground(new Color(255, 255, 134));
	    lblExample_1_1_2_1_1.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    lblExample_1_1_2_1_1.setBounds(262, 386, 84, 13);
	    panel.add(lblExample_1_1_2_1_1);
	    
	    JLabel lblExample_1_1_2_1_2 = new JLabel(new8);
	    lblExample_1_1_2_1_2.setForeground(new Color(255, 255, 134));
	    lblExample_1_1_2_1_2.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    lblExample_1_1_2_1_2.setBounds(262, 429, 84, 13);
	    panel.add(lblExample_1_1_2_1_2);
	    
	    JLabel lblExample_1_1_2_1_3 = new JLabel(new9);
	    lblExample_1_1_2_1_3.setForeground(new Color(255, 255, 134));
	    lblExample_1_1_2_1_3.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    lblExample_1_1_2_1_3.setBounds(262, 467, 84, 13);
	    panel.add(lblExample_1_1_2_1_3);
	    
	    JLabel lblExample_1_1_2_1_3_1 = new JLabel(new10);
	    lblExample_1_1_2_1_3_1.setForeground(new Color(255, 255, 134));
	    lblExample_1_1_2_1_3_1.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    lblExample_1_1_2_1_3_1.setBounds(262, 507, 84, 13);
	    panel.add(lblExample_1_1_2_1_3_1);
	    
	    JLabel lblBudgetOccured_1 = new JLabel("BUDGET OCCURED");
	    lblBudgetOccured_1.setForeground(new Color(255, 255, 134));
	    lblBudgetOccured_1.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    lblBudgetOccured_1.setBounds(10, 185, 143, 13);
	    panel.add(lblBudgetOccured_1);
	    
	    JLabel lblExample_1_2 = new JLabel(new11);
	    lblExample_1_2.setForeground(new Color(255, 255, 134));
	    lblExample_1_2.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    lblExample_1_2.setBounds(262, 186, 84, 13);
	    panel.add(lblExample_1_2);
	    
	    
	    int Budget = budget_occurred/estimated_budget*1000;
	    CircularProgressPanel budget = new CircularProgressPanel();
	    budget.setProgress(1);
	    budget.setBackground(Color.BLACK);
	    budget.setBounds(435, 216, 199, 195);
	    panel.add(budget);
	    Timer timer_plumb = new Timer(50, e -> {
            if (budget.getProgress() < 50) {
                budget.setProgress(budget.getProgress() + 1);
	            } else {
	                ((Timer) e.getSource()).stop(); // Stop the timer at 100%
	            }
	        });
	        timer_plumb.start();
                
                JLabel lblBudgetOccured_2 = new JLabel("BUDGET OCCURED");
                lblBudgetOccured_2.setForeground(new Color(255, 255, 134));
                lblBudgetOccured_2.setFont(new Font("Felix Titling", Font.BOLD, 13));
                lblBudgetOccured_2.setBounds(457, 163, 143, 13);
                panel.add(lblBudgetOccured_2);
                
                
                
               double Payment =  0.5 * 100;
                CircularProgressPanel payment = new CircularProgressPanel();
                payment.setProgress(1);
                payment.setBackground(Color.BLACK);
                payment.setBounds(759, 216, 199, 195);
                panel.add(payment);
                Timer timer_paid = new Timer(50, e -> {
                    if (payment.getProgress() < Payment) {
                        payment.setProgress(payment.getProgress() + 1);}
                        else {
        	                ((Timer) e.getSource()).stop(); // Stop the timer at 100%
        	            }
        	        });
        	        timer_paid.start();
                
                JLabel lblBudgetOccured_2_1 = new JLabel(" PAYMENT PAID ");
                lblBudgetOccured_2_1.setForeground(new Color(255, 255, 134));
                lblBudgetOccured_2_1.setFont(new Font("Felix Titling", Font.BOLD, 13));
                lblBudgetOccured_2_1.setBounds(802, 163, 143, 13);
                panel.add(lblBudgetOccured_2_1);
                
                
     
	    
	    
	    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	    
	    frame.setVisible(true);
	}
}
