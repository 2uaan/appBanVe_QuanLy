package model_interface;

import java.awt.Color;

public class colors {
	
	public Color loginBack = new Color(0xD6BA73);
	public Color back = new Color(0x222222);
	public Color button = new Color(0x31111D);
	
	public Color cineRed = new Color(0xaa1d1d);
	public Color cineBrown = new Color(0x663C1F);
	public Color cineYellow = new Color(0xffde9c);
	public Color cineBlue = new Color(0x059abb);
	
	public Color darkRed = new Color(0x780116);
	public Color lightPink = new Color(0xDD948C);
	
	public Color transparent = new Color(0,0,0,0);
	
	public Color cineRedOpa(int opa) {
		Color temp = new Color(0xaa1d1d);
		return temp;
	}
	public Color cineBrownOpa(int opa) {
		Color temp = new Color(102,60,31,opa);
		return temp;
	}
	public Color cineYellowOpa(int opa) {
		Color temp = new Color(0xffde9c);
		return temp;
	}
	public Color cineBlueOpa(int opa) {
		Color temp = new Color(5,154,187,opa);
		return temp;
	}
	
}
