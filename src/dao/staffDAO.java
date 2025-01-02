package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.jdbc_new;
import model_data.*;

public class staffDAO {
	Connection connect = null;
	
	public staff[] exportStaff() {
		staff[] st = null;
		int numStaff = 0;
		
		try {
			
			connect = jdbc_new.getConnection();
			String sql = "Select * from staff";
			PreparedStatement pst = connect.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			
			while (result.next()) {
				String temp = result.getString("staff_name");
				numStaff++;
			}
			
			result = pst.executeQuery();
			st = new staff[numStaff];
			int i = 0;
			
			while (result.next()) {
				st[i] = new staff();
				
				int staff_id = result.getInt("staff_id");
				String staff_name = result.getString("staff_name");
				boolean state = result.getInt("state")==0 ? false : true;
				String password = result.getString("password");
				
				st[i].setStaff_id(staff_id);
				st[i].setStaff_name(staff_name);
				st[i].setState(state);
				st[i].setPassword(password);
				
				i++;
			}
			
			jdbc_new.closeConnection(connect);
			connect.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return st;
	}
	
	public int checkStaff(staff[] sta, int n, int sid, String spass) {
		if (n==0) return 0;
		else if (sta[n-1].getStaff_id() == sid && sta[n-1].getPassword().equals(spass)) return sta[n-1].getStaff_id();
		else return checkStaff(sta, n-1, sid, spass);
	}
	
	public void setStateStaff(int id) {
		try {
			
			connect = jdbc_new.getConnection();
			String sql = "UPDATE staff \nSET state = 1 \nWHERE staff_id = ?";
			
			PreparedStatement pst = connect.prepareStatement(sql);
			pst.setInt(1, id);
			int result = pst.executeUpdate();
			
			jdbc_new.closeConnection(connect);
			connect.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void addStaff(staff s) {
		try {
			
			connect = jdbc_new.getConnection();
			String sql = "INSERT INTO staff"
					+ "\nVALUES (?,?,?,?);";
			
			PreparedStatement pst = connect.prepareStatement(sql);
			pst.setInt(1, s.getStaff_id());
			pst.setString(2, s.getStaff_name());
			pst.setInt(3, s.isState() ? 1 : 0);
			pst.setString(4, s.getPassword());
			int result = pst.executeUpdate();
			
			jdbc_new.closeConnection(connect);
			connect.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void staffOff() {
		try {
			
			connect = jdbc_new.getConnection();
			String sql = "UPDATE staff \nSET state = 0";
			
			PreparedStatement pst = connect.prepareStatement(sql);
			int result = pst.executeUpdate();
			
			jdbc_new.closeConnection(connect);
			connect.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void upDateStaffById(staff s) {
		try {
					
				connect = jdbc_new.getConnection();
				String sql = "UPDATE staff "
						+ "\nSET staff_id = ?, staff_name = ?, state = ?, password = ? "
						+ "\nWHERE staff_id = ?";
				
				PreparedStatement pst = connect.prepareStatement(sql);
				pst.setInt(1, s.getStaff_id());
				pst.setString(2, s.getStaff_name());
				pst.setInt(3, s.isState() ? 1 : 0);
				pst.setString(4, s.getPassword());
				pst.setInt(5, s.getStaff_id());
				int result = pst.executeUpdate();
				
				jdbc_new.closeConnection(connect);
				connect.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	
	public void deleteStaffById(int id) {
		try {
			
			connect = jdbc_new.getConnection();
			String sql = "DELETE FROM staff"
					+ "\nWHERE staff_id = ?";
			PreparedStatement pst = connect.prepareStatement(sql);
			pst.setInt(1, id);
			int kq = pst.executeUpdate();
			jdbc_new.closeConnection(connect);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
