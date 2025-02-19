package v_builders;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class progress {

	public String StartDate;
	public String EstimatedCompletion;
	public int BudgetOccurred;
	public int EstimatedManpower;
	public int ManpowerUsed;
	public String MaterialsUsed;
	public int BuildingStructure;
	public int Plumbing;
	public int Electrical;
	public int Interior;
	public String username;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		new progress();
	}

	/**
	 * Create the frame.
	 */
	public progress() 
	{
		JFrame frame = new JFrame("PROFILE");
	    frame.setBackground(Color.WHITE);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(1285,779);
	    frame.getContentPane().setLayout(null);
	    
	    JPanel panel = new JPanel();
	    panel.setBackground(Color.BLACK);
	    panel.setBounds(-10, 10, 1271, 742);
	    frame.getContentPane().add(panel);
	    panel.setLayout(null);
	    
//String //username_ = login.name();
	    
	    // getting database connection
	    Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Establishing a connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/v_builders", "root", "I7585040714m");

            // Step 2: Create a SQL SELECT query
            String sql = "SELECT StartDate,EstimatedCompletion,BudgetOccurred,EstimatedManPower,ManPowerUsed,MaterialsUsed,BuildingStructure,Plumbing,Electrical,Interior FROM progress WHERE BudgetOccurred = ?";
           
            // Step 3: Create a PreparedStatement
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, 9000000); // Replace 101 with the id value you are looking for

            // Step 4: Execute the query and retrieve the result
            resultSet = pstmt.executeQuery();

            // Step 5: Process the ResultSet
            if (resultSet.next()) { // Check if a row is returned
               
            	 StartDate = resultSet.getString("StartDate");
            	 EstimatedCompletion = resultSet.getString("EstimatedCompletion");
//            	 SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//                 String formattedDate = sdf.format(StartDate);
//                 String formattedDate2 = sdf.format(EstimatedCompletion);
            	
            	 BudgetOccurred = resultSet.getInt("BudgetOccurred");
            	 EstimatedManpower = resultSet.getInt("EstimatedManpower");
            	 ManpowerUsed = resultSet.getInt("ManpowerUsed");
            	 MaterialsUsed  = resultSet.getString("MaterialsUsed");
            	 BuildingStructure = resultSet.getInt("BuildingStructure");
            	 Plumbing = resultSet.getInt("Plumbing");
            	 Electrical = resultSet.getInt("Electrical");
            	Interior = resultSet.getInt("Interior");
            	
            } else {
                System.out.println("No employee found with the given id.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        // typecasting string to integers
        
        
	    
	    JLabel progress = new JLabel("PROGRESS");
	    progress.setBounds(556, 10, 203, 31);
	    progress.setForeground(new Color(255, 255, 134));
		progress.setFont(new Font("Felix Titling", Font.BOLD, 35));
	    panel.add(progress);
	    
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
	    
	    //------------------------------------------------------ date in the top right corner---------------------------------------------------------------------------------------------------------
	    

	    LocalDate currentDate = LocalDate.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	    String formattedDate = currentDate.format(formatter);
	    JLabel date = new JLabel("DATE -  " + formattedDate);
	    date.setBounds(1117,10,154,13);
	    date.setForeground(new Color(255, 255, 134));
	   	date.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    panel.add(date);
	    
	    

	    //-------------------------------------------------------------------------------------------end of adding the time in the top right corner ----------------------------------------------
	    
	    
	    CircularProgressPanel progressPanel = new CircularProgressPanel();
	    progressPanel.setBackground(Color.BLACK);
	    progressPanel.setSize(192, 164);
	    progressPanel.setLocation(43, 526);
        panel.add(progressPanel);
        Timer timer_ = new Timer(50, e -> {
            if (progressPanel.getProgress() < BuildingStructure) {
                progressPanel.setProgress(progressPanel.getProgress() + 1);
                
                
            } else {
                ((Timer) e.getSource()).stop(); // Stop the timer at 100%
            }
        });
        timer_.start();

        // Timer to simulate progress
        
        JLabel level = new JLabel("BUILDING STRUCTURE");
        level.setBounds(43, 470, 203, 13);
        level.setForeground(new Color(255, 255, 134));
		level.setFont(new Font("Felix Titling", Font.BOLD, 13));
        
        panel.add(level);
        
        JLabel start = new JLabel("START DATE");
        start.setBounds(43, 151, 84, 13);
        start.setForeground(new Color(255, 255, 134));
		start.setFont(new Font("Felix Titling", Font.BOLD, 13));
        panel.add(start);
        
        JLabel st_date = new JLabel(StartDate);
        st_date.setBounds(410, 151, 78, 13);
        st_date.setForeground(new Color(255, 255, 134));
		st_date.setFont(new Font("Felix Titling", Font.BOLD, 13));
        panel.add(st_date);
        
        JLabel lblEndDate = new JLabel("ESTIMATED COMPLETION");
        lblEndDate.setForeground(new Color(255, 255, 134));
        lblEndDate.setFont(new Font("Felix Titling", Font.BOLD, 13));
        lblEndDate.setBounds(43, 196, 168, 13);
        panel.add(lblEndDate);
        
        JLabel st_date_1 = new JLabel(EstimatedCompletion);
        st_date_1.setForeground(new Color(255, 255, 134));
        st_date_1.setFont(new Font("Felix Titling", Font.BOLD, 13));
        st_date_1.setBounds(410, 196, 78, 13);
        panel.add(st_date_1);
        
        JLabel lblExpenses = new JLabel("EXPENSE OCCURED TILL DATE");
        lblExpenses.setForeground(new Color(255, 255, 134));
        lblExpenses.setFont(new Font("Felix Titling", Font.BOLD, 13));
        lblExpenses.setBounds(43, 239, 218, 13);
        panel.add(lblExpenses);
        
        
        String new_budget = Integer.toString(BudgetOccurred);
        JLabel st_date_1_1 = new JLabel(new_budget);
        st_date_1_1.setForeground(new Color(255, 255, 134));
        st_date_1_1.setFont(new Font("Felix Titling", Font.BOLD, 13));
        st_date_1_1.setBounds(410, 239, 78, 13);
        panel.add(st_date_1_1);
        
        String new_manpower = Integer.toString(EstimatedManpower);
        JLabel lblEstimatedManpower = new JLabel("ESTIMAED MANPOWER");
        lblEstimatedManpower.setForeground(new Color(255, 255, 134));
        lblEstimatedManpower.setFont(new Font("Felix Titling", Font.BOLD, 13));
        lblEstimatedManpower.setBounds(43, 290, 218, 13);
        panel.add(lblEstimatedManpower);
        
        JLabel st_date_1_1_1 = new JLabel(new_manpower);
        st_date_1_1_1.setForeground(new Color(255, 255, 134));
        st_date_1_1_1.setFont(new Font("Felix Titling", Font.BOLD, 13));
        st_date_1_1_1.setBounds(410, 290, 78, 13);
        panel.add(st_date_1_1_1);
        
        JLabel lblManpowerUsed = new JLabel("MANPOWER USED");
        lblManpowerUsed.setForeground(new Color(255, 255, 134));
        lblManpowerUsed.setFont(new Font("Felix Titling", Font.BOLD, 13));
        lblManpowerUsed.setBounds(43, 340, 218, 13);
        panel.add(lblManpowerUsed);
        
        String new_manpower2 = Integer.toString(ManpowerUsed);
        JLabel st_date_1_1_1_1 = new JLabel(new_manpower2);
        st_date_1_1_1_1.setForeground(new Color(255, 255, 134));
        st_date_1_1_1_1.setFont(new Font("Felix Titling", Font.BOLD, 13));
        st_date_1_1_1_1.setBounds(410, 340, 78, 13);
        panel.add(st_date_1_1_1_1);
        
        JLabel lblMaterialsExpense = new JLabel("MATERIALS USED");
        lblMaterialsExpense.setForeground(new Color(255, 255, 134));
        lblMaterialsExpense.setFont(new Font("Felix Titling", Font.BOLD, 13));
        lblMaterialsExpense.setBounds(43, 385, 218, 13);
        panel.add(lblMaterialsExpense);
        
        CircularProgressPanel plumbing_progress = new CircularProgressPanel();
        plumbing_progress.setProgress(1);
        plumbing_progress.setBackground(Color.BLACK);
        plumbing_progress.setBounds(354, 526, 192, 164);
        panel.add(plumbing_progress);
        Timer timer_plumb = new Timer(50, e -> {
            if (plumbing_progress.getProgress() < Plumbing) {
                plumbing_progress.setProgress(plumbing_progress.getProgress() + 1);
                
                
            } else {
                ((Timer) e.getSource()).stop(); // Stop the timer at 100%
            }
        });
        timer_plumb.start();
        
        JLabel lblPlumbing = new JLabel("PLUMBING");
        lblPlumbing.setForeground(new Color(255, 255, 134));
        lblPlumbing.setFont(new Font("Felix Titling", Font.BOLD, 13));
        lblPlumbing.setBounds(399, 470, 94, 13);
        panel.add(lblPlumbing);
        
        CircularProgressPanel electrical_progress = new CircularProgressPanel();
        electrical_progress.setProgress(1);
        electrical_progress.setBackground(Color.BLACK);
        electrical_progress.setBounds(690, 526, 192, 164);
        panel.add(electrical_progress);
        Timer timer_elect = new Timer(50, e -> {
            if (electrical_progress.getProgress() < Electrical) {
                electrical_progress.setProgress(electrical_progress.getProgress() + 1);
                
                
            } else {
                ((Timer) e.getSource()).stop(); // Stop the timer at 100%
            }
        });
        timer_elect.start();
        
        JLabel lblElectrical = new JLabel("ELECTRICAL");
        lblElectrical.setForeground(new Color(255, 255, 134));
        lblElectrical.setFont(new Font("Felix Titling", Font.BOLD, 13));
        lblElectrical.setBounds(740, 471, 94, 13);
        panel.add(lblElectrical);
        
        CircularProgressPanel interior_progress = new CircularProgressPanel();
        interior_progress.setProgress(1);
        interior_progress.setBackground(Color.BLACK);
        interior_progress.setBounds(1023, 526, 192, 164);
        panel.add(interior_progress);
        Timer timer_inte = new Timer(50, e -> {
            if (interior_progress.getProgress() < Interior) {
                interior_progress.setProgress(interior_progress.getProgress() + 1);
                
                
            } else {
                ((Timer) e.getSource()).stop(); // Stop the timer at 100%
            }
        });
        timer_inte.start();
        
        JLabel lblInterior = new JLabel("INTERIOR");
        lblInterior.setForeground(new Color(255, 255, 134));
        lblInterior.setFont(new Font("Felix Titling", Font.BOLD, 13));
        lblInterior.setBounds(1073, 471, 94, 13);
        panel.add(lblInterior);
        
        JLabel st_date_1_1_1_1_1 = new JLabel(MaterialsUsed);
        st_date_1_1_1_1_1.setForeground(new Color(255, 255, 134));
        st_date_1_1_1_1_1.setFont(new Font("Felix Titling", Font.BOLD, 13));
        st_date_1_1_1_1_1.setBounds(410, 386, 78, 13);
        panel.add(st_date_1_1_1_1_1);
        
        JLabel lblProjectSummary = new JLabel("PROJECT SUMMARY    -");
        lblProjectSummary.setForeground(new Color(255, 255, 134));
        lblProjectSummary.setFont(new Font("Felix Titling", Font.BOLD, 13));
        lblProjectSummary.setBounds(690, 87, 168, 13);
        panel.add(lblProjectSummary);
        
        JTextArea textArea = new JTextArea("the project is going by schedule aligning with all the updates and points \n it is going on full swing thanks to our project management team and \n the whole construction\n\n" + "\nthe project is expected to be completed within the estimated date \n" + "\n\ntimely updates will be updated here\n" + "\n\nthank you for choosing VBuilders");
        textArea.setBackground(Color.BLACK);
        textArea.setBounds(690, 125, 571, 310);
        textArea.setForeground(new Color(255, 255, 134));
        textArea.setFont(new Font("Felix Titling", Font.BOLD, 13));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        // Add a JScrollPane for scrolling if the text is too long
        //JScrollPane scrollPane = new JScrollPane(textArea);

        // Add the scroll pane to the frame
//        frame.add(scrollPane);
        panel.add(textArea);
//        panel.add(textArea);
        frame.setVisible(true);
    }
}


	
	
	


