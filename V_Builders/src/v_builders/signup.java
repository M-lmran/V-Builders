package v_builders;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class signup extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField confirm_passwordField;

	/**
	 * Launch the application.
	 */
	public signup(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signup frame = new signup();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 */
	public signup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(942,779);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.windowText);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 928, 845);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setBounds(576, 202, 162, 13);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setForeground(new Color(255, 255, 119));
		lblNewLabel_1.setBackground(new Color(255, 255, 119));
		
		textField = new JTextField();
		textField.setBounds(576, 251, 296, 41);
		panel.add(textField);
		textField.setColumns(10);
		
		confirm_passwordField = new JPasswordField();
		confirm_passwordField.setBounds(576, 378, 295, 41);
		panel.add(confirm_passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setBounds(576, 330, 293, 13);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(255, 255, 119));
		lblNewLabel_2.setBackground(new Color(255, 255, 134));
		lblNewLabel_2.setFont(new Font("Segoe UI Variable", Font.BOLD, 17));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(576, 504, 295, 41);
		panel.add(passwordField);
		
		
		
		JLabel lblNewLabel_2_1 = new JLabel("CONFIRM PASSWORD");
		lblNewLabel_2_1.setBounds(576, 454, 293, 13);
		panel.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setForeground(new Color(255, 255, 119));
		lblNewLabel_2_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 17));
		lblNewLabel_2_1.setBackground(new Color(255, 255, 134));
		
		JButton btnNewButton = new JButton("Sign Up"
				+ "");
		btnNewButton.setBounds(762, 646, 111, 41);
		panel.add(btnNewButton);
		btnNewButton.setBackground(SystemColor.window);
		btnNewButton.setForeground(SystemColor.windowText);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String username = textField.getText();
	                String password = new String(passwordField.getPassword());
	                String confirm_pass = new String(confirm_passwordField.getPassword());
	                //String confirmPassword = new String(confirmPasswordField.getPassword());

	                // Validate the input
	                if (username.isEmpty() || password.isEmpty() || confirm_pass.isEmpty()) {
	                    JOptionPane.showMessageDialog(null, "All fields are required.");
	                } 
	                else if (!password.equals(confirm_pass)) {
	                    JOptionPane.showMessageDialog(null, "BOTH THE PASSWORDS SHOULD BE THE SAME");
	                }
	                else {
	                    // Insert into database
	                    try {
	                        // Database connection
	                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/v_builders", "root", "I7585040714m");
	                        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
	                        PreparedStatement pstmt = conn.prepareStatement(sql);
	                        pstmt.setString(1, username);
	                        pstmt.setString(2, password);
	                        pstmt.executeUpdate();
	                        JOptionPane.showMessageDialog(null, "Registration successful!");
	                        //new LoginPage();
	                        dispose();  // Close the registration form
	                       login Login =  new login();
	                       Login.setVisible(true);
	                       createUserTable(conn, username);
	                        conn.close();
	                    } catch (SQLException ex) {
	                        JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage());
	                    }
	                }
	            
				
			}
		});
		btnNewButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		
		JLabel lblNewLabel_1_1 = new JLabel("SIGNUP");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 134));
		lblNewLabel_1_1.setFont(new Font("Felix Titling", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(406, 10, 288, 45);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Windows 11\\Downloads\\V BUILDERS FINAL.png"));
		lblNewLabel_4.setBounds(86, 223, 339, 268);
		panel.add(lblNewLabel_4);
		
		JLabel vbuilders = new JLabel("© 2024 VBUILDERS INC");
		vbuilders.setForeground(new Color(255, 255, 134));
		vbuilders.setFont(new Font("Felix Titling", Font.BOLD, 16));
		vbuilders.setBounds(386, 706, 236, 13);
		panel.add(vbuilders);
		
		JButton back = new JButton("BACK");
		back.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		login Login = new login();
	    		Login.setVisible(true);
	    		dispose();
	    		
	    	}
	    });
		back.setOpaque(false);
		back.setForeground(new Color(255, 255, 134));
		back.setFont(new Font("Felix Titling", Font.BOLD, 13));
		back.setBorder(new LineBorder(new Color(255, 255, 134), 1));
		back.setBackground(Color.BLACK);
		back.setBounds(0, 0, 102, 30);
		panel.add(back);
		
		
	}
	private static void createUserTable(Connection conn, String username) {
        // Sanitize the username for use as a table name (optional)
		// Sanitize the username for use as a table name (optional)
        String sanitizedUsername = username.replaceAll("[^a-zA-Z0-9]", "_");

        // Create a dynamic table name based on the username
        String tableName = "user_" + sanitizedUsername;
        String createTableSQL = "CREATE TABLE IF NOT EXISTS " + tableName + " ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "firstname VARCHAR(50), "
                + "lastname VARCHAR(50), "
                + "contact_no VARCHAR(50), "
                + "email VARCHAR(100), "
                + "street VARCHAR(100), "
                + "house_no VARCHAR(10), "
                + "district VARCHAR(50), "
                + "state VARCHAR(50), "
                + "pincode VARCHAR(50), "
                + "aadhar VARCHAR(50), "
                + "estimated_budget DECIMAL(15, 2), "
                + "employee_budget DECIMAL(15, 2), "
                + "budget_occurred DECIMAL(15, 2), "
                + "foundation_budget DECIMAL(15, 2), "
                + "base_material_budget DECIMAL(15, 2), "
                + "plumbing_budget DECIMAL(15, 2), "
                + "electrical_budget DECIMAL(15, 2), "
                + "design_budget DECIMAL(15, 2), "
                + "interior_budget DECIMAL(15, 2), "
                + "comissions_budget DECIMAL(15, 2), "
                + "brokerage_budget DECIMAL(15, 2), "
                + "client_name VARCHAR(50), "
                + "project_name VARCHAR(50), "
                + "site VARCHAR(50), "
                + "contractor_name VARCHAR(50), "
                + "contractor_phone BIGINT, "
                + "contractor_mail VARCHAR(100), "
                + "budget_retailer DECIMAL(15, 2)"
                + ");";

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
            //System.out.println("Table '" + tableName + "' created successfully for user " + username + ".");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
