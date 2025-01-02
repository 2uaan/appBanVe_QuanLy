package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

import model_interface.*;
import thread.*;

public class adminView extends JFrame{
	
	private JPanel frame, buttonFrame;
	private JButton msButton, mButton, fndButton, ticketButton, staffButton, seatButton;
	private colors colo = new colors();
	private fonT font = new fonT();
	
	public static void main(String[] args) {
		new adminView(new startView()).setVisible(true);
	}
	
	public adminView(JPanel workPlace) {
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
		
		// Component in Button Frame
		buttonFrame = new JPanel();
		buttonFrame.setBounds(1,0,this.getWidth() - 15, 40);
		buttonFrame.setLayout(new GridLayout(1,0));
		buttonFrame.setBackground(colo.back);
		
		JButton sample = new JButton("Sample");
		sample.setBackground(colo.cineYellow);
		sample.setMargin(new Insets(0, 0, 0, 0));
		sample.setFont(font.bahnschrift(16));
		sample.setBorder(BorderFactory.createLineBorder(colo.back, 3));
		
		msButton = createButton(sample, "Movie Screening");
		msButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new adminView(new msView()).setVisible(true);
			}
		});
		
		mButton = createButton(sample, "Movie");
		mButton.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new adminView(new mView()).setVisible(true);
			}
		});
		
		fndButton = createButton(sample, "Food & Drink");
		fndButton.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new adminView(new fndView()).setVisible(true);
			}
		});
		
		ticketButton = createButton(sample, "Ticket");
		ticketButton.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new adminView(new ticketView()).setVisible(true);
			}
		});
		
		staffButton = createButton(sample, "Staff");
		staffButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				adminView av = new adminView(new staffView());
				setVisible(false);
				av.setVisible(true);
			}
		});
		
		seatButton = createButton(sample, "Seat");
		seatButton.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new adminView(new seatView()).setVisible(true);
			}
		});
		
		buttonFrame.add(staffButton);
		buttonFrame.add(mButton);
		buttonFrame.add(msButton);
		buttonFrame.add(seatButton);
		buttonFrame.add(ticketButton);
		buttonFrame.add(fndButton);
		
		//Component in Work Place Frame
		
//		workPlace = new JPanel();
//		workPlace.setBounds(10, 43, this.getWidth()-36, this.getHeight() - 90);
//		workPlace.setBackground(colo.back);
//		workPlace.setBorder(BorderFactory.createLineBorder(colo.cineYellow, 5));
		
		
		add(workPlace);
		add(buttonFrame);
		
		setVisible(true);

	}
	
	private JButton createButton(JButton template, String text) {
	    JButton newButton = new JButton(text); // Tạo nút mới với text cụ thể
	    newButton.setBackground(template.getBackground()); // Sao chép màu nền
	    newButton.setMargin(template.getMargin()); // Sao chép margin
	    newButton.setFont(template.getFont()); // Sao chép font
	    newButton.setBorder(template.getBorder()); // Sao chép border
	    return newButton;
	}
	
}
