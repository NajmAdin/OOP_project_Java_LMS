package Main_Package;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.event.*;
import java.lang.*;


public abstract class Person {
	JFrame f=new JFrame();
	int Size;
	String id;
	String Password;
	String [] ID;
	String [] Name;
	String [] Pass;
	public Person() {
		
	  
	}
	void set_Size(int x) {
		Size=x;
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
	String Name_Save(String s) {  
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
