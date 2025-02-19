package v_builders;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class profile_edit {

	
	private JPanel contentPane;
	private JTextField firstname;
	private JTextField lastname;
	private JTextField contact;
	private JTextField email_addr;
	private JTextField street_addr;
	private JTextField house_no;
	private JTextField district_addr;
	private JTextField state_name;
	private JTextField pincode_no;
	private JTextField aadhar_no;
	private JTextField Contact;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new profile_edit();
	}

	/**
	 * Create the frame.
	 */
	public profile_edit() {
		JFrame frame = new JFrame("PROFILE");
	    frame.setBackground(Color.WHITE);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(850,630);
	    frame.getContentPane().setLayout(null);
	    
	    JPanel panel = new JPanel();
	    panel.setBackground(Color.BLACK);
	    panel.setBounds(0, 0, 836, 593);
	    frame.getContentPane().add(panel);
	    panel.setLayout(null);
	    
	    JLabel profile = new JLabel("PROFILE");
	    profile.setForeground(new Color(255, 255, 134));
	    profile.setFont(new Font("Felix Titling", Font.BOLD, 35));
	    profile.setBounds(334, 10, 154, 33);
	    panel.add(profile);
	    
	    JLabel vbuilders = new JLabel("© 2024 VBUILDERS INC");
	    vbuilders.setForeground(new Color(255, 255, 134));
	    vbuilders.setFont(new Font("Felix Titling", Font.BOLD, 16));
	    vbuilders.setBounds(308, 570, 236, 13);
	    panel.add(vbuilders);
	    
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
	    back.setBounds(10, 0, 65, 15);
	    panel.add(back);
	    
	    JLabel first_name = new JLabel("FIRST NAME");
	    first_name.setForeground(new Color(255, 255, 134));
	    first_name.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    first_name.setBounds(273, 115, 90, 24);
	    panel.add(first_name);
	    
	    JLabel last_name = new JLabel("LAST NAME");
	    last_name.setForeground(new Color(255, 255, 134));
	    last_name.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    last_name.setBounds(273, 149, 90, 24);
	    panel.add(last_name);
	    
	    JLabel contact_no = new JLabel("CONTACT NO");
	    contact_no.setForeground(new Color(255, 255, 134));
	    contact_no.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    contact_no.setBounds(273, 186, 105, 24);
	    panel.add(contact_no);
	    
	    JLabel Email = new JLabel("EMAIL\r\n");
	    Email.setForeground(new Color(255, 255, 134));
	    Email.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    Email.setBounds(273, 220, 90, 24);
	    panel.add(Email);
	    
	    JLabel Street = new JLabel("street");
	    Street.setForeground(new Color(255, 255, 134));
	    Street.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    Street.setBounds(273, 263, 90, 24);
	    panel.add(Street);
	    
	    JLabel House = new JLabel("HOUSE NO");
	    House.setForeground(new Color(255, 255, 134));
	    House.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    House.setBounds(273, 297, 90, 24);
	    panel.add(House);
	    
	    JLabel District = new JLabel("DISTRICT");
	    District.setForeground(new Color(255, 255, 134));
	    District.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    District.setBounds(273, 331, 90, 24);
	    panel.add(District);
	    
	    JLabel State = new JLabel("STATE");
	    State.setForeground(new Color(255, 255, 134));
	    State.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    State.setBounds(273, 365, 90, 24);
	    panel.add(State);
	    
	    JLabel Pincode = new JLabel("PINCODE");
	    Pincode.setForeground(new Color(255, 255, 134));
	    Pincode.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    Pincode.setBounds(273, 399, 90, 24);
	    panel.add(Pincode);
	    
	    JLabel Aadhar = new JLabel("AADHAR NO");
	    Aadhar.setForeground(new Color(255, 255, 134));
	    Aadhar.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    Aadhar.setBounds(273, 433, 90, 24);
	    panel.add(Aadhar);
	    
	    firstname = new JTextField();
	    firstname.setBounds(475, 120, 204, 19);
	    panel.add(firstname);
	    firstname.setColumns(10);
	    
	    lastname = new JTextField();
	    lastname.setColumns(10);
	    lastname.setBounds(475, 153, 204, 19);
	    panel.add(lastname);
	    
	    Contact = new JTextField();
	    Contact.setBounds(475, 190, 204, 19);
	    panel.add(Contact);
	    Contact.setColumns(10);
	    
	    email_addr = new JTextField();
	    email_addr.setColumns(10);
	    email_addr.setBounds(475, 224, 204, 19);
	    panel.add(email_addr);
	    
	    street_addr = new JTextField();
	    street_addr.setColumns(10);
	    street_addr.setBounds(475, 267, 204, 19);
	    panel.add(street_addr);
	    
	    house_no = new JTextField();
	    house_no.setColumns(10);
	    house_no.setBounds(475, 301, 204, 19);
	    panel.add(house_no);
	    
	    district_addr = new JTextField();
	    district_addr.setColumns(10);
	    district_addr.setBounds(475, 335, 204, 19);
	    panel.add(district_addr);
	    
	    state_name = new JTextField();
	    state_name.setColumns(10);
	    state_name.setBounds(475, 369, 204, 19);
	    panel.add(state_name);
	    
	    pincode_no = new JTextField();
	    pincode_no.setColumns(10);
	    pincode_no.setBounds(475, 403, 204, 19);
	    panel.add(pincode_no);
	    
	    aadhar_no = new JTextField();
	    aadhar_no.setColumns(10);
	    aadhar_no.setBounds(475, 437, 204, 19);
	    panel.add(aadhar_no);
	    
	    JButton submit = new JButton("SUBMIT");
	    submit.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		String Firstname = new String(firstname.getText());
	    		String Lastname = new String(lastname.getText());
	    		String Contact_no = new String(Contact.getText());
	    		String Email = new String(email_addr.getText());
	    		String Street_addr = new String(street_addr.getText());
	    		String House_no = new String(house_no.getText());
	    		String District_addr = new String(district_addr.getText());
	    		String State_name = new String(state_name.getText());
	    		String Pincode_no = new String(pincode_no.getText());
	    		String Aadhar_no = new String(aadhar_no.getText());
	    		if (Firstname.isEmpty() || Lastname.isEmpty() || Contact_no.isEmpty() || Email.isEmpty() || Street_addr.isEmpty() ||  House_no.isEmpty() || District_addr.isEmpty() || State_name.isEmpty() || Pincode_no.isEmpty() || Aadhar_no.isEmpty())
	    		{
	    			JOptionPane.showMessageDialog(null, "please fill all the fields");
	    			return ;
	    		}
	    		else {
	    		
	    			// database connection to insert the details in the table 
	    			
	    			try {
	                    //establishing Database connection
	                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/v_builders", "root", "I7585040714m");
	                    PreparedStatement pstmt = null;
	                    
	                    //getting username from login page
	                    String table = "user_"+login.name();

	                    //  Creating an SQL INSERT statement
	                    String insertSQL = "INSERT INTO " + table + " (firstname, lastname, contact_no, email, street, house_no, district, state, pincode, aadhar) "
	                                     + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	                    // Step 3: Create PreparedStatement and set parameter values
	                    pstmt = conn.prepareStatement(insertSQL);
	                    pstmt.setString(1, Firstname);
	                    pstmt.setString(2, Lastname);
	                    pstmt.setString(3, Contact_no);
	                    pstmt.setString(4, Email);
	                    pstmt.setString(5, Street_addr);
	                    pstmt.setString(6, House_no);
	                    pstmt.setString(7, District_addr);
	                    pstmt.setString(8, State_name);
	                    pstmt.setString(9, Pincode_no);
	                    pstmt.setString(10, Aadhar_no);

	                    // Step 4: Execute the INSERT statement
	                    int rowsInserted = pstmt.executeUpdate();
	                    if (rowsInserted > 0) {
	                        //System.out.println("A new record was inserted successfully!");
	                    	JOptionPane.showMessageDialog(null, "Profile Updated Successfully!");
	    	                new Home_page();
	                        conn.close();
	                    }
	                } catch (SQLException e1) {
	                    e1.printStackTrace();
//	                } finally {
//	                    // Close resources
//	                    try {
//	                        if (pstmt != null) pstmt.close();
//	                        if (conn != null) conn.close();
//	                    } catch (SQLException ex) {
//	                        ex.printStackTrace();
//	                    }
	              //  }
	            }
	    			
	                
	    			
	    		 
	    	}}
	    });
	    submit.setOpaque(false);
	    submit.setForeground(new Color(255, 255, 134));
	    submit.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    submit.setBorder(new LineBorder(new Color(255, 255, 134), 1));
	    submit.setBackground(Color.BLACK);
	    submit.setBounds(554, 497, 105, 21);
	    panel.add(submit);
	    
	  
	    
	    
	    
	    
	    frame.setVisible(true);
	}

}
