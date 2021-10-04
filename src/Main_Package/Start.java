package Main_Package;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Start {
	public Start() throws FileNotFoundException {
		GO();	
	}
	int Find_Id(Person P1) {
		for(int idx=0;idx<P1.Size;idx++) {	
			if(P1.ID[idx].equals(P1.id)) {
				return idx;
			}
		}
		return -1;
	}
	int Find_Pass(Person P1){
		int idx;
		for(idx=0;idx<P1.Size;idx++) {
			if(P1.Pass[idx].equals(P1.Password)) {
				return idx;
				
			}
		}
		return -1;
	}
	Boolean Accessed(Person P1) {
		JFrame f=new JFrame();
		Boolean b= false ;
		
		if(Find_Id(P1)==-1) {
			 JOptionPane.showMessageDialog(f,"Not accessed {ID not found} ","L.M.S.",JOptionPane.ERROR_MESSAGE);
			 return false;
		}
		else if(P1.Pass[Find_Id(P1)].equals(P1.Password)) {
			JOptionPane.showMessageDialog(f,"Hello, "+P1.Name[Find_Id(P1)]+" ☺","Accessed",JOptionPane.INFORMATION_MESSAGE);
			return true;
		}
		else{
			JOptionPane.showMessageDialog(f,"Not accessed {Password is wrong} ","L.M.S.",JOptionPane.ERROR_MESSAGE);
			 return false;
		}
	}
	void Admin_Frame1() {
		Frame AdF1=new Frame(350,500,"Admin Mode");
		AdF1.setLayout(new GridLayout(6,1,10,10));
		Button MBook,Search,Borrow,Return,Show,AddUser;
		MBook=new Button("Modify");
		Search=new Button("Search");
		Borrow=new Button("Borrow a Book");
		Return=new Button("Return a Book");
		Show=new Button("Show all Books");
		AddUser=new Button("Add User");
		MBook.setBackground(Color.green);
		Search.setBackground(Color.lightGray);
		Borrow.setBackground(Color.YELLOW);
		Return.setBackground(Color.CYAN);
		Show.setBackground(Color.blue);
		AddUser.setBackground(Color.red);
		AdF1.add(MBook);
		AdF1.add(Search);
		AdF1.add(Borrow);
		AdF1.add(Return);
		AdF1.add(Show);
		AdF1.add(AddUser);
		Find_Action A=new Find_Action();
		MBook.addActionListener(A);
		Search.addActionListener(A);
		Borrow.addActionListener(A);
		Return.addActionListener(A);
		Show.addActionListener(A);
		AddUser.addActionListener(A);
	}
	void User_Frame1() {
		Frame UF1=new Frame(400,200,"Student Mode");
		UF1.setLayout(new GridLayout(2,1,10,10));
		Button Search,Show;
		Search=new Button("Search");
		Show=new Button("Show all Books");
		Search.setBackground(Color.lightGray);
		Show.setBackground(Color.blue);
		UF1.add(Search);
		UF1.add(Show);
		Find_Action A=new Find_Action();
		Search.addActionListener(A);
		Show.addActionListener(A);
	}
	void GO() throws FileNotFoundException {
		JFrame f=new JFrame();
		f.setTitle("L.M.S.");
		int a=JOptionPane.showConfirmDialog(f,"Sign in as admin");
		if(a==JOptionPane.YES_OPTION) {
			Admin AD=new Admin();
		//System.out.println(AD.ID.length);
			if(Accessed(AD)) {
				
				Admin_Frame1();
			}
		}
		else if(a==JOptionPane.NO_OPTION) {
			User US=new User();
			if(Accessed(US)) {
//				JOptionPane.showMessageDialog(f,"Accessed","L.M.S.",JOptionPane.INFORMATION_MESSAGE);
				User_Frame1();
			}
		}
		else {
			JOptionPane.showMessageDialog(f,"Not accessed","L.M.S.",JOptionPane.ERROR_MESSAGE);
			
		}
	 
		
	}
}
