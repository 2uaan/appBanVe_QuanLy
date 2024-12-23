package thread;

import javax.swing.JFrame;

import model.RotatedLabel;

public class loadingRotate extends Thread{

	private JFrame frame;
	private RotatedLabel label;
	private int goc;
	
	public loadingRotate(JFrame frame, RotatedLabel label, int goc) {
		super();
		this.frame = frame;
		this.label = label;
		this.goc = goc;
	}
	
	@Override
	public void run() {
		int i = 0;
		while (i<30) {
			label.setAngle(label.getAngle() + goc);
			
			label.setVisible(false);
			label.setVisible(true);
			
			i++;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
