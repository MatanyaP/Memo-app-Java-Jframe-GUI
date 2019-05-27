package Q2;

import java.io.*;
// a memo repestetion using the date
public class Memo implements Serializable  {
	Date date ; 
	String txt; 
	public Memo(int d, int m,int y , String txt) throws NoDateException {
		date = new Date(d,m,y);
		this.txt = txt;
	}
	public Memo(int d, int m,int y) throws NoDateException {
		date = new Date(d,m,y);
		this.txt = "";
	}
	public void setTxt(String st) {
		txt = st;
	}
	public String getTxt() {
		return txt;
	}
	
	public int hashCode() {
		return date.hashCode();
	}
	public String toString() {
		return date.toString() + "\n" + this.txt ;
	}
}
