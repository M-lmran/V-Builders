package v_builders;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
public class Home_page{
    /**
	 * 
	 */
	

	/**
	 * 
	 */
	public String user_name;
	

	public static void main(String[] args) {
         new Home_page();
        
}
    
    public Home_page(){
	
    JFrame frame = new JFrame("HOME PAGE");
    frame.setBackground(Color.BLACK);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1554,1020);
    frame.getContentPane().setLayout(new BorderLayout(0, 0));
    
    JPanel panel_1 = new JPanel();
    panel_1.setPreferredSize(new Dimension(130, 130));
    panel_1.setBackground(Color.BLACK);
    frame.getContentPane().add(panel_1, BorderLayout.NORTH);
    panel_1.setLayout(null);
    
    JLabel v = new JLabel("V-BUILDERS");
    v.setBounds(458, 25, 722, 76);
    v.setForeground(new Color(255, 255, 134));
	v.setFont(new Font("Felix Titling", Font.BOLD, 90));
    panel_1.add(v);
    
    JButton home = new JButton("");                      // the v icon will direct us to login page
    home.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		frame.dispose();
    		login back = new login();
    		back.setVisible(true);
    		
    	}
    });
    
	
    home.setBackground(Color.BLACK);
    home.setBorderPainted(false);
    home.setOpaque(false);
    home.setFocusPainted(false);
    home.setIcon(new ImageIcon("C:\\Users\\Windows 11\\Downloads\\V MEDIUM.png"));
    home.setBounds(10, 0, 129, 130);
    panel_1.add(home);
    
    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    // to add date in panel 1(top right corner)
    
    LocalDate currentDate = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    String formattedDate = currentDate.format(formatter);
    JLabel date = new JLabel("DATE -  " + formattedDate);
    date.setBounds(1381, 10, 159, 28);
    date.setForeground(new Color(255, 255, 134));
   	date.setFont(new Font("Felix Titling", Font.BOLD, 16));
    panel_1.add(date);
    
  
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
   
    JPanel panel_2 = new JPanel();
    panel_2.setPreferredSize(new Dimension(130, 130));
    panel_2.setBackground(Color.BLACK);
    frame.getContentPane().add(panel_2, BorderLayout.WEST);
    panel_2.setLayout(null);
    
    JPanel panel3 = new JPanel();
    frame.getContentPane().add(panel3, BorderLayout.SOUTH);
    panel3.setPreferredSize(new Dimension(130, 130));
    panel3.setBackground(Color.BLACK);
    panel3.setLayout(null);
    
    JLabel addr2 = new JLabel("kattankulathur TamilNadu");
    addr2.setBounds(1333, 51, 207, 19);
    addr2.setForeground(new Color(255, 255, 134));
   	addr2.setFont(new Font("Felix Titling", Font.BOLD, 10));
    panel3.add(addr2);
    
    JLabel addr3 = new JLabel("Chengalpattu - 603203");
    addr3.setBounds(1333, 68, 178, 13);
    addr3.setForeground(new Color(255, 255, 134));
   	addr3.setFont(new Font("Felix Titling", Font.BOLD, 10));
    panel3.add(addr3);
    
    JLabel cont = new JLabel("Contact : 9532452321");
    cont.setBounds(1135, 54, 178, 13);
    cont.setForeground(new Color(255, 255, 134));
   	cont.setFont(new Font("Felix Titling", Font.BOLD, 10));
    panel3.add(cont);
    
    JLabel mail = new JLabel("vbuilders@gmail.com");
    mail.setBounds(1135, 68, 133, 13);
    mail.setForeground(new Color(255, 255, 134));
   	mail.setFont(new Font("Felix Titling", Font.BOLD, 10));
    panel3.add(mail);
    
    JButton btnCarreers = new JButton("CARREERS");
    btnCarreers.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		frame.dispose();
    		new careers();
    	}
    });
    btnCarreers.setOpaque(false);
    btnCarreers.setForeground(new Color(255, 255, 134));
    btnCarreers.setFont(new Font("Felix Titling", Font.BOLD, 14));
    btnCarreers.setBorder(new LineBorder(Color.BLACK));
    btnCarreers.setBackground(Color.BLACK);
    btnCarreers.setBounds(131, 50, 133, 19);
    ///btnCarreers.setFocusPainted(false);
    panel3.add(btnCarreers);
    
    JLabel vbuilders = new JLabel("© 2024 VBUILDERS INC");
    vbuilders.setBounds(617, 56, 236, 13);
    vbuilders.setForeground(new Color(255, 255, 134));
   	vbuilders.setFont(new Font("Felix Titling", Font.BOLD, 16));
    panel3.add(vbuilders);
    
    JLabel address = new JLabel("address : \r\n SRM UNIVERSITY \r\n\r\n");
    address.setBounds(1333, 32, 172, 25);
    panel3.add(address);
    address.setForeground(new Color(255, 255, 134));
    address.setFont(new Font("Felix Titling", Font.BOLD, 10));
    frame.setVisible(true);
    
    JPanel panel4 = new JPanel();
    frame.getContentPane().add(panel4, BorderLayout.EAST);
    panel4.setPreferredSize(new Dimension(130, 130));
    panel4.setBackground(Color.BLACK);
    
    JPanel panel5 = new JPanel();
    frame.getContentPane().add(panel5, BorderLayout.CENTER);
    panel5.setPreferredSize(new Dimension(130, 130));
    panel5.setBackground(Color.BLACK);
    panel5.setLayout(null);
    


    String welcum = "WELCOME   " + login.name() + "  "; 
    JLabel wel = new JLabel(welcum);
    
    wel.setForeground(new Color(255, 255, 134));
	wel.setFont(new Font("Felix Titling", Font.BOLD, 30));
    wel.setBounds(438, 10, 1100, 86);
    panel5.add(wel);
    
    JButton profile = new JButton("PROFILE");
    profile.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		frame.dispose();
    		new Profile();
    	}
    });
    profile.setBounds(331, 175, 260, 60);    
    profile.setForeground(new Color(255, 255, 134));
  	profile.setFont(new Font("Felix Titling", Font.BOLD, 50));
    profile.setBackground(Color.black);                    //new Color(255, 255, 0)
    profile.setOpaque(false);
    //profile.setBorderPainted(false);
    profile.setBorder(new LineBorder(new Color(255, 255, 134), 3));
    panel5.add(profile);
    
    JButton project = new JButton("PROGRESS");
    project.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		new progress();
    		frame.dispose();
    	}
    });
    project.setBounds(601, 175, 292, 60);  
    project.setForeground(new Color(255, 255, 134));
  	project.setFont(new Font("Felix Titling", Font.BOLD, 50));
    project.setBackground(Color.black);                    //new Color(255, 255, 0)
    project.setOpaque(false);
    project.setBorder(new LineBorder(new Color(255, 255, 134), 3));
    panel5.add(project);
    
    JButton btnBudget = new JButton("BUDGET");
    btnBudget.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		frame.dispose();
    		new budget();
    	}
    });
    btnBudget.setOpaque(false);
    btnBudget.setForeground(new Color(255, 255, 134));
    btnBudget.setFont(new Font("Felix Titling", Font.BOLD, 50));
    btnBudget.setBorder(new LineBorder(new Color(255, 255, 134), 3));
    btnBudget.setBackground(Color.BLACK);
    btnBudget.setBounds(331, 245, 260, 60);
    panel5.add(btnBudget);
    
    JButton btnInfo = new JButton("INFO");
    btnInfo.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		frame.dispose();
    		new info();
    	}
    });
    btnInfo.setOpaque(false);
    btnInfo.setForeground(new Color(255, 255, 134));
    btnInfo.setFont(new Font("Felix Titling", Font.BOLD, 50));
    btnInfo.setBorder(new LineBorder(new Color(255, 255, 134), 3));
    btnInfo.setBackground(Color.BLACK);
    btnInfo.setBounds(601, 245, 292, 60);
    panel5.add(btnInfo);
    
    
    
    //---------------------------------------------------------------- TO ADD CLOCK IN THE PANEL TOP RIGHT CORNER---------------------------------------------------------------------------------
    

    JLabel timer_label = new JLabel("");
    timer_label.setBounds(1449, 48, 87, 37);
    timer_label.setForeground(new Color(255, 255, 134));
   	timer_label.setFont(new Font("Felix Titling", Font.BOLD, 16));
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

    panel_1.add(timer_label);
    
    JLabel time = new JLabel("TIME   -");
    time.setBounds(1381, 48, 58, 37);
    time.setForeground(new Color(255, 255, 134));
   	time.setFont(new Font("Felix Titling", Font.BOLD, 16));
    panel_1.add(time);
    
    frame.setVisible(true);
    
        
    }
}