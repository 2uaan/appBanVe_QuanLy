package view;

import java.awt.Color;

import javax.swing.*;

import model_interface.*;
import model_data.*;

public class startView extends JPanel{
	
	private colors colo = new colors();
	private fonT font = new fonT();
	
	public static void main(String[] args) {
		new adminView(new startView());
	}
	
	
	
	public startView() {
		
		this.setBounds(10, 43,1000-36, 675- 90);
		this.setBackground(colo.back);
		this.setBorder(BorderFactory.createLineBorder(colo.cineYellow, 5));
		this.setLayout(null);
		
		
		JLabel work = new JLabel("Workplace");
		work.setBounds(250, 245, 700, 90);
		work.setFont(font.bahnschrift(100));
		this.add(work);
		
		this.setVisible(false);
		this.setVisible(true);
	}
	
}
