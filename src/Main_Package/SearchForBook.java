package Main_Package;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SearchForBook {
	JFrame f=new JFrame();
	String Bo_Id;
    Book B=new Book();
	public SearchForBook() throws FileNotFoundException {
		Optian();
		
	   // Bo_Name=JOptionPane.showInputDialog(f,"Enter Password");
	}
	public SearchForBook(String ID) throws FileNotFoundException{
		
	}
	void Optian() throws FileNotFoundException {
		
		int a=JOptionPane.showConfirmDialog(f,"Do you know Book Id ?");
		if(a==JOptionPane.YES_OPTION) {
			Bo_Id=JOptionPane.showInputDialog(f,"Enter Book ID");
			int test=SearchIdx(Bo_Id);
			if(test==-1) {
				JOptionPane.showMessageDialog(f,"Not found","L.M.S.",JOptionPane.ERROR_MESSAGE);
			}
			else {
				Bo_Info(test);
			}
		}
		else if(a==JOptionPane.NO_OPTION) {
			JOptionPane.showMessageDialog(f,"press \"Show all Books\" first to get id","L.M.S.",JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	public int SearchIdx(String ID) {
		int BookIdx=-1;
		for(int i=0;i<B.Num;i++) {
			if(ID.equals(B.Book_Id[i])) {
				BookIdx=i;
				break;
			}
		}
		return BookIdx;
	}
	private void Bo_Info(int i) {
		Frame BIF=new Frame();
		BIF.setTitle("Search");
		Show(BIF,i);
	}
	private void Show(Frame F,int i) {
		F.setSize(800, 200);
		JPanel SBF=new JPanel();
		F.setLayout(new FlowLayout());
		F.add(SBF);
		SBF.setLayout(new GridLayout(6, 4, 10, 10));
		SBF.setBackground(Color.WHITE);
		SBF.add(new JLabel("ID →→→"));//1
		SBF.add(new JLabel(B.Book_Id[i]));
		JLabel l=new JLabel("|| Name →→→");
		l.setSize(150, 150);
		SBF.add(l);//2
		SBF.add(new JLabel(B.Book_Name[i]));
		JLabel l1=new JLabel("Edition →→→");
		l1.setSize(150, 150);
		SBF.add(l1);//3
		SBF.add(new JLabel(B.Book_Edition[i]));
		JLabel l2=new JLabel("|| Writer →→→");
		l2.setSize(150, 150);
		SBF.add(l2);//4
		SBF.add(new JLabel(B.Book_Writer[i]));
		SBF.add(new JLabel("Publisher →→→"));//5
		SBF.add(new JLabel(B.Publisher[i]));
		SBF.add(new JLabel("|| Publish Price →→→"));//6
		SBF.add(new JLabel(String.valueOf(B.Publish_Price[i])));
		SBF.add(new JLabel("Publish Date →→→"));//7
		SBF.add(new JLabel(B.Publish_Date[i]));
		SBF.add(new JLabel("|| Availablaty →→→"));//8
		if(B.Availability[i]==true) {
			SBF.add(new JLabel("Available"));
		}
		else {
			SBF.add(new JLabel("Not available"));
		}
		JLabel l4=new JLabel("in Storage →→→");//9
		l4.setSize(50, 150);
		SBF.add(l4);
		SBF.add(new JLabel(String.valueOf(B.In_Storage[i])));
		JLabel l5=new JLabel("|| in Library →→→");//10
		l5.setSize(50, 150);
		SBF.add(l5);
		SBF.add(new JLabel(String.valueOf(B.In_Library[i])));
		SBF.add(new JLabel("Total →→→"));//11
		SBF.add(new JLabel(String.valueOf(B.In_Storage[i]+B.In_Library[i])));
		SBF.add(new JLabel("|| Programming By : →→→"));
		SBF.add(new JLabel(" Eng // :: Najm "));
	}

}
