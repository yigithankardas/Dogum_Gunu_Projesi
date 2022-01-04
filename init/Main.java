package init;
import java.io.*;

import fileio.*;
import gui.*;

@SuppressWarnings("unused")
public class Main {
	
	public static void main(String[] args) {
		File file = new File(System.getenv("USERPROFILE") + "/DogumGunleri.txt");
		boolean exist = false;
		try {
			exist = file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*if (exist == true) {	// dosya oluþturuldu
			
		}
		else {		// dosya zaten vardý
			
		}*/
		FileHandler handler = new FileHandler(file);
		//System.out.println(handler.getBirthdayList());
		AllGui frame = new AllGui(handler);
	}
}