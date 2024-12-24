package thread;

import java.awt.Color;

import javax.swing.JLabel;

import dao.staffDAO;
import model_data.staff;

public class updateState extends Thread{

	private volatile boolean running = true;
	private int staff_id;
	private JLabel state;
	
	
	public updateState(int staff_id, JLabel state) {
		super();
		this.staff_id = staff_id;
		this.state = state;
	}
	
	@Override
	public void run() {
		while (running) {
			staff[] s = new staffDAO().exportStaff();
			for (int i = 0; i < s.length; i++) {
				if (s[i].getStaff_id() == staff_id) {
					state.setText(s[i].isState() ? "WORK" : "OFF");
					if (s[i].isState()) state.setForeground(Color.green);
					else state.setForeground(Color.DARK_GRAY);
				}
			}
			
			state.setVisible(false);
			state.setVisible(true);
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				 Thread.currentThread().interrupt();
	             System.out.println("Thread interrupted");
			}
		}
	}
	
}
