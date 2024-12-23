package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import model_interface.*;
import thread.*;

public class welcomeAdminView extends JFrame{
	
	private JLabel background, welcome, admin, load;
	private JPanel frame, welcomeFrame, in, out;
	private colors colo = new colors();
	private fonT font = new fonT();
	
	
	public static void main(String[] args) {
		new welcomeAdminView().setVisible(true);
	}
	
	public welcomeAdminView() {
		setTitle("Welcome Admin !!");
		setSize(1000,675);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		frame = new JPanel();
		setContentPane(frame);
		setLayout(null);
		setIconImage(new ImageIcon("C:\\Users\\tlmqu\\OneDrive\\Desktop\\Java Project\\appBanVe_QuanLy\\image\\logo.png").getImage());
		frame.setBackground(colo.back);
		
		welcomeFrame = new JPanel();
		welcomeFrame.setBounds(100,170,350,400);
		welcomeFrame.setBackground(colo.back);
//		welcomeFrame.setBorder(BorderFactory.createLineBorder(colo.cineYellow));
		welcomeFrame.setLayout(null);
		
		
		welcome = new JLabel("Welcome", JLabel.CENTER);
		welcome.setBounds(0,20,350,60);
		welcome.setForeground(colo.cineRed);
		welcome.setFont(font.tilt_neon(75).deriveFont(Font.BOLD));
		
		admin = new JLabel("Admin", JLabel.RIGHT);
		admin.setBounds(0,70,350,50);
		admin.setForeground(colo.cineYellow);
		admin.setFont(font.bahnschrift(50));
		
		load = new JLabel("Loading . . .");
		load.setForeground(Color.white);
		load.setFont(font.bahnschrift(20));
		load.setBounds(25, 200, 350, 25);
		
		in = new JPanel();
		in.setBounds(25,230, 0, 20);
		in.setBackground(colo.cineBlue);
		
		out = new JPanel();
		out.setBounds(25,230, 300, 20);
		out.setBackground(colo.transparent);
		out.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 3));
		
		
		welcomeFrame.add(out);
		welcomeFrame.add(in);
		welcomeFrame.add(load);
		welcomeFrame.add(admin);
		welcomeFrame.add(welcome);
		
		add(welcomeFrame);
		
		background = new JLabel();
		background.setIcon(new ImageIcon("C:\\Users\\tlmqu\\OneDrive\\Desktop\\Java Project\\appBanVe_QuanLy\\image\\background.png"));
		background.setBounds(0,-25,this.getWidth(),this.getHeight());
		add(background);
		
		loading l = new loading(this, in, load, 300, 0);
		l.start();
	}
	
}
