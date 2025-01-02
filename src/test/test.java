package test;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import model_interface.RotatedLabel;
import thread.loadingRotate;

public class test{
	public static void main(String[] args) {
		
		JFrame temp = new JFrame();
		temp.setSize(300,300);
		temp.setVisible(true);
		
		int kq = JOptionPane.showConfirmDialog(temp, "choice", "ID", JOptionPane.OK_CANCEL_OPTION);
		System.out.println(kq);
	}
}
