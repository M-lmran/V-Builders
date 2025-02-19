package v_builders;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Profile{

	
	/**
	 * Launch the application.
	 */
	public String first;
	public String last;
	public String Contact;
	public String Email;
	public String Street;
	public String House;
	public String District;
	public String Pincode;
	public String Aadhar;
	public String State;
	public static void main(String[] args) {
			new Profile();
	}

	/**
	 * Create the frame.
	 */
	public Profile() {
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
	    profile.setBounds(324, 10, 154, 33);
	    profile.setForeground(new Color(255, 255, 134));
		profile.setFont(new Font("Felix Titling", Font.BOLD, 35));
	    panel.add(profile);
	    
	    JButton back = new JButton("BACK");
	    back.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		frame.dispose();
	    		new Home_page();
	    	}
	    });
	    back.setForeground(new Color(255, 255, 134));
	  	back.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    back.setBackground(Color.black);                    //new Color(255, 255, 0)
	    back.setOpaque(false);
	    //profile.setBorderPainted(false);
	    back.setBorder(new LineBorder(new Color(255, 255, 134), 1));
	    back.setBounds(0, 0, 65, 15);
	    panel.add(back);
	    
	    JLabel first_name = new JLabel("FIRST NAME");
	    first_name.setBounds(258, 85, 90, 24);
	    first_name.setForeground(new Color(255, 255, 134));
	    first_name.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    panel.add(first_name);
	    
	    JLabel last_name = new JLabel("LAST NAME");
	    last_name.setForeground(new Color(255, 255, 134));
	    last_name.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    last_name.setBounds(258, 119, 90, 24);
	    panel.add(last_name);
	    
	    JLabel contact = new JLabel("CONTACT NO");
	    contact.setForeground(new Color(255, 255, 134));
	    contact.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    contact.setBounds(258, 156, 105, 24);
	    panel.add(contact);
	    
	    JLabel email = new JLabel("EMAIL\r\n");
	    email.setForeground(new Color(255, 255, 134));
	    email.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    email.setBounds(258, 190, 90, 24);
	    panel.add(email);
	    
	    JLabel street = new JLabel("street");
	    street.setForeground(new Color(255, 255, 134));
	    street.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    street.setBounds(258, 224, 90, 24);
	    panel.add(street);
	    
	    
	    //---------------------------------------------FOR ADDING DATE TO THE PANEL----------------------------------------------------------------------------------//
	    
	    
	    LocalDate currentDate = LocalDate.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	    String formattedDate = currentDate.format(formatter);
	    JLabel date = new JLabel("DATE -  " + formattedDate);
	    date.setBounds(707,10,154,13);
	    date.setForeground(new Color(255, 255, 134));
	   	date.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    panel.add(date);
	    
	    
	    
	    //-------------------------- FOR DATE AND TIME ABOVE CORNER -------------------------------------------------------------------------------------------------//
	    
	    

	    JLabel timer_label = new JLabel("");
	    timer_label.setBounds(760, 30, 66, 13);
	    timer_label.setForeground(new Color(255, 255, 134));
	   	timer_label.setFont(new Font("Felix Titling", Font.BOLD, 13));
	   	Timer timer = new Timer();
	    timer.scheduleAtFixedRate(new TimerTask() {
	        @Override
	        public void run() {
	            // Get the current time
	            LocalDateTime now = LocalDateTime.now();
	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	            String timeString = now.format(formatter);

	            // Update the JLabel with the current time
	            timer_label.setText(timeString);
	        }
	    }, 0, 1000); // Update every 1000 milliseconds (1 second)

	    panel.add(timer_label);
	    
	    JLabel time = new JLabel("TIME   -");
	    time.setBounds(707, 30, 54, 13);
	    time.setForeground(new Color(255, 255, 134));
	   	time.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    panel.add(time);
	    
	    JLabel aadhar = new JLabel("AADHAR NO");
	    aadhar.setForeground(new Color(255, 255, 134));
	    aadhar.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    aadhar.setBounds(258, 403, 90, 24);
	    panel.add(aadhar);
	    
	    JButton submit = new JButton("EDIT PROFILE");
	    submit.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		new profile_edit();
	    	}
	    });
	    submit.setForeground(new Color(255, 255, 134));
	  	submit.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    submit.setBackground(Color.black);                    //new Color(255, 255, 0)
	    submit.setOpaque(false);
	    //profile.setBorderPainted(false);
	    submit.setBorder(new LineBorder(new Color(255, 255, 134), 1));
	    submit.setBounds(453, 480, 131, 21);
	    panel.add(submit);
	    
	    JLabel house = new JLabel("HOUSE NO");
	    house.setForeground(new Color(255, 255, 134));
	    house.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    house.setBounds(258, 267, 90, 24);
	    panel.add(house);
	    
	    JLabel district = new JLabel("DISTRICT");
	    district.setForeground(new Color(255, 255, 134));
	    district.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    district.setBounds(258, 301, 90, 24);
	    panel.add(district);
	    
	    JLabel state = new JLabel("STATE");
	    state.setForeground(new Color(255, 255, 134));
	    state.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    state.setBounds(258, 335, 90, 24);
	    panel.add(state);
	    
	    JLabel pincode_ = new JLabel("PINCODE");
	    pincode_.setForeground(new Color(255, 255, 134));
	    pincode_.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    pincode_.setBounds(258, 369, 90, 24);
	    panel.add(pincode_);
	    
	    JLabel vbuilders = new JLabel("© 2024 VBUILDERS INC");
	    vbuilders.setForeground(new Color(255, 255, 134));
	    vbuilders.setFont(new Font("Felix Titling", Font.BOLD, 16));
	    vbuilders.setBounds(330, 570, 236, 13);
	    panel.add(vbuilders);
	    
	    
	    
	    //------------------------------------------------------------------------------connecting with database to show information-----------------------------------------------------------------
	    
	    
	    
	    
// for getting username from login page 
	    
	    String username = login.name();
	    
	    // getting database connection
	    Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Establishing a connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/v_builders", "root", "I7585040714m");

            // Step 2: Create a SQL SELECT query
            String sql = "SELECT firstname,lastname,contact_no,email,street,house_no,state,district,pincode,aadhar FROM user_vishnu WHERE id = ?";
           
            // Step 3: Create a PreparedStatement
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, 1); // Replace 101 with the id value you are looking for

            // Step 4: Execute the query and retrieve the result
            resultSet = pstmt.executeQuery();

            // Step 5: Process the ResultSet
            if (resultSet.next()) { // Check if a row is returned
               
            	first = resultSet.getString("firstname");
            	 last = resultSet.getString("lastname");
            	Contact = resultSet.getString("contact_no");
            	 Email = resultSet.getString("email");
            	 Street = resultSet.getString("street");
            	 House = resultSet.getString("house_no");
            	 District = resultSet.getString("district");
            	Pincode = resultSet.getString("pincode");
            	 Aadhar = resultSet.getString("aadhar");
            	 State = resultSet.getString("state");
            } else {
                System.out.println("No employee found with the given id.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
	    JLabel name_first = new JLabel(first);
	    name_first.setForeground(new Color(255, 255, 134));
	    name_first.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    name_first.setBounds(448, 92, 184, 13);
	    panel.add(name_first);
	    
	    JLabel name_first_1 = new JLabel(last);
	    name_first_1.setForeground(new Color(255, 255, 134));
	    name_first_1.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    name_first_1.setBounds(450, 126, 184, 13);
	    panel.add(name_first_1);
	    
	    JLabel name_first_2 = new JLabel(Contact);
	    name_first_2.setForeground(new Color(255, 255, 134));
	    name_first_2.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    name_first_2.setBounds(448, 163, 184, 13);
	    panel.add(name_first_2);
	    
	    JLabel name_first_3 = new JLabel(Email);
	    name_first_3.setForeground(new Color(255, 255, 134));
	    name_first_3.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    name_first_3.setBounds(450, 197, 184, 13);
	    panel.add(name_first_3);
	    
	    JLabel name_first_4 = new JLabel(Street);
	    name_first_4.setForeground(new Color(255, 255, 134));
	    name_first_4.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    name_first_4.setBounds(450, 231, 184, 13);
	    panel.add(name_first_4);
	    
	    JLabel name_first_5 = new JLabel(House);
	    name_first_5.setForeground(new Color(255, 255, 134));
	    name_first_5.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    name_first_5.setBounds(448, 274, 184, 13);
	    panel.add(name_first_5);
	    
	    JLabel name_first_6 = new JLabel(District);
	    name_first_6.setForeground(new Color(255, 255, 134));
	    name_first_6.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    name_first_6.setBounds(448, 307, 184, 13);
	    panel.add(name_first_6);
	    
	    JLabel name_first_7 = new JLabel(State);
	    name_first_7.setForeground(new Color(255, 255, 134));
	    name_first_7.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    name_first_7.setBounds(450, 342, 184, 13);
	    panel.add(name_first_7);
	    
	    JLabel name_first_8 = new JLabel(Pincode);
	    name_first_8.setForeground(new Color(255, 255, 134));
	    name_first_8.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    name_first_8.setBounds(450, 376, 184, 13);
	    panel.add(name_first_8);
	    
	    JLabel name_first_9 = new JLabel(Aadhar);
	    name_first_9.setForeground(new Color(255, 255, 134));
	    name_first_9.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    name_first_9.setBounds(450, 410, 184, 13);
	    panel.add(name_first_9);
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    frame.setVisible(true);
	  
	    
	   
	}
}
