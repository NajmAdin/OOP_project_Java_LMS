package Main_Package;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.*;

public class Find_Action implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		String s=e.getActionCommand();
		  try {
			ACT(s);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}
	
	void ACT(String x) throws FileNotFoundException {  
		  ModBooks MB = new ModBooks();
		  Book B=new Book();
		  if(x.equals("Show all Books")) {
			  new ShowAllBooks(); 
		  }
		  else if(x.equals("Borrow a Book")) {
			  BorrowBook(); 
		  }
		  else if(x.equals("Search")) {
			  new SearchForBook();
		  }
		  else if(x.equals("Add User")) {
				  new User(" ");
			
		  }
		  else if(x.equals("Modify")) {
			 MB.form();
		  }
		  else if(x.equals("Add Book")) {
			  B.WF(1);
		  }
		  else if(x.equals("Remove Book")) {
			  MB.ReB();
		  }
		  else if(x.equals("Return a Book")) {
			  new BorrowFM(0);
		  }
	}  
	private void BorrowBook() throws FileNotFoundException {
		new BorrowFM(1);
		
	}
}
/*
 * Return a Book
		b1=new JButton("Add Book");
		b2=new JButton("Remove Book");
		b3=new JButton("Edit Book");
		*/
 