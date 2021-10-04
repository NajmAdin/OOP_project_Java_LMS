package Main_Package;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.io.*;

public class BorrowFM  {
	String[] Us_Id;
	String[] Bo_Id;
	long[] Time;
	Book B;
	User U;
	
	File BorrowFile=new File("Borrow.data");
	Scanner scan=new Scanner(BorrowFile);
	int Num;
	public BorrowFM(int test) throws FileNotFoundException{
		lod();
		if(test==1) {
		save();
		}
		else if(test==0) {
			ReBook();
		}
    }
	void lod()throws FileNotFoundException {
		Num=scan.nextInt();
		Us_Id =new String[Num];
		Bo_Id = new String[Num];
		Time=new long[Num];
		for(int i=0;i<Num;i++) {
			Us_Id[i]=scan.next();
			Bo_Id[i]=scan.next();
			Time[i]=scan.nextLong();
		}
	}
	void save() throws FileNotFoundException {
		B=new Book();
		U=new User(0);
		String Uid="",Bid="";
		int ch=0,ch1=0;
		JFrame f=new JFrame(); 
		try {
			Uid=JOptionPane.showInputDialog(f,"Enter User ID");
		}
		catch(Exception e) {
			 JOptionPane.showMessageDialog(f,"Not accessed {ID not found} ","L.M.S.",JOptionPane.ERROR_MESSAGE);
			 return;
		}
		U.LF(0);
		if(Uid.equals("")) {
			JOptionPane.showMessageDialog(f,"Not accessed {ID not found} ","L.M.S.",JOptionPane.ERROR_MESSAGE);
		}
		else {
			for(int i=0;i<U.Size;i++) {
				if(Uid.equals(U.ID[i])) {
				ch1=1;
				break;
				}
			}
			if(ch1==0) {
				 JOptionPane.showMessageDialog(f,"Not accessed","L.M.S.",JOptionPane.ERROR_MESSAGE);
				 return;
			}
			
		}
		try {
			Bid=JOptionPane.showInputDialog(f,"Enter Book ID");
		}
		catch(Exception e) {
			 JOptionPane.showMessageDialog(f,"Not accessed {Book not found} ","L.M.S.",JOptionPane.ERROR_MESSAGE);
			 return;
		}
		if(Bid.equals("")) {
			 JOptionPane.showMessageDialog(f,"Not accessed {Book not found} ","L.M.S.",JOptionPane.ERROR_MESSAGE);
		}
		else {
			for(int i=0;i<B.Num;i++) {
				if(Bid.equals(B.Book_Id[i])) {
					ch=1;
					break;
				}
			}
			if(ch==0) {
				 JOptionPane.showMessageDialog(f,"Not accessed","L.M.S.",JOptionPane.ERROR_MESSAGE);
				 return;
			}
		}
		PrintWriter Save;
		Save = new PrintWriter(BorrowFile);
		Save.println(Num+1);
		for(int i=0;i<Num;i++) {
			Save.print(Us_Id[i]+" ");
			Save.print(Bo_Id[i]+" ");
			Save.println(Time[i]+" ");
		}
		Save.print(Uid+" "+Bid+" ");
		long t=System.currentTimeMillis();
		Save.println(t);
		Save.close();
		JOptionPane.showMessageDialog(f,"Done","L.M.S.",JOptionPane.INFORMATION_MESSAGE);
	}
	void ReBook() throws FileNotFoundException {
		B=new Book();
		U=new User(0);
		long T=(long) 0;
		String Uid="",Bid="";
		int ch=0,ch1=0;
		JFrame f=new JFrame(); 
		try {
			Uid=JOptionPane.showInputDialog(f,"Enter User ID");
		}
		catch(Exception e) {
			 JOptionPane.showMessageDialog(f,"Not accessed {ID not found} ","L.M.S.",JOptionPane.ERROR_MESSAGE);
			 return;
		}
		U.LF(0);
		try {
			Bid=JOptionPane.showInputDialog(f,"Enter Book ID");
		}
		catch(Exception e) {
			 JOptionPane.showMessageDialog(f,"Not accessed {Book not found} ","L.M.S.",JOptionPane.ERROR_MESSAGE);
			 return;
		}
		if(Bid.equals("")) {
			 JOptionPane.showMessageDialog(f,"Not accessed {Book not found} ","L.M.S.",JOptionPane.ERROR_MESSAGE);
			 return;
		}
		else if(Uid.equals("")) {
			JOptionPane.showMessageDialog(f,"Not accessed {ID not found} ","L.M.S.",JOptionPane.ERROR_MESSAGE);
			 return;
		}
		else {
			long t=System.currentTimeMillis();
			for(int i=0;i<U.Size;i++) {
				if(Uid.equals(Us_Id[i])&&Bid.equals(Bo_Id[i])) {
				ch1=1;
				Us_Id[i]="#";
				T=t-Time[i];
				break;
				}
			}
			if(ch1==0) {
				 JOptionPane.showMessageDialog(f,"Not accessed","L.M.S.",JOptionPane.ERROR_MESSAGE);
				 return;
			}
				//‭259200
			
		}
		PrintWriter Save;
		Save = new PrintWriter(BorrowFile);
		Save.println(Num-1);
		for(int i=0;i<Num;i++) {
			if(!Us_Id[i].equals("#")) {
			Save.print(Us_Id[i]+" ");
			Save.print(Bo_Id[i]+" ");
			Save.println(Time[i]+" ");
			}
		}
		Save.close();
		if(T<259200) {
			JOptionPane.showMessageDialog(f,"Done","L.M.S.",JOptionPane.INFORMATION_MESSAGE);		
		}
		else {
			JOptionPane.showMessageDialog(f,"The User Must pay fine","L.M.S.",JOptionPane.INFORMATION_MESSAGE);
		}
		}
}
