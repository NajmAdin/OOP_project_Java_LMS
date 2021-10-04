package Main_Package;
import javax.swing.*;
import java.lang.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.event.*;

public class Admin extends Person {
	File AF;
	public Admin() throws FileNotFoundException{
		id=JOptionPane.showInputDialog(f,"Enter your ID");
	    Password=JOptionPane.showInputDialog(f,"Enter Password");
		AF = new File("Admin.data");
		Scanner AS=new Scanner(AF);
		int x=AS.nextInt();
		set_Size(x);
		  Name =new String[Size];
			ID = new String[Size];
			Pass =new String[Size];
		for(int i=0;i<x;i++) {
			ID[i]=AS.next();
			//System.out.println(ID[i]);
			Name[i]=AS.next();
			Name[i]=Name_Ed(Name[i]);
			Pass[i]=AS.next();
		}
	}
}
