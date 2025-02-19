package v_builders;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

public class careers{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new careers();
	}

	/**
	 * Create the frame.
	 */
	public careers() {
		JFrame frame = new JFrame("careers");
	    frame.setBackground(Color.WHITE);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(850,540);
	    frame.getContentPane().setLayout(null);
	    
	    JPanel panel = new JPanel();
	    panel.setBackground(Color.BLACK);
	    panel.setBounds(0, 0, 836, 503);
	    frame.getContentPane().add(panel);
	    panel.setLayout(null);
	    
	    
	    JLabel careers = new JLabel("CAREERS");
	    careers.setBounds(324, 10, 193, 33);
	    careers.setForeground(new Color(255, 255, 134));
		careers.setFont(new Font("Felix Titling", Font.BOLD, 35));
	    panel.add(careers);
	    
	    JLabel logo = new JLabel("");
	    logo.setIcon(new ImageIcon("C:\\Users\\Windows 11\\Downloads\\V BUILDERS FINAL.png"));
	    logo.setBounds(0, 74, 333, 239);
	    panel.add(logo);
	    
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
	    
	    JLabel email = new JLabel("send your resume to the below email id");
	    email.setBounds(412, 294, 347, 33);
	    email.setForeground(new Color(255, 255, 134));
	    email.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    panel.add(email);
	    
	    JLabel id = new JLabel("vbuilders@gmail.com");
	    id.setBounds(458, 325, 257, 33);
	    id.setForeground(new Color(255, 255, 134));
	    id.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    panel.add(id);
	    
	    JLabel first_name = new JLabel("NAME");
	    first_name.setForeground(new Color(255, 255, 134));
	    first_name.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    first_name.setBounds(427, 129, 52, 24);
	    panel.add(first_name);
	    
	    textField = new JTextField();
	    textField.setColumns(10);
	    textField.setBounds(529, 133, 201, 19);
	    panel.add(textField);
	    
	    JLabel first_name_1_2 = new JLabel("EMAIL\r\n");
	    first_name_1_2.setForeground(new Color(255, 255, 134));
	    first_name_1_2.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    first_name_1_2.setBounds(427, 180, 90, 24);
	    panel.add(first_name_1_2);
	    
	    textField_1 = new JTextField();
	    textField_1.setColumns(10);
	    textField_1.setBounds(529, 184, 201, 19);
	    panel.add(textField_1);
	    
	    JLabel first_name_1_1 = new JLabel("CONTACT NO");
	    first_name_1_1.setForeground(new Color(255, 255, 134));
	    first_name_1_1.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    first_name_1_1.setBounds(394, 231, 105, 24);
	    panel.add(first_name_1_1);
	    
	    textField_2 = new JTextField();
	    textField_2.setColumns(10);
	    textField_2.setBounds(529, 235, 201, 19);
	    panel.add(textField_2);
	    
	    JButton submit = new JButton("SUBMIT");
	    submit.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		String name = textField.getText();
	    		String contact = textField_2.getText();
	    		String email = textField_1.getText();
	    		if (name.isEmpty() ||  contact.isEmpty() || email.isEmpty())
	    		{
	    			JOptionPane.showMessageDialog(null, "please fill all the fields");
	    			return ;
	    		}
	    		else {
	    			try {
                        // Database connection
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/v_builders", "root", "I7585040714m");
                        String sql = "INSERT INTO career (name,email,contact_no) VALUES (?, ?, ?)";
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        pstmt.setString(1, name);
                        pstmt.setString(2, email);
                        pstmt.setString(3, contact);
                        pstmt.executeUpdate();
                        
                       
                    
                        conn.close();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage());
                    }
	    		}
	    		 JOptionPane.showMessageDialog(null, "thanks for sending your cv\n we will get back to you shortly :)");
	                new Home_page();
	    	}
	    });
	    submit.setOpaque(false);
	    submit.setForeground(new Color(255, 255, 134));
	    submit.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    submit.setBorder(new LineBorder(new Color(255, 255, 134), 1));
	    submit.setBackground(Color.BLACK);
	    submit.setBounds(711, 453, 85, 21);
	    panel.add(submit);
	    
	    JLabel message = new JLabel("we look forward to have you in our team!");
	    message.setBounds(10, 403, 424, 33);
	    message.setFont(new Font("Felix Titling", Font.BOLD, 13));
	    message.setForeground(new Color(255, 255, 134));
	    panel.add(message);
	    
	    JLabel vbuilders = new JLabel("© 2024 VBUILDERS INC");
	    vbuilders.setForeground(new Color(255, 255, 134));
	    vbuilders.setFont(new Font("Felix Titling", Font.BOLD, 16));
	    vbuilders.setBounds(310, 480, 236, 13);
	    panel.add(vbuilders);
	    
	    frame.setVisible(true);

	}

}
