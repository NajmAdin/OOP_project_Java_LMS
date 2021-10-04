package Main_Package;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.*;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.lang.*;

public class User extends Person  {
	File UF;
	public User() throws FileNotFoundException{
		id=JOptionPane.showInputDialog(f,"Enter your ID");
	    Password=JOptionPane.showInputDialog(f,"Enter Password");
	    LF(0);
	}
	public User(String NU) throws FileNotFoundException {
		try {
			NU=JOptionPane.showInputDialog(f,"Enter User Name");
			if(NU.length()==0) {
				JOptionPane.showMessageDialog(f," User name is empty","L.M.S.",JOptionPane.ERROR_MESSAGE);
			}
			else {
				try {
					String s=JOptionPane.showInputDialog(f,"Enter Password for First Time");
					if(s.length()==0) {
						JOptionPane.showMessageDialog(f," User Password is empty","L.M.S.",JOptionPane.ERROR_MESSAGE);
					}
					else {
						LF(1);
						Name[Size-1]=NU;
						if(Size>=10) {
							ID[Size-1]="Us"+(Size-1);
						}
						else {
							ID[Size-1]="Us0"+(Size-1);
						}
						Pass[Size-1] =s;
						WF();
					}
				}
				catch(Exception e1) {
					
				}
			}
		}
		catch(Exception e) {
			
		}
		
	}
	public User(int i) {
		
	}
	
	void LF(int add) throws FileNotFoundException {
		UF = new File("User.data");
		Scanner US=new Scanner(UF);
		int x=US.nextInt();
		set_Size(x+add);
		Name =new String[Size];
		ID = new String[Size];
		Pass =new String[Size];
		
		for(int i=0;i<x;i++) {
			ID[i]=US.next();
			Name[i]=US.next();
			Name[i]=Name_Ed(Name[i]);
			Pass[i]=US.next();
		}	
	}
	private void WF() throws FileNotFoundException {
	    PrintWriter Save = new PrintWriter(UF);
	    Save.println(Size);
	    Show();
	    for(int i=0;i<Size;i++) {
			Save.print(ID[i]+" ");
			Name[i]=Name_Save(Name[i]);
			Save.print(Name[i]+" ");
			Save.println(Pass[i]+" ");
		}
	    Save.close();
	    JOptionPane.showMessageDialog(f,"new User is added Successfully ☺","Save",JOptionPane.INFORMATION_MESSAGE);
	   
	}
	private void Show() {
		Frame SBF=new Frame();
		SBF.setTitle("User Ifo.");
		SBF.setSize(300, 100);
		SBF.setLayout(new GridLayout(2, 3, 10, 10));
		SBF.setBackground(Color.WHITE);
		SBF.add(new JLabel("ID"));
		JLabel l=new JLabel("Name");
		l.setSize(150, 150);
		SBF.add(l);
		JLabel l1=new JLabel(Name[Size-1]);
		l1.setSize(150, 150);
		SBF.add(new JLabel("Pass"));
		SBF.add(new JLabel(ID[Size-1]));
		SBF.add(l1);
		SBF.add(new JLabel(Pass[Size-1]));
	}
}
