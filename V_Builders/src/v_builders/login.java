package v_builders;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.SystemColor;


public class login extends JFrame{

	public static final long serialVersionUID = 1L;
	String user;
	public JPanel contentPane;
	public static JTextField textField;
	public String user_name;

	public JPasswordField passwordField;
	int count = 0; 
	//private login frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 894, 610);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setForeground(new Color(255, 255, 134));
		lblNewLabel.setBackground(new Color(255, 250, 250));
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblNewLabel.setBounds(530, 144, 110, 62);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setForeground(new Color(255, 255, 134));
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(530, 260, 110, 13);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.PLAIN, 15));
		textField.setBounds(530, 200, 304, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
        UserData.setUsername(user);
		
		
        passwordField = new JPasswordField();
		passwordField.setFont(new Font("Dialog", Font.PLAIN, 15));
		passwordField.setBounds(530, 293, 304, 33);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(SystemColor.window);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = new String(textField.getText());
                String password = new String(passwordField.getPassword());

                // Validate input
                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Username and Password cannot be empty.");
                    return;
                }
               

                try {
                    // Database connection
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/v_builders", "root", "I7585040714m");
                    String sql = "SELECT password FROM users WHERE username = ?";
                   
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, username);
                    ResultSet rs = pstmt.executeQuery();

                    if (rs.next()) {
                        String storedPassword = rs.getString("password");

                        if (storedPassword.equals(password)) {
                            JOptionPane.showMessageDialog(null, "Login successful!");
                         user = new String(textField.getText());   
                         dispose();
                         new Home_page();
                         
                        } else {
                        	count += 1;
                            JOptionPane.showMessageDialog(null, "Incorrect password.");
                            if (count > 3)
                            {
                            	 JOptionPane.showMessageDialog(null, "EXCEEDED LIMIT. PLEASE TRY AGAIN LATER");
                            }
                        }
                    } else {
                    	
                        JOptionPane.showMessageDialog(null, "User not found. Redirecting to registration.");
                        dispose();
                        signup new_main = new signup();
                        new_main.setVisible(true);
                        
                        //new NewUserPage(); // Redirect to New User Registration page
                        //dispose(); // Close the login page
                    }

                    conn.close();

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage());
                }
            }
        });

			
		
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnNewButton.setBounds(530, 391, 110, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.setBackground(SystemColor.window);
		btnNewButton_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				passwordField.setText(null);
			}
		});
		btnNewButton_1.setBounds(727, 391, 117, 33);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = 
				
				new JButton("Sign Up");
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBackground(SystemColor.window);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				signup signup = new signup();
				signup.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBounds(771, 513, 99, 33);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("Sign up if you are a new user ");
		lblNewLabel_3.setForeground(new Color(255, 255, 134));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(579, 518, 315, 23);
		contentPane.add(lblNewLabel_3);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 414, 583);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Windows 11\\Downloads\\V BUILDERS FINAL.png"));
		lblNewLabel_4.setBounds(30, 119, 339, 268);
		panel.add(lblNewLabel_4);
		
		JLabel vbuilders = new JLabel("© 2024 VBUILDERS INC");
		vbuilders.setForeground(new Color(255, 255, 134));
		vbuilders.setFont(new Font("Felix Titling", Font.BOLD, 16));
		vbuilders.setBounds(88, 543, 236, 13);
		panel.add(vbuilders);
		
		JLabel lblNewLabel_1_1 = new JLabel("LOGIN");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 134));
		lblNewLabel_1_1.setFont(new Font("Felix Titling", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(606, 10, 288, 45);
		contentPane.add(lblNewLabel_1_1);
	}
	public static String name()
	{
		String user_name = new String(textField.getText());
		return user_name;
	}
}
