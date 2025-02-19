package v_builders;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class info {


	public String client;
	public String project;
	public String contractor_name;
	public String contractor_mail;
	public String site;
	public String phone;
	public int budget;
	public int rating;
	public int vrating;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		new info();
	}
	/**
	 * Create the frame.
	 */
	public info() {
		JFrame frame = new JFrame("BUDGET");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Windows 11\\Downloads\\v small.png"));
	    frame.setBackground(Color.BLACK);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(883,721);
	    frame.getContentPane().setLayout(null);
	    
	    JPanel panel = new JPanel();
	    panel.setBackground(Color.BLACK);
	    panel.setBounds(0, 0, 875, 684);
	    frame.getContentPane().add(panel);
	    panel.setLayout(null);
	    
	    
	    
	    JLabel lblInformation = new JLabel("INFORMATION");
	    lblInformation.setForeground(new Color(255, 255, 134));
	    lblInformation.setFont(new Font("Felix Titling", Font.BOLD, 35));
	    lblInformation.setBounds(315, 10, 266, 33);
	    panel.add(lblInformation);
	    
	    LocalDate currentDate = LocalDate.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	    String formattedDate = currentDate.format(formatter);
	    JLabel date = new JLabel("DATE -  " + formattedDate);
	    date.setForeground(new Color(255, 255, 134));
	    date.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    date.setBounds(742, 10, 154, 13);
	    panel.add(date);
	    
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
	    
	    JLabel vbuilders = new JLabel("© 2024 VBUILDERS INC");
	    vbuilders.setForeground(new Color(255, 255, 134));
	    vbuilders.setFont(new Font("Felix Titling", Font.BOLD, 16));
	    vbuilders.setBounds(337, 661, 236, 13);
	    panel.add(vbuilders);
	    
	    JLabel lblClientName = new JLabel("CLIENT NAME");
	    lblClientName.setForeground(new Color(255, 255, 134));
	    lblClientName.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    lblClientName.setBounds(10, 132, 154, 22);
	    panel.add(lblClientName);
	    
	    
	    
	    //------------------------------------------------------------------------------connecting with database to show information-----------------------------------------------------------------
	    
	    
	    
	    
// for getting username from login page 
	    
	   //String username = "user_"+login.name();
	    
	    // getting database connection
	    Connection connection;
        PreparedStatement pstmt;
        ResultSet resultSet;
        ResultSet resultSet_;
        PreparedStatement pstmt_;

        try {
            // Step 1: Establishing a connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/v_builders", "root", "I7585040714m");

            // Step 2: Create a SQL SELECT query
            String sql = "SELECT client_name,project_name,site,contractor_name,contractor_phone,contractor_mail,budget_retailer,contractor_rating,vrating FROM user_vishnu WHERE id = ?";
            String sql_ = "SELECT contractor_rating,vrating FROM user_vishnu WHERE id = ?";
           
            // Step 3: Create a PreparedStatement
            pstmt_ = connection.prepareStatement(sql_);
            pstmt_.setInt(1, 3);
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, 2);
            //pstmt.setInt(phone, budget)// Replace 101 with the id value you are looking for

            // Step 4: Execute the query and retrieve the result
            resultSet = pstmt.executeQuery();
            resultSet_ = pstmt_.executeQuery();

            // Step 5: Process the ResultSet
            if (resultSet.next()) { // Check if a row is returned
               
            	client = resultSet.getString("client_name");
            	 project = resultSet.getString("project_name");
            	contractor_name = resultSet.getString("contractor_name");
            	 contractor_mail = resultSet.getString("contractor_mail");
            	 phone = resultSet.getString("contractor_phone");
            	 site = resultSet.getString("site");
            	rating = resultSet.getInt("contractor_rating");
            	budget = resultSet.getInt("budget_retailer");
            	
            	
            } else {
                System.out.println("No employee found with the given id.");
            }
            if (resultSet_.next()) { // Check if a row is returned
                
            	rating = resultSet_.getInt("contractor_rating");
            	vrating = resultSet_.getInt("vrating");
            	
            	
            } else {
                System.out.println("No employee found with the given id.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
	    
	    JLabel lblExample = new JLabel(client);
	    lblExample.setForeground(new Color(255, 255, 134));
	    lblExample.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    lblExample.setBounds(216, 138, 165, 13);
	    panel.add(lblExample);
	    
	    JLabel lblProjectName = new JLabel("PROJECT NAME");
	    lblProjectName.setForeground(new Color(255, 255, 134));
	    lblProjectName.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    lblProjectName.setBounds(10, 178, 154, 22);
	    panel.add(lblProjectName);
	    
	    JLabel lblSiteLocation = new JLabel("SITE LOCATION");
	    lblSiteLocation.setForeground(new Color(255, 255, 134));
	    lblSiteLocation.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    lblSiteLocation.setBounds(10, 224, 154, 22);
	    panel.add(lblSiteLocation);
	    
	    JLabel lblContractorName = new JLabel("CONTRACTOR NAME");
	    lblContractorName.setForeground(new Color(255, 255, 134));
	    lblContractorName.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    lblContractorName.setBounds(10, 277, 154, 22);
	    panel.add(lblContractorName);
	    
	    JLabel lblContractorPhone = new JLabel("CONTRACTOR PHONE");
	    lblContractorPhone.setForeground(new Color(255, 255, 134));
	    lblContractorPhone.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    lblContractorPhone.setBounds(10, 330, 154, 22);
	    panel.add(lblContractorPhone);
	    
	    JLabel lblContractorMail = new JLabel("CONTRACTOR MAIL");
	    lblContractorMail.setForeground(new Color(255, 255, 134));
	    lblContractorMail.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    lblContractorMail.setBounds(10, 387, 154, 22);
	    panel.add(lblContractorMail);
	    
	    JLabel lblBudget = new JLabel("BUDGET");
	    lblBudget.setForeground(new Color(255, 255, 134));
	    lblBudget.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    lblBudget.setBounds(10, 444, 154, 22);
	    panel.add(lblBudget);
	    
	    CircularProgressPanel client_rev = new CircularProgressPanel();
	    client_rev.setProgress(1);
	    client_rev.setBackground(Color.BLACK);
	    client_rev.setBounds(561, 138, 200, 195);
	    panel.add(client_rev);
	    Timer timer_rev = new Timer(50, e -> {
            if (client_rev.getProgress() < rating) {
                client_rev.setProgress(client_rev.getProgress() + 1);
	            } else {
	                ((Timer) e.getSource()).stop(); // Stop the timer at 100%
	            }
	        });
	        timer_rev.start();
	        
	        CircularProgressPanel vbuilder_rating = new CircularProgressPanel();
            vbuilder_rating.setProgress(1);
            vbuilder_rating.setBackground(Color.BLACK);
            vbuilder_rating.setBounds(561, 401, 199, 195);
            panel.add(vbuilder_rating);
            Timer timer_vbuilder_rating = new Timer(50, e -> {
                if (vbuilder_rating.getProgress() < vrating) {
                    vbuilder_rating.setProgress(vbuilder_rating.getProgress() + 1);}
                    else {
    	                ((Timer) e.getSource()).stop(); // Stop the timer at 100%
    	            }
    	        });
    	        timer_vbuilder_rating.start();
	    
	    JLabel lblContractorRating = new JLabel("CONTRACTOR RATING");
	    lblContractorRating.setForeground(new Color(255, 255, 134));
	    lblContractorRating.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    lblContractorRating.setBounds(589, 106, 172, 22);
	    panel.add(lblContractorRating);
	    
	    JLabel lblVbuildersRating = new JLabel("VBUILDERS RATING");
	    lblVbuildersRating.setForeground(new Color(255, 255, 134));
	    lblVbuildersRating.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    lblVbuildersRating.setBounds(589, 359, 172, 22);
	    panel.add(lblVbuildersRating);
	    
	    JLabel lblExample_1 = new JLabel(project);
	    lblExample_1.setForeground(new Color(255, 255, 134));
	    lblExample_1.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    lblExample_1.setBounds(216, 184, 165, 13);
	    panel.add(lblExample_1);
	    
	    JLabel lblExample_2 = new JLabel(site);
	    lblExample_2.setForeground(new Color(255, 255, 134));
	    lblExample_2.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    lblExample_2.setBounds(216, 230, 165, 13);
	    panel.add(lblExample_2);
	    
	    JLabel lblExample_3 = new JLabel(contractor_name);
	    lblExample_3.setForeground(new Color(255, 255, 134));
	    lblExample_3.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    lblExample_3.setBounds(216, 283, 246, 13);
	    panel.add(lblExample_3);
	    
	  
	    JLabel lblExample_4 = new JLabel(phone);
	    lblExample_4.setForeground(new Color(255, 255, 134));
	    lblExample_4.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    lblExample_4.setBounds(216, 336, 246, 13);
	    panel.add(lblExample_4);
	    
	    JLabel lblExample_5 = new JLabel(contractor_mail);
	    lblExample_5.setForeground(new Color(255, 255, 134));
	    lblExample_5.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    lblExample_5.setBounds(216, 393, 256, 13);
	    panel.add(lblExample_5);
	    
	    
	    String new_budget = Integer.toString(budget);
	    JLabel lblExample_6 = new JLabel(new_budget + " rs");
	    lblExample_6.setForeground(new Color(255, 255, 134));
	    lblExample_6.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    lblExample_6.setBounds(216, 450, 165, 13);
	    panel.add(lblExample_6);
	    
	    frame.setVisible(true);
	}
}
