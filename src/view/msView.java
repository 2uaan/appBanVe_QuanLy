package view;

import javax.swing.*;

import model_interface.*;
import model_data.*;

public class msView extends JPanel{
	
	private colors colo = new colors();
	
	public static void main(String[] args) {
		new adminView(new msView());
	}
	
	
	
	public msView() {
		
		this.setBounds(10, 43,1000-36, 675- 90);
		this.setBackground(colo.cineBrown);
		this.setBorder(BorderFactory.createLineBorder(colo.cineYellow, 5));
		
		
		
		this.setVisible(false);
		this.setVisible(true);
	}
	
}
