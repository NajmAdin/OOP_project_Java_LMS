package Main_Package;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.FileNotFoundException;

import javax.swing.*;

public class ModBooks {
	Book book;
	JFrame f=new JFrame();
	Find_Action A=new Find_Action();
	JPanel P;
	Frame Mod;
	JButton b1,b2;
	void form(){
		Mod=new Frame();
		Mod.setTitle("Modify");
		Mod.setSize(350,320);
		P=new JPanel();
		Mod.add(P);
		P.setBounds(0, 0, 350, 200);
		P.setLayout(new GridLayout(2,1,10,10));
		b1=new JButton("Add Book");
		b2=new JButton("Remove Book");
		b1.setBackground(Color.magenta);
		b2.setBackground(Color.pink);
		P.setBackground(Color.WHITE);
		b1.setSize(350, 80);
		b2.setSize(350, 80);
		P.add(b1);
		P.add(b2);
		b1.addActionListener(A);
		b2.addActionListener(A);
	}
	String GetID() {
		String str=JOptionPane.showInputDialog(f,"Enter Book ID");
		return str;
	}
	void ReB() throws FileNotFoundException {
	
		book=new Book();
			String s=GetID();
			SearchForBook SearchID=new SearchForBook(s);
			int Idx=SearchID.SearchIdx(s);
			if(Idx==-1) {
				JOptionPane.showMessageDialog(f,"Wrong ID","Error",JOptionPane.ERROR_MESSAGE);
			}
			else {
					int a=JOptionPane.showConfirmDialog(f,"Are You Sure to Remove Book with ID " + s);
					if(a==JOptionPane.YES_OPTION) {
						book.Book_Id[Idx]="#";
						book.WF(-1);
						JOptionPane.showMessageDialog(f,"succeeded","Save",JOptionPane.INFORMATION_MESSAGE);
					}
			}
		}
	public ModBooks(){
		
	}

}
