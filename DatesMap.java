package Q2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

// data base for the memoes
public class DatesMap {
	private HashMap<Integer,Memo> cal ;
	
	public DatesMap() {
		cal = new HashMap<Integer,Memo>();
	}

	public void add(int d,int m, int y) throws NoDateException {
		Memo temp = new Memo(d,m,y); 
		cal.put(temp.hashCode(), temp)	;
		
	}
	public void add(Memo o) {
		cal.put(o.hashCode(), o);
	}
	public Memo find(int key) {
		return cal.get(key);
	}
	// save to file the memo
	public void saveAll(File f) throws IOException {
		ObjectOutputStream out = new ObjectOutputStream
				(new FileOutputStream(f));
		cal.forEach((k,v)->{
				try {
					out.writeObject(v);
				}catch(FileNotFoundException e) {}	
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		});
		out.close();
	}
	
	
	 
	
	
}
