package Main_Package;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.FileNotFoundException;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShowAllBooks {
	public ShowAllBooks() throws FileNotFoundException {
		ShowBook();
	}
	void ShowBook() throws FileNotFoundException {
		Book B=new Book();
		Frame SBF=new Frame();
		SBF.setTitle("Show all Books");
		SBF.setSize(1400,(B.Num*80));
		SBF.setLayout(new FlowLayout());
		JPanel pan=new JPanel();
		SBF.add(pan);
		GridLayout G=new GridLayout(1+B.Num,9,10,10);
		pan.setLayout(G);
		pan.setBackground(Color.WHITE);
		HShow(pan);
		for(int i=0;i<B.Num;i++) {
			Filler(i,pan, B);
		}
	}
	private void Filler(int index,JPanel SBF,Book B) {
		SBF.add(new JLabel(B.Book_Id[index]));
		JLabel l=new JLabel(B.Book_Name[index]);
		l.setSize(150, 150);
		SBF.add(l);
		JLabel l1=new JLabel(B.Book_Edition[index]);
		l1.setSize(150, 150);
		SBF.add(l1);
		JLabel l2=new JLabel(B.Book_Writer[index]);
		l2.setSize(150, 150);
		SBF.add(l2);
		if(B.Availability[index]==true) {
			SBF.add(new JLabel("Available"));
		}
		else {
			SBF.add(new JLabel("Not available"));
		}
		JLabel l4=new JLabel(String.valueOf(B.In_Storage[index]));
		l4.setSize(50, 150);
		SBF.add(l4);
		JLabel l5=new JLabel(String.valueOf(B.In_Library[index]));
		l5.setSize(50, 150);
		SBF.add(l5);
		SBF.add(new JLabel(String.valueOf(B.In_Library[index]+B.In_Storage[index])));
	}
	private void HShow(JPanel SBF) {
		SBF.add(new JLabel("ID"));
		JLabel l=new JLabel("Name");
		l.setSize(150, 150);
		SBF.add(l);
		JLabel l1=new JLabel("Edition");
		l1.setSize(150, 150);
		SBF.add(l1);
		JLabel l2=new JLabel("Writer");
		l2.setSize(150, 150);
		SBF.add(l2);
		SBF.add(new JLabel("Availablaty"));
		JLabel l4=new JLabel("in Storage");
		l4.setSize(50, 150);
		SBF.add(l4);
		JLabel l5=new JLabel("in Library");
		l5.setSize(50, 150);
		SBF.add(l5);
		SBF.add(new JLabel("Total"));
	}
}
