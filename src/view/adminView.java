package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import model_interface.*;
import thread.*;

public class adminView extends JFrame{
	
	private JPanel frame, welcomeFrame;
	private colors colo = new colors();
	private fonT font = new fonT();
	
	
	public static void main(String[] args) {
		new adminView().setVisible(true);
	}
	
	public adminView() {
		setTitle("Admin Permissions");
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
		

	}
	
}
