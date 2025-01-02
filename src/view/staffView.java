package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.*;

import dao.*;
import model_interface.*;
import thread.updateState;
import model_data.*;

public class staffView extends JPanel{
	
	private JPanel staffFrame, changeFrame, colStaff;
	private fonT font = new fonT();
	private colors colo = new colors();
	private JLabel id, name, state, pass;
	private JLabel seid, sename, sestate, sepass;
	private JTextField idtf, nametf, passtf;
	private JButton delete, add, update, randomID;
	private JScrollPane scrollStaff;
	private JToggleButton statetg;
	private GridBagConstraints gbcn, gbcd;
	
	private staff[] staff = new staffDAO().exportStaff();
	private staffDAO sdao = new staffDAO();
	
	public static void main(String[] args) {
		new adminView(new staffView());
	}
	
	public void addStaff() {
		gbcd = new GridBagConstraints();
		gbcd.gridx = 0;
		gbcd.gridy = 0;
		gbcd.weightx = 1;
		gbcd.weighty = 1;
		gbcd.gridheight = 1;
		gbcd.gridwidth = 1;
		gbcd.fill = GridBagConstraints.HORIZONTAL;
		gbcd.insets = new Insets(5, 5, 5, 5);
		
		int right = 15;
		if (staff.length > 7) right = 0;
		
		for ( int i = 0; i < staff.length; i++) {
			staff s = staff[i];
			JPanel s_no = new JPanel();
			s_no.setLayout(new GridBagLayout());
			s_no.setPreferredSize(new Dimension(0, 50));
			s_no.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					idtf.setText(s.getStaff_id()+"");
					nametf.setText(s.getStaff_name());
					statetg.setSelected(!s.isState());
					if (!s.isState()) {
						statetg.setText("OFF");
						statetg.setForeground(Color.darkGray);
					}else {
						statetg.setText("WORK");
						statetg.setForeground(Color.green);
					}
					passtf.setText(s.getPassword());
				}
			});
			String strid, strname, strstate, strpass;
			
			strid = " "+staff[i].getStaff_id();
			strname = " "+staff[i].getStaff_name();
			strstate = staff[i].isState() ? " WORK" : " OFF";
			strpass = " "+staff[i].getPassword();
			
			Color c = strstate.equals(" OFF") ? Color.DARK_GRAY : Color.green;
			
			JLabel idL, nameL, stateL, passL;
			
			idL = new JLabel(strid);
			idL.setFont(font.tilt_neon(18));
			idL.setBorder(BorderFactory.createLineBorder(colo.back, 3));
			idL.setPreferredSize(new Dimension(70,0));
			
			
			nameL = createLabel(idL, strname, 220);
			stateL = createLabel(idL, strstate, 80);
			stateL.setForeground(c);
			passL = createLabel(idL, strpass, 110 + right);
			
			updateState us = new updateState(s.getStaff_id(), stateL);
			us.start();
			s_no.add(idL,gbcn);
			gbcn.gridx++;
			s_no.add(nameL, gbcn);
			gbcn.gridx++;
			s_no.add(stateL, gbcn);
			gbcn.gridx++;
			s_no.add(passL, gbcn);
			gbcn.gridx++;
			
			staffFrame.add(s_no, gbcd);
			gbcd.gridy++;
		} 
		
	}
	
	public staffView() {
		
//		JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
		
		this.setBounds(10, 43, 1000-36, 675 - 90);
		this.setBackground(colo.back);
		this.setBorder(BorderFactory.createLineBorder(colo.cineYellow, 5));
		this.setLayout(null);
		
		colStaff = new JPanel();
		colStaff.setBounds(40, 50, 525, 40);
		colStaff.setBackground(colo.back);
		colStaff.setLayout(new GridBagLayout());
		gbcn = new GridBagConstraints();
		
		gbcn.gridx = 0;
		gbcn.gridy = 0;
		gbcn.weightx = 1;
		gbcn.weighty = 1;
		gbcn.gridheight = 1;
		gbcn.gridwidth = 1;
		gbcn.fill = GridBagConstraints.VERTICAL;
		
		addCol();
		
		staffFrame = new JPanel();
		staffFrame.setBackground(Color.white);
		staffFrame.setLayout(new GridBagLayout());
		
		addStaff();
		
		changeFrame = new JPanel();
		
		scrollStaff = new JScrollPane(staffFrame);
		
		scrollStaff.setBounds(40,90, 525, 450);
		scrollStaff.setBackground(colo.back);
		scrollStaff.setBorder(BorderFactory.createLineBorder(colo.cineBrown, 5));
		
		
		
		changeFrame.setBounds(600, 50, 320, 300);
		changeFrame.setLayout(null);
		changeFrame.setBorder(BorderFactory.createLineBorder(colo.cineBrown, 4));
		changeFrame.setBackground(colo.back);
		
		JLabel select = new JLabel("Selected staff", JLabel.CENTER);
		select.setFont(font.bahnschrift(30));
		select.setForeground(colo.cineYellow);
		select.setBounds(5,10, 310, 35);
		
		addseStaff();
		
		add = new JButton("Add");
		delete = new JButton("Delete");
		update = new JButton("Update");
		
		int button_size = 18;
		
		add.setBounds(40, 240, 50, 30);
		add.setMargin(new Insets(5, 0, 0, 0));
		add.setFont(font.bahnschrift(button_size));
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 				
					if (!nametf.getText().equals("")) {
						
						if (checkId(Integer.parseInt(idtf.getText()))) {
							JOptionPane.showMessageDialog(null, "This ID already existed!!!", "Errorr!!", JOptionPane.ERROR_MESSAGE);
							idtf.setText("");
							nametf.setText("");
							statetg.setSelected(false);
							passtf.setText("");
						}else {
							int choice = JOptionPane.showConfirmDialog(null, "Add "+nametf.getText()+" , Id = " + idtf.getText(),"Confirm ✓", JOptionPane.OK_CANCEL_OPTION);
							if (choice == 0) {							
								staff s = new staff(Integer.parseInt(idtf.getText()) , nametf.getText(), !statetg.isSelected(), "");
								sdao.addStaff(s);
								idtf.setText("");
								nametf.setText("");
								statetg.setSelected(false);
								passtf.setText("");
							}else {
								idtf.setText("");
								nametf.setText("");
								statetg.setSelected(false);
								passtf.setText("");
							}
						}
					}else JOptionPane.showMessageDialog(null, "You must enter staff name!!!", "Errorr!!", JOptionPane.ERROR_MESSAGE);
				setVisible(false);
				setVisible(true);
				
			}
		});

		
		delete.setBounds(100, 240, 90, 30);
		delete.setMargin(add.getInsets());
		delete.setFont(font.bahnschrift(button_size));
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (idtf.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Information is empty!!!", "Errorr!!!", JOptionPane.ERROR_MESSAGE);
				}else {	
					if (checkId(Integer.parseInt(idtf.getText()))) {						
						int choice = JOptionPane.showConfirmDialog(null, "Delete Id = " + idtf.getText() , "Confirm ✓", JOptionPane.OK_CANCEL_OPTION);
						if (choice == 0) {												
							sdao.deleteStaffById(Integer.parseInt(idtf.getText()));
							idtf.setText("");
							nametf.setText("");
							statetg.setSelected(false);
							passtf.setText("");
						}else {
							idtf.setText("");
							nametf.setText("");
							statetg.setSelected(false);
							passtf.setText("");
						}
					}else {
						JOptionPane.showMessageDialog(null, "This ID does not exist!!!", "Errorr!!!", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		update.setBounds(200, 240, 90, 30);
		update.setMargin(add.getInsets());
		update.setFont(font.bahnschrift(button_size));
		update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (idtf.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Information is empty!!!", "Errorr!!!", JOptionPane.ERROR_MESSAGE);
				}else {	
					if (checkId(Integer.parseInt(idtf.getText()))) {						
						int choice = JOptionPane.showConfirmDialog(null, "Update Id = " + idtf.getText() , "Confirm ✓", JOptionPane.OK_CANCEL_OPTION);
						if (choice == 0) {												
							staff s = new staff(Integer.parseInt(idtf.getText()) , nametf.getText(), !statetg.isSelected(), passtf.getText());
							sdao.upDateStaffById(s);
							idtf.setText("");
							nametf.setText("");
							statetg.setSelected(false);
							passtf.setText("");
						}else {
							idtf.setText("");
							nametf.setText("");
							statetg.setSelected(false);
							passtf.setText("");
						}
					}else {
						JOptionPane.showMessageDialog(null, "This ID does not exist!!!", "Errorr!!!", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		changeFrame.add(update);
		changeFrame.add(delete);
		changeFrame.add(add);
		changeFrame.add(select);
		this.add(colStaff);
		this.add(changeFrame);
		this.add(scrollStaff);
	}
	
	public boolean checkId(int id) {
		boolean check = false;
		for (int i = 0; i < staff.length; i++) {
			if (staff[i].getStaff_id() == id) check = true;
			else continue;
		}
		
		return check;
	}
	
	public void addseStaff() {
		int size = 18;
		randomID = new JButton("↺");
		
		seid = new JLabel("id: ", JLabel.RIGHT);
		seid.setFont(font.bahnschrift(size));
		seid.setForeground(colo.cineYellow);
		
		sename = new JLabel("name: ", JLabel.RIGHT);
		sename.setFont(font.bahnschrift(size));
		sename.setForeground(colo.cineYellow);
		
		sestate = new JLabel("state: ", JLabel.RIGHT);
		sestate.setFont(font.bahnschrift(size));
		sestate.setForeground(colo.cineYellow);
		
		sepass = new JLabel("pass: ", JLabel.RIGHT);
		sepass.setFont(font.bahnschrift(size));
		sepass.setForeground(colo.cineYellow);
		
		randomID.setMargin(new Insets(0, 0, 5, 0));
		randomID.setFont(randomID.getFont().deriveFont(Font.BOLD, 23));
		randomID.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int id = (int) (Math.random()*1000 + 1000);
				idtf.setText(id + "");
				passtf.setText("00" + id);
				statetg.setText("OFF");
                statetg.setForeground(Color.DARK_GRAY);
                statetg.setSelected(true);
			}
		});
		
		idtf = new JTextField();
		idtf.setMargin(new Insets(0, 5, 0, 0));
		
		nametf = new JTextField();
		nametf.setMargin(idtf.getInsets());
		
		statetg = new JToggleButton("WORK");
		statetg.setForeground(Color.green);
		statetg.setMargin(idtf.getInsets());
		statetg.addActionListener(e -> {
            if (statetg.isSelected()) {
                statetg.setText("OFF");
                statetg.setForeground(Color.DARK_GRAY);
            } else {
                statetg.setText("WORK");
        		statetg.setForeground(Color.green);
            }
        });
		
		passtf = new JTextField();
		passtf.setMargin(idtf.getInsets());
		
		int x = 30, y = 60;
		
		seid.setBounds(x,y,55, 30);
		y+= 40;
		sename.setBounds(x,y,55, 30);
		y+= 40;
		sestate.setBounds(x,y,55, 30);
		y+= 40;
		sepass.setBounds(x,y,55, 30);
		
		y = 60;
		x+=60;
		idtf.setBounds(x,y,150, 30);
		x+=160;
		randomID.setBounds(x,y, 40, 30);
		x-=160;
		y+= 40;
		nametf.setBounds(x,y,200, 30);
		y+= 40;
		statetg.setBounds(x,y,100, 30);
		y+= 40;
		passtf.setBounds(x,y,200, 30);
		
		changeFrame.add(randomID);
		changeFrame.add(seid);
		changeFrame.add(idtf);
		changeFrame.add(sename);
		changeFrame.add(nametf);
		changeFrame.add(sestate);
		changeFrame.add(statetg);
		changeFrame.add(sepass);
		changeFrame.add(passtf);
		
	}
	
	public void addCol() {
		id = new JLabel("ID");
		name = new JLabel("Name");
		state = new JLabel("State");
		pass = new JLabel("Password");
		
		int size = 18;
		
		id.setPreferredSize(new Dimension(80, 0));
		id.setBorder(BorderFactory.createLineBorder(colo.cineBrown, 3));
		id.setFont(font.bahnschrift(size));
		id.setForeground(colo.cineYellow);
		colStaff.add(id, gbcn);
		gbcn.gridx++;
		
		name.setPreferredSize(new Dimension(220, 0));
		name.setBorder(BorderFactory.createLineBorder(colo.cineBrown, 3));
		name.setFont(font.bahnschrift(size));
		name.setForeground(colo.cineYellow);
		colStaff.add(name, gbcn);
		gbcn.gridx++;
		
		state.setPreferredSize(new Dimension(80, 0));
		state.setBorder(BorderFactory.createLineBorder(colo.cineBrown, 3));
		state.setFont(font.bahnschrift(size));
		state.setForeground(colo.cineYellow);
		colStaff.add(state, gbcn);
		gbcn.gridx++;
		
		pass.setPreferredSize(new Dimension(135, 0));
		pass.setBorder(BorderFactory.createLineBorder(colo.cineBrown, 3));
		pass.setFont(font.bahnschrift(size));
		pass.setForeground(colo.cineYellow);
		colStaff.add(pass, gbcn);
		gbcn.gridx++;
		
	}
	
	
	public JLabel createLabel(JLabel label, String text, int width) {
		JLabel temp = new JLabel(text);
		temp.setFont(label.getFont());
		temp.setBorder(label.getBorder());
		temp.setPreferredSize(new Dimension(width, 0));
		
		return temp;
	}
	
}
