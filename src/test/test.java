package test;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

import model_interface.RotatedLabel;
import thread.loadingRotate;

public class test{
	public static void main(String[] args) {
		        // Tạo JFrame
		        JFrame frame = new JFrame("Rotated JLabel Example");
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frame.setSize(800, 600);
		        frame.setBackground(new Color(0,0,0));
		        frame.setLayout(null); // Sử dụng layout null

		        // Tạo RotatedLabel
		        RotatedLabel label = new RotatedLabel("", Math.toRadians(0));
		        label.setIcon(new ImageIcon("C:\\Users\\tlmqu\\OneDrive\\Desktop\\Java Project\\appBanVe_QuanLy\\image\\loading.png"));
		        label.setBounds(50, 20, 512, 512); // Đặt vị trí và kích thước
		        label.setHorizontalAlignment(SwingConstants.CENTER); // Căn giữa văn bản
		        label.setFont(new Font("Arial", Font.BOLD, 16));
		        label.setOpaque(true);

		        
		        
		        // Thêm RotatedLabel vào JFrame
		        frame.add(label);

		        loadingRotate lr = new loadingRotate(frame, label, -45);
		        lr.start();
		        
		        // Hiển thị JFrame
		        frame.setVisible(true);
		    
	}
}
