package Main_Package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame extends JFrame {
	public final int w =1280;
	public final int h=720;
	public final String Title="L.M.S.";
	ImageIcon imgicon = new ImageIcon("LMS.ico");
	public Frame() {
			this.setTitle(Title);
			this.setSize(w,h);
			this.setVisible(true);
			//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setResizable(false);
			this.setLayout(null);
			this.setIconImage(imgicon.getImage());
			
	}
	public Frame(int a,int b,String Titlex) {
		this.setTitle("L.M.S. "+Titlex);
		this.setSize(a,b);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setIconImage(imgicon.getImage());
}
}
