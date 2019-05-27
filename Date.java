package Q2;

import java.io.Serializable;

public class Date implements Serializable{
	private int day; 
	private int month; 
	private int year;
	

	public Date(int d, int m,int y) throws NoDateException {
		
		
		
		// check for vaild dates, throw the NoDateException in needed
		if(m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m ==10 || m == 12) {
			
		}
		else if(m == 2) {
			if(d > 29 ) {
				throw new NoDateException("invaild date"); 
			}
			else {
				if(d == 29 ) {
					if(y%400 ==0 ) {
						
					}
					else if(y%100 ==0 ) {
						throw new NoDateException("invaild date"); 
					}
					else if(y%4 != 0 ) {
						throw new NoDateException("invaild date"); 
					}
					
					
				}
				
			}
			
		}
		else {
			if(d == 31) {
				throw new NoDateException("invaild date"); 
			}
		}
		
		
		day = d;
		month =m;
		year = y; 
		
	}
	public boolean equals(Object other) {
		if(other instanceof Date) {
		return  (this.day == ((Date)other).day) && 
				(this.month == ((Date)other).month) && 
				(this.year == ((Date)other).year);}
		return false;
	}
	
	public String toString() {
		return day+ "." + month + "." + year; 
	}
	public int hashCode() {
		return this.toString().hashCode();
	}
}
