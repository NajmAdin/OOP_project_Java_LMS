package Main_Package;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.*;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.lang.*;

public class Book {
	String[] Book_Name;
	String[] Book_Id;
	String[] Book_Edition;
	String[] Book_Writer;
	String[] Publish_Date;
	String[] Publisher;
	double[] Publish_Price;
	boolean[] Availability;
	int[] In_Storage;
	int[] In_Library;
	int Num;
	File BookFile=new File("Book.data");
	Scanner SBook=new Scanner(BookFile);
	int Total(int index) {
		return In_Storage[index]+In_Library[index];
	}
	private void Def() {
		Book_Name=new String[Num];
		Book_Id=new String[Num];
		Book_Edition=new String[Num];
		Book_Writer=new String[Num];
		Publish_Date=new String[Num];
		Publisher=new String[Num];
		Publish_Price=new double[Num];
		Availability=new boolean[Num];
		In_Storage=new int[Num];
		In_Library=new int[Num];
	}
	String Name_Ed(String s) {  
		String x="";
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)==',') {
				x+= ' ';
			}
			else {
				x+=s.charAt(i);
			}
		} 
	      return x;
	  } 
	private void Filler(int index){
		Book_Name[index]=SBook.next();//1
		Book_Name[index]=Name_Ed(Book_Name[index]);
		Book_Id[index]=SBook.next();//2
		Book_Edition[index]=SBook.next();//3
		Book_Writer[index]=SBook.next();//4
		Book_Writer[index]=Name_Ed(Book_Writer[index]);
		Publish_Date[index]=SBook.next();//5
		Publisher[index]=SBook.next();//6
		Publisher[index]=Name_Ed(Publisher[index]);
		Publish_Price[index]=SBook.nextDouble();//7
		int in=SBook.nextInt();//8
		if(in==1) {
			Availability[index]=true;
		}
		else {
			Availability[index]=false;
		}
		In_Storage[index]=SBook.nextInt();//9
		In_Library[index]=SBook.nextInt();//10
	}
	public Book() throws FileNotFoundException{
		
		Num =SBook.nextInt();
		Def();
		for(int i=0;i<Num;i++) {
			Filler(i);
		}
	}
	void WF(int mark) throws FileNotFoundException {
		PrintWriter Save;
		Save = new PrintWriter(BookFile);
		if(mark==1) {
			Save.println(Num+mark);
			AddBook(Save);
		}
		else {
			Save.println(Num+mark);
		}
	 	for(int i=0;i<Num;i++) {
	 		if(Book_Id[i].equals("#")) {
	 			
	 		}
	 		else {
		 		Book_Name[i]=Name_Save(Book_Name[i]);
				Save.print(Book_Name[i]+" ");//1
				Save.print(Book_Id[i]+" ");//2
				Save.print(Book_Edition[i]+" ");//3
				Book_Writer[i]=Name_Save(Book_Writer[i]);
				Save.print(Book_Writer[i]+" ");//4
				Save.print(Publish_Date[i]+" ");//5
				Publisher[i]=Name_Save(Publisher[i]);
				Save.print(Publisher[i]+" ");//6
				Save.print(Publish_Price[i]+" ");//7
				int av=0;
				if(Availability[i]==true) {
					av=1;
				}
				Save.print(av+" ");//8
				Save.print(In_Storage[i]+" ");//9
				Save.println(In_Library[i]+" ");//10
				
	 			}
		 	}
	 	Save.close();
	}
	private void AddBook(PrintWriter Save) {
		JFrame f=new JFrame();
		int ch=1;
		do {
		try {
			Save.print(Name_Save(JOptionPane.showInputDialog(f,"Enter Book Name"))+" ");
			ch=1;
		}
		catch(Exception e) {
			ch=0;
		}
		}while(ch==0);//1
		Save.print("NBo0"+Num+2+" ");//2
		do {
			try {
				Save.print(Name_Save(JOptionPane.showInputDialog(f,"Enter Book Edition"))+" ");
				ch=1;
			}
			catch(Exception e) {
				ch=0;
			}
			}while(ch==0);//3
		do {
			try {
				Save.print(Name_Save(JOptionPane.showInputDialog(f,"Enter Book Writer Name"))+" ");
				ch=1;
			}
			catch(Exception e) {
				ch=0;
			}
			}while(ch==0);//4
		do {
			try {
				Save.print(Name_Save(JOptionPane.showInputDialog(f,"Enter Book Publish Date"))+" ");
				ch=1;
			}
			catch(Exception e) {
				ch=0;
			}
			}while(ch==0);//5
		do {
			try {
				Save.print(Name_Save(JOptionPane.showInputDialog(f,"Enter Book Publisher "))+" ");
				ch=1;
			}
			catch(Exception e) {
				ch=0;
			}
			}while(ch==0);//6
		do {
			try {
				double d=Double.parseDouble(JOptionPane.showInputDialog(f,"Enter Book Publish Price"));
				Save.print(d+" ");
				ch=1;
			}
			catch(Exception e) {
				ch=0;
			}
			}while(ch==0);//7
		do {
			try {
				String AV =JOptionPane.showInputDialog(f,"Enter 1 the Book is Availabile else Enter 0");
				if(AV.equals("1")) {
					Save.print("1"+" ");				
					ch=1;
				}
				else if(AV.equals("1")) {
					Save.print("0"+" ");				
					ch=1;
				}
				else {
					ch=0;
				}
			}
			catch(Exception e) {
				ch=0;
			}
			}while(ch==0);//8
		do {
			try {
				double d=Double.parseDouble(JOptionPane.showInputDialog(f,"Enter number of copys In Storage")+" ");
				if(d>=0) {
					ch=1;
					int t=(int)d;
					Save.print(t+" ");
				}
				else {
					ch=0;
					
				}
			}
			catch(Exception e) {
				ch=0;
			}
			}while(ch==0);//9
		do {
			try {
				double d=Double.parseDouble(JOptionPane.showInputDialog(f,"Enter number of copys In Library")+" ");
				if(d>=0) {
					ch=1;
					int t=(int)d;
					Save.println(t+" ");
				}
				else {
					ch=0;
					
				}
		}
			catch(Exception e) {
				ch=0;
			}
			}while(ch==0);//10
		JOptionPane.showMessageDialog(f,"Done","L.M.S.",JOptionPane.INFORMATION_MESSAGE);
		//
	}
	
	private String Name_Save(String s) {  
		String x="";
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)==' ') {
				x+= ',';
			}
			else {
				x+=s.charAt(i);
			}
		} 
	      return x;
	  } 
	
}
